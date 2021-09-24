package com.ithub.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionsWeb {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(QuestionsWeb.class);
        app.run();
    }

}