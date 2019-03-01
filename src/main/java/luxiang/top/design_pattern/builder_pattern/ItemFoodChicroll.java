package luxiang.top.design_pattern.builder_pattern;

public class ItemFoodChicroll extends ItemAbstractFood{
    @Override
    public Double getPrice() {
        return 7d;
    }

    @Override
    public String name() {
        return "鸡肉卷";
    }
}
