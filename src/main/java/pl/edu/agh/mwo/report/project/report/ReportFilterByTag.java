package pl.edu.agh.mwo.report.project.report;

import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.TableReport;
import pl.edu.agh.mwo.report.project.reports.GenerateRaport;
import pl.edu.agh.mwo.report.project.reports.ParseFilter;

import java.util.List;

public class ReportFilterByTag implements GenerateRaport, ParseFilter {
    @Override
    public TableReport generateReport() {
        return null;
    }

    @Override
    public void setInputData(List<Project> projects) {

    }

    @Override
    public void setFilterData(List<String> tags) {

    }
}
