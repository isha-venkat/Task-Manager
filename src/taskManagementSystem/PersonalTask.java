package taskManagementSystem;

public class PersonalTask extends Task{
	//Class created to use personaltask.
	public PersonalTask(int ID, String name, String description) {
		super(ID, name, description);
	}	
	 
	@Override
	public String toString() {
		return "Personal Task: " + super.toString();
	}
}
