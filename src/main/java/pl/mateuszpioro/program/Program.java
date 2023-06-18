package pl.mateuszpioro.program;

import pl.mateuszpioro.config.Configuration;
import pl.mateuszpioro.config.UIMessages;
import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.file_reader.DirectoryEmployeeReader;
import pl.mateuszpioro.ranking.DayHoursRanking;
import pl.mateuszpioro.ranking.EmployeeHoursRanking;
import pl.mateuszpioro.ranking.MonthHoursRanking;
import pl.mateuszpioro.ranking.WorkingDateTime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;

public class Program {

    public boolean isAlive;
    private DayHoursRanking dayHoursRanking;
    private MonthHoursRanking monthHoursRanking;
    private EmployeeHoursRanking employeeHoursRanking;

    public Program() {
        isAlive = true;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        dayHoursRanking = new DayHoursRanking(employees);
        monthHoursRanking = new MonthHoursRanking(employees);
        employeeHoursRanking = new EmployeeHoursRanking(employees);
    }

    public DayHoursRanking getDayHoursRanking() {
        return dayHoursRanking;
    }

    public MonthHoursRanking getMonthHoursRanking() {
        return monthHoursRanking;
    }

    public EmployeeHoursRanking getEmployeeHoursRanking() {
        return employeeHoursRanking;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(UIMessages.HELLO_MESSAGE);
        boolean readingEmployeesComplete = false;

        while(!readingEmployeesComplete) {
            System.out.println(UIMessages.MENU_MESSAGE);
            String path;
            try {
                path = reader.readLine();
                if(path.equals(Configuration.EXIT_COMMAND))
                    return;
            }
            catch (IOException e) {
                System.out.println(UIMessages.WRONG_PATH);
                continue;
            }

            ArrayList<Employee> employees;
            DirectoryEmployeeReader employeesReader = new DirectoryEmployeeReader();

            System.out.println(UIMessages.READING_FILES);

            try {
                employees = employeesReader.readAllEmployees(path);
                this.setEmployees(employees);
            }
            catch (Exception e) {
                if(e instanceof FileNotFoundException)
                    System.out.println(UIMessages.WRONG_PATH);
                else if(e instanceof NotDirectoryException)
                    System.out.println(UIMessages.NOT_DIRECTORY);
                else
                    System.out.println(UIMessages.READING_FILES_ERROR);
                continue;
            }

            System.out.println(UIMessages.READ + " " + employees.size() + " " + UIMessages.EMPLOYEES);
            readingEmployeesComplete = true;
            System.out.println(UIMessages.GENERATING_RANKINGS);

            Employee[] employeesRanking;
            WorkingDateTime[] monthHoursRanking;
            WorkingDateTime[] dayHoursRanking;

            try {
                employeesRanking = this.getEmployeeHoursRanking().getRanking();
                monthHoursRanking = this.getMonthHoursRanking().getRanking();
                dayHoursRanking = this.getDayHoursRanking().getRanking();
            }
            catch (Exception e) {
                System.out.println(UIMessages.READING_RANKINGS_ERROR);
                continue;
            }
            int index;

            System.out.println("\n" + UIMessages.EMPLOYEES_RANKING_TITLE);
            index = 1;
            for(Employee e : employeesRanking) {
                System.out.println(index +". " + e.getName() + " - " +
                        (int) e.getHours() + " " + UIMessages.HOURS);
                index++;
            }

            System.out.println("\n" + UIMessages.MONTHS_RANKING_TITLE);
            index = 1;
            for(WorkingDateTime e : monthHoursRanking) {
                System.out.println(index +". " + e.getPolishMonthName() + " - " +
                        (int) e.getWorkingHours() + " " + UIMessages.HOURS);
                index++;
            }

            System.out.println("\n" + UIMessages.DAYS_RANKING_TITLE);
            index = 1;
            for(WorkingDateTime e : dayHoursRanking) {
                System.out.println(index +". " + e.getPolishDayName() + " - " +
                        (int) e.getWorkingHours() + " " + UIMessages.HOURS);
                index++;
                if(index > 10)
                    break;
            }
            System.out.println("\n" + UIMessages.GENERATING_DONE);
        }
    }

}
