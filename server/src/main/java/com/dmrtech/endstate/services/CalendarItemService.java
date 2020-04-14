package com.dmrtech.endstate.services;

import com.dmrtech.endstate.model.CalendarItem;
import com.dmrtech.endstate.payload.request.CalendarItemRequest;

public interface CalendarItemService {
    CalendarItem generateFromRequest(CalendarItemRequest calendarItemRequest);
}
