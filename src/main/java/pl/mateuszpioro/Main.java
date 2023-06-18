package pl.mateuszpioro;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.file_reader.DirectoryEmployeeReader;
import pl.mateuszpioro.ranking.DayHoursRanking;
import pl.mateuszpioro.ranking.WorkingDateTime;
import pl.mateuszpioro.ranking.MonthHoursRanking;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DirectoryEmployeeReader reader = new DirectoryEmployeeReader();

//        try {
//            ArrayList<Employee> employees = reader.readAllEmployees("C:\\Users\\Mateusz\\Desktop\\projekt_zaliczeniowy\\reporter-dane\\2012\\01");
//            System.out.println(employees);
//            EmployeeHoursRanking hoursRanking = new EmployeeHoursRanking(employees);
//            Employee[] ranking = hoursRanking.getRanking();
//
//            for(int i = 0; i < ranking.length; i++) {
//                System.out.println(i + ". " + ranking[i].getName() + ", hours: " + ranking[i].getHours());
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            ArrayList<Employee> employees = reader.readAllEmployees("C:\\Users\\Mateusz\\Desktop\\projekt_zaliczeniowy\\reporter-dane\\2012\\01");
//            MonthHoursRanking hoursRanking = new MonthHoursRanking(employees);
//            WorkingDateTime[] ranking = hoursRanking.getRanking();
//
//            System.out.println(employees);
//
//            for(int i = 0; i < ranking.length; i++) {
//                System.out.println(i + ". " + (ranking[i].getPolishMonthName()) + ", hours: " + ranking[i].getWorkingHours());
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            ArrayList<Employee> employees = reader.readAllEmployees("C:\\Users\\Mateusz\\Desktop\\projekt_zaliczeniowy\\reporter-dane\\2012\\01");
            DayHoursRanking hoursRanking = new DayHoursRanking(employees);
            WorkingDateTime[] ranking = hoursRanking.getRanking();

            System.out.println(employees);

            for(int i = 0; i < ranking.length; i++) {
                System.out.println(i + ". " + (ranking[i].getPolishDayName()) + ", hours: " + ranking[i].getWorkingHours());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}