package com.multi.db.multi_db_sb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

    @Bean("postgresDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("postgresJdbcTemplate")
    @Primary
    public JdbcTemplate postgresJdbcTemplate(
            @Qualifier("postgresDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
    
    
    
    
    
    
    @Bean("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("oracleJdbcTemplate")
    public JdbcTemplate oracleJdbcTemplate(
            @Qualifier("oracleDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
    
    
    
    
    @Bean("h2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("h2JdbcTemplate")
    public JdbcTemplate h2JdbcTemplate(
            @Qualifier("h2DataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}