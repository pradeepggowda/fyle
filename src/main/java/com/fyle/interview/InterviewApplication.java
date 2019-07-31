package com.fyle.interview;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.spring.DBIFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class InterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewApplication.class, args);
    }

}
