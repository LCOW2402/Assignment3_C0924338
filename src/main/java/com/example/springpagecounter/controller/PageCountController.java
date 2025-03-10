package com.example.springpagecounter.controller;

import com.example.springpagecounter.service.PageCounter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/count")
public class PageCountController {

    private final PageCounter pageCounter;

    public PageCountController(PageCounter pageCounter) {
        this.pageCounter = pageCounter;
    }

    @GetMapping("/currentcount")
    public Integer getCurrentCount() {
        return pageCounter.getPageCount();
    }
}