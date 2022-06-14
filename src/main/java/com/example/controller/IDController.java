package com.example.controller;

import com.example.datacollectionwebapp.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Scanner;

@RestController
@CrossOrigin
public class IDController {
    @GetMapping("/rest/ID")
    @CrossOrigin
    public int generateNextID() throws FileNotFoundException, IOException {
        int newID = 0;
        int lastID;
        Scanner scanner = new Scanner(new File("/opt/tomcat/webapps/DataCollectionWebApp/WEB-INF/classes/lastId.txt"));
        lastID = scanner.nextInt();
        newID = lastID + 1;
        Logger.log("Newest ID: " + newID);
        scanner.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("/opt/tomcat/webapps/DataCollectionWebApp/WEB-INF/classes/lastId.txt")); //src/main/resources/lastId.txt
        writer.write(String.valueOf(newID));
        writer.close();
        Double toHash = (double) newID + System.nanoTime();
        return Math.abs(toHash.hashCode());
    }
}
