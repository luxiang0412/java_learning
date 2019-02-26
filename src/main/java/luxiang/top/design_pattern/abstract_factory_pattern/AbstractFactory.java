package luxiang.top.design_pattern.abstract_factory_pattern;

public abstract class AbstractFactory {

    public abstract HeadSet createHeadSet();

    public abstract KeyBoard createKeyBoard();

    //后来加的
    public abstract Mouse createMouse();
}
