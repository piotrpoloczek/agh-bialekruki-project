package pl.edu.agh.mwo.report.project;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pl.edu.agh.mwo.report.project.model.Project;
import pl.edu.agh.mwo.report.project.model.Task;
import pl.edu.agh.mwo.report.project.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {


    public static List<Project> parseExcelToProjectList(Path givenPath) throws IOException {
        List<Path> paths = listOfAllPathsToExcels(givenPath);
        List<Project> projects = new ArrayList<>();


        paths.stream()
                .forEach(path -> {
                    try (FileInputStream fileInputStream = new FileInputStream(path.toString());
                         Workbook workbook = WorkbookFactory.create(fileInputStream)) {
                        int numberOfSheets = workbook.getNumberOfSheets();
                        for (int i = 0; i < numberOfSheets; i++) {
                            Project project = new Project(workbook.getSheetName(i));
                            Sheet sheet = workbook.getSheetAt(i);
                            File file = new File(String.valueOf(path));
                            String nameWithoutExtension = convertNameWithoutExtension(file.getName());
                            User user = new User(nameWithoutExtension);
                            project.addUser(user);

                            for (Row row : sheet) {
                                if (row.getRowNum() > 0) {
                                    Task task = new Task(
                                            row.getCell(0).getDateCellValue(),
                                            row.getCell(1).getStringCellValue(),
                                            Float.parseFloat(String.valueOf(row.getCell(2).getNumericCellValue())));
                                    user.addTask(task);
                                }
                            }
                            projects.add(project);
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        return projects;
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
