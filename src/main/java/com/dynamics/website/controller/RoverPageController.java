package com.dynamics.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoverPageController {

    @GetMapping("/dynamics/aboutus/rover")
    public String roverPage(){
        return "rover.html";
    }
}
