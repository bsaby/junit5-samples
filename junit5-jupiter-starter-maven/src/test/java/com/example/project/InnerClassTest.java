package com.example.project;

import org.junit.jupiter.api.Test;

class InnerClassTest {
    @Test
    void outmethod1() {       
        System.out.println("[OUTPUT-Junit5]: This is out method");        
    }

    public static class InnerTest{
         @Test
         public void innermethod1(){            
            System.out.println("[OUTPUT-Junit5]: This is inner method"); 
         }
     }
}
