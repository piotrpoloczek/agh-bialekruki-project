package pl.edu.agh.mwo.report.project.printer;

import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class ExcelPrinter {

    public String madePackage() {
        String folderName = "reports";
        File dir = new File(folderName);

        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Folder " + folderName + " został utworzony.");
            } else {
                System.out.println("Nie udało się utworzyć folderu " + folderName + ".");
            }
        } else {
            System.out.println("Folder " + folderName + " już istnieje.");
        }

        return folderName;
    }

    public String currentDate() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Bieżąca data i godzina: " + now);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return now.format(format);
    }

    private void createPackage(List<String> headers, List<List<String>> rows, String title) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(title);
        Map<String, Object[]> data = new LinkedHashMap<>();

        data.put("1", headers.toArray(new Object[0]));

        for (int i = 0; i < rows.size(); i++) {
            data.put(String.valueOf(i + 2), rows.get(i).toArray());
        }

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        String folderName = madePackage();
        String currentDate = currentDate();

        FileOutputStream out = new FileOutputStream(folderName + "/" + title + "_" + currentDate + ".xls");
        workbook.write(out);
        out.close();
    }

    public void printReport(List<String> headers, List<List<String>> rows, String title) {
        try {
            createPackage(headers, rows, title);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
