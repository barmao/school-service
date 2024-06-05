package com.barmao.school_service.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public Flyway flyway(){
        return Flyway.configure()
                .dataSource(dataSourceUrl, dataSourceUsername, dataSourcePassword)
                .baselineOnMigrate(true)
                .load();
    }
}
