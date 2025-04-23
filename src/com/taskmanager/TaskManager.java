package com.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

  private List<Task> tasks;
  private int nextId;

  public TaskManager() {
    this.tasks = new ArrayList<>();
    this.nextId = 1;
  }

  public void addTask(String description, Priority priority, Category category, String dueDateStr) {
    Task task = new Task(nextId++, description, priority, category, dueDateStr);
    tasks.add(task);
  }

  public boolean removeTask(int id){
    return tasks.removeIf(task -> task.getId() == id);
  }
  public List<Task> listTasks() {
    return new ArrayList<>(tasks);
  }

  public List<Task> filterByPriority(Priority priority) {
    return tasks.stream().filter(task -> task.getPriority() == priority).collect(Collectors.toList());
  }
  public List<Task> filterByCategory(Category category){
    return tasks.stream().filter(task -> task.getCategory().equals(category)).collect(Collectors.toList());
  }

  public boolean markTaskAsDone(int id){
    for(Task task: tasks){
      if (task.getId() == id && !task.isDone()){
        task.markAsDone();
        return true;
      }
    }
    return false;
  }
}