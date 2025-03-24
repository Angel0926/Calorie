package org.example.models;

public class DailyReportDTO {
    private int totalCalories;
    private int numberOfMeals;

    public DailyReportDTO(int totalCalories, int numberOfMeals) {
        this.totalCalories = totalCalories;
        this.numberOfMeals = numberOfMeals;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }
}
