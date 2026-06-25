package com.example.leetcode_java.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Submission {
    private UUID UserId;
    private  UUID SubmissionId;
    private  String Lang;
    private Boolean Status;
}
