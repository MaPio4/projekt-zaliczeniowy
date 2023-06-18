package pl.mateuszpioro;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.file_reader.DirectoryEmployeeReader;
import pl.mateuszpioro.program.Program;
import pl.mateuszpioro.program.UIMessages;
import pl.mateuszpioro.ranking.WorkingDateTime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;

public class Main {
    public static Program program;
    public static BufferedReader reader;
    public static void main(String[] args) {
        program = new Program();
        reader = new BufferedReader(new InputStreamReader(System.in));

        while(program.isAlive) {
            System.out.println("\n");
            System.out.println(UIMessages.HELLO_MESSAGE);
            boolean readingEmployeesComplete = false;

            while(!readingEmployeesComplete) {
                System.out.println(UIMessages.MENU_MESSAGE);
                String path;
                try {
                    path = reader.readLine();
                    if(path.equals(UIMessages.EXIT_COMMAND))
                        return;
                }
                catch (IOException e) {
                    System.out.println(UIMessages.WRONG_PATH);
                    continue;
                }

                ArrayList<Employee> employees;
                DirectoryEmployeeReader employeesReader = new DirectoryEmployeeReader();

                try {
                    employees = employeesReader.readAllEmployees(path);
                    program.setEmployees(employees);
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

                System.out.println("Wczytano " + employees.size() + " pracowników!");
                readingEmployeesComplete = true;
                System.out.println("Generowanie rankingów...");

                Employee[] employeesRanking;
                WorkingDateTime[] monthHoursRanking;
                WorkingDateTime[] dayHoursRanking;

                try {
                    employeesRanking = program.getEmployeeHoursRanking().getRanking();
                    monthHoursRanking = program.getMonthHoursRanking().getRanking();
                    dayHoursRanking = program.getDayHoursRanking().getRanking();
                }
                catch (Exception e) {
                    System.out.println("Błąd podczas wczytywania rankingów!");
                    continue;
                }
                int index;

                System.out.println("\nRanking pracowników wg przepracowanych godzin we wszystkich projetkach:");
                index = 1;
                for(Employee e : employeesRanking) {
                    System.out.println(index +". " + e.getName() + " - " + (int) e.getHours() + " godzin");
                    index++;
                }

                System.out.println("\nRanking miesięcy wg przepracowanych godzin:");
                index = 1;
                for(WorkingDateTime e : monthHoursRanking) {
                    System.out.println(index +". " + e.getPolishMonthName() + " - " + (int) e.getWorkingHours() + " godzin");
                    index++;
                }

                System.out.println("\nRanking dziesięciu dni wg przepracowanych godzin:");
                index = 1;
                for(WorkingDateTime e : dayHoursRanking) {
                    System.out.println(index +". " + e.getPolishDayName() + " - " + (int) e.getWorkingHours() + " godzin");
                    index++;
                    if(index > 10)
                        break;
                }
            }
        }
    }


}