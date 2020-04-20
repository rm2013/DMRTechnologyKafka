package com.dmrtech.calendarapp.payload.response;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for JwtResponse
 *
 * @author dferguson
 * @see JwtResponse
 */
public class JwtResponseTest {
    /**
     * Parasoft Jtest UTA: Test for getAccessToken()
     *
     * @author dferguson
     * @see JwtResponse#getAccessToken()
     */
    @Test(timeout = 1000)
    public void testGetAccessToken() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getAccessToken();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getEmail()
     *
     * @author dferguson
     * @see JwtResponse#getEmail()
     */
    @Test(timeout = 1000)
    public void testGetEmail() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getEmail();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getId()
     *
     * @author dferguson
     * @see JwtResponse#getId()
     */
    @Test(timeout = 1000)
    public void testGetId() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        Long result = underTest.getId();

        // Then
        // assertEquals(0L, result.longValue());
    }

    /**
     * Parasoft Jtest UTA: Test for getTokenType()
     *
     * @author dferguson
     * @see JwtResponse#getTokenType()
     */
    @Test(timeout = 1000)
    public void testGetTokenType() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getTokenType();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getUsername()
     *
     * @author dferguson
     * @see JwtResponse#getUsername()
     */
    @Test(timeout = 1000)
    public void testGetUsername() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getUsername();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for setAccessToken(String)
     *
     * @author dferguson
     * @see JwtResponse#setAccessToken(String)
     */
    @Test(timeout = 1000)
    public void testSetAccessToken() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String accessToken2 = ""; // UTA: default value
        underTest.setAccessToken(accessToken2);

    }

    /**
     * Parasoft Jtest UTA: Test for setEmail(String)
     *
     * @author dferguson
     * @see JwtResponse#setEmail(String)
     */
    @Test(timeout = 1000)
    public void testSetEmail() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String email2 = ""; // UTA: default value
        underTest.setEmail(email2);

    }

    /**
     * Parasoft Jtest UTA: Test for setId(Long)
     *
     * @author dferguson
     * @see JwtResponse#setId(Long)
     */
    @Test(timeout = 1000)
    public void testSetId() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        Long id2 = 0L; // UTA: default value
        underTest.setId(id2);

    }

    /**
     * Parasoft Jtest UTA: Test for setTokenType(String)
     *
     * @author dferguson
     * @see JwtResponse#setTokenType(String)
     */
    @Test(timeout = 1000)
    public void testSetTokenType() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String tokenType = ""; // UTA: default value
        underTest.setTokenType(tokenType);

    }

    /**
     * Parasoft Jtest UTA: Test for setUsername(String)
     *
     * @author dferguson
     * @see JwtResponse#setUsername(String)
     */
    @Test(timeout = 1000)
    public void testSetUsername() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String username2 = ""; // UTA: default value
        underTest.setUsername(username2);

    }
}