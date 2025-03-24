package org.example.controller;

import org.example.models.CalorieCheckDTO;
import org.example.models.DailyReportDTO;
import org.example.models.MealHistoryDTO;
import org.example.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private MealService mealService;

    @GetMapping("/daily-report")
    public ResponseEntity<DailyReportDTO> getDailyReport(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        DailyReportDTO report = mealService.getDailyReport(userId, date);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/calorie-limit")
    public ResponseEntity<CalorieCheckDTO> checkCalorieLimit(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        CalorieCheckDTO result = mealService.checkCalorieLimit(userId, date);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/meal-history")
    public ResponseEntity<List<MealHistoryDTO>> getMealHistory(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<MealHistoryDTO> history = mealService.getMealHistory(userId, startDate, endDate);
        return ResponseEntity.ok(history);
    }
}
