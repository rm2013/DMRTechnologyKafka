package com.dmrtech.monolith.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CalendarEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date eventDate;
    private boolean allDayEvent;
    private String summary;
    private String details;

    public CalendarEvent(Date eventDate, boolean allDayEvent, String summary, String details) {
        this.eventDate = eventDate;
        this.allDayEvent = allDayEvent;
        this.summary = summary;
        this.details = details;
    }

    public long getID() {
        return id;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
