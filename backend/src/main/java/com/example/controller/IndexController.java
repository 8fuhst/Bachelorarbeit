package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Scanner;

@RestController
public class IndexController {

    @GetMapping("/rest/ID")
    @CrossOrigin
    public int generateNextID() throws FileNotFoundException, IOException {
        int newID = 0;
        int lastID;
        Scanner scanner = new Scanner(new File("backend/src/main/resources/lastId.txt"));
        lastID = scanner.nextInt();
        newID = lastID + 1;
        scanner.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("backend/src/main/resources/lastId.txt"));
        writer.write(String.valueOf(newID));
        writer.close();
        return newID;
    }
}
