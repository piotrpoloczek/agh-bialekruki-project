package pl.edu.agh.mwo.report.project.printer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ConsolePrinter {
    private final String title;
    private final List<String> headers;
    private final List<List<String>> rows;
    private final String fileName;
    private final String filePath;
    private final String projectName;
    final int numberOneHundred = 100;

    public ConsolePrinter(String title, List<String> headers, List<List<String>> rows,
                          String fileName, String filePath, String projectName) {
        this.title = title;
        this.headers = headers;
        this.rows = rows;
        this.fileName = fileName;
        this.filePath = filePath;
        this.projectName = projectName;
    }

    public String currentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(format);
    }

    public void printHeader() {
        System.out.println("Report: " + title);
        System.out.println("Date: " + currentDate());
        System.out.println();
        for (String header : headers) {
            System.out.printf("%-20s", header);
        }
        System.out.println();
        printRows();
    }
    public void printRows() {
        for (List<String> row : rows) {
            for (String cell : row) {
                System.out.printf("%-20s", cell);
            }
            System.out.println();
        }
    }
}
