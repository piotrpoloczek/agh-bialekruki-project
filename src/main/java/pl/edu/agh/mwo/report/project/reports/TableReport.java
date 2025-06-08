package pl.edu.agh.mwo.report.project.reports;

import lombok.Getter;
import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TableReport {

    private String name;
    private List<String> headers;
    private List<List<String>> values;
    private List<ErrorFromExcelParser> errors;

    public TableReport(String name, List<String> headers, List<List<String>> values, List<ErrorFromExcelParser> errors) {
        this.name = name;
        this.headers = headers;
        this.values = values;
        this.errors = errors;
    }

    public void print() {
        System.out.println(name);
        System.out.println("Headers: " + headers);
        values.forEach(System.out::println);
        errors.forEach(System.out::println);
    }
}