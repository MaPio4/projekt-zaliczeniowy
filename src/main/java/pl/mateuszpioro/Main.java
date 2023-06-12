package pl.mateuszpioro;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.EmployeeProject;
import pl.mateuszpioro.employee.Task;
import pl.mateuszpioro.file_reader.DirectoryEmployeeReader;
import pl.mateuszpioro.ranking.EmployeeHoursRanking;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DirectoryEmployeeReader reader = new DirectoryEmployeeReader();

        try {
            ArrayList<Employee> employees = reader.readAllEmployees("C:\\Users\\Mateusz\\Desktop\\projekt_zaliczeniowy\\reporter-dane\\2012\\01");
            EmployeeHoursRanking hoursRanking = new EmployeeHoursRanking(employees);
            Employee[] ranking = hoursRanking.getRanking();

            for(int i = 0; i < ranking.length; i++) {
                System.out.println(i + ". " + ranking[i].getName() + ", hours: " + ranking[i].getHours());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}