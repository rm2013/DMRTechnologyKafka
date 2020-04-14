package com.dmrtech.endstate.services;

import com.dmrtech.endstate.model.CalendarEvent;
import com.dmrtech.endstate.payload.request.CalendarEventRequest;
import org.springframework.stereotype.Service;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {

    @Override
    public CalendarEvent generateFromRequest(CalendarEventRequest calendarEventRequest) {
        CalendarEvent calendarEvent = new CalendarEvent(calendarEventRequest.getDate(), calendarEventRequest.isAllDayEvent(), calendarEventRequest.getTitle(), calendarEventRequest.getDetails());
        calendarEvent.setId(calendarEventRequest.getId());
        return calendarEvent;
    }
}
