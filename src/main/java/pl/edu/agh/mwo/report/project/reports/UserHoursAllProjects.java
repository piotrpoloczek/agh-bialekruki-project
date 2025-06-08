package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class UserHoursAllProjects {
    public TableReport generate(List<Project> projects) {
        List<String> headers = Arrays.asList("Name", "Hours");
        List<List<String>> rows = new ArrayList<>();

        Map<String, Double> userHours = new HashMap<>();

        for (Project project : projects) {
            for (User user : project.getUserList()) {
                double totalHours = 0.0;
                for (Task task : user.getTaskList()) {
                    totalHours += task.getTimeSpentOnTheTask();
                }

                String userName = user.getName();

                userHours.put(userName, userHours.getOrDefault(userName, 0.0) + totalHours);

            }
        }

        for (Map.Entry<String, Double> entry : userHours.entrySet()) {
            rows.add(Arrays.asList(entry.getKey(), String.format("%.2f", entry.getValue())));
        }

        return new TableReport("Raport 1", headers, rows);
    }

}
