package com.example.datacollectionwebapp;

import com.example.controller.WordController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = WordController.class)
public class DataCollectionWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectionWebAppApplication.class, args);
    }

}
