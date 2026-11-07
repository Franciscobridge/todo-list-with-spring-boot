package com.example.demo.controller;

import com.example.demo.DTOs.TaskRequest;
import com.example.demo.DTOs.TaskResponse;
import com.example.demo.DTOs.TaskUpdateRequest;
import com.example.demo.domain.Task;
import com.example.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

   private final TaskService taskService;

   @GetMapping
   public List<TaskResponse> findAll(){
     return taskService.listAllTask().stream().map(TaskResponse::from).toList();
   }

   @PostMapping
   public ResponseEntity<TaskResponse> createNewTask(@RequestBody TaskRequest taskRequest){
      Task task = taskService.createTask(taskRequest.title(), taskRequest.description());
      return ResponseEntity.status(HttpStatus.CREATED).body(TaskResponse.from(task));
   }

   @GetMapping("/{id}")
   public TaskResponse findById(@PathVariable String id) {
      return TaskResponse.from(taskService.getTaskById(id));
   }

   @PutMapping("/{id}")
   public TaskResponse update(@PathVariable String id, @RequestBody TaskUpdateRequest request) {
      Task task = taskService.updateTask(id, request.title(), request.description(), request.status());
      return TaskResponse.from(task);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void delete(@PathVariable String id) {
      taskService.deleteTask(id);
   }
}
