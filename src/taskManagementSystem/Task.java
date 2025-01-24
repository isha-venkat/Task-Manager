package taskManagementSystem;
import java.io.Serializable;

// Task class representing a task with ID, name, and description.
public class Task implements Serializable{
	// Defining the fields of the class. 
	private int ID;
	private String name;
	private String description;
	protected String teamName;
	
	// Task constructor to initialize only the ID field.
	public Task(int ID) {
		this.ID=ID;
	}

	// Task constructor to initialize only the ID and name field. 
	public Task(int ID, String name) {
		this.ID=ID;
		this.name=name;
		this.description="";
	}
	
	// Task constructor to initialize all the ID, name, description field.
	public Task(int ID, String name, String description) {
		this.ID=ID;
		this.name=name;
		this.description=description;
	}
	
	public Task(int ID, String name, String description, String teamName) {
		this.ID=ID;
		this.name=name;
		this.description=description;
		this.teamName=teamName;
	}

	// Getter method for getting the task ID. 
	public int getID() {
		return ID;		
	}
	
	// Getter method for getting the task name. 
	public String getName() {
		return name;
	}
	
	// Getter method for getting the task description. 
	public String getDescription() {
		return description;
	}
	
	// Getter method for getting the team name.
	public String getTeamName() {
		return teamName;
	}
	
	// Setter method for setting the task ID and returning it.
	public int setID() {
		return ID;
	}
	
	// Setter method for setting the task name and returning it.
	public String setName() {
		return name;
	}
	
	// Setter method for setting the task description and returning it.
	public String setDescription() {
		return description;
	}
	
	// Setter method for setting the team name and returning it.
	public String setTeamName() {
		return teamName;
	}
	
	// toString method to print the task details in a textual way. 
	@Override
	public String toString() {
		return "Task{ID=" + ID + ", Name='" + name + "', Description='" + description + "'}" + "\n";
	}
}