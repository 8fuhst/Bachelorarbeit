package com.example.controller;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

@RestController
public class WordController {

    @RequestMapping(method = RequestMethod.GET, value = "/word")
    @CrossOrigin
    public String getRandomWord(@RequestParam String wordnumber) {
        // TODO: Read file, pick random word, respond
        Random random = new Random();
        int amountLines = 41; // 57
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/opt/tomcat/webapps/DataCollectionWebApp/WEB-INF/classes/WordPool.txt")); //src/main/resources/WordPool.txt
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // int randint = random.nextInt(amountLines-1)+1; //TODO: Variable File length
        String out = "";
        for(int i = 0; i <= Integer.parseInt(wordnumber); i++) {
            try {
                if(reader != null) {
                    out = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out;
    }
}
