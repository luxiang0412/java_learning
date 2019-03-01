package luxiang.top.design_pattern.builder_pattern;

public class ItemDrinkCola extends ItemAbstractDrink {
    @Override
    public Double getPrice() {
        return 3d;
    }

    @Override
    public String name() {
        return "可乐";
    }
}
