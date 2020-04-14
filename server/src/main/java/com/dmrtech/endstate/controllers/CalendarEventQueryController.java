package com.dmrtech.endstate.controllers;

import com.dmrtech.endstate.model.CalendarEvent;
import com.dmrtech.endstate.repository.CalendarEventRepository;
import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/calendarevents")
public class CalendarEventQueryController {

    private final CalendarEventRepository calendarEventRepository;

    public CalendarEventQueryController(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarEvent findCalendarEventById(@PathVariable long id) throws NotFoundException {
        return calendarEventRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Calendar event not found with id: " + id));

    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    public Iterable<CalendarEvent> all() {
        return calendarEventRepository.findAll();
    }


}
