package com.example.project;

import org.junit.jupiter.api.*;

class MyRepeatedTest {    
    @RepeatedTest(3)
    @DisplayName("my repeated test")
    void addNumber(TestInfo testInfo) {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        System.out.println("[OUTPUT-Junit5]: repeatedtest"); 
    }

}
