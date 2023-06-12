package pl.mateuszpioro.employee;

import java.util.Date;

public class Task {
    private final Date date;
    private final String title;
    private final double time;

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
