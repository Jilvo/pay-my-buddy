package com.paymybuddy.paymybuddy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontEndController {

    @GetMapping(value = "/")
    public String getTemplate(@RequestParam(name = "name", required = false, defaultValue = "World") String param,
                              Model model) {
        return "home";
    }

}
