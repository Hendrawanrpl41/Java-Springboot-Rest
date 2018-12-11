package com.sti.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sti.bootcamp.dao.CustomerDao;
import com.sti.bootcamp.dao.DaoSpringConfig;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories({""})
@Import(DaoSpringConfig.class)
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
