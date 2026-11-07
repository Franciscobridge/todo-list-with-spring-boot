package com.example.demo.DTOs;

import com.example.demo.domain.TaskStatus;

public record TaskUpdateRequest(String title, String description, TaskStatus status) {
}
