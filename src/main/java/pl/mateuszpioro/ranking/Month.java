package pl.mateuszpioro.ranking;

import java.time.LocalDateTime;

public class Month {

    public static final String[] POLISH_MONTH_NAMES = {"Styczeń", "Luty", "Marzec",
            "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};

    private final LocalDateTime dateTime;
    private double workingHours;

    public Month(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        workingHours = 0;
    }
    public String getFullPolishName() {
        return POLISH_MONTH_NAMES[dateTime.getMonthValue() - 1] + " " + dateTime.getYear();
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
}
