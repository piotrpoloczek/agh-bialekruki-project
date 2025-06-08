package pl.edu.agh.mwo.report.project;

import lombok.Getter;
import pl.edu.agh.mwo.report.project.reports.ReportType;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
public class InputManager {

    private Path absolutePath = null;
    private String date = null;
    private ReportType reportType = null;
    private final List<String> tags = new ArrayList<>();
    private final List<String> labels = new ArrayList<>();
    private boolean export = false;


    public InputManager(String[] args) {
        parseArgs(args);
        printArguments();

    }

    private void createAbsolutePathFromData(String data) {
        if (date == null) {
            absolutePath = Paths.get(".").toAbsolutePath();
        } else {
            absolutePath = Paths.get(date).toAbsolutePath();
        }
    }

    private void parseArgs(String[] args) {

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-d":
                    if (i + 1 < args.length) {
                        date = args[++i];
                    }
                    break;
                case "-r":
                    if (i + 1 < args.length) {
                        reportType = ReportType.fromString(args[++i]);
                    }
                    break;
                case "-t":
                    // Keep adding arguments to tags until we hit another flag or end of args
                    while (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        tags.add(args[++i]);
                    }
                    break;
                case "-l":
                    // Similarly for labels
                    while (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        labels.add(args[++i]);
                    }
                    break;
                case "-e":
                    export = true;
                    break;
                default:
                    // Handle standalone date (first argument without flag)
                    if (i == 0 && Objects.equals(args[i], "-h")) {
                        printHelp();
                    } else if (i == 0 && date == null) {
                        date = args[i];
                        createAbsolutePathFromData(date);
                    }
                    break;
            }
        }

        if (absolutePath == null) {
            throw new IllegalArgumentException("Path cannot be null");
        }
    }

    private void printHelp() {
        System.out.println("Usage: java -jar report.jar [-d date] [-r report_type] "
                + "[-t tag1 tag2 ...] [-l label1 label2 ...] [-e] [path]");
        System.out.println("Options:");
        System.out.println("  -d date            Date in the format YYYY-MM-DD");
        System.out.println("  -r report_type     Report type (1-4)");
        System.out.println("  -t tag1 tag2 ...   Tags to filter by");
        System.out.println("  -l label1 label2 ...   Labels to filter by");
        System.out.println("  -e                 Export report to file");
        System.out.println("  path               Path to the project folder");
    }

    private void printArguments() {
        System.out.println("Date: " + date);
        System.out.println("Report Type: " + reportType);
        System.out.println("Tags: " + tags);
        System.out.println("Labels: " + labels);
        System.out.println("Export: " + export);
        System.out.println("Path: " + absolutePath);
    }
}
