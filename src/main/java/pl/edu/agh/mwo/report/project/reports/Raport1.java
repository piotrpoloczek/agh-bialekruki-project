package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.model.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Raport1 {
    public TableReport generate(List<Project> projects) {
        List<String> headers = Arrays.asList("Name", "Hours", "Project");
        List<List<String>> rows = new ArrayList<>();

        for (Project project : projects) {
            List<String> row = new ArrayList<>();
            row.add(project.

        }

        return new TableReport("Raport 1", headers, rows);
    }

}
