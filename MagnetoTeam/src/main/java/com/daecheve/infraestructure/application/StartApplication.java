package com.daecheve.infraestructure.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author daecheve
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.daecheve.infraestructure.*"})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
