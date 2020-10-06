package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    private MealService mealService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mealService = new MealServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                mealService.delete(Integer.parseInt(Objects.requireNonNull(request.getParameter("id"))));
                response.sendRedirect("meals");
                break;
            case "create":
                request.setAttribute("meal", new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 0));
                request.getRequestDispatcher("/createMeal.jsp").forward(request, response);
                break;
            case "update":
                request.setAttribute("meal", mealService.get(Integer.parseInt(Objects.requireNonNull(request.getParameter("id")))));
                request.getRequestDispatcher("/createMeal.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("meals",
                        MealsUtil.filteredByStreams(mealService.getAll(), LocalTime.MIN, LocalTime.MAX, 2000));
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        mealService.save(meal);
        response.sendRedirect("meals");
    }
}
