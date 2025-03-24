package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.MealController;
import org.example.models.Meal;
import org.example.repository.MealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class MealControllerTest {

    @InjectMocks
    private MealController mealController;

    @Mock
    private MealRepository mealRepository;
    private MockMvc mockMvc;

    private Meal meal;

    @BeforeEach
    void setUp() {
        meal = new Meal();
        meal.setId(1L);
        meal.setName("Breakfast");
        meal.setCalories(350);

        mockMvc = MockMvcBuilders.standaloneSetup(mealController).build();
    }

    @Test
    void testAddMeal() throws Exception {
        when(mealRepository.save(any(Meal.class))).thenReturn(meal);

        mockMvc.perform(post("/meals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(meal)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Breakfast"))
                .andExpect(jsonPath("$.calories").value(350));
    }


    @Test
    void testGetMeals() throws Exception {
        when(mealRepository.findAll()).thenReturn(Arrays.asList(meal));

        mockMvc.perform(get("/meals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Breakfast"));
    }

    @Test
    void testGetMealById() throws Exception {
        when(mealRepository.findById(1L)).thenReturn(Optional.of(meal));

        mockMvc.perform(get("/meals/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Breakfast"))
                .andExpect(jsonPath("$.calories").value(350));
    }
}
