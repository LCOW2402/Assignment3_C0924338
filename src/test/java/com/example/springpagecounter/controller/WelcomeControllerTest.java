package com.example.springpagecounter.controller;

import com.example.springpagecounter.service.PageCounter;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WelcomeControllerTest {

    @Test
    void testWelcomePageLoadsAndIncrementsCounter() {
        PageCounter pageCounter = mock(PageCounter.class);
        WelcomeController controller = new WelcomeController(pageCounter);

        Model model = mock(Model.class);
        String viewName = controller.welcome(model);

        verify(pageCounter, times(1)).increment();
        verify(model, times(1)).addAttribute(eq("pageCount"), any());

        assertEquals("welcome", viewName);
    }
}