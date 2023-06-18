package pl.mateuszpioro.ranking;

import pl.mateuszpioro.employee.Employee;
import pl.mateuszpioro.employee.EmployeeProject;
import pl.mateuszpioro.employee.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class DayHoursRanking extends Ranking implements IRanking<WorkingDateTime[]> {
    public DayHoursRanking(ArrayList<Employee> employees) {
        super(employees);
    }

    @Override
    public WorkingDateTime[] getRanking() {
        HashMap<String, WorkingDateTime> dates = new HashMap<>();

        for(Employee e : employees) {
            for(EmployeeProject p : e.getProjects()) {
                for(Task t : p.getTasks()) {
                    WorkingDateTime w = new WorkingDateTime(t.getDate());
                    String key = w.getPolishDayName();
                    System.out.println(key);
                    if(dates.containsKey(key)) {
                        WorkingDateTime existingMonth = dates.get(key);
                        existingMonth.setWorkingHours(existingMonth.getWorkingHours() +  t.getTime());
                    }
                    else {
                        w.setWorkingHours(t.getTime());
                        dates.put(w.getPolishDayName(), w);
                    }
                }
            }
        }
        return sort(dates.values().toArray(new WorkingDateTime[0]));
    }

    private WorkingDateTime[] sort(WorkingDateTime[] table) {
        int lastIndex = table.length - 1;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < lastIndex; i++) {
                if (table[i].getWorkingHours() < table[i + 1].getWorkingHours()) {
                    WorkingDateTime jValue = table[i + 1];
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
