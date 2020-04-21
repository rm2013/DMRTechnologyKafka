package com.dmrtech.calendarservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class CalendarItem {
    @Id
    private UUID id;

    private Date eventDate;
    private boolean allDayEvent;
    private String title;
    private String details;
    private boolean completed;

    public CalendarItem(Date eventDate, boolean allDayEvent, String title, String details, boolean completed) {
        this.eventDate = eventDate;
        this.allDayEvent = allDayEvent;
        this.title = title;
        this.details = details;
        this.completed = completed;
    }

    public CalendarItem() {

    }

    public UUID getID() {
        return id;
    }
    public void setId(UUID id) { this.id = id; }


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

    public boolean isCompleted() {return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

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


    @Override
    public String toString() {
        return "CalendarItem{" +
                "id=" + id +
                ", eventDate=" + eventDate +
                ", allDayEvent=" + allDayEvent +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", completed=" + completed +
                '}';
    }
}
