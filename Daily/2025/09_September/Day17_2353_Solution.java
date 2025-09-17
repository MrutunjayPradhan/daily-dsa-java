import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodRatings {
    private Map<String, Integer> foodRatingMap = new HashMap<>();
    private Map<String, String> foodCuisineMap = new HashMap<>();
    private Map<String, TreeSet<Food>> cuisineFoodMap = new HashMap<>();

    class Food {
        int rating;
        String name;

        Food(int rating, String name) {
            this.rating = rating;
            this.name = name;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            cuisineFoodMap
                .computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                    if (a.rating != b.rating) return b.rating - a.rating; // higher first
                    return a.name.compareTo(b.name); // lexicographic
                }))
                .add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        TreeSet<Food> set = cuisineFoodMap.get(cuisine);

        // remove old
        set.remove(new Food(foodRatingMap.get(food), food));

        // update map
        foodRatingMap.put(food, newRating);

        // add new
        set.add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        return cuisineFoodMap.get(cuisine).first().name;
    }
}
