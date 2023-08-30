package com.lookup.lookup.meal;


import com.lookup.lookup.BaseResponse;
import com.lookup.lookup.meal.entity.MealEntity;

public class Meal extends BaseResponse<Meal> {

    private String name;
    private String description;
    private Double price;

    public Meal() {

    }

    public Meal(long id, String name, Double price, String description) {
        setId(id);
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Meal copy(Meal meal) {
        this.name = meal.name;
        this.price = meal.price;
        this.description = meal.description;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static Meal of(MealEntity mealEntity) {
        return new Meal(mealEntity.getId(), mealEntity.getName(), mealEntity.getPrice(), mealEntity.getDescription());
    }
}