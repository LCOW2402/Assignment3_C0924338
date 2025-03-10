package com.example.springpagecounter.config;
import com.example.springpagecounter.service.PageCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageCountConfig {

    @Bean
    public PageCounter pageCounter() {
        return new PageCounter();
    }
}