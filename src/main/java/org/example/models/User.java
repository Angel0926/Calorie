package org.example.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 18, message = "Age should be at least 18")
    private int age;

    private double weight;
    private double height;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference  // This will manage the forward side of the relationship
    private List<Meal> meals;

    public User(String name, List<Meal> meals) {
        this.name = name;
        this.meals = meals;
    }

    public User() {

    }

    public List<Meal> getMeals() {
        return meals;
    }

    @Enumerated(EnumType.STRING)
    private Goal goal;

    @Transient
    private double dailyCalories;

    public double calculateDailyCalories() {
        double bmr;
        if (goal == Goal.LOSS) {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        } else if (goal == Goal.MAINTENANCE) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5 + 500;
        }
        this.dailyCalories = bmr;
        return this.dailyCalories;
    }

    public enum Goal {
        LOSS,
        MAINTENANCE,
        GAIN
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Name is required") @NotNull(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name is required") @NotNull(message = "Name is required") String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Min(value = 18, message = "Age should be at least 18")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 18, message = "Age should be at least 18") int age) {
        this.age = age;
    }

    public @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public double getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(double dailyCalories) {
        this.dailyCalories = dailyCalories;
    }
}
