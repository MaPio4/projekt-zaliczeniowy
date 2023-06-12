package pl.mateuszpioro.file_reader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pl.mateuszpioro.config.Configuration;
import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.Task;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class EmployeeSheetReader {
    public Employee readEmployee(String path) {
        try {
            File file = new File(path);
            Workbook wb = WorkbookFactory.create(file);
            ArrayList<Task> tasks = this.readTasks(wb.getSheet(Configuration.SHEET_NAME));

            return new Employee(this.getEmployeeName(file), tasks);
        }
        catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<Task> readTasks(Sheet sheet) {
        int index = 1;
        Row row = sheet.getRow(index);
        ArrayList<Task> tasks = new ArrayList<>();

        while(row != null) {
            Date date = row.getCell(Configuration.DATE_CELL_INDEX).getDateCellValue();
            String title = row.getCell(Configuration.TITLE_CELL_INDEX).getStringCellValue();
            double time = row.getCell(Configuration.TIME_CELL_INDEX).getNumericCellValue();

            tasks.add(new Task(date, title, time));
            row = sheet.getRow(index++);
        }

        return tasks;
    }

    private String getEmployeeName(File file) {
        String filename = file.getName();
        filename = filename.replace("_", " ");
        filename = filename.replace(".xls", "");
        return filename;
    }
}
