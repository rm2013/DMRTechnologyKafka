package com.dmrtech.endstate.controllers;

import com.dmrtech.endstate.model.CalendarItem;
import com.dmrtech.endstate.model.CalendarItemEvent;
import com.dmrtech.endstate.payload.request.CalendarItemRequest;
import com.dmrtech.endstate.repository.CalendarItemRepository;
import com.dmrtech.endstate.services.CalendarItemEventProducer;
import com.dmrtech.endstate.services.CalendarItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/calendarevents")
public class CalendarItemCommandController {

    private final CalendarItemRepository calendarItemRepository;
    private final CalendarItemService calendarItemService;
    private final CalendarItemEventProducer calendarItemEventProducer;

    public CalendarItemCommandController(CalendarItemRepository calendarItemRepository, CalendarItemService calendarItemService, CalendarItemEventProducer calendarItemEventProducer) {
        this.calendarItemRepository = calendarItemRepository;
        this.calendarItemService = calendarItemService;
        this.calendarItemEventProducer = calendarItemEventProducer;
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarItem calendarItem(@RequestBody CalendarItemRequest calendarItemRequest) {
        CalendarItem calendarItem = calendarItemService.generateFromRequest(calendarItemRequest);
        return calendarItemRepository.save(calendarItem);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarItem update(@RequestBody CalendarItemRequest calendarItemRequest, @PathVariable Long id) {

        // send event
        CalendarItem updatedCalendarItem = new CalendarItem(calendarItemRequest.getDate(), calendarItemRequest.isAllDayEvent(), calendarItemRequest.getTitle(), calendarItemRequest.getTitle());
        updatedCalendarItem.setId(calendarItemRequest.getId());
        CalendarItemEvent updatedCalendarItemEvent = new CalendarItemEvent(CalendarItemEvent.EVENT_TYPE.UPDATED, updatedCalendarItem);
        calendarItemEventProducer.sendMessage(updatedCalendarItemEvent);

        // then do the legacy processing
        return calendarItemRepository.findById(id)
                .map(calendarItem -> {
                    calendarItem.setDate(calendarItemRequest.getDate());
                    calendarItem.setAllDayEvent(calendarItemRequest.isAllDayEvent());
                    calendarItem.setTitle(calendarItemRequest.getTitle());
                    calendarItem.setDetails(calendarItemRequest.getDetails());

                    return calendarItemRepository.save(calendarItem);
                })
                .orElseGet(() -> {
                    CalendarItem calendarItem = calendarItemService.generateFromRequest(calendarItemRequest);
                    calendarItem.setId(id);
                    return calendarItemRepository.save(calendarItem);
                });
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id) {
        calendarItemRepository.deleteById(id);
    }

}
