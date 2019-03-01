package luxiang.top.design_pattern.builder_pattern;

public class Test {
    public static void main(String[] args) {
        BuilderMeal builderMeal = new BuilderMeal();
        Meal packOne = builderMeal.getPackOne();
        packOne.showItem();
        System.out.println("价格：" + packOne.price());
        System.out.println();
        Meal packTwo = builderMeal.getPackTwo();
        packTwo.showItem();
        System.out.println("价格：" + packTwo.price());
    }
}
