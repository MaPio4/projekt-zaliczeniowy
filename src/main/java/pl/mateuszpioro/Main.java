package pl.mateuszpioro;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.Task;
import pl.mateuszpioro.file_reader.EmployeeSheetReader;

public class Main {
    public static void main(String[] args) {
        EmployeeSheetReader reader = new EmployeeSheetReader();

        Employee employee = reader.readEmployee("C:\\Users\\Mateusz\\Desktop\\projekt_zaliczeniowy\\reporter-dane\\2012\\01\\Kowalski_Jan.xls");
        System.out.println(employee.getName());
        for (Task t : employee.getTasks()) {
            System.out.println(t.getTitle() + " | " + t.getDate() + " | " + t.getTime());
        }
    }
}