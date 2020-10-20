package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_MEAL_ID_1 = START_SEQ;
    public static final int USER_MEAL_ID_2 = START_SEQ + 1;
    public static final int USER_MEAL_ID_3 = START_SEQ + 2;
    public static final int ADMIN_MEAL_ID_1 = START_SEQ + 3;
    public static final int ADMIN_MEAL_ID_2 = START_SEQ + 4;
    public static final int ADMIN_MEAL_ID_3 = START_SEQ + 5;
    public static final int NOT_FOUND = 10;

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final Meal user_meal_1 = new Meal(USER_MEAL_ID_1, LocalDateTime.parse("2020-01-30 10:00", formatter), "Завтрак", 500);
    public static final Meal user_meal_2 = new Meal(USER_MEAL_ID_2, LocalDateTime.parse("2020-01-30 13:00", formatter), "Обед", 1000);
    public static final Meal user_meal_3 = new Meal(USER_MEAL_ID_3, LocalDateTime.parse("2020-01-30 20:00", formatter), "Ужин", 500);
    public static final Meal admin_meal_1 = new Meal(ADMIN_MEAL_ID_1, LocalDateTime.parse("2020-01-31 10:00", formatter), "Завтрак", 1000);
    public static final Meal admin_meal_2 = new Meal(ADMIN_MEAL_ID_2, LocalDateTime.parse("2020-01-30 13:00", formatter), "Обед", 500);
    public static final Meal admin_meal_3 = new Meal(ADMIN_MEAL_ID_3, LocalDateTime.parse("2020-01-30 20:00", formatter), "Ужин", 410);

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
