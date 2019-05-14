package luxiang.top.base;

public class ClassInitChild extends ClassInitParent{
    static {
        System.out.println("子类static初始化");
    }
    {
        System.out.println("子类初始化块");
    }

    public ClassInitChild(){
        super();
        System.out.println("子类构造方法初始化");
    }

    public static void main(String[] args) {
        new ClassInitChild();
    }
}
