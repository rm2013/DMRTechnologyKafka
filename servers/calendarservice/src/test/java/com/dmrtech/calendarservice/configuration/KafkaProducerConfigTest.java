package com.dmrtech.calendarservice.configuration;


import com.dmrtech.calendarservice.model.CalendarItemEvent;
import org.junit.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for KafkaProducerConfig
 *
 * @author dferguson
 * @see KafkaProducerConfig
 */
public class KafkaProducerConfigTest {
    /**
     * Parasoft Jtest UTA: Test for calendarItemEventProducerFactory()
     *
     * @author dferguson
     * @see KafkaProducerConfig#calendarItemEventProducerFactory()
     */
    @Test(timeout = 1000)
    public void testCalendarItemEventProducerFactory() throws Throwable {
        // Given
        KafkaProducerConfig underTest = new KafkaProducerConfig();

        // When
        ProducerFactory<String, CalendarItemEvent> result = underTest.calendarItemEventProducerFactory();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for kafkaTemplate()
     *
     * @author dferguson
     * @see KafkaProducerConfig#kafkaTemplate()
     */
    @Test(timeout = 1000)
    public void testKafkaTemplate() throws Throwable {
        // Given
        KafkaProducerConfig underTest = new KafkaProducerConfig();

        // When
        KafkaTemplate<String, CalendarItemEvent> result = underTest.kafkaTemplate();

        // Then
        // assertNotNull(result);
    }
}