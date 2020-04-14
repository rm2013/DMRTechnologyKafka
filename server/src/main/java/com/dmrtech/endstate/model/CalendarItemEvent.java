package com.dmrtech.endstate.model;

public class CalendarItemEvent {
    public CalendarItemEvent(EVENT_TYPE eventType, CalendarItem calendarItem) {
        this.eventType = eventType;
        this.calendarItem = calendarItem;
    }

    public EVENT_TYPE getEventType() {
        return eventType;
    }

    public CalendarItem getCalendarItem() {
        return calendarItem;
    }

    public enum EVENT_TYPE {
        CREATED,
        UPDATED,
        DELETED
    }

    private EVENT_TYPE eventType;
    private CalendarItem calendarItem;


}
