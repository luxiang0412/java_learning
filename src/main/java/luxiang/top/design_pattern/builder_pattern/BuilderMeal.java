package luxiang.top.design_pattern.builder_pattern;

public class BuilderMeal {
    public Meal getPackOne(){
        Meal meal = new Meal();
        meal.add(new ItemDrinkCola());
        meal.add(new ItemFoodBurger());
        return meal;
    }

    public Meal getPackTwo(){
        Meal meal = new Meal();
        meal.add(new ItemDrinkMilk());
        meal.add(new ItemFoodChicroll());
        return meal;
    }
}
