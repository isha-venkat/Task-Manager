# Task Management System

This project is a simple task management system built as part of an Object-Oriented Programming (OOP) coursework. The system lets users add, view, and remove tasks. It also supports different task types and reminders for work-related tasks.

## Features
- **Task Types**: Personal, Work, and TeamWork tasks.
- **Reminders**: Work and TeamWork tasks can send reminders.
- **File Storage**: Save and load tasks from a file.

## Setup
1. **Clone the Repository**:
   - Fork or clone the project to your local machine.
   ```bash
   git clone https://github.com/isha-venkat/Task-Manager

2. Open with Eclipse:
. Import the project into Eclipse to start working.
3. Java Setup:
. Ensure you have Java installed to run the program.

### How to Use
1. Run the Main class to start the program.
2. The system will show a menu with options:
. View all tasks
. Add a task
. Remove a task
. Exit the program

### Code Overview
. Task: Represents a task with ID, name, and description.
. TaskManager: Manages the tasks (add, remove, list).
. PersonalTask, WorkTask, TeamWorkTask: Special types of tasks with extra features.
. Main: The entry point of the program that handles user input.

### Testing
Unit tests are included to verify that adding and removing tasks works as expected.
