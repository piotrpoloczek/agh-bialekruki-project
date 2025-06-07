package pl.edu.agh.mwo.report.project.reports;

import lombok.Getter;

import java.util.List;

@Getter
public class TableReport {

    private String name;
    private List<String> headers;
    private List<List<String>> values;

    public TableReport(String name, List<String> headers, List<List<String>> values) {
        this.name = name;
        this.headers = headers;
        this.values = values;
    }

    public void print() {
        System.out.println(name);
        System.out.println("Headers: " + headers);
        System.out.println("Values: " + values);

        values.forEach(System.out::println);
    }
}