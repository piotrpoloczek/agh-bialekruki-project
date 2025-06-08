package pl.edu.agh.mwo.report.project.model;

import lombok.Getter;

import java.util.List;

@Getter
public class TableReport {

    private final String name;
    private final List<String> headers;
    private final List<List<String>> values;
    private final List<ErrorFromExcelParser> errors;

    public TableReport(String name, List<String> headers, List<List<String>> values, List<ErrorFromExcelParser> errors) {
        this.name = name;
        this.headers = headers;
        this.values = values;
        this.errors = errors;
    }

    public void print() {
        System.out.println(name);
        System.out.println("Headers: " + headers);
        System.out.println("Values: " + values);
        values.forEach(System.out::println);
        errors.forEach(System.out::println);
    }
}