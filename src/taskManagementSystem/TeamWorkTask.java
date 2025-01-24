package taskManagementSystem;
//Class created to use teamworktask.
public class TeamWorkTask extends WorkTask implements Remindable{
	public TeamWorkTask(int ID, String name, String description, String teamName) {
		super(ID, name, description);
        this.teamName = teamName;

	}

	@Override
	public String toString() {
	return "TeamWork Task" + "(" + teamName + "):" + super.toString();

	}

	@Override
	public void reminderUser() {
		System.out.println("Reminder: This task is urgent! <" + toString() + ">");	
	}
}
	


