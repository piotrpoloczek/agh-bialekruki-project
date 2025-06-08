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
        System.out.println(
                ExcelParser.parseExcelToProjectList(
                        Path.of("/home/students/m/d/mdebski/IdeaProjects/agh-bialekruki-project/"
                                + "src/main/resources/input/reporter-dane/2012/01")
                ));
    }
}

