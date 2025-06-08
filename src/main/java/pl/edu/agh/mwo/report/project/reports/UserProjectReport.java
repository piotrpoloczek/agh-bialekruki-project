package pl.edu.agh.mwo.report.project.reports;

import java.util.List;

public class UserProjectReport {
    private String userName;
    private float totalHours;
    private List<List<String>> rows;

    public UserProjectReport(String userName, float totalHours, List<List<String>> rows) {
        this.userName = userName;
        this.totalHours = totalHours;
        this.rows = rows;
    }

    public void print() {
        System.out.println(userName + " – " + String.format("%.0f", totalHours) + " h\n");
        System.out.println("Project name\tHours\tPercent [%]");
        for (List<String> row : rows) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
