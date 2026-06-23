package com.example.leetcode_java.services;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class RouteService {
    Queue<Integer> queue = new LinkedList<>();

    public String greet(){
        return "hello world";
    }


    public void addToQueue(int no){
        queue.add(no);
    }


}
