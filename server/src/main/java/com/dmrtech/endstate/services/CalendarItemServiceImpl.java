package com.dmrtech.endstate.services;

import com.dmrtech.endstate.model.CalendarItem;
import com.dmrtech.endstate.payload.request.CalendarItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CalendarItemServiceImpl implements CalendarItemService {

    @Override
    public CalendarItem generateFromRequest(CalendarItemRequest calendarItemRequest) {
        CalendarItem calendarItem = new CalendarItem(calendarItemRequest.getDate(), calendarItemRequest.isAllDayEvent(), calendarItemRequest.getTitle(), calendarItemRequest.getDetails());
        calendarItem.setId(calendarItemRequest.getId());
        return calendarItem;
    }
}
