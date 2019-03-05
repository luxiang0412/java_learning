package luxiang.top.design_pattern.proxy_pattern.dynamic_proxy;

public class RealSubject implements Subject {
    @Override
    public void speak() {
        System.out.println("realSubject speak");
    }

    @Override
    public void draw(String str) {
        System.out.println("realSubject draw " + str);
    }
}
