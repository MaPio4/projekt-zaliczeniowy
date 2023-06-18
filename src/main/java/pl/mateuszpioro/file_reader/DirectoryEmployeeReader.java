package pl.mateuszpioro.file_reader;

import pl.mateuszpioro.employee.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;

public class DirectoryEmployeeReader {
    public ArrayList<Employee> readAllEmployees(String path) throws NotDirectoryException, FileNotFoundException {
        File dir = new File(path);
        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeSheetReader reader = new EmployeeSheetReader();

        if(!dir.exists()) {
            throw new FileNotFoundException(dir.getPath());
        }

        if(!dir.isDirectory()) {
            throw new NotDirectoryException(dir.getPath());
        }

        ArrayList<File> files = new ArrayList<>();
        this.addAllFiles(files, dir);

        for(File file : files) {
            Employee employee = reader.readEmployee(file.getPath());
            if(employee != null) {
                employees.add(employee);
            }
        }

        return employees;
    }

    private void addAllFiles(ArrayList<File> foundFiles, File dir) {
        File[] files = dir.listFiles();

        if(files == null)
            return;

        for(File f : files) {
            if(f.isDirectory()) {
                addAllFiles(foundFiles, f);
            }
            else if(f.isFile()) {
                foundFiles.add(f);
            }
        }
    }
}
