package com.dmrtech.calendarservice.configuration;


import org.apache.kafka.clients.admin.NewTopic;
import org.junit.Test;
import org.springframework.kafka.core.KafkaAdmin;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for KafkaTopicConfig
 *
 * @author dferguson
 * @see KafkaTopicConfig
 */
public class KafkaTopicConfigTest {
    /**
     * Parasoft Jtest UTA: Test for calendarItems()
     *
     * @author dferguson
     * @see KafkaTopicConfig#calendarItems()
     */
    @Test(timeout = 1000)
    public void testCalendarItems() throws Throwable {
        // Given
        KafkaTopicConfig underTest = new KafkaTopicConfig();

        // When
        NewTopic result = underTest.calendarItems();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for kafkaAdmin()
     *
     * @author dferguson
     * @see KafkaTopicConfig#kafkaAdmin()
     */
    @Test(timeout = 1000)
    public void testKafkaAdmin() throws Throwable {
        // Given
        KafkaTopicConfig underTest = new KafkaTopicConfig();

        // When
        KafkaAdmin result = underTest.kafkaAdmin();

        // Then
        // assertNotNull(result);
    }
}