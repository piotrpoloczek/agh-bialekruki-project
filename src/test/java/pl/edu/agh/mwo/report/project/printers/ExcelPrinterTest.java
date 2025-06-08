package pl.edu.agh.mwo.report.project.printers;


import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.report.project.reports.ExcelPrinter;

import java.util.ArrayList;
import java.util.List;

public class ExcelPrinterTest {

    @Test
    public void testPrintExcel() {

        List<String> headers = new ArrayList<>();
        headers.add("Pracownik");
        headers.add("Liczba godzin");

        List<List<String>> rows = new ArrayList<>();
        rows.add(List.of("Jan", "12"));
        rows.add(List.of("Krzysztof", "15"));
        rows.add(List.of("Marek", "10"));

        String title = "Raport_1";

        ExcelPrinter printer = new ExcelPrinter();
        printer.printReport(headers, rows, title);
    }

}
