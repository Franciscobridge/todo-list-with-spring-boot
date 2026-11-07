package com.example.demo.repository.InMemory;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository {
   List<Task> getAllTasks();
   Optional<Task> getTaskById(String id);
   Task createTask(String title, String description);
   Task updateTask(String id, String title, String description, TaskStatus status);
   void deleteTask(String id);
}
