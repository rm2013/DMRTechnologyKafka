package com.dmrtech.calendarservice.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class CalendarItemRequest {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return eventDate;
    }

    public void setDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isAllDayEvent() {
        return allDayEvent;
    }

    public void setAllDayEvent(boolean allDayEvent) {
        this.allDayEvent = allDayEvent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isCompleted() {return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @NotBlank
    private Date eventDate;
    private boolean allDayEvent;
    private boolean completed;

    @NotBlank
    private String title;
    private String details;


}
