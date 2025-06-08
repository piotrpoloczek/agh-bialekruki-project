package pl.edu.agh.mwo.report.project.reports;

import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;
import pl.edu.agh.mwo.report.project.model.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserHoursAllProjectsReportTest {


    @Test
    public void notNullReportTest() {
        Task task1 = new Task(new Date(), "Task 1", 10);
        Task task2 = new Task(new Date(), "Task 2", 10);

        User user1 = new User("Kasia");
        user1.addTask(task1);

        User user2 = new User("Kacper");
        user2.addTask(task2);

        Project project1 = new Project("Projekt pierwszy");
        project1.addUser(user1);

        Project project2 = new Project("Projekt drugi");
        project2.addUser(user2);

        List<Project> projects = List.of(project1, project2);
        TableReport report = new UserHoursAllProjectsReport().generate(projects);
        assertNotNull(report);

    }

    @Test

    public void UserHoursSumWithOneUserOneProjectTest() {
        Task task1 = new Task(new Date(), "Task 1", 10);
        Task task2 = new Task(new Date(), "Task 2", 10);

        User user1 = new User("Kasia");
        user1.addTask(task1);
        user1.addTask(task2);


        Project project1 = new Project("Projekt pierwszy");
        project1.addUser(user1);

        List<Project> projects = List.of(project1);

        TableReport report = new UserHoursAllProjectsReport().generate(projects);

        assertEquals("Raport 1", report.getName());
        assertEquals(List.of("Name", "Hours"), report.getHeaders());

        List<List<String>> rows = report.getValues();
        assertEquals(1, rows.size());

        assertEquals(List.of("Kasia", "20.00"), rows.getFirst());
    }

    @Test
    public void UserHoursSumWithOneUserCoupleProjectsTest() {
        Task task1 = new Task(new Date(), "Task 1", 10);
        Task task2 = new Task(new Date(), "Task 2", 20);


        User user1 = new User("Kasia");
        User user2 = new User("Kasia");
        user1.addTask(task1);
        user1.addTask(task2);
        user2.addTask(task2);


        Project project1 = new Project("Projekt pierwszy");
        Project project2 = new Project("Projekt drugi");

        project1.addUser(user1);
        project2.addUser(user2);

        List<Project> projects = List.of(project1, project2);

        TableReport report = new UserHoursAllProjectsReport().generate(projects);

        assertEquals("Raport 1", report.getName());
        assertEquals(List.of("Name", "Hours"), report.getHeaders());

        List<List<String>> rows = report.getValues();
        assertEquals(1, rows.size());

        assertEquals(List.of("Kasia", "50.00"), rows.getFirst());
    }

    @Test
    public void TwoUsersWithOneTaskTest() {
        Task task1 = new Task(new Date(), "Task 1", 10);


        User user1 = new User("Kasia");
        User user2 = new User("Bartek");
        user1.addTask(task1);
        user2.addTask(task1);

        Project project1 = new Project("Projekt pierwszy");


        project1.addUser(user1);
        project1.addUser(user2);

        List<Project> projects = List.of(project1);

        TableReport report = new UserHoursAllProjectsReport().generate(projects);

        assertEquals("Raport 1", report.getName());
        assertEquals(List.of("Name", "Hours"), report.getHeaders());

        List<List<String>> rows = report.getValues();
        assertEquals(2, rows.size());

        assertEquals(List.of("Kasia", "10.00"), rows.getFirst());
        assertEquals(List.of("Bartek", "10.00"), rows.getLast());
    }


    @Test
    public void MultipleUsersWithMultipleProjectsAndTaskTest() {
        Task task1 = new Task(new Date(), "Task 1", 10);
        Task task2 = new Task(new Date(), "Task 2", 20);
        Task task3 = new Task(new Date(), "Task 3", 30);


        User user1 = new User("Kasia");
        User user2 = new User("Bartek");
        User user3 = new User("Zosia");
        User user4 = new User("Bartek");
        user1.addTask(task1);
        user1.addTask(task3);
        user2.addTask(task1);
        user3.addTask(task3);
        user4.addTask(task2);


        Project project1 = new Project("Projekt pierwszy");
        Project project2 = new Project("Projekt drugi");
        Project project3 = new Project("Projekt trzeci");
        Project project4 = new Project("Projekt czwarty");


        project1.addUser(user1);
        project1.addUser(user2);
        project2.addUser(user3);
        project2.addUser(user4);
        project3.addUser(user4);
        project4.addUser(user1);

        List<Project> projects = List.of(project1, project2, project3, project4);

        TableReport report = new UserHoursAllProjectsReport().generate(projects);

        assertEquals("Raport 1", report.getName());
        assertEquals(List.of("Name", "Hours"), report.getHeaders());

        List<List<String>> rows = report.getValues();
        assertEquals(3, rows.size());

        assertEquals(List.of("Kasia", "80.00"), rows.getFirst());
        assertEquals(List.of("Bartek", "50.00"), rows.get(1));
        assertEquals(List.of("Zosia", "30.00"), rows.get(2));

    }


    @Test
    void testGenerate_emptyProjectsList() {
        TableReport report = new UserHoursAllProjectsReport().generate(new ArrayList<>());

        assertEquals("Raport 1", report.getName());
        assertEquals(List.of("Name", "Hours"), report.getHeaders());
        assertFalse(report.getName().isEmpty());
    }

    @Test
    void testGenerate_projectWithNoUsers() {
        Project emptyProject = new Project("Empty");

        TableReport report = new UserHoursAllProjectsReport().generate(List.of(emptyProject));

        assertEquals(0, report.getValues().size());
        assertEquals("Raport 1", report.getName());
    }

    @Test
    void testGenerate_projectWithUsersButNoTasks() {
        User userWithoutTasks = new User("GhostUser");

        Project project = new Project("DeadProject");
        project.addUser(userWithoutTasks);

        TableReport report = new UserHoursAllProjectsReport().generate(List.of(project));

        assertEquals(1, report.getValues().size());
        assertEquals(List.of("GhostUser", "0.00"), report.getValues().get(0));
    }





}