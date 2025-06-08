package pl.edu.agh.mwo.report.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Date date;

    private String name;

    private float timeSpentOnTheTask;

    @Override
    public String toString() {
        return "Task{"
                + "date='" + date + '\''
                + ", name='" + name + '\''
                + ", timeSpentOnTheTask="
                + timeSpentOnTheTask
                + '}';
    }
}
