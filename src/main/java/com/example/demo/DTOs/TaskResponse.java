package com.example.demo.DTOs;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskStatus;

public record TaskResponse(String id, String title, String description, TaskStatus status) {
   public static TaskResponse from(Task task) {
      return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
   }
}