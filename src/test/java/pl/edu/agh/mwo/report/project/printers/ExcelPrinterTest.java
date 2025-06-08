package pl.edu.agh.mwo.report.project.printers;


import org.junit.Test;
import pl.edu.agh.mwo.report.project.reports.ExcelPrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelPrinterTest {

    @Test
    public void testPrintExcel() throws IOException {

        List<String> headers = new ArrayList<>();
        headers.add("Pracownik");
        headers.add("Liczba godzin");

        List<List<String>> rows = new ArrayList<>();
        rows.add(List.of("Jan", "12"));
        rows.add(List.of("Krzysztof", "15"));
        rows.add(List.of("Marek", "10"));

        String title = "Raport_1";

        ExcelPrinter printer = new ExcelPrinter(title, headers, rows);
        printer.printReportOne();

        List<String> headers2 = new ArrayList<>();
        headers2.add("Projekt");
        headers2.add("Liczba godzin");

        List<List<String>> rows2 = new ArrayList<>();
        rows2.add(List.of("Projekt 1", "200"));
        rows2.add(List.of("Projekt 2", "300"));
        rows2.add(List.of("Projekt 3", "20"));

        String title2 = "Raport_2";

        ExcelPrinter printer2 = new ExcelPrinter(title2, headers2, rows2);
        printer2.printReportTwo();
    }

}
