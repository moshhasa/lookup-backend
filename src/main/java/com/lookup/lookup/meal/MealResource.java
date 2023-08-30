package com.lookup.lookup.meal;


import com.lookup.lookup.meal.entity.MealEntity;
import com.lookup.lookup.meal.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meals")
public class MealResource {

    private final MealRepository mealRepository;

    @Autowired
    public MealResource(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

//
//    @Override
//    public void init() {
//        setItems(Arrays.asList(new Meal(1, "Sushi", 20.99, "Finest fist and veggies"),
//                new Meal(2, "Schnitzel", 16.50, "A german speciality"),
//                new Meal(3, "Barbeque Burger", 9.99, "American, raw, meaty")));
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getMeals() {
        return mealRepository.findAll()
                .stream()
                .map(Meal::of)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{mealId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal getMeal(@PathVariable("mealId") long mealId) {
        return this.mealRepository.findById(mealId)
                .map(Meal::of)
                .orElseThrow(() -> new EntityNotFoundException("Meal does not exists!"));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal addMeal(@RequestBody Meal meal) {
        final MealEntity entity = new MealEntity();
        entity.setName(meal.getName());
        entity.setPrice(meal.getPrice());
        entity.setDescription(meal.getDescription());
        return Meal.of(this.mealRepository.save(entity));
    }

    @DeleteMapping("/{mealId}")
    public List<Meal> deleteMeal(@PathVariable("mealId") long mealId) {
        this.mealRepository.deleteById(mealId);
       return  mealRepository.findAll()
               .stream()
               .map(Meal::of)
               .collect(Collectors.toList());
    }

    @PutMapping(value = "/{mealId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal updateMeal(@PathVariable("mealId") long mealId, @RequestBody Meal meal) {
       MealEntity entity =  this.mealRepository.findById(mealId)
                .orElseThrow(() -> new EntityNotFoundException("Meal does not exists!"));

        entity.setDescription(meal.getDescription());
        entity.setName(meal.getName());
        entity.setPrice(meal.getPrice());

        return Meal.of(this.mealRepository.save(entity));
    }
}
