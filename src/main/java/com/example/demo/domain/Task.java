package com.example.demo.domain;

public class Task {
   private String id;
   private String title;
   private String description;
   private TaskStatus status;


   public Task(String id, String title, String description, TaskStatus status){
      this.id = id;
      this.title = title;
      this.description = description;
      this.status = status;
   }

   public String getTitle(){
      return this.title;
   }

   public void setTitle(String title){
      this.title = title;
   }

   public String getDescription(){
      return this.description;
   }

   public void setDescription(String description){
      this.description = description;
   }

   public TaskStatus getStatus(){
      return this.status;
   }

   public void setStatus(TaskStatus status){
      this.status = status;
   }

   public String getId(){
      return this.id;
   }
}
