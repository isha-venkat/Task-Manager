package taskManagementSystem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//Tester to check all the tasks.
class Tester {
    private TaskManager taskManager;
    private static final String TEST_FILEMAN = "tasks.ser";

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }
    
    @After
    public void tearDown() {
    	File file = new File("TEST_FILEMAN");
    	if(file.exists()) {
    		file.delete();
    	}
    	
    }

    @Test
    void testAddTask() {
        Task personalTask = new PersonalTask(1, "Personal Task 1", "Description");
        assertTrue(taskManager.addTask(personalTask));
        assertEquals(1, taskManager.size());

        Task workTask = new WorkTask(2, "Work Task 1", "Description");
        assertTrue(taskManager.addTask(workTask));
        assertEquals(2, taskManager.size());

        Task teamWorkTask = new TeamWorkTask(3, "Teamwork Task 1", "Description", "Team A");
        assertTrue(taskManager.addTask(teamWorkTask));
        assertEquals(3, taskManager.size());

    }

    @Test
    void testRemoveTask() {
        taskManager.addTask(new PersonalTask(1, "Personal Task 1", "Description"));
        taskManager.addTask(new WorkTask(2, "Work Task 1", "Description"));
        taskManager.addTask(new TeamWorkTask(3, "Teamwork Task 1", "Description", "Team A"));

        assertTrue(taskManager.removeTask(1));
        assertEquals(2, taskManager.size());

        assertFalse(taskManager.removeTask(4));
        assertEquals(2, taskManager.size());
    }
    
    @Test
    void testSaveAndLoadTasks() {
        // Add some tasks to the task manager
        Task task1 = new PersonalTask(1, "Task 1", "Description 1");
        Task task2 = new WorkTask(2, "Task 2", "Description 2");
        Task task3 = new TeamWorkTask(3, "Task 3", "Description 3", "Team A");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        
        // Save tasks to file
        taskManager.saveAlltasks(TEST_FILEMAN);
        
        // Clear the task manager and load tasks from file
        taskManager = new TaskManager();
        taskManager.loadTasksfromFile(TEST_FILEMAN);
        
        // Retrieve loaded tasks
        String loadedTasksstring = taskManager.getAlltasks();
        
        // Expected string representation of tasks
        String expectedTaskstring = "Personal Task: Task{ID=1, Name='Task 1', Description='Description 1'}\n" +"Work Task: Task{ID=2, Name='Task 2', Description='Description 2'}\n" +"Teamwork Task: Task{ID=3, Name='Task 3', Description='Description 3', Team='Team A'}";
        
        // Check if loaded tasks match the expected string representation
        assertEquals(expectedTaskstring, loadedTasksstring);
    }
}