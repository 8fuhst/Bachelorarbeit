package com.example.controller;

import org.springframework.stereotype.Controller;
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
    public String getRandomWord() {
        // TODO: Read file, pick random word, respond
        // System.out.println("Request received!");
        Random random = new Random();
        int amountLines = 57;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("backend/src/main/resources/WordPool.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int randint = random.nextInt(amountLines-1)+1; //TODO: Variable File length
        String out = "";
        for(int i = 0; i < randint; i++) {
            try {
                out = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(out);
        return out;
    }

}
