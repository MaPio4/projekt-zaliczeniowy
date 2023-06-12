package pl.mateuszpioro.ranking;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.EmployeeProject;
import pl.mateuszpioro.employee.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeHoursRanking implements IRanking<Employee[]> {
    private ArrayList<Employee> employees;

    public EmployeeHoursRanking(ArrayList<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public Employee[] getRanking() {
        Employee[] ranking = employees.toArray(new Employee[0]);
        this.sort(ranking);
        return ranking;
    }

    public void sort(Employee[] table) {
        int lastIndex = table.length - 1;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < lastIndex; i++) {
                if (table[i].getHours() < table[i + 1].getHours()) {
                    Employee jValue = table[i + 1];
                    table[i + 1] = table[i];
                    table[i] = jValue;
                    flag = true;
                }
            }
        } while (flag);
    }
}
