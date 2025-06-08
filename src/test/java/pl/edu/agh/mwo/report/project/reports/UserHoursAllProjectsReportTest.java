package pl.edu.agh.mwo.report.project.reports;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.report.project.ExcelParser;
import pl.edu.agh.mwo.report.project.InputManager;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;
import pl.edu.agh.mwo.report.project.model.Project;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserHoursAllProjectsReportTest {

    String params1 = "dane/2012";
    String params2 = "-r";
    String params_raport_users_hours_all_projects = "1";
    String params_raport_hours_per_project = "2";
    String params_raport_details_per_user = "3";
    String params_raport_top_10 = "4";
    String params_raport_filter_by_tag = "5";
    String params3 = "1";
    String params4 = "-t";
    String params5 = "tag1";
    String params6 = "tag2";
    String params7 = "-l";
    String params8 = "label1";
    String params9 = "label2";
    String params10 = "-e";

@Test
public void testEmployeeCount() throws IOException {

    String[] args = new String[1];
    args[0] = params1;
    InputManager inputManager = new InputManager(args);
    Path inputManagerPath = inputManager.getAbsolutePath();
    List<Project> projectList = ExcelParser.parseExcelToProjectList(inputManagerPath);

    TableReport report = new UserHoursAllProjectsReport().generate(projectList);
    List<List<String>> rows = report.getValues();
    assertEquals(9, rows.size());

}

    @Test
    public void testSingleUser() throws IOException {

        String[] args = new String[1];
        args[0] = params1;
        InputManager inputManager = new InputManager(args);
        Path inputManagerPath = inputManager.getAbsolutePath();
        List<Project> projectList = ExcelParser.parseExcelToProjectList(inputManagerPath);

        TableReport report = new UserHoursAllProjectsReport().generate(projectList);
        List<List<String>> rows = report.getValues();
        assertEquals(9, rows.size());
        assertEquals(List.of("Filip Sara", "57.00"), rows.getFirst());
    }
    @Test
    public void testMultiUser() throws IOException {


        String[] args = new String[1];
        args[0] = params1;
        InputManager inputManager = new InputManager(args);
        Path inputManagerPath = inputManager.getAbsolutePath();
        List<Project> projectList = ExcelParser.parseExcelToProjectList(inputManagerPath);

        TableReport report = new UserHoursAllProjectsReport().generate(projectList);
        List<List<String>> rows = report.getValues();
        assertEquals(9, rows.size());
        assertEquals(List.of("Kowalski Jan", "111.00"), rows.get(5));
    }


}