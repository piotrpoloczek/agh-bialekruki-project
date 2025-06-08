package pl.edu.agh.mwo.report.project;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pl.edu.agh.mwo.report.project.reports.ReportType;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InputManagerTest {

    String params1 = "data/2012";
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
    public void testGenerationOfAbsolutePath(){
        Path path2 = Paths.get(params1).toAbsolutePath();

        String[] args = new String[1];
        args[0] = params1;

        InputManager inputManager = new InputManager(args);
        Path inputManagerPath = inputManager.getAbsolutePath();

        Assertions.assertEquals(path2, inputManagerPath);
    }

    @Test
    public void testGenerationOfReportType(){
        String[] args = new String[3];
        args[0] = params1;
        args[0] = params2;
        args[1] = params_raport_details_per_user;

        InputManager inputManager = new InputManager(args);
        ReportType reportType = inputManager.getReportType();

        Assertions.assertEquals(reportType, ReportType.DETAILS_PER_USER);
    }


}
