package com.example.springpagecounter.controller;

import com.example.springpagecounter.service.PageCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PageCountControllerTest {

    @Test
    void testGetCurrentCount() {
        PageCounter pageCounter = mock(PageCounter.class);
        when(pageCounter.getPageCount()).thenReturn(5);

        PageCountController controller = new PageCountController(pageCounter);
        int count = controller.getCurrentCount();

        assertEquals(5, count);
        verify(pageCounter, times(1)).getPageCount();
    }
}