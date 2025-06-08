package pl.edu.agh.mwo.report.project.reports;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    private void printHeader() {
        System.out.println("Report: " + title);
        System.out.println("Date: " + currentDate());
        System.out.println();
        for (String header : headers) {
            System.out.printf("%-20s", header);
        }
        System.out.println();
    }
}
