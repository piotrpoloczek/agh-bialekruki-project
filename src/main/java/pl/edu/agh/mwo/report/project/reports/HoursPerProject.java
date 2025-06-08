package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoursPerProject {

    public TableReport generate(List<Project> projects) {
        List<String> headers = Arrays.asList("Project Name", "Total Hours");
        List<List<String>> rows = new ArrayList<>();

        for (Project project : projects) {
            float projectTotalHours = 0;

            for (User user : project.getUserList()) {
                for (Task task : user.getTaskList()) {
                    projectTotalHours += task.getTimeSpentOnTheTask();
                }
            }

            String projectName = project.getName();
            String hoursStr = String.format("%.2f", projectTotalHours);

            rows.add(Arrays.asList(projectName, hoursStr));
        }

        return new TableReport("Raport 2", headers, rows);
    }
}
