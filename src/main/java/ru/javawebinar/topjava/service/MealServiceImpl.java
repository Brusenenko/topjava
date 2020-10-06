package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.InMemoryMealRepository;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.List;

public class MealServiceImpl implements MealService {

    private final MealRepository repository = new InMemoryMealRepository();

    @Override
    public void save(Meal meal) {
        repository.save(meal);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Meal> getAll() {
        return repository.getAll();
    }
}
