package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.InputManager;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.TableReport;
import pl.edu.agh.mwo.report.project.report.*;

import java.util.List;

public class RaportFactory {

    public static TableReport getRaport(InputManager inputManager, List<Project> projectList) {
        TableReport raport = null;
        GenerateRaport generateRaport = null;
        switch (inputManager.getReportType()) {
            case USER_HOURS_ALL_PROJECTS:
                generateRaport = new ReportUserHoursAllProjects();
                generateRaport.setInputData(projectList);
                raport = generateRaport.generateReport();
                break;
            case HOURS_PER_PROJECT:
                generateRaport = new ReportHoursPerProjectPercent();
                generateRaport.setInputData(projectList);
                raport = generateRaport.generateReport();
                break;
            case DETAILS_PER_USER:
                generateRaport = new ReportDetailsPerUser();
                generateRaport.setInputData(projectList);
                raport = generateRaport.generateReport();
                break;
            case TOP_10:
                generateRaport = new ReportTop10();
                generateRaport.setInputData(projectList);
                raport = new ReportTop10().generateReport();
                break;
            case FILTER_BY_TAG:
                generateRaport = new ReportFilterByTag();
                generateRaport.setInputData(projectList);
                ((ReportFilterByTag) generateRaport).setFilterData(inputManager.getTags());
                raport = new ReportFilterByTag().generateReport();
                break;
            default:
                System.out.println("Wrong report type");
                break;
        }
        return raport;
    }
}
