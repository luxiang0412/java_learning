package luxiang.top.base;

public class ClassInitParent {

    static {
        System.out.println("父类static初始化");
    }
    {
        System.out.println("父类初始化块");
    }

    public ClassInitParent(){
        super();
        System.out.println("父类构造方法初始化");
    }
}
