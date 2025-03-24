package org.example.service;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.example.models.*;
import org.example.repository.MealRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Meal addMeal(@RequestBody @Valid Meal meal) {
        System.out.println("Received meal: " + meal);
        return mealRepository.save(meal);
    }

    public DailyReportDTO getDailyReport(Long userId, Date date) {
        List<Meal> meals = mealRepository.findByUserIdAndDate(userId, date);
        int totalCalories = meals.stream().mapToInt(Meal::getCalories).sum();
        return new DailyReportDTO(totalCalories, meals.size());
    }

    public CalorieCheckDTO checkCalorieLimit(Long userId, Date date) {
        List<Meal> meals = mealRepository.findByUserIdAndDate(userId, date);
        int totalCalories = meals.stream().mapToInt(Meal::getCalories).sum();

        // Получаем дневную норму калорий пользователя
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        int dailyCalorieLimit = user.getGoal().ordinal();  // Допустим, это поле содержит дневную норму калорий

        boolean withinLimit = totalCalories <= dailyCalorieLimit;
        return new CalorieCheckDTO(totalCalories, dailyCalorieLimit, withinLimit);
    }

    public List<MealHistoryDTO> getMealHistory(Long userId, Date startDate, Date endDate) {
        List<Meal> meals = mealRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
        Map<Date, Integer> dailyCalories = new HashMap<>();

        for (Meal meal : meals) {
            dailyCalories.merge(meal.getDate(), meal.getCalories(), Integer::sum);
        }

        return dailyCalories.entrySet().stream()
                .map(entry -> new MealHistoryDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
