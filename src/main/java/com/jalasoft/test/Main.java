package com.jalasoft.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(Main.class, args);
    }
}
