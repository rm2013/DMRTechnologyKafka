package com.dmrtech.endstate.services;

import com.dmrtech.endstate.model.CalendarItemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class CalendarItemEventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CalendarItemEventConsumer.class);

    @KafkaListener(id="calendaritems", topics = "${kafka.calendarItemTopicName}",autoStartup = "true")
    public void calendarItemEventListener(CalendarItemEvent calendarItemEvent) {
        logger.debug("received message {}", calendarItemEvent);
    }
}
