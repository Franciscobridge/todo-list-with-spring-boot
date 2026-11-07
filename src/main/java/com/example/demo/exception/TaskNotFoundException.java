package com.example.demo.exception;

public class TaskNotFoundException extends RuntimeException {

   public TaskNotFoundException(String id) {
      super("Tarefa com id " + id + " não encontrada");
   }
}