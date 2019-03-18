package com.example.project;

import org.junit.jupiter.api.Test;

class ConfigurationTest {
    @Test
    void workspacefoldertest() {       
        System.out.println("[OUTPUT-Junit5-env]: " + System.getenv("key"));
        System.out.println("[OUTPUT-Junit5-vmargs]: " +(String) System.getProperties().get("foo")); 
        System.out.println("[OUTPUT-Junit5-workingDirectory]: " + System.getProperty("user.dir")); 
    }

}