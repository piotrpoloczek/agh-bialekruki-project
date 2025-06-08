package pl.edu.agh.mwo.report.project.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelPrinter {

    private final List<String> headers;
    private final List<List<String>> rows;
    private final String title;

    public ExcelPrinter(String title, List<String> headers, List<List<String>> rows) {
        this.title = title;
        this.headers = headers;
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public String madePackage() throws FileNotFoundException {
        String folderName = "reports";
        File dir = new File(folderName);

        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Folder " + folderName + " został utworzony.");
            } else {
                System.out.println("Nie udało się utworzyć folderu " + folderName + ".");
            }
        } else {
            System.out.println("Folder " + folderName + " już istnieje.");
        }

        return folderName;
    }

    public String currentDate() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Bieżąca data i godzina: " + now);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return now.format(format);
    }

}
