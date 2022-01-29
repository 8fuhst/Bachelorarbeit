package com.example.controller;

import com.example.model.TypingData;
import com.example.repositories.TypingDataRepository;
import com.google.gson.*;
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
            JsonObject td = new Gson().fromJson(td_json, JsonObject.class);
            typingRepo.insert(td);
        }
        else {
            System.out.println("Error!");
        }
    }

    private JsonElement parse(String json) throws JsonSyntaxException {
        return new JsonParser().parse(json).getAsJsonObject();
    }
}
