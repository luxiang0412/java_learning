package luxiang.top.design_pattern.builder_pattern;

public abstract class ItemAbstractFood implements Item {
    @Override
    public Package packing() {
        return new PackageWarpper();
    }
}
