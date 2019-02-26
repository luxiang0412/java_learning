package luxiang.top.design_pattern.abstract_factory_pattern;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory huaweiFactory = new HuaWeiFactory();
        System.out.println(huaweiFactory.createHeadSet().printName());
        System.out.println(huaweiFactory.createKeyBoard().printName());
        System.out.println(huaweiFactory.createMouse().printName());
        //后来加的
        AbstractFactory xiaomiFactory = new XiaoMiFactory();
        System.out.println(xiaomiFactory.createHeadSet().printName());
        System.out.println(xiaomiFactory.createKeyBoard().printName());
        //后来加的
        System.out.println(xiaomiFactory.createMouse().printName());
    }
}
