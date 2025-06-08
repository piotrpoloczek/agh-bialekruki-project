package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;

import java.util.*;
import java.util.stream.Collectors;

public class Top10Report implements GenerateRaport {
    public TableReport generate(List<Project> projects) {
        List<String> headers = Arrays.asList("Activity", "Hours");
        List<List<String>> rows = new ArrayList<>();
        List<ErrorFromExcelParser> errors = new ArrayList<>();

        Map<String, Double> activityHours = new HashMap<>();

        for (Project project : projects) {
            errors.addAll(project.getErrorFromExcelParserList());

            for (Task task : project.getTaskList()) {
                String taskName = task.getName();
                double hours = task.getTimeSpentOnTheTask();
                activityHours.put(taskName, activityHours.getOrDefault(taskName, 0.0) + hours);
            }
        }

        Map<String,Double> topTen =
                activityHours.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(10)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Double> entry : topTen.entrySet()) {
            rows.add(Arrays.asList(entry.getKey(), String.format("%.2f", entry.getValue())));
        }

        return new TableReport("Raport 4", headers, rows, errors);
    }

    @Override
    public TableReport generateReport() {
        return null;
    }

    @Override
    public void setInputData(List<Project> projects) {

    }
}
