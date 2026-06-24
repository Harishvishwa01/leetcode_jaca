package com.example.leetcode_java.controller;


import com.example.leetcode_java.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
   RouteService routeService;

    @GetMapping("/")
    public String greet(){
        return routeService.greet();
    }

    @PostMapping("/add")
    public String add(@RequestBody Integer no) {
        routeService.addToQueue(no);
        return "added";
    }
}
