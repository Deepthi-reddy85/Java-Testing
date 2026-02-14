package com.example.CICDExample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalTest {

    @Test
    public void addTest() {
        SimpleCal cal = new SimpleCal();
        assertEquals(13, cal.add(5, 8));
    }

    @Test
    public void multiplyTest() {
        SimpleCal cal = new SimpleCal();
        assertEquals(25, cal.mul(5, 5));
    }
}