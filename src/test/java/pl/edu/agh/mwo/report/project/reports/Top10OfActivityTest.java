package pl.edu.agh.mwo.report.project.reports;

import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.TableReport;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;
import pl.edu.agh.mwo.report.project.report.Top10Report;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Top10OfActivityTest {

    @Test
    public void test() {
        Task task1 = new Task(new Date(), "Task 1", 10);
        Task task2 = new Task(new Date(), "Task 2", 20);
        Task task3 = new Task(new Date(), "Task 1", 30);
        Task task4 = new Task(new Date(), "Task 3", 40);
        Task task5 = new Task(new Date(), "Task 4", 10);
        Task task6 = new Task(new Date(), "Task 5", 20);
        Task task7 = new Task(new Date(), "Task 6", 30);
        Task task8 = new Task(new Date(), "Task 7", 40);
        Task task9 = new Task(new Date(), "Task 8", 10);
        Task task10 = new Task(new Date(), "Task 9", 20);
        Task task11 = new Task(new Date(), "Task 10", 30);
        Task task12 = new Task(new Date(), "Task 11", 60);

        User user1 = new User("Kasia");
        user1.addTask(task1);

        User user2 = new User("Kacper");
        user2.addTask(task2);
        user2.addTask(task3);

        Project project1 = new Project("Projekt pierwszy");
        project1.addUser(user1);

        project1.addTask(task1);
        project1.addTask(task2);
        project1.addTask(task3);
        project1.addTask(task4);
        project1.addTask(task5);
        project1.addTask(task6);
        project1.addTask(task7);
        project1.addTask(task8);
        project1.addTask(task9);
        project1.addTask(task10);
        project1.addTask(task11);
        project1.addTask(task12);

        Project project2 = new Project("Projekt drugi");
        project2.addUser(user2);

        project2.addTask(task3);

        List<Project> projects = List.of(project1, project2);
        TableReport report = new Top10Report().generate(projects);

        report.print();

        assertNotNull(report);
    }
}
