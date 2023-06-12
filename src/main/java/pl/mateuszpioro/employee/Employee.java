package pl.mateuszpioro.employee;

import java.util.ArrayList;

public class Employee {
    private String name;
    private ArrayList<EmployeeProject> projects;

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
}
