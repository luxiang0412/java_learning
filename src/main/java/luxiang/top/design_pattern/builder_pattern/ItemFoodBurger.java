package luxiang.top.design_pattern.builder_pattern;

public class ItemFoodBurger extends ItemAbstractFood{
    @Override
    public Double getPrice() {
        return 7d;
    }

    @Override
    public String name() {
        return "汉堡";
    }
}
