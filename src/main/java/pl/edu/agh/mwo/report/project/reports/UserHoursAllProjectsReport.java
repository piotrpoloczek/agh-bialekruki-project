package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class UserHoursAllProjectsReport {
    public TableReport generate(List<Project> projects) {
        List<String> headers = Arrays.asList("Name", "Hours");
        List<List<String>> rows = new ArrayList<>();
        List<ErrorFromExcelParser> errors = new ArrayList<>();

        Map<User, Double> userHours = new HashMap<>();

        for (Project project : projects) {
            List<ErrorFromExcelParser> errorFromExcelParserList = project.getErrorFromExcelParserList();
            errors.addAll(errorFromExcelParserList);

            for (User user : project.getUserList()) {
                if (!userHours.containsKey(user)) {
                    double totalHours = 0.0;
                    for (Task task : user.getTaskList()) {
                        totalHours += task.getTimeSpentOnTheTask();
                    }
                    userHours.put(user, userHours.getOrDefault(user, 0.0) + totalHours);
                } else {
                    double totalHours = userHours.get(user);
                    for (Task task : user.getTaskList()) {
                        totalHours += task.getTimeSpentOnTheTask();
                    }
                    userHours.put(user, totalHours);
                }
            }
        }


        for (Map.Entry<User, Double> entry : userHours.entrySet()) {
            rows.add(Arrays.asList(entry.getKey().getName(), String.format("%.2f", entry.getValue())));
        }

        return new TableReport("Raport 1", headers, rows, errors);
    }
}
