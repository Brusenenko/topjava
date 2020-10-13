package ru.javawebinar.topjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.Collection;

@Service
public class MealService {
    private static final Logger log = LoggerFactory.getLogger(MealService.class);
    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(int userId, Meal meal) {
        log.info("create {}", meal);
        return repository.save(userId, meal);
    }

    public void delete(int userId, int id) {
        log.info("delete {}", id);
        repository.delete(userId, id);
    }

    public Meal get(int userId, int id) {
        log.info("get {}", id);
        return repository.get(userId, id);
    }

    public Collection<Meal> getAll(int userId) {
        log.info("getAll for user #{}", userId);
        return repository.getAll(userId);
    }

    public void update(int userId, Meal meal) {
        log.info("update {}", meal);
        repository.save(userId, meal);

    }
}