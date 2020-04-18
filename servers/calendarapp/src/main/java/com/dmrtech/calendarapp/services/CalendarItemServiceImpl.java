package com.dmrtech.calendarapp.services;

import com.dmrtech.calendarapp.model.CalendarItem;
import com.dmrtech.calendarapp.payload.request.CalendarItemRequest;
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
