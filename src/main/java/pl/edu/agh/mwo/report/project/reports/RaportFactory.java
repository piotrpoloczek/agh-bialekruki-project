package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.InputManager;
import pl.edu.agh.mwo.report.project.model.Project;
import java.util.List;

public class RaportFactory {

    public static TableReport getReport(InputManager inputManager, List<Project> projectList) {
        TableReport raport = null;
        GenerateRaport generateRaport = null;
        switch (inputManager.getReportType()) {
            case USER_HOURS_ALL_PROJECTS:
                generateRaport = new UserHoursAllProjectsReport();
                generateRaport.setInputData(projectList);
                raport = generateRaport.generateReport();
                break;
            case HOURS_PER_PROJECT:
                generateRaport = new ReportHoursPerProjectPercent();
                generateRaport.setInputData(projectList);
                raport = generateRaport.generateReport();
                break;
            case DETAILS_PER_USER:
                generateRaport = new DetailsPerUserReport();
                generateRaport.setInputData(projectList);
                raport = generateRaport.generateReport();
                break;
            case TOP_10:
                generateRaport = new Top10Report();
                generateRaport.setInputData(projectList);
                raport = new Top10Report().generateReport();
                break;
            case FILTER_BY_TAG:
                generateRaport = new FilterByTagReport();
                generateRaport.setInputData(projectList);
                ((FilterByTagReport) generateRaport).setFilterData(inputManager.getTags());
                raport = new FilterByTagReport().generateReport();
                break;
            default:
                System.out.println("Wrong report type");
                break;
        }
        return raport;
    }
}
