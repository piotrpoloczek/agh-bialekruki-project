package pl.edu.agh.mwo.report.project.reports;

import pl.edu.agh.mwo.report.project.model.Project;

import java.util.List;

public class FilterByTagReport implements GenerateRaport, ParseFilter {
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
