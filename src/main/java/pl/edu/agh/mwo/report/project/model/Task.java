package pl.edu.agh.mwo.report.project.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Task {

    private LocalDateTime date;

    private String name;

    private float timeSpentOnTheTask;
}
