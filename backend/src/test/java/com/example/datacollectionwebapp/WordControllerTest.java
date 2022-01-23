package com.example.datacollectionwebapp;

import com.example.controller.WordController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class WordControllerTest {

    private WordController wc = new WordController();

    @Test
    void wordDistribution() {
        Map<String, Integer> wordcount = new HashMap<>();
        String word;
        for(int i = 0; i < 1000; i++) {
            word = wc.getRandomWord();
            if(wordcount.containsKey(word)) {
                wordcount.put(word, wordcount.get(word)+1);
            }
            else {
                wordcount.put(word, 1);
            }
        }
        for(String str : wordcount.keySet()) {
            System.out.println(String.format("%s: %s", str, wordcount.get(str)));
        }
    }

}
