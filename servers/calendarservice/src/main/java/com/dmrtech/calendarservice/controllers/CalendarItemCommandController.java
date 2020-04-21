package com.dmrtech.calendarservice.controllers;

import com.dmrtech.calendarservice.model.CalendarItem;
import com.dmrtech.calendarservice.model.CalendarItemEvent;
import com.dmrtech.calendarservice.payload.request.CalendarItemRequest;
import com.dmrtech.calendarservice.services.CalendarItemEventConsumer;
import com.dmrtech.calendarservice.services.CalendarItemEventProducer;
import com.dmrtech.calendarservice.services.CalendarItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/calendaritems")
public class CalendarItemCommandController {

    private static final Logger logger = LoggerFactory.getLogger(CalendarItemCommandController.class);

    private final CalendarItemService calendarItemService;
    private final CalendarItemEventProducer calendarItemEventProducer;

    public CalendarItemCommandController(CalendarItemService calendarItemService, CalendarItemEventProducer calendarItemEventProducer) {
        this.calendarItemService = calendarItemService;
        this.calendarItemEventProducer = calendarItemEventProducer;
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarItem calendarItem(@RequestBody CalendarItemRequest calendarItemRequest) {
        CalendarItem calendarItem = calendarItemService.generateFromRequest(calendarItemRequest);
        calendarItem.setId(UUID.randomUUID());

        CalendarItemEvent newCalendarItemEvent = new CalendarItemEvent(CalendarItemEvent.EVENT_TYPE.CREATED, calendarItem);
        calendarItemEventProducer.sendMessage( newCalendarItemEvent );

        return calendarItem;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarItem update(@RequestBody CalendarItemRequest calendarItemRequest, @PathVariable String id) {

        // send event
        CalendarItem updatedCalendarItem = calendarItemService.generateFromRequest(calendarItemRequest);

        updatedCalendarItem.setId(UUID.fromString(id));

        CalendarItemEvent updatedCalendarItemEvent = new CalendarItemEvent(CalendarItemEvent.EVENT_TYPE.UPDATED, updatedCalendarItem);
        calendarItemEventProducer.sendMessage(updatedCalendarItemEvent);

        logger.info("Sent message to save calendar event: {}", updatedCalendarItem);
        return updatedCalendarItem;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable UUID id) {
        CalendarItem calendarItem = new CalendarItem();
        calendarItem.setId(id);
        CalendarItemEvent calendarItemEvent = new CalendarItemEvent(CalendarItemEvent.EVENT_TYPE.DELETED,calendarItem );
        calendarItemEventProducer.sendMessage(calendarItemEvent);
    }

}
