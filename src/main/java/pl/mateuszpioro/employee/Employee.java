package pl.mateuszpioro.employee;

import java.util.ArrayList;

public class Employee {
    private final String name;
    private final ArrayList<EmployeeProject> projects;

    public Employee(String name, ArrayList<EmployeeProject> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public ArrayList<EmployeeProject> getProjects() {
        return projects;
    }

    public double getHours() {
        double hours = 0.0;
        for(EmployeeProject p : this.getProjects()) {
            for(Task t : p.getTasks()) {
                hours += t.getTime();
            }
        }
        return hours;
    }
}
