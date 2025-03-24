package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int proteins;
    private int fats;
    private int carbohydrates;

    @ManyToOne
    private User user;

    private String date;

    @ManyToMany
    private List<Meal> meals;
}
