package com.rouvsen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJobSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJobSchedulerApplication.class, args);
    }

}
