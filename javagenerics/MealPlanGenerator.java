/*
 * Different meal categories such as Vegetarian,
 * Vegan, Keto, and High Protein are handled
 * using a generic Meal<T extends MealPlan>.
 * The system dynamically generates meal plans
 * while maintaining compile-time type safety.
 */

package javagenerics;

import java.util.ArrayList;
import java.util.List;

interface MealPlan {

    // Returns the name of the meal plan
    String getPlanName();

    // Displays diet guidelines for the meal plan
    void showDietGuidelines();
}

class VegetarianMeal implements MealPlan {

    // Returns vegetarian meal plan name
    @Override
    public String getPlanName() {
        return "Vegetarian Meal Plan";
    }

    // Displays vegetarian diet guidelines
    @Override
    public void showDietGuidelines() {
        System.out.println("Includes vegetables, fruits, dairy. No meat.");
    }
}

class VeganMeal implements MealPlan {

    // Returns vegan meal plan name
    @Override
    public String getPlanName() {
        return "Vegan Meal Plan";
    }

    // Displays vegan diet guidelines
    @Override
    public void showDietGuidelines() {
        System.out.println("Includes plant-based foods only. No animal products.");
    }
}

class KetoMeal implements MealPlan {

    // Returns keto meal plan name
    @Override
    public String getPlanName() {
        return "Keto Meal Plan";
    }

    // Displays keto diet guidelines
    @Override
    public void showDietGuidelines() {
        System.out.println("High fat, low carb diet.");
    }
}

class HighProteinMeal implements MealPlan {

    // Returns high protein meal plan name
    @Override
    public String getPlanName() {
        return "High Protein Meal Plan";
    }

    // Displays high protein diet guidelines
    @Override
    public void showDietGuidelines() {
        System.out.println("Protein-rich foods like eggs, chicken, legumes.");
    }
}

class Meal<T extends MealPlan> {

    private T mealPlan;
    private List<String> dishes;

    // Constructor to initialize meal with specific plan
    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
        this.dishes = new ArrayList<>();
    }

    // Adds a dish to the meal
    public void addDish(String dish) {
        dishes.add(dish);
    }

    // Displays meal plan details and included dishes
    public void displayMeal() {
        System.out.println("Meal Plan: " + mealPlan.getPlanName());
        mealPlan.showDietGuidelines();

        System.out.println("Dishes Included:");
        for (String dish : dishes) {
            System.out.println("- " + dish);
        }
    }

    // Returns the associated meal plan
    public T getMealPlan() {
        return mealPlan;
    }
}

class MealGenerator {

    // Generates a meal plan dynamically using bounded generic method
    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {

        Meal<T> meal = new Meal<>(plan);

        // Simple validation logic for different meal types
        if (plan instanceof VegetarianMeal) {
            meal.addDish("Paneer Curry");
            meal.addDish("Vegetable Salad");
        }
        else if (plan instanceof VeganMeal) {
            meal.addDish("Tofu Stir Fry");
            meal.addDish("Quinoa Bowl");
        }
        else if (plan instanceof KetoMeal) {
            meal.addDish("Grilled Chicken");
            meal.addDish("Avocado Salad");
        }
        else if (plan instanceof HighProteinMeal) {
            meal.addDish("Boiled Eggs");
            meal.addDish("Lentil Soup");
        }

        return meal;
    }
}

public class MealPlanGenerator {

    // Entry point of the meal plan generator system
    public static void main(String[] args) {

        // Creating different meal plans
        VegetarianMeal vegetarian = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();

        // Generate meals dynamically using generic method
        Meal<VegetarianMeal> vegMeal =
                MealGenerator.generateMealPlan(vegetarian);

        Meal<VeganMeal> veganMeal =
                MealGenerator.generateMealPlan(vegan);

        Meal<KetoMeal> ketoMeal =
                MealGenerator.generateMealPlan(keto);

        // Display generated meals
        vegMeal.displayMeal();
        veganMeal.displayMeal();
        ketoMeal.displayMeal();
    }
}
