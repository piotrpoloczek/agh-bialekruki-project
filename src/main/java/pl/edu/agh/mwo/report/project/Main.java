package pl.edu.agh.mwo.report.project;

import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.TableReport;
import pl.edu.agh.mwo.report.project.printer.ExcelPrinter;
import pl.edu.agh.mwo.report.project.reports.RaportFactory;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Bialekruki project!");

        InputManager inputManager = new InputManager(args);
        List<Project> projectList = ExcelParser.parseExcelToProjectList(inputManager.getAbsolutePath());

        TableReport tableReport = RaportFactory.getReport(inputManager, projectList);
        System.out.println(tableReport.getName());

        tableReport.print();

        if (inputManager.isExport()) {
            ExcelPrinter excelPrinter = new ExcelPrinter();
            excelPrinter.printReport(tableReport.getHeaders(), tableReport.getValues(), tableReport.getName());
        }
    }
}