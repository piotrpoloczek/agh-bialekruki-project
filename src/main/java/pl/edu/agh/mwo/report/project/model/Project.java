package pl.edu.agh.mwo.report.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Project {

    private String name;
    private List<User> userList = new ArrayList<>();
//f
    public Project(String name) {
        this.name = name;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public String toString() {
        return "Project{"
                + "name='" + name + '\''
                + ", userList="
                + userList
                + '}';
    }
}
