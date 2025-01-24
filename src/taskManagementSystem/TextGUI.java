package taskManagementSystem;
import java.util.Scanner;
//Import statements to include the necessary task classes

public class TextGUI {
	public static final String FILENAME = "tasks.ser";
	public void show() {
		Scanner input = new Scanner(System.in);
		TaskManager taskManager = new TaskManager();
		taskManager.loadTasksfromFile(FILENAME);

		// Loop for the user to choose the kind of operation they want to perform.
		while (true) {
			System.out.println("---------------------------------");
			System.out.println("Welcome to the TaskManager system!");
			System.out.println("---------------------------------");
			System.out.println("The following tasks have a reminder attached to them:" +"\n");

			if(taskManager.size()>0) {
				taskManager.reminderUser();
			}
			
			// User options
			System.out.println("Instructions:");
			System.out.println("-------------");
			System.out.println("1. Show all current tasks.");
			System.out.println("2. Add a new task.");
			System.out.println("3. Remove an existing task.");
			System.out.println("4. Exit the system." + "\n");
			System.out.println("Enter your choice(1-4):\n");
			// Read the user choice and store in the choice variable.
			int choice = input.nextInt();
			input.nextLine();

			// Operations based on choice.
			// Show all current tasks.
			if (choice == 1) {
				System.out.println("\n"+taskManager.getAlltasks());
			}

			// Add a new task.
			else if (choice == 2) {
				System.out.println("\n" + "What kind of task would you like to create?" + "\n");
				System.out.println("1. Personal Task");
				System.out.println("2. Work Task");
				System.out.println("3. TeamWork Task" + "\n");
				int option = input.nextInt();

				if (option == 1) {
					System.out.print("Enter task ID: ");
					int newID = input.nextInt();
					Task dupCheck = new Task(newID);

					// Check for duplicate ID and perform needed function.
					if (taskManager.checkDuplicate(dupCheck)) {
						System.out.println("ID already exists. Task unsuccessful." + "\n");
					}

					// Else continuing the loop.
					else {
						System.out.print("Enter task name: ");
						String newName = input.next();
						System.out.print("Enter task description (optional): ");
						String newDescription = "";
						input.nextLine();
						if (input.hasNextLine()) {
							newDescription = input.nextLine();
						}
						//If the user wants to use personaltask.
						PersonalTask newTask = new PersonalTask(newID, newName, newDescription.trim());
						if (taskManager.addTask(newTask)) {
							System.out.println("\nTask added successfully!" + "\n");
						} 
						else {
							System.out.println("\nFailed to add task.");
						}
						
						System.out.println("All current tasks:" + "\n");
						System.out.println(taskManager.getAlltasks());
						taskManager.saveAlltasks(FILENAME);

					}
				}

				else if (option == 2) {
					System.out.print("\n" + "Enter task ID: ");
					int newID = input.nextInt();
					Task dupCheck = new Task(newID);

					// Check for duplicate ID and perform needed function.
					if (taskManager.checkDuplicate(dupCheck)) {
						System.out.println("ID already exists. Task unsuccessful." + "\n");
					}
					// Else continuing the loop.
					else {
						System.out.print("Enter task name: ");
						String newName = input.next();
						System.out.print("Enter task description (optional): ");
						String newDescription = "";
						input.nextLine();
						if (input.hasNextLine()) {
							newDescription = input.nextLine();
						}
						//If the user wants to use worktask.
						WorkTask newTask = new WorkTask(newID, newName, newDescription.trim());
						if (taskManager.addTask(newTask)) {
							System.out.println("\nTask added successfully!" + "\n");
						} else {
							System.out.println("\nFailed to add task.");
						}
						System.out.println("All current tasks:" + "\n");
						System.out.println(taskManager.getAlltasks());
						taskManager.saveAlltasks(FILENAME);

					}
				}

				else if (option == 3) {
					System.out.print("\n" + "Enter task ID: ");
					int newID = input.nextInt();
					Task dupCheck = new Task(newID);

					// Check for duplicate ID and perform needed function.
					if (taskManager.checkDuplicate(dupCheck)) {
						System.out.println("ID already exists. Task unsuccessful." + "\n");
					}

					// Else continuing the loop.
					else {
						System.out.print("Enter task name: ");
						String newName = input.next();
						System.out.print("Enter task description (optional): ");
						String newDescription = "";
						input.nextLine();
						if (input.hasNextLine()) {
							newDescription = input.nextLine();
						}
						System.out.print("Enter team name:");
						String newTeamName = input.next();
						
						//If the user wants to use teamworktask.
						TeamWorkTask newTask = new TeamWorkTask(newID, newName, newDescription.trim(), newTeamName);
						if (taskManager.addTask(newTask)) {
							System.out.println("\nTask added successfully!" + "\n");
						} else {
							System.out.println("\nFailed to add task.");
						}
						System.out.println("All current tasks:" + "\n");
						System.out.println(taskManager.getAlltasks());
						taskManager.saveAlltasks(FILENAME);

					}
				}
				else {
					System.out.println("\nInvaid choice. Please enter a vaild option.");
				}
			}

			// Remove an existing task using ID.

			else if (choice == 3) {
				System.out.print("\nEnter task ID to remove: ");
				int tasktoRemove = input.nextInt();
				if (taskManager.removeTask(tasktoRemove)) {
					System.out.println("\nTask removed successfully." + "\n");
				} else {
					System.out.println("\nID doesnt exist in the TaskList. Task unsuccesful." + "\n");

				}
				if(taskManager.size()>0) {
					System.out.println("All current tasks:" + "\n");
					System.out.println(taskManager.getAlltasks());
					
				}
				else {
					System.out.println("No tasks available.");
				}
			}

			// Exiting the program.
			else if (choice == 4) {
				System.out.println("\nExiting the system. Bye!");
				input.close();
				System.exit(0);
				taskManager.saveAlltasks(FILENAME);
			}

			// Invalid choice.
			else {
				System.out.println("\nInvalid choice. Please enter a valid option." + "\n");
			}
		}
	}
}
