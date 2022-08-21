package com.salon.salon.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.salon.salon.repository")
@EntityScan("com.salon.salon.domain.models")
@EnableJpaAuditing
public class DatabaseConfig {
}
