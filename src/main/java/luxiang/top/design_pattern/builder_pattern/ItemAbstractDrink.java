package luxiang.top.design_pattern.builder_pattern;

public abstract class ItemAbstractDrink implements Item{
    @Override
    public Package packing() {
        return new PackageBottle();
    }
}
