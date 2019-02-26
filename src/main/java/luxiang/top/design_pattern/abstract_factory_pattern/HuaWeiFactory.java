package luxiang.top.design_pattern.abstract_factory_pattern;

/**
 * 华为工厂
 */
public class HuaWeiFactory extends AbstractFactory {

    @Override
    public HeadSet createHeadSet() {
        return new HeadSetHuaWei();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new KeyBoardHuaWei();
    }

    @Override
    public Mouse createMouse() {
        return new MouseHuaWei();
    }
}
