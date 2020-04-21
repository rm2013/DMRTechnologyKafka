package com.dmrtech.calendarservice.controllers;

import com.dmrtech.calendarservice.model.CalendarItem;
import com.dmrtech.calendarservice.repository.CalendarItemRepository;
import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/calendaritems")
public class CalendarItemQueryController {

    private final CalendarItemRepository calendarItemRepository;

    public CalendarItemQueryController(CalendarItemRepository calendarItemRepository) {
        this.calendarItemRepository = calendarItemRepository;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public CalendarItem findCalendarEventById(@PathVariable String id) throws NotFoundException {
        return calendarItemRepository.findById(UUID.fromString(id))
                .orElseThrow(()-> new NotFoundException("Calendar event not found with id: " + id));

    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    public Iterable<CalendarItem> all() {
        return calendarItemRepository.findAll();
    }


}
