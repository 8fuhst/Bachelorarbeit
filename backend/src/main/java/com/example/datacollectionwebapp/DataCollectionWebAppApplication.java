package com.example.datacollectionwebapp;

import com.example.controller.WordController;
import com.example.repositories.TypingDataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = WordController.class)
@EnableMongoRepositories(basePackageClasses = TypingDataRepository.class)
public class DataCollectionWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectionWebAppApplication.class, args);
    }

}
