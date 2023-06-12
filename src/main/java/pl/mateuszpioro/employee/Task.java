package pl.mateuszpioro.employee;


import java.time.LocalDate;

public class Task {
    private LocalDate date;
    private String title;
    private int time;

    public Task(LocalDate date, String title, int time) {
        this.date = date;
        this.title = title;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public int getTime() {
        return time;
    }
}
