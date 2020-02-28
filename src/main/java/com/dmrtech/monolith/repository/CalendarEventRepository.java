package com.dmrtech.monolith.repository;


import com.dmrtech.monolith.model.CalendarEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "calendarevents", path = "calendarevents")
public interface CalendarEventRepository extends PagingAndSortingRepository<CalendarEvent, Long> {


}