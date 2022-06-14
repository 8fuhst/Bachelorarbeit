package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @CrossOrigin
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @CrossOrigin
    @GetMapping(value = "/collectionSite")
    public String collectionSite() {
        return "collectionSite";
    }

    @CrossOrigin
    @GetMapping(value = "/thanks")
    public String thanks() {
        return "thanks";
    }
}
