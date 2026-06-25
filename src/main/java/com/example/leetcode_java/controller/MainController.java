package com.example.leetcode_java.controller;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.leetcode_java.model.Submission;
import com.example.leetcode_java.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SubmissionDto> submission(
            @PathVariable String id,
            @RequestBody Submission submission) {
        try {
            routeService.addToQueue(submission);

            SubmissionDto response = new SubmissionDto(
                    "Submission successful",   // msg
                    true,                      // status
                    submission.getUserId(),    // UserId
                    UUID.randomUUID()                         // Question_id
            );

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            SubmissionDto error = new SubmissionDto(
                    "Invalid submission: " + e.getMessage(),
                    false,
                    submission.getUserId(),
                    UUID.randomUUID()

            );
            return ResponseEntity.badRequest().body(error);

        } catch (Exception e) {
            SubmissionDto error = new SubmissionDto(
                    "Internal server error: " + e.getMessage(),
                    false,
                    submission.getUserId(),
                    UUID.randomUUID()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }


    public class SubmissionDto {
        private String msg;
        private Boolean status;
        private UUID UserId;
        private UUID Question_id;
        private LocalDateTime timestamp;

        // Constructor
        public SubmissionDto(String msg, Boolean status, UUID UserId, UUID Question_id) {
            this.msg = msg;
            this.status = status;
            this.UserId = UserId;
            this.Question_id = Question_id;
            this.timestamp = LocalDateTime.now(); // auto set current time
        }

        // Getters & Setters
        public String getMsg() { return msg; }
        public void setMsg(String msg) { this.msg = msg; }

        public Boolean getStatus() { return status; }
        public void setStatus(Boolean status) { this.status = status; }

        public UUID getUserId() { return UserId; }
        public void setUserId(UUID UserId) { this.UserId = UserId; }

        public UUID getQuestion_id() { return Question_id; }
        public void setQuestion_id(UUID Question_id) { this.Question_id = Question_id; }

        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    }
}
