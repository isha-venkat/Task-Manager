package taskManagementSystem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


//TaskManager class to store all the functions of the Task class into an array.
public class TaskManager extends ArrayList <Task> {
	
	
	// addTask() method to add new tasks to the task list. 
	public boolean addTask(Task t) { 
		super.add(t);
		return true;		
	}
	
	// checkDuplicate() method to check if the ID of the tasks are unique. 
	public boolean checkDuplicate(Task t) {
		for (int i=0;i<this.size();i++) {
			if(this.get(i).getID()==(t.getID())) {
				return true;
			}		
		}
		return false;	
	}
	
	// removeTask() method to remove existing task using ID. 
	public boolean removeTask(int ID) {
		for (int i=0;i<this.size();i++) {
			if(this.get(i).getID()==(ID)) {
				super.remove(i);
				return true;
			}	
		}
		return false;		
	}
	
	// getSize() method to show the current number of tasks in the list.  
	public int getSize(){
		return super.size();
	}
	
	// getAlltasks() method to show all the tasks in the list. 
	public String getAlltasks() {
		String[] taskDetails = new String[super.size()];
        for (int i=0;i<super.size();i++) {
            taskDetails[i]=super.get(i).toString();
        }
        return String.join("\n", taskDetails);	
	}
	// reminderUser() method to give the user the reminder. 
	public void reminderUser() {
		boolean isFirst = true;
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i) instanceof Remindable) {
				if (isFirst) {
					isFirst = false;
				}
				((Remindable) super.get(i)).reminderUser();
			}
		}
	}
		
	// Method to store tasks to a file
	public boolean saveAlltasks(String filename) {
		try (FileOutputStream fos = new FileOutputStream("tasks.ser");
			 OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			 BufferedWriter writer = new BufferedWriter(osw)) {
			writer.write(getAlltasks());
			System.out.println("Tasks saved to file: " + filename);
		}
        catch (IOException e) {
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
		return true;
    }
   

	// Method to read tasks from a file
    @SuppressWarnings("unchecked")
    public boolean loadTasksfromFile(String filename) {
        try {
            // Check if the file exists
            File file = new File(filename);
            if (!file.exists()) {
                // If the file doesn't exist, create it
                if (file.createNewFile()) {
                    System.out.println("File created: " + filename);
                } else {
                    System.out.println("Failed to create file: " + filename);
                    return false;
                }
            }
        
            loadFile();
        }
        catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return false;
        }
		return false;
    }

	public List<Task> getTasklist() {
		return getTasklist();
	}
	public boolean loadFile() {
		String data = null;
		try{
			File myObj = new File("tasks.ser");

	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        data = myReader.nextLine();
	        System.out.println(data);
	      }
	      myReader.close();
		}
		catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return false;
        }
		return false;
		
		
	}
}
