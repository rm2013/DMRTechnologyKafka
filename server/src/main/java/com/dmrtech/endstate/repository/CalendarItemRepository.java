package com.dmrtech.endstate.repository;


import com.dmrtech.endstate.model.CalendarItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CalendarItemRepository extends PagingAndSortingRepository<CalendarItem, Long> {

}