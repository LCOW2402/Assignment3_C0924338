package com.example.springpagecounter.controller;

import com.example.springpagecounter.service.PageCounter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private final PageCounter pageCounter;

    public WelcomeController(PageCounter pageCounter) {
        this.pageCounter = pageCounter;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        pageCounter.increment();
        model.addAttribute("pageCount", pageCounter.getPageCount());
        return "welcome";
    }
}