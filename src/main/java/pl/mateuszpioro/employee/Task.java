package pl.mateuszpioro.employee;


import java.time.LocalDate;
import java.util.Date;

public class Task {
    private Date date;
    private String title;
    private double time;

    public Task(Date date, String title, double time) {
        this.date = date;
        this.title = title;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public double getTime() {
        return time;
    }
}
