package pl.edu.agh.mwo.report.project.reports;

import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.report.project.model.TableReport;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.report.ReportUserHoursAllProjects;

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
//        TableReport report = new ReportUserHoursAllProjects().generate(projects);
//        assertNotNull(report);

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

//        TableReport report = new ReportUserHoursAllProjects().generate(projects);

//        assertEquals("Raport 1", report.getName());
//        assertEquals(List.of("Name", "Hours"), report.getHeaders());
//
//        List<List<String>> rows = report.getValues();
//        assertEquals(1, rows.size());
//
//        assertEquals(List.of("Kasia", "20.00"), rows.getFirst());
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
//
//        TableReport report = new ReportUserHoursAllProjects().generate(projects);
//
//        assertEquals("Raport 1", report.getName());
//        assertEquals(List.of("Name", "Hours"), report.getHeaders());
//
//        List<List<String>> rows = report.getValues();
//        assertEquals(1, rows.size());
//
//        assertEquals(List.of("Kasia", "50.00"), rows.getFirst());
    }
}