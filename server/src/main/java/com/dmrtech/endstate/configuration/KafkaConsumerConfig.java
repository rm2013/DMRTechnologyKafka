package com.dmrtech.endstate.configuration;

import com.dmrtech.endstate.model.CalendarItemEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.kafkaBroker}")
    private String kafkaBroker;

    @Value(value = "${kafka.consumerGroupName}")
    private String kafkaConsumerGroupName;

    //@Bean
    public ConsumerFactory<String, CalendarItemEvent> calendarItemEventConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerGroupName + UUID.randomUUID());
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(CalendarItemEvent.class));
    }

    //@Bean
    public ConcurrentKafkaListenerContainerFactory<String, CalendarItemEvent> calendarItemEventListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, CalendarItemEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(calendarItemEventConsumerFactory());
        return factory;
    }
}