package com.example.springpagecounter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageCounterTest {

    private PageCounter pageCounter;

    @BeforeEach
    void setUp() {
        pageCounter = new PageCounter(); // Create a new PageCounter before each test
    }

    @Test
    void testInitialPageCountIsZero() {
        assertEquals(0, pageCounter.getPageCount(), "Initial page count should be 0");
    }

    @Test
    void testPageCountIncrements() {
        pageCounter.increment();
        assertEquals(1, pageCounter.getPageCount(), "After 1 increment, page count should be 1");

        pageCounter.increment();
        assertEquals(2, pageCounter.getPageCount(), "After 2 increments, page count should be 2");
    }

    @Test
    void testMultipleIncrements() {
        for (int i = 0; i < 10; i++) {
            pageCounter.increment();
        }
        assertEquals(10, pageCounter.getPageCount(), "After 10 increments, page count should be 10");
    }

    @Test
    void testThreadSafetyOfIncrement() {
        // Simulating multiple threads incrementing the counter
        int numberOfThreads = 100;
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(pageCounter::increment);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                fail("Thread execution was interrupted");
            }
        }

        assertEquals(numberOfThreads, pageCounter.getPageCount(),
                "After " + numberOfThreads + " parallel increments, count should be " + numberOfThreads);
    }
}