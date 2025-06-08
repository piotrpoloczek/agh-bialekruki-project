package pl.edu.agh.mwo.report.project.reports;

import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HoursPerProjectTest {
    @Test
    public void testSingleProjectTotalHours() {
        Task task1 = new Task(new Date(), "Task 1", 2.0f);
        Task task2 = new Task(new Date(), "Task 2", 3.5f);
        User user = new User("User A", Arrays.asList(task1, task2));
        Project project = new Project("Project X", List.of(user));

        HoursPerProject generator = new HoursPerProject();
        TableReport report = generator.generate(List.of(project));

        assertEquals("Raport 2", report.getName());
        assertEquals(List.of("Project Name", "Total Hours"), report.getHeaders());
        assertEquals(1, report.getValues().size());

        List<String> row = report.getValues().get(0);
        assertEquals("Project X", row.get(0));
        assertEquals("5,50", row.get(1));
    }

    @Test
    public void testMultipleProjects() {
        Task task1 = new Task(new Date(), "Task A", 1.0f);
        Task task2 = new Task(new Date(), "Task B", 2.0f);
        Task task3 = new Task(new Date(), "Task C", 3.0f);

        User user1 = new User("User 1", List.of(task1));
        User user2 = new User("User 2", List.of(task2));
        User user3 = new User("User 3", List.of(task3));

        Project project1 = new Project("Project 1", List.of(user1));
        Project project2 = new Project("Project 2", List.of(user2, user3));

        HoursPerProjectPercent generator = new HoursPerProjectPercent();
        TableReport report = generator.generate(List.of(project1, project2));

        assertEquals(2, report.getValues().size());

        List<String> row1 = report.getValues().get(0);
        assertEquals("Project 1", row1.get(0));
        assertEquals("1,00", row1.get(1));

        List<String> row2 = report.getValues().get(1);
        assertEquals("Project 2", row2.get(0));
        assertEquals("5,00", row2.get(1));
    }

    @Test
    public void testEmptyProjectList() {
        HoursPerProject generator = new HoursPerProject();
        TableReport report = generator.generate(List.of());

        assertEquals("Raport 2", report.getName());
        assertEquals(0, report.getValues().size());
    }

    @Test
    public void testProjectWithNoUsers() {
        Project emptyProject = new Project("Empty Project", List.of());

        HoursPerProject generator = new HoursPerProject();
        TableReport report = generator.generate(List.of(emptyProject));

        assertEquals(1, report.getValues().size());
        List<String> row = report.getValues().get(0);
        assertEquals("Empty Project", row.get(0));
        assertEquals("0,00", row.get(1));
    }

    @Test
    public void testUserWithNoTasks() {
        User user = new User("Idle User", List.of());
        Project project = new Project("No Work Project", List.of(user));

        HoursPerProject generator = new HoursPerProject();
        TableReport report = generator.generate(List.of(project));

        assertEquals(1, report.getValues().size());
        List<String> row = report.getValues().get(0);
        assertEquals("No Work Project", row.get(0));
        assertEquals("0,00", row.get(1));
    }

}