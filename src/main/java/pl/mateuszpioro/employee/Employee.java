package pl.mateuszpioro.employee;

import java.util.ArrayList;

public class Employee {
    private String name;

    private ArrayList<Task> tasks;

    public Employee(String name) {
        this.name = name;
        tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
