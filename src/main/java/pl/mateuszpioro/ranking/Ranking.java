package pl.mateuszpioro.ranking;

import pl.mateuszpioro.employee.Employee;

import java.util.ArrayList;

public abstract class Ranking {
    protected ArrayList<Employee> employees;
    public Ranking(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
