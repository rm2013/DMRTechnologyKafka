package com.dmrtech.calendarservice.repository;


import com.dmrtech.calendarservice.model.CalendarItem;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CalendarItemRepository extends PagingAndSortingRepository<CalendarItem, UUID> {

}