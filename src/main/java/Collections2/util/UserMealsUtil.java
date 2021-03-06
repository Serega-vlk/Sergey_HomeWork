package Collections2.util;

import Collections2.model.UserMeal;
import Collections2.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        List<UserMealWithExceed> list = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
        list.forEach(System.out::println);
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> list = new ArrayList<>();
        for (int i = 0; i < mealList.size(); i++) {
            int day = mealList.get(i).getDateTime().getDayOfMonth();
            int caloriesSum = 0;
            List<UserMeal> mealsOnDay = new ArrayList<>();
            for (UserMeal userMeal : mealList) {
                if (userMeal.getDateTime().getDayOfMonth() == day) {
                    caloriesSum += userMeal.getCalories();
                    mealsOnDay.add(userMeal);
                }
            }
            int caloriesSumResult = caloriesSum;
            mealsOnDay.stream()
                    .filter(x -> TimeUtil.isBetween(x.getDateTime().toLocalTime(), startTime, endTime))
                    .forEach(x -> {
                        UserMealWithExceed exceed = new UserMealWithExceed(x.getDateTime(), x.getDescription(),
                                x.getCalories(), caloriesSumResult > caloriesPerDay);
                        if (!list.contains(exceed))
                            list.add(exceed);
                    });
        }
        return list;
    }
}
