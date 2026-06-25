package com.example.leetcode_java.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String name;
    private UUID UserId;
    private int solvedQuestion;
}
