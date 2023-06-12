package pl.mateuszpioro.employee;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    private final LocalDateTime date;
    private final String title;
    private final double time;

    public Task(LocalDateTime date, String title, double time) {
        this.date = date;
        this.title = title;
        this.time = time;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public double getTime() {
        return time;
    }
}
