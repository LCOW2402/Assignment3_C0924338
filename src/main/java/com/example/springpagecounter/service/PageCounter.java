package com.example.springpagecounter.service;
import org.springframework.stereotype.Component;

@Component
public class PageCounter {
    private Integer pageCounter = 0;

    public synchronized void increment() {
        pageCounter++;
    }

    public Integer getPageCount() {
        return pageCounter;
    }
}