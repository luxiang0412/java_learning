package luxiang.top.design_pattern.abstract_factory_pattern;

/**
 * 小米工厂
 */
public class XiaoMiFactory extends AbstractFactory {
    @Override
    public HeadSet createHeadSet() {
        return new HeadSetXiaoMi();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new KeyBoardXiaoMi();
    }

    @Override
    public Mouse createMouse() {
        return new MouseXiaoMi();
    }
}
