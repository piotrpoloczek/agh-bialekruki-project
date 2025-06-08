package pl.edu.agh.mwo.report.project.reports;


import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.TableReport;

import java.util.List;

public interface GenerateRaport {

    TableReport generateReport();

    void setInputData(List<Project> projects);
}
