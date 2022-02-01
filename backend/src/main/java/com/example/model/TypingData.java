package com.example.model;

import org.springframework.data.annotation.Id;

import javax.json.JsonObject;

public class TypingData {
    @Id
    private String id;
    private int userID;
    private int age;
    private int typingSkill;
    private String layout;
    private String word;
    private JsonObject timings;
    //private JsonObject data;
    /*public TypingData(JsonObject data) {
        this.data = data;
    }*/

    public TypingData(int userID, int age, int typingSkill, String layout, String word, JsonObject data) {
        this.userID = userID;
        this.age = age;
        this.typingSkill = typingSkill;
        this.layout = layout;
        this.word = word;
        this.timings = data;
    }

    /*public TypingData fromJSON(org.bson.json.JsonObject json) {

    }*/

    public String getId() {
        return id;
    }
}
