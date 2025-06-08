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

    public void printReportWithValidation() {
        printHeader();
        int rowIndex = 1;
        List<LocalDate> dates = new ArrayList<>();

        for (List<String> row : rows) {
            if (isEmptyRow(row)) continue;

            boolean hasMissing = false;
            StringBuilder rowOutput = new StringBuilder();
            for (String cell : row) {
                if (cell == null || cell.trim().isEmpty()) {
                    hasMissing = true;
                }
                rowOutput.append(String.format("%-20s", cell));
            }

            if (hasMissing) {
                System.out.println("\n Lack of data in the file:");
                System.out.println("File: " + fileName);
                System.out.println("Path: " + filePath);
                System.out.println("Project: " + projectName);
                System.out.println("Row: " + rowIndex);
                System.out.println();
            } else {
                System.out.println(rowOutput);
                extractDateIfPresent(row, dates);
            }
            rowIndex++;
        }

        if (!dates.isEmpty()) {
            LocalDate min = Collections.min(dates);
            LocalDate max = Collections.max(dates);
            System.out.println("\nRange of date: from " + formatDate(min) + " to " + formatDate(max));
        }
    }

    public void printPercentageReport(Map<String, Integer> projectHours, int totalHours) {
        System.out.println("\n Project Name        Hours       Percent [%]");
        for (Map.Entry<String, Integer> entry : projectHours.entrySet()) {
            String project = entry.getKey();
            int hours = entry.getValue();
            double percent = ((double) hours / totalHours) * 100;
            System.out.printf("%-22s %-18d %.1f\n", project, hours, percent);
        }
    }

    private boolean isEmptyRow(List<String> row) {
        return row.stream().allMatch(cell -> cell == null || cell.trim().isEmpty());
    }

    private void extractDateIfPresent(List<String> row, List<LocalDate> dates) {
        for (String cell : row) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate date = LocalDate.parse(cell, formatter);
                dates.add(date);
                break;
            } catch (Exception ignored) {

            }
        }
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }
}