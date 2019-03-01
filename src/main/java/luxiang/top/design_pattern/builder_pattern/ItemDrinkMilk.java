package luxiang.top.design_pattern.builder_pattern;

public class ItemDrinkMilk extends ItemAbstractDrink{
    @Override
    public Double getPrice() {
        return 4d;
    }

    @Override
    public String name() {
        return "牛奶";
    }
}
