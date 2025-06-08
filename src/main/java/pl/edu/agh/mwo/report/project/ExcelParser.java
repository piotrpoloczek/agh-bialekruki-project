package pl.edu.agh.mwo.report.project;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pl.edu.agh.mwo.report.project.model.ErrorFromExcelParser;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class ExcelParser {

    public static List<Project> parseExcelToProjectList(Path givenPath) throws IOException {
        List<Path> paths = listOfAllPathsToExcels(givenPath);
        List<Project> projects = new ArrayList<>();

        paths.forEach(path -> {
            try (FileInputStream fileInputStream = new FileInputStream(path.toString());
                 Workbook workbook = WorkbookFactory.create(fileInputStream)) {
                int numberOfSheets = workbook.getNumberOfSheets();
                createProjectsFromSelectedPath(path, numberOfSheets, workbook, projects);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return projects;
    }

    private static void createProjectsFromSelectedPath(
            Path path,
            int numberOfSheets,
            Workbook workbook,
            List<Project> projects
    ) {
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            File file = new File(String.valueOf(path));
            String nameWithoutExtension = convertNameWithoutExtension(file.getName());
            boolean anyMatch = projects.stream().anyMatch(project -> project.getName().equals(sheet.getSheetName()));
            if (!anyMatch) {
                Project project = new Project(workbook.getSheetName(i));
                User user = new User(nameWithoutExtension);
                project.addUser(user);
                goByRow(path, sheet, file, project, user);
                projects.add(project);
            } else {
                Project projectFound = projects.stream().filter(project -> project.getName().equals(sheet.getSheetName())).findFirst().orElseThrow();
                User user = new User(nameWithoutExtension);
                projectFound.addUser(user);
                goByRow(path, sheet, file, projectFound,user);
            }
        }
    }

    private static void goByRow(Path path, Sheet sheet, File file, Project project, User user) {
        for (Row row : sheet) {
            if (row.getRowNum() > 0) {
                Task task = new Task();
                try {
                    Date dateCellValue = row.getCell(0).getDateCellValue();
                    String stringCellValue = row.getCell(1).getStringCellValue();
                    float parseFloat = Float.parseFloat(String.valueOf(row.getCell(2).getNumericCellValue()));
                    if (dateCellValue != null
                            && stringCellValue != null
                            && !stringCellValue.isEmpty()
                            && !stringCellValue.equalsIgnoreCase("null")
                            && parseFloat >= 0.0
                    ) {
                        task.setDate(dateCellValue);
                        task.setName(stringCellValue);
                        task.setTimeSpentOnTheTask(parseFloat);
                    } else {
                        project.addErrorFromExcelParser(new ErrorFromExcelParser(
                                path.toString(),
                                file.getName(),
                                row.getRowNum())
                        );
                    }
                    user.addTask(task);
                } catch (Exception e) {
                    project.addErrorFromExcelParser(new ErrorFromExcelParser(
                            path.toString(),
                            file.getName(),
                            row.getRowNum())
                    );
                }
            }
        }
    }

    private static List<Path> listOfAllPathsToExcels(Path path) throws IOException {
        return Files.walk(Paths.get(path.toString()))
                .filter(Files::isRegularFile)
                .toList();
    }

    private static String convertNameWithoutExtension(String fileName) {
        StringBuilder builder = new StringBuilder();

        String[] strings = fileName.replace("_", " ").split(".xls");
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }
}
