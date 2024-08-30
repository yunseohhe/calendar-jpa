package com.sparta.calendarjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableJpaAuditing
@SpringBootApplication
public class CalendarJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarJpaApplication.class, args);
    }

}


// 6단계 구현까지 - 해설영상 ( 1:41:07 까지임)