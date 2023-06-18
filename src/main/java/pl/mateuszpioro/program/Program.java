package pl.mateuszpioro.program;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.ranking.DayHoursRanking;
import pl.mateuszpioro.ranking.EmployeeHoursRanking;
import pl.mateuszpioro.ranking.MonthHoursRanking;

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
}
