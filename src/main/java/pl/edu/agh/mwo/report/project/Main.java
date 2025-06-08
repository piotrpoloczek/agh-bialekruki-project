package pl.edu.agh.mwo.report.project;


import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.reports.ConsolePrinter;
import pl.edu.agh.mwo.report.project.reports.HoursPerProjectPercent;
import pl.edu.agh.mwo.report.project.reports.HoursPerProjectPercent;
import pl.edu.agh.mwo.report.project.reports.TableReport;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Bialekruki project!");

        InputManager inputManager = new InputManager(args);
        List<Project> projectList = ExcelParser.parseExcelToProjectList(inputManager.getAbsolutePath());

        for (Project project : projectList) {
            System.out.println("\nProject:");
            System.out.println(project);
        }

        System.out.println("Raport");

        HoursPerProjectPercent raport3 = new HoursPerProjectPercent();
        TableReport tableReport = raport3.generate(projectList);

        tableReport.print();

        ConsolePrinter printer = new ConsolePrinter(
                "Raport o pracownikach",
                Arrays.asList("Pracownik", "Ilość godzin"),
                Arrays.asList(
                        Arrays.asList("Anna Kowalska", "40"),
                        Arrays.asList("", "35"),
                        Arrays.asList("Jan Nowak", "")
                ),
                "plik1.xls",
                "/ścieżka/do/plik1.xls",
                "Projekt 1"


        );
        printer.printReportWithValidation();
    }
}

