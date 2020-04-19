package com.dmrtech.calendarapp.payload.response;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for MessageResponse
 *
 * @author dferguson
 * @see MessageResponse
 */
public class MessageResponseTest {
    /**
     * Parasoft Jtest UTA: Test for getMessage()
     *
     * @author dferguson
     * @see MessageResponse#getMessage()
     */
    @Test(timeout = 1000)
    public void testGetMessage() throws Throwable {
        // Given
        String message = ""; // UTA: default value
        MessageResponse underTest = new MessageResponse(message);

        // When
        String result = underTest.getMessage();

        // Then
        // assertEquals("", result);
    }
/**
 * Parasoft Jtest UTA: Test for setMessage(String)
 *
 * @see MessageResponse#setMessage(String)
 * @author dferguson
 */
@Test(timeout=1000)
public void testSetMessage() throws Throwable
{
    // Given
    String message = ""; // UTA: default value
    MessageResponse underTest = new MessageResponse(message);

    // When
    String message2 = ""; // UTA: default value
    underTest.setMessage(message2);

}
}