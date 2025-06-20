package pl.edu.agh.mwo.report.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Project {

    private String name;
    private List<User> userList = new ArrayList<>();
    private List<ErrorFromExcelParser> errorFromExcelParserList = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addErrorFromExcelParser(ErrorFromExcelParser errorFromExcelParser) {
        errorFromExcelParserList.add(errorFromExcelParser);
    }

    @Override
    public String toString() {
        return "Project{"
                + "name='" + name + '\''
                + ", userList=" + userList
                + ", errorFromExcelParserList="
                + errorFromExcelParserList
                + '}';
    }
}
