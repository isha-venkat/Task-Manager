package taskManagementSystem;
//Class created to use worktask.
public class WorkTask extends Task implements Remindable{
	public WorkTask(int ID, String name, String description) {
        super(ID, name, description);	
	}

	@Override
	public String toString() {
	return "Work Task: " + super.toString();
	}


	@Override
	public void reminderUser() {
		System.out.println("Reminder: This task is urgent! <" + toString() + ">");
	}
}
