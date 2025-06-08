package pl.edu.agh.mwo.report.project;


import pl.edu.agh.mwo.report.project.model.Project;
<<<<<<< HEAD
import pl.edu.agh.mwo.report.project.reports.RaportFactory;
import pl.edu.agh.mwo.report.project.reports.ReportType;
=======
import pl.edu.agh.mwo.report.project.reports.HoursPerProjectPercentReport;
>>>>>>> main
import pl.edu.agh.mwo.report.project.reports.TableReport;

import java.io.IOException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Bialekruki project!");

        InputManager inputManager = new InputManager(args);
        List<Project> projectList = ExcelParser.parseExcelToProjectList(inputManager.getAbsolutePath());

<<<<<<< HEAD
        for (Project project : projectList) {
            System.out.println("\nProject:");
            System.out.println(project);
        }

        ReportType reportType = inputManager.getReportType();


        // Generate report from. factory
        TableReport tableReport = RaportFactory.getRaport(inputManager, projectList);
=======
        System.out.println("Raport");

        HoursPerProjectPercentReport raport2 = new HoursPerProjectPercentReport();
        TableReport tableReport = raport2.generate(projectList);

>>>>>>> main
        tableReport.print();
    }
}
