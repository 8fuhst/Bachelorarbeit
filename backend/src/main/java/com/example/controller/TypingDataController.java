package com.example.controller;

import com.example.model.TypingData;
import com.example.repositories.TypingDataRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TypingDataController {

    @Autowired
    private TypingDataRepository typingRepo;

    @PostMapping("/rest/addData")
    @CrossOrigin
    public void addTypingData(@RequestBody String td_json) throws IOException {
        System.out.println("td_json: " + td_json);
        if(!(td_json.equals("")) && td_json != null) {
            System.out.println("Received Data!");
            Gson g = new Gson(); //TODO: Fix!!
            TypingData td = g.fromJson(td_json, TypingData.class);
            typingRepo.insert(td);
        }
        else {
            System.out.println("Error!");
        }
    }
}
