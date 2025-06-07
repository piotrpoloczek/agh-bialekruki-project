package pl.edu.agh.mwo.report.project.reports;

import java.util.List;

public class TableReport {

    private String name;
    private List<String> headers;
    private List<List<String>> values;

    public TableReport(String name, List<String> headers, List<List<String>> values) {
        this.name = name;
        this.headers = headers;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getValues() {
        return values;
    }
}


