package com.dmrtech.monolith;

import com.dmrtech.monolith.model.CalendarEvent;
import com.dmrtech.monolith.repository.CalendarEventRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SpringBootApplication
public class MonolithApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonolithApplication.class, args);
    }

    // Bootstrap some test data into the in-memory database
    @Bean
    ApplicationRunner init(CalendarEventRepository repository) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        AtomicInteger currentMonth = new AtomicInteger();

        return args -> {
            Stream.of("Write introduction", "Create Sample App", "Introduce Kafka", "Study Vue.js", "Present at GOTO").forEach(name -> {
                CalendarEvent calendarEvent = new CalendarEvent();
                calendarEvent.setSummary(name);
                cal.set(Calendar.MONTH,currentMonth.getAndIncrement());
                calendarEvent.setDetails(String.format("%s | %s | %s", name,name,name));
                calendarEvent.setDate(cal.getTime());
                repository.save(calendarEvent);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
