package pl.edu.agh.mwo.report.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class User {

    private String name;
    private List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name
                + '\''
                + ", taskList="
                + taskList
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
