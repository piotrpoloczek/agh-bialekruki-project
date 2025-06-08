package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportHoursPerProject implements GenerateRaport {

    private List<Project> projects;

    @Override
    public TableReport generateReport() {
        List<String> headers = Arrays.asList("Name", "Hours");
        List<List<String>> rows = new ArrayList<>();
        List<ErrorFromExcelParser> errors = new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            float projectTime = 0;

            for (User user : project.getUserList()) {
                for (Task task : user.getTaskList()) {
                    projectTime += task.getTimeSpentOnTheTask();
                }
            }

            String projectName = "Project " + (i + 1);
            String hoursStr = String.format("%.2f", projectTime);

            List<ErrorFromExcelParser> errorList = project.getErrorFromExcelParserList();
            errors.addAll(errorList);


            rows.add(Arrays.asList(projectName, hoursStr));
        }

        return new TableReport("Raport 2", headers, rows, errors);
    }

    @Override
    public void setInputData(List<Project> projects) {
        this.projects = projects;
    }
}