package com.dmrtech.monolith.repository;


import com.dmrtech.monolith.model.CalendarEvent;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CalendarEventRepository extends PagingAndSortingRepository<CalendarEvent, Long> {

}