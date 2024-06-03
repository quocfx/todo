package com.lf.todo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class TodoClock {
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
