package pl.edu.agh.mwo.report.project.reports;

import lombok.Getter;
import lombok.Setter;
import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FilterByTagReport implements GenerateRaport, ParseFilter {
    private List<String> tags;
    private List<Project> projects = new ArrayList<>();
    private List<String> headers = Arrays.asList("User name", "Date", "Task name", "Time spent");
    private List<List<String>> rows = new ArrayList<>();
    private List<ErrorFromExcelParser> errors = new ArrayList<>();
    @Override
    public TableReport generateReport() {
        for (Project project : projects) {
            List<User> userList = project.getUserList();
            for (User user : userList) {
                List<Task> taskList = user.getTaskList();
                getTasksAndFillAllRows(user, taskList);
            }
            List<ErrorFromExcelParser> errorList = project.getErrorFromExcelParserList();
            errors.addAll(errorList);
        }
        return new TableReport("Raport 5", headers, rows, errors);

        //TODO Wyświetlić osobę, czynność, datę i liczbę godzin spędzonych

    }

    private void getTasksAndFillAllRows(User user, List<Task> taskList) {
        for (Task task : taskList) {
            String name = task.getName();
            String[] strings = name.split(" ");
            fillTheRowsByData(user, task, strings);
        }
    }

    private void fillTheRowsByData(User user, Task task, String[] strings) {
        for (int i = 0; i < strings.length ; i++) {
            if(tags.contains(strings[i].toLowerCase())) {
                rows.add(Arrays.asList(
                        user.getName(),
                        task.getDate().toString(),
                        task.getName(),
                        String.valueOf(task.getTimeSpentOnTheTask()
                        )
                ));
            }
        }
    }

    @Override
    public void setInputData(List<Project> projects) {
        setProjects(projects) ;
    }

    @Override
    public void setFilterData(List<String> tags) {
        this.tags = tags.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
