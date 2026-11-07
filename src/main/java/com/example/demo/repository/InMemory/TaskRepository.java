package com.example.demo.repository.InMemory;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class TaskRepository implements ITaskRepository {

   protected Map<String, Task> listTasks = new HashMap<>();

   @Override
   public List<Task> getAllTasks() {
      return new ArrayList<>(listTasks.values());
   }

   @Override
   public Task createTask(String title, String description) {
      String id = UUID.randomUUID().toString();
      Task task = new Task(id, title, description, TaskStatus.PENDING);

      listTasks.put(id, task);

      return task;
   }

   @Override
   public Optional<Task> getTaskById(String id) {
      return Optional.ofNullable(listTasks.get(id));
   }

   @Override
   public Task updateTask(String id, String title, String description, TaskStatus status) {
      Task taskToEdit = listTasks.get(id);
      taskToEdit.setTitle(title);
      taskToEdit.setDescription(description);
      taskToEdit.setStatus(status);

      return taskToEdit;
   }

   @Override
   public void deleteTask(String id) {
      listTasks.remove(id);
   }
}
