package com.example.controller;

import com.example.datacollectionwebapp.Logger;
import com.example.repositories.TypingDataRepository;
import com.google.gson.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

@RestController
public class TypingDataController {

    @Autowired
    private TypingDataRepository typingRepo;

    @PostMapping("/rest/addData")
    @CrossOrigin
    public void addTypingData(@RequestBody String td_json) throws IOException {
        if(!(td_json.equals("")) && td_json != null) {
            if(verifyJSON(td_json)) {
                typingRepo.insert(new JSONObject(td_json));
            }
            else {
                Logger.log("Error, JSON is invalid!" + td_json);
            }
        }
        else {
            Logger.log("Error in receiving Data, json is null!" + td_json);
        }
    }

    private boolean verifyJSON(String json) {
        return json.contains("timings") && json.contains("word");
    }
}
