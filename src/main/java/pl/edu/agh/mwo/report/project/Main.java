package pl.edu.agh.mwo.report.project;


import pl.edu.agh.mwo.report.project.model.Project;

import java.io.IOException;
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
    }
}
