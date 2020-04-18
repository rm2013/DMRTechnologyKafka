package com.dmrtech.calendarapp.repository;


import com.dmrtech.calendarapp.model.CalendarItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CalendarItemRepository extends PagingAndSortingRepository<CalendarItem, Long> {

}