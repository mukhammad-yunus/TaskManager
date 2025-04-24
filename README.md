
# Task Manager Console App

A simple Java console application for managing a to-do list. Users can create, delete, list, and filter tasks by priority or category, set reminders, and mark tasks as done. All data is stored in memory and lost when the program closes.

## Features
- Create tasks with a description, priority (LOW, MEDIUM, HIGH), category, and optional due date.
- Delete tasks by ID.
- List all tasks or filter by priority or category.
- Mark tasks as completed.
- Input validation with user-friendly error messages.
- Console-based menu interface.

## Technologies Used
- **Java**: JDK 17
- **IDE**: Visual Studio Code with Java Extension Pack
- **Version Control**: Git and GitHub
- **Storage**: In-memory (ArrayList)

## How to Install and Run
1. **Install JDK 17**:
   - Download from [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or [Adoptium](https://adoptium.net/).
   - Verify with `java -version`.

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/YOUR_USERNAME/TaskManager.git
   cd TaskManager
   ```

3. **Compile the Code**:
   ```bash
   javac -d bin src/com/taskmanager/*.java
   ```

4. **Run the Application**:
   ```bash
   java -cp bin com.taskmanager.MainApp
   ```

5. **Using VS Code**:
   - Open the `TaskManager` folder in VS Code.
   - Ensure the Java Extension Pack is installed.
   - Run `MainApp.java` by clicking the "Run" button.

## Example Usage
1. Start the app and see the menu:
   ```
   === Task Manager ===
   1. Add Task
   2. Remove Task
   3. List All Tasks
   4. Filter by Priority
   5. Filter by Category
   6. Mark Task as Done
   7. Exit
   Choose an option:
   ```
2. Add a task:
   - Choose option 1.
   - Enter description: "Finish homework"
   - Enter priority: HIGH
   - Enter category: School
   - Enter due date: 2025-04-30
3. List tasks or filter by priority/category.
4. Mark tasks as done or delete them by ID.

## Known Limitations
- Data is not persistent (lost on program exit).
- No sorting of tasks by due date or priority.
- Basic console interface (no GUI).

## Future Improvements
- Add persistent storage (e.g., file-based).
- Implement task sorting.
- Add recurring tasks or reminders.
- Enhance the UI with a graphical interface (e.g., JavaFX, if allowed).


**Git Commit and Push**:
```bash
git add README.md
git commit -m "Add README.md for GitHub"
git push origin main
```
