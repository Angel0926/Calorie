package org.example.models;

public class CalorieCheckDTO {
    private int totalCalories;
    private int dailyCalorieLimit;
    private boolean withinLimit;

    public CalorieCheckDTO(int totalCalories, int dailyCalorieLimit, boolean withinLimit) {
        this.totalCalories = totalCalories;
        this.dailyCalorieLimit = dailyCalorieLimit;
        this.withinLimit = withinLimit;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public int getDailyCalorieLimit() {
        return dailyCalorieLimit;
    }

    public void setDailyCalorieLimit(int dailyCalorieLimit) {
        this.dailyCalorieLimit = dailyCalorieLimit;
    }

    public boolean isWithinLimit() {
        return withinLimit;
    }

    public void setWithinLimit(boolean withinLimit) {
        this.withinLimit = withinLimit;
    }
}
