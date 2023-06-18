package pl.mateuszpioro.ranking;

import java.time.LocalDateTime;

public class WorkingDateTime {

    public static final String[] POLISH_MONTH_NAMES = {"Styczeń", "Luty", "Marzec",
            "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};

    private final LocalDateTime dateTime;
    private double workingHours;

    public WorkingDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        workingHours = 0;
    }
    public String getPolishMonthName() {
        return POLISH_MONTH_NAMES[dateTime.getMonthValue() - 1] + " " + dateTime.getYear();
    }

    public String getPolishDayName() {
        return dateTime.getDayOfMonth() + " " + getPolishMonthName();
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
}
