package com.dynamics.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @GetMapping("/dynamics")
    public String welcomePage(){
        return "index.html";
    }

    @GetMapping("/dynamics/aboutus")
    public String aboutPage(){
        return "about.html";
    }

    @GetMapping("/dynamics/portfolio")
    public String portfolioPage(){
        return "portfolio.html";
    }

    @GetMapping("/dynamics/project")
    public String projectPage(){
        return "project.html";
    }

    @GetMapping("/dynamics/events")
    public String eventPage(){
        return "events.html";
    }

    @GetMapping("/dynamics/team")
    public String teamPage(){
        return "team.html";
    }

}
