package pl.edu.agh.mwo.report.project;

import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;
import pl.edu.agh.mwo.report.project.reports.HoursPerProjectPercent;
import pl.edu.agh.mwo.report.project.reports.TableReport;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(
//                ExcelParser.parseExcelToProjectList(
//                        Path.of("/home/students/m/d/mdebski/IdeaProjects/agh-bialekruki-project/"
//                                + "src/main/resources/input/reporter-dane/2012/01")
//                ));


        Date now = new Date();

        Task task1 = new Task(now, "UI Design", 2.0f);
        Task task2 = new Task(now, "API Development", 7.0f);
        Task task3 = new Task(now, "Payment Integration", 5.0f);


        User anna = new User("Anna");
        anna.addTask(task1);
        anna.addTask(task2);

        User bartek = new User("Bartek");
        bartek.addTask(task3);


        Project crm = new Project("CRM System");
        crm.addUser(anna);

        Project ecommerce = new Project("E-commerce");
        ecommerce.addUser(bartek);

        List<Project> projects = List.of(crm, ecommerce);


        HoursPerProjectPercent generator = new HoursPerProjectPercent();
        TableReport report = generator.generate(projects);

        System.out.println("Title: " + report.getName());
        System.out.println("Headers: " + report.getHeaders());
        System.out.println("Rows:");
        for (List<String> row : report.getValues()) {
            System.out.println(row);
        }
    }
}

