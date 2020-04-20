package com.dmrtech.calendarservice.payload.request;


import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for CalendarItemRequest
 *
 * @author dferguson
 * @see CalendarItemRequest
 */
public class CalendarItemRequestTest {
    /**
     * Parasoft Jtest UTA: Test for getDate()
     *
     * @author dferguson
     * @see CalendarItemRequest#getDate()
     */
    @Test(timeout = 1000)
    public void testGetDate() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        Date result = underTest.getDate();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for getDetails()
     *
     * @author dferguson
     * @see CalendarItemRequest#getDetails()
     */
    @Test(timeout = 1000)
    public void testGetDetails() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        String result = underTest.getDetails();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getId()
     *
     * @author dferguson
     * @see CalendarItemRequest#getId()
     */
    @Test(timeout = 1000)
    public void testGetId() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        long result = underTest.getId();

        // Then
        // assertEquals(0L, result);
    }

    /**
     * Parasoft Jtest UTA: Test for getTitle()
     *
     * @author dferguson
     * @see CalendarItemRequest#getTitle()
     */
    @Test(timeout = 1000)
    public void testGetTitle() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        String result = underTest.getTitle();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for isAllDayEvent()
     *
     * @author dferguson
     * @see CalendarItemRequest#isAllDayEvent()
     */
    @Test(timeout = 1000)
    public void testIsAllDayEvent() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        boolean result = underTest.isAllDayEvent();

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Test for setAllDayEvent(boolean)
     *
     * @author dferguson
     * @see CalendarItemRequest#setAllDayEvent(boolean)
     */
    @Test(timeout = 1000)
    public void testSetAllDayEvent() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        boolean allDayEvent = false; // UTA: default value
        underTest.setAllDayEvent(allDayEvent);

    }

    /**
     * Parasoft Jtest UTA: Test for setDate(Date)
     *
     * @author dferguson
     * @see CalendarItemRequest#setDate(Date)
     */
    @Test(timeout = 1000)
    public void testSetDate() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        Date eventDate = mock(Date.class);
        underTest.setDate(eventDate);

    }

    /**
     * Parasoft Jtest UTA: Test for setDetails(String)
     *
     * @author dferguson
     * @see CalendarItemRequest#setDetails(String)
     */
    @Test(timeout = 1000)
    public void testSetDetails() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        String details = ""; // UTA: default value
        underTest.setDetails(details);

    }

    /**
     * Parasoft Jtest UTA: Test for setId(long)
     *
     * @author dferguson
     * @see CalendarItemRequest#setId(long)
     */
    @Test(timeout = 1000)
    public void testSetId() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        long id = 0L; // UTA: default value
        underTest.setId(id);

    }

    /**
     * Parasoft Jtest UTA: Test for setTitle(String)
     *
     * @author dferguson
     * @see CalendarItemRequest#setTitle(String)
     */
    @Test(timeout = 1000)
    public void testSetTitle() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();

        // When
        String title = ""; // UTA: default value
        underTest.setTitle(title);

    }
}