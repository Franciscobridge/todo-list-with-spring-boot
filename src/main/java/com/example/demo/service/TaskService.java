package com.example.demo.service;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskStatus;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.repository.InMemory.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TaskService {
   private final ITaskRepository tastRepository;

   public Task createTask(String title, String description){
      if(title == null || title.trim().isEmpty()){
         throw new IllegalArgumentException("The title of task are empty or null!");
      }

      return tastRepository.createTask(title, description);
   }

   public List<Task> listAllTask(){
      return tastRepository.getAllTasks();
   }

   public Task getTaskById(String id){
      return tastRepository.getTaskById(id).orElseThrow(() -> new TaskNotFoundException(id));
   }

   public Task updateTask(String id, String title, String description, TaskStatus status){
      return tastRepository.updateTask(id, title, description, status);
   }

   public void deleteTask(String id){
      tastRepository.deleteTask(id);
   }
}
