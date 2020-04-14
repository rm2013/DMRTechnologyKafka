package com.dmrtech.endstate.controllers;

import com.dmrtech.endstate.model.CalendarEvent;
import com.dmrtech.endstate.payload.request.CalendarEventRequest;
import com.dmrtech.endstate.repository.CalendarEventRepository;
import com.dmrtech.endstate.services.CalendarEventService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/calendarevents")
public class CalendarEventCommandController {

    private final CalendarEventRepository calendarEventRepository;
    private final CalendarEventService calendarEventService;

    public CalendarEventCommandController(CalendarEventRepository calendarEventRepository, CalendarEventService calendarEventService) {
        this.calendarEventRepository = calendarEventRepository;
        this.calendarEventService = calendarEventService;
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarEvent calendarEvent(@RequestBody CalendarEventRequest calendarEventRequest) {
        CalendarEvent calendarEvent = calendarEventService.generateFromRequest(calendarEventRequest);
        return calendarEventRepository.save(calendarEvent);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarEvent update(@RequestBody CalendarEventRequest calendarEventRequest, @PathVariable Long id) {

        return calendarEventRepository.findById(id)
                .map(calendarEvent -> {
                    calendarEvent.setDate(calendarEventRequest.getDate());
                    calendarEvent.setAllDayEvent(calendarEventRequest.isAllDayEvent());
                    calendarEvent.setTitle(calendarEventRequest.getTitle());
                    calendarEvent.setDetails(calendarEventRequest.getDetails());

                    return calendarEventRepository.save(calendarEvent);
                })
                .orElseGet(() -> {
                    CalendarEvent calendarEvent = calendarEventService.generateFromRequest(calendarEventRequest);
                    calendarEvent.setId(id);
                    return calendarEventRepository.save(calendarEvent);
                });
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id) {
        calendarEventRepository.deleteById(id);
    }

}
