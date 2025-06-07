package pl.edu.agh.mwo.report.project.reports;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelPrinter {
    private String title;
    private List<String> headers;
    private List<List<String>> rows;

    public ExcelPrinter(String title, List<String> headers, List<List<String>> rows) {
        this.title = title;
        this.headers = headers;
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public String madePackage() throws FileNotFoundException {
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

    public String currentDate(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Bieżąca data i godzina: " + now);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");

        return now.format(format);
    }

    private void createPackage() throws IOException {
        String folderName = madePackage();
        String currentDate = currentDate();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(getTitle());
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        List<String> headers = getHeaders();
        data.put("1", headers.toArray(new Object[0]));

        for (int i = 0; i < getRows().size(); i++) {
            data.put(String.valueOf(i+2), getRows().get(i).toArray());
        }


        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            XSSFRow row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                XSSFCell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String)obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        FileOutputStream out = new FileOutputStream(folderName+"/"+getTitle() +"_"+ currentDate + ".xlsx");
        workbook.write(out);
        out.close();
    }

    public void printReportOne() throws IOException {
        createPackage();
    }

    public void printReportTwo() throws IOException {
        createPackage();
    }
}
