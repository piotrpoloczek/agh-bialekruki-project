//package pl.edu.agh.mwo.report.project.reports;
//
//import pl.edu.agh.mwo.report.project.model.Project;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Raport2 {
//    public TableReport generate(List<Project> projects) {
//        List<String> headers = Arrays.asList("Name", "Hours", "Percent");
//        List<List<String>> rows = new ArrayList<>();
//
//        int totalHours = projects.stream().mapToInt(Project::getHours).sum();
//
//        for (Project project : projects) {
//            List<String> row = new ArrayList<>();
//            row.add(project.getName());
//            row.add(String.valueOf(project.getHours()));
//            double percent = totalHours == 0 ? 0 : (project.getHours() * 100.0 / totalHours);
//            row.add(String.format("%.2f%%", percent));
//            rows.add(row);
//        }
//
//        return new TableReport("Raport 2", headers, rows);
//    }
//}
