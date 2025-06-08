package pl.edu.agh.mwo.report.project.report;

import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.TableReport;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.reports.GenerateRaport;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Top10Report implements GenerateRaport {
    private final int maxTopValue = 10;

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

        Map<String, Double> topTen =
                activityHours.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(maxTopValue)
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

