package com.cgi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Code Challenge App.
 */
public class FibonacciClockTest {

    @Test
    public void itShouldReturnRGBColor() {
        FibonnaciClock fibonnaciClock = new FibonnaciClock(1, 50);
        assertEquals("R 1  | G 5 3 2  | B ", fibonnaciClock.calculateRGBColors());
    }

}
