package com.taskmanager;

import java.util.List;
import java.util.Scanner;

public class MainApp {
  private TaskManager taskManager;
  private Scanner scanner;

  public MainApp() {
    this.taskManager = new TaskManager();
    this.scanner = new Scanner(System.in);
  }

  public void run() {
    while (true) {
      displayMenu();
      String choice = scanner.nextLine().trim();
      try {
        switch (choice) {
          case "1":
            addTask();
            break;
          case "2":
            removeTask();
            break;
          case "3":
            listTasks();
            break;
          case "4":
            filterByPriority();
            break;
          case "5":
            filterByCategory();
            break;
          case "6":
            markTaskAsDone();
            break;
          case "7":
            System.out.println("Exiting....");
            scanner.close();
            return;
          default:
            break;
        }
      } catch (IllegalArgumentException e) {
      }
    }
  }

  public void displayMenu() {
    System.out.println("\n=== Task manager ===");
    System.out.println("1. Add Task");
    System.out.println("2. Remove Task");
    System.out.println("3. List All Tasks");
    System.out.println("4. Filter by Priority");
    System.out.println("5. Filter by Category");
    System.out.println("6. Mark Task as Done");
    System.out.println("7. Exit");
    System.out.println("Choose an option: ");
  }

  public void addTask() {
    System.out.print("Enter description: ");
    String description = scanner.nextLine().trim();

    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
    Priority priority;
    try {
      priority = Priority.valueOf(scanner.nextLine().trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid priority. Use LOW, MEDIUM, or HIGH");
    }

    System.out.print("Enter category name: ");
    String categoryName = scanner.nextLine().trim();
    Category category = new Category(categoryName);

    System.out.print("Enter due date (yyyy-MM-dd, or leave a blank): ");
    String dueDate = scanner.nextLine().trim();

    taskManager.addTask(description, priority, category, dueDate);
    System.out.println("Task added successfully!");
  }

  public void removeTask() {
    System.out.print("Enter task ID to remove: ");
    try {
      int id = Integer.parseInt(scanner.nextLine().trim());
      if (taskManager.removeTask(id)) {
        System.out.println("Task removed successfully!");
      } else {
        System.out.println("Task ID not found.");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid ID format.");
    }
  }

  private void listTasks() {
    List<Task> tasks = taskManager.listTasks();
    if (tasks.isEmpty()) {
      System.out.println("No tasks available.");
    } else {
      tasks.forEach(System.out::println);
    }
  }

  private void filterByPriority() {
    System.out.print("Enter priority to filter (LOW, MEDIUM, HIGH): ");
    try {
      Priority priority = Priority.valueOf((scanner.nextLine().trim().toUpperCase()));
      List<Task> filtered = taskManager.filterByPriority(priority);
      if (filtered.isEmpty()) {
        System.out.println("No tasks with priority " + priority);
      } else {
        filtered.forEach(System.out::println);
      }
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid priority. Use LOW, MEDIUM, or HIGH.");
    }
  }

  public void filterByCategory() {
    System.out.print("Enter category name to filter: ");
    String categoryName = scanner.nextLine().trim();
    Category category = new Category(categoryName);
    List<Task> filtered = taskManager.filterByCategory(category);
    System.out.println(filtered);
    if (filtered.isEmpty()) {
      System.out.println("No tasks in category " + categoryName);
    } else {
      filtered.forEach(System.out::println);
    }
  }

  public void markTaskAsDone() {
    System.out.print("Enter task ID to mark as done: ");
    try {
      int id = Integer.parseInt(scanner.nextLine().trim());
      if (taskManager.markTaskAsDone(id)) {
        System.out.println("Task marked as done!");
      } else {
        System.out.println("Task ID not found or already done!");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid ID format.");
    }
  }

  public static void main(String[] args) {
    MainApp app = new MainApp();
    app.run();
  }
}