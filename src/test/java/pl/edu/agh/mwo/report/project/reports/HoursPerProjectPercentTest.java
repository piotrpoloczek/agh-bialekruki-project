package pl.edu.agh.mwo.report.project.reports;

import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HoursPerProjectPercentTest {

    @Test
    void testGenerate_twoProjectsWithEqualTime() {

        Task task1 = new Task(new Date(), "Task 1", 5f);
        Task task2 = new Task(new Date(), "Task 2", 5f);

        User user1 = new User("Anna");
        user1.addTask(task1);

        User user2 = new User("Bartek");
        user2.addTask(task2);

        Project project1 = new Project("CRM");
        project1.addUser(user1);

        Project project2 = new Project("Shop");
        project2.addUser(user2);

        List<Project> projects = List.of(project1, project2);


        TableReport report = new HoursPerProjectPercent().generate(projects);


        assertEquals("Raport 3", report.getName());
        assertEquals(List.of("Name", "Hours", "Percent"), report.getHeaders());

        List<List<String>> rows = report.getValues();
        assertEquals(2, rows.size());

        assertEquals(List.of("Project 1", "5,00", "50,00%"), rows.get(0));
        assertEquals(List.of("Project 2", "5,00", "50,00%"), rows.get(1));
    }



    @Test
    void testGenerate_multipleTasksAndProjects() {
        Task task1 = new Task(new Date(), "Task A", 2f);
        Task task2 = new Task(new Date(), "Task B", 3f);
        Task task3 = new Task(new Date(), "Task C", 5f);

        User u1 = new User("User 1");
        u1.addTask(task1);
        u1.addTask(task2);

        User u2 = new User("User 2");
        u2.addTask(task3);

        Project p1 = new Project("Alpha");
        p1.addUser(u1);

        Project p2 = new Project("Beta");
        p2.addUser(u2);

        TableReport report = new HoursPerProjectPercent().generate(List.of(p1, p2));

        List<List<String>> rows = report.getValues();

        assertEquals(2, rows.size());
        assertEquals(List.of("Project 1", "5,00", "50,00%"), rows.get(0));
        assertEquals(List.of("Project 2", "5,00", "50,00%"), rows.get(1));
    }
}
