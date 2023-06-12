package pl.mateuszpioro.employee;

import java.util.ArrayList;

public class EmployeeProject {
    private String name;
    private ArrayList<Task> tasks;

    public EmployeeProject(String name, ArrayList<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
