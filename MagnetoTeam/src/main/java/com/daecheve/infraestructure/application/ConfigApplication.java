package com.daecheve.infraestructure.application;

import com.daecheve.adapter.delivery.MutantDelivery;
import com.daecheve.adapter.repository_adapter.MutantRepositoryAdapter;
import com.daecheve.core.mutant.port.MutantPort;
import com.daecheve.core.mutant.service.MutantService;
import com.daecheve.infraestructure.repository.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author daecheve
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.daecheve.*"})
@EntityScan("com.daecheve.infraestructure.repository.entity")
@EnableJpaRepositories("com.daecheve.infraestructure.repository")
public class ConfigApplication {

    @Autowired
    MutantRepository mutantRepository;

    @Bean
    public MutantPort mutantPort() {
        return new MutantRepositoryAdapter(mutantRepository);
    }

    @Bean
    public MutantService mutantService() {
        return new MutantService(mutantPort());
    }

    @Bean
    public MutantDelivery mutantDelivery() {
        return new MutantDelivery(mutantService());
    }
}
