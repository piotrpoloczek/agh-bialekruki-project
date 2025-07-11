package pl.edu.agh.mwo.report.project.report;

import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.TableReport;
import pl.edu.agh.mwo.report.project.model.User;
import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;
import pl.edu.agh.mwo.report.project.reports.GenerateRaport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReportDetailsPerUser implements GenerateRaport {

    private List<Project> projects = new ArrayList<>();
    private List<String> headers = Arrays.asList("User name", "Project", "Time spent", "Percentage");
    private List<List<String>> rows = new ArrayList<>();
    private List<ErrorFromExcelParser> errors = new ArrayList<>();

    @Override
    public TableReport generateReport() {

        final int oneHundredPercent = 100;
        float grandTotal = 0;
        String username = null;

        for (Project project : projects) {
            for (User user : project.getUserList()) {
                for (Task task : user.getTaskList()) {
                    grandTotal += task.getTimeSpentOnTheTask();
                }
            }
        }

        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            float projectTime = 0;

            for (User user : project.getUserList()) {
                for (Task task : user.getTaskList()) {
                    projectTime += task.getTimeSpentOnTheTask();
                    username = user.getName();
                }
            }
            String projectName = "Project " + (i + 1);
            String hoursStr = String.format("%.2f", projectTime);
            String percentStr = grandTotal > 0 ? String.format("%.2f%%", (projectTime / grandTotal) * oneHundredPercent) : "0.00%";
            List<ErrorFromExcelParser> errorList = project.getErrorFromExcelParserList();

            for (ErrorFromExcelParser errorFromExcelParser : errorList) {
                errors.add(errorFromExcelParser);
            }
            rows.add(Arrays.asList(username, projectName, hoursStr, percentStr));
        }

        return new TableReport("Raport 3", headers, rows, errors);
    }

    @Override
    public void setInputData(List<Project> projects) {
        this.projects = projects;
    }
}
