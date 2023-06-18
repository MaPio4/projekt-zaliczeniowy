package pl.mateuszpioro.ranking;

import pl.mateuszpioro.employee.Employee;

import java.util.ArrayList;

public class EmployeeHoursRanking extends Ranking implements IRanking<Employee[]> {

    public EmployeeHoursRanking(ArrayList<Employee> employees) {
        super(employees);
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
