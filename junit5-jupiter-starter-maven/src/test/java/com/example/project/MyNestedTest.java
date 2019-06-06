package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

@DisplayName("JUnit 5 Nested Example")
class MyNestedTest {   
    @Nested
    class ATests {
        @Test
        public void test() {
            assertEquals(true, false);
        }

    }

    @Nested
    class A {
        @Test
        @DisplayName("Example test for method A")
        void sampleTestForMethodA() {
            System.out.println("Example test for method A");
        }

        @Nested        
        class WhenX {           
            @Test
            @DisplayName("Example test for method A when X is true")
            void sampleTestForMethodAWhenX() {
                System.out.println("Example test for method A when X is true");                
            }
        }
    }
}