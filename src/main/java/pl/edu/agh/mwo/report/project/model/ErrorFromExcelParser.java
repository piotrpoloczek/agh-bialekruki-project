package pl.edu.agh.mwo.report.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorFromExcelParser {

    String path;
    String sheetName;
    int rowNumber;

    @Override
    public String toString() {
        return "Error occurred: "
                + "path: '" + path + "' , sheetName: " + sheetName + ", rowNumber: " + rowNumber;
    }
}
