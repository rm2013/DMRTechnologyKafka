package com.dmrtech.endstate.repository;


import com.dmrtech.endstate.model.CalendarEvent;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CalendarEventRepository extends PagingAndSortingRepository<CalendarEvent, Long> {

}