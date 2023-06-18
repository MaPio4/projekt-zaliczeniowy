package pl.mateuszpioro.file_reader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pl.mateuszpioro.config.Configuration;
import pl.mateuszpioro.config.UIMessages;
import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.EmployeeProject;
import pl.mateuszpioro.employee.Task;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class EmployeeSheetReader {
    public Employee readEmployee(String path) {
        try {
            File file = new File(path);

            Workbook wb = WorkbookFactory.create(file);
            ArrayList<EmployeeProject> projects = new ArrayList<>();

            for(int i = 0; i < wb.getNumberOfSheets(); i++) {
                Sheet sheet = wb.getSheetAt(i);
                ArrayList<Task> tasks = this.readTasks(sheet);
                projects.add(new EmployeeProject(sheet.getSheetName(), tasks));
            }

            return new Employee(this.getEmployeeName(file), projects);
        }
        catch(IOException e) {
            System.out.println(UIMessages.OPENING_EMPLOYEE_FILE_ERROR + path);
            return null;
        }
    }

    private ArrayList<Task> readTasks(Sheet sheet) {
        int index = 1;
        Row row = sheet.getRow(index);
        ArrayList<Task> tasks = new ArrayList<>();

        while(row != null) {
            index++;
            LocalDateTime date = row.getCell(Configuration.DATE_CELL_INDEX).getLocalDateTimeCellValue();
            String title = row.getCell(Configuration.TITLE_CELL_INDEX).getStringCellValue();
            double time = row.getCell(Configuration.TIME_CELL_INDEX).getNumericCellValue();

            tasks.add(new Task(date, title, time));
            row = sheet.getRow(index);
        }

        return tasks;
    }

    private String getEmployeeName(File file) {
        String filename = file.getName();
        filename = filename.replace(Configuration.SEPARATOR, " ");
        filename = filename.replace(Configuration.FILES_EXTENSION, "");
        return filename;
    }
}
