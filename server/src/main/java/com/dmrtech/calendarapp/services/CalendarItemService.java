package com.dmrtech.calendarapp.services;

import com.dmrtech.calendarapp.model.CalendarItem;
import com.dmrtech.calendarapp.payload.request.CalendarItemRequest;

public interface CalendarItemService {
    CalendarItem generateFromRequest(CalendarItemRequest calendarItemRequest);
}
