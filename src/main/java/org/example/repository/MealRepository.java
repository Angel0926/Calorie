package org.example.repository;

import org.example.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUserIdAndDate(Long userId, Date date); // Поиск по пользователю и дате
    public abstract List<Meal> findByUserIdAndDateBetween(Long userId, Date startDate, Date endDate);

}

