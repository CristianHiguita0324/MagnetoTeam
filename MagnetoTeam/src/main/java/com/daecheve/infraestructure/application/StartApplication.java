package com.daecheve.infraestructure.application;

import com.daecheve.adapter.delivery.MutantDelivery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public MutantDelivery mutantDelivery() {
        return new MutantDelivery();
    }
}
