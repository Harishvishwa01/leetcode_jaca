package com.example.leetcode_java.services;

import com.example.leetcode_java.model.Submission;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class RouteService {
    Queue<Submission> queue = new LinkedList<>();

    public String greet(){
        return "hello world";
    }


    public void addToQueue(Submission no){
        queue.add(no);
    }


}
