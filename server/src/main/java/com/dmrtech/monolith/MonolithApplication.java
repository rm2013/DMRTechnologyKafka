package com.dmrtech.monolith;

import com.dmrtech.monolith.model.CalendarEvent;
import com.dmrtech.monolith.repository.CalendarEventRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Calendar;
import java.util.Collections;
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

        return args ->
            Stream.of("Write introduction", "Create Sample App", "Introduce Kafka", "Study Vue.js", "Present at GOTO").forEach(name -> {
                CalendarEvent calendarEvent = new CalendarEvent();
                calendarEvent.setTitle(name);
                cal.set(Calendar.MONTH,currentMonth.getAndIncrement());
                calendarEvent.setDetails(String.format("%s | %s | %s", name,name,name));
                calendarEvent.setDate(cal.getTime());
                repository.save(calendarEvent);
            });
    }

    // Fix the CORS errors
    @Bean
    public FilterRegistrationBean simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // *** URL below needs to match the Vue client URL and port ***
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
