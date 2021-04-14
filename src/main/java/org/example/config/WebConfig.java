package org.example.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.example" })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Bean
    public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource getDataSource() throws NamingException{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/projetrestful");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

}