package com.taskmanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task {
  private int id;
  private String description;
  private Priority priority;
  private Category category;
  private LocalDate dueDate;
  private Boolean isDone;

  public Task(int id, String description, Priority priority, Category category, String dueDateStr) {
    if (description == null || description.trim().isEmpty()) {
      throw new IllegalArgumentException("Description cannot be empty");
    }
    if (priority == null) {
      throw new IllegalArgumentException("Priority cannot be null");
    }
    if (category == null) {
      throw new IllegalArgumentException("Category cannot be null");
    }
    this.id = id;
    this.description = description.trim();
    this.priority = priority;
    this.category = category;
    this.isDone = false;
    setDueDate(dueDateStr);
  }

  public void setDueDate(String dueDateStr) {
    if (dueDateStr == null || dueDateStr.trim().isEmpty()) {
      this.dueDate = null; // dueDate can be empty
      return;
    }

    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      this.dueDate = LocalDate.parse(dueDateStr, formatter);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date format. Use yyyy-MM-dd");
    }
  }

  public void markAsDone(){
    this.isDone = true;
  }

  public int getId(){
    return id;
  }
  public String getDescription(){
    return description;
  }
  public Priority getPriority(){
    return priority;
  }
  public Category getCategory(){
    return category;
  }
  public LocalDate getDueDate(){
    return dueDate;
  }
  public boolean isDone(){
    return isDone;
  }

  @Override
  public String toString() {
    String dueDateStr = (dueDate != null) ? dueDate.toString() : "No due date";
    String status = isDone ? "Done" : "Pending";
    return String.format("ID: %d | %s | Priority: %s | Category: %s | Due: %s | Status: %s", id, description, priority,
        category.getName(), dueDateStr, status);
  }
}