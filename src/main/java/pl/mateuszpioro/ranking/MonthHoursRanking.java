package pl.mateuszpioro.ranking;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.EmployeeProject;
import pl.mateuszpioro.employee.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthHoursRanking extends Ranking implements IRanking {

    public MonthHoursRanking(ArrayList<Employee> employees) {
        super(employees);
    }

    @Override
    public Month[] getRanking() {
        HashMap<String, Month> months = new HashMap<>();

        for(Employee e : employees) {
            for(EmployeeProject p : e.getProjects()) {
                for(Task t : p.getTasks()) {
                    Month month = new Month(t.getDate());
                    String key = month.getFullPolishName();

                    if(months.containsKey(key)) {
                        Month existingMonth = months.get(key);
                        existingMonth.setWorkingHours(existingMonth.getWorkingHours() +  t.getTime());
                    }
                    else {
                        month.setWorkingHours(t.getTime());
                        months.put(month.getFullPolishName(), month);
                    }
                }
            }
        }
        return sort(months.values().toArray(new Month[0]));
    }

    private Month[] sort(Month[] table) {
        int lastIndex = table.length - 1;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < lastIndex; i++) {
                if (table[i].getWorkingHours() < table[i + 1].getWorkingHours()) {
                    Month jValue = table[i + 1];
                    table[i + 1] = table[i];
                    table[i] = jValue;
                    flag = true;
                }
            }
        }
        while (flag);

        return table;
    }
}
