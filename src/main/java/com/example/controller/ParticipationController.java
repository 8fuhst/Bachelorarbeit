package com.example.controller;

import com.example.datacollectionwebapp.Logger;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class ParticipationController {
    private int evalParticipants = 0;
    private int doubleParticipants = 0;

    @PostMapping("/rest/participation")
    @CrossOrigin
    public void addParticipant(@RequestBody String strval) throws IOException {
        int val = Integer.parseInt(strval);
        if(val == 1) {
            doubleParticipants++;
        }
        evalParticipants++;
        BufferedWriter writer = new BufferedWriter(new FileWriter("/opt/tomcat/webapps/DataCollectionWebApp/WEB-INF/classes/participants.log", false));
        writer.write("Total Participants: " + evalParticipants + "\nDouble Participants: " + doubleParticipants);
        writer.close();
    }
}
