package com.example.leetcode_java.controller;


import com.example.leetcode_java.model.Submission;
import com.example.leetcode_java.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
   RouteService routeService;

    @GetMapping("/")
    public String greet(){
        return routeService.greet();
    }

    @PostMapping("/submission/{id}")
    public String submission(@PathVariable String id, @RequestBody Submission submission) {
        routeService.addToQueue(submission);
        return "added";
    }

}
