package com.dmrtech.monolith.controllers;

import com.dmrtech.monolith.model.CalendarEvent;
import com.dmrtech.monolith.repository.CalendarEventRepository;
import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/calendarevents")
public class CalendarEventController {

    private final CalendarEventRepository calendarEventRepository;

    public CalendarEventController(CalendarEventRepository calendarEventRepository) {
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
    Iterable<CalendarEvent> all() {
        return calendarEventRepository.findAll();
    }


    @PostMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    CalendarEvent calendarEvent(@RequestBody CalendarEvent calendarEvent) {
        return calendarEventRepository.save(calendarEvent);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    CalendarEvent update(@RequestBody CalendarEvent newCalendarEvent, @PathVariable Long id) {

        return calendarEventRepository.findById(id)
                .map(calendarEvent -> {
                    calendarEvent.setDate(newCalendarEvent.getDate());
                    calendarEvent.setAllDayEvent(newCalendarEvent.isAllDayEvent());
                    calendarEvent.setTitle(newCalendarEvent.getTitle());
                    calendarEvent.setDetails(newCalendarEvent.getDetails());

                    return calendarEventRepository.save(calendarEvent);
                })
                .orElseGet(() -> {
                    newCalendarEvent.setId(id);
                    return calendarEventRepository.save(newCalendarEvent);
                });
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    void delete(@PathVariable Long id) {
        calendarEventRepository.deleteById(id);
    }
}
