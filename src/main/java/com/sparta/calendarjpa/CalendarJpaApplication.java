package com.sparta.calendarjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CalendarJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarJpaApplication.class, args);
    }

}
