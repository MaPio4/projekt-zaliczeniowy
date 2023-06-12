package pl.mateuszpioro;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.EmployeeProject;
import pl.mateuszpioro.employee.Task;
import pl.mateuszpioro.file_reader.DirectoryEmployeeReader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DirectoryEmployeeReader reader = new DirectoryEmployeeReader();

        try {
            ArrayList<Employee> employees = reader.readAllEmployees("C:\\Users\\Mateusz\\Desktop\\projekt_zaliczeniowy\\reporter-dane\\2012\\01");
            for (Employee employee : employees) {
                System.out.println("#Employee: " + employee.getName());
                for(EmployeeProject p : employee.getProjects()) {
                    System.out.println("##Project: " + p.getName());
                    for (Task t : p.getTasks()) {
                        System.out.println("### Task: " + t.getTitle() + " | " + t.getDate() + " | " + t.getTime());
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}