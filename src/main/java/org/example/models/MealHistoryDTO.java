package org.example.models;

import java.time.LocalDate;
import java.util.Date;

public class MealHistoryDTO {
    private String date;
    private int totalCalories;

    public MealHistoryDTO(Date key, Integer value) {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }
}
