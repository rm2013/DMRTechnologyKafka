package com.dmrtech.endstate.services;

import com.dmrtech.endstate.model.CalendarEvent;
import com.dmrtech.endstate.payload.request.CalendarEventRequest;

public interface CalendarEventService {
    CalendarEvent generateFromRequest(CalendarEventRequest calendarEventRequest);
}
