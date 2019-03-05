package luxiang.top.design_pattern.proxy_pattern.dynamic_proxy_cglib;

public class Engineer {
    public void eat() {
        System.out.println("吃饭");
    }

    public final void work() {
        System.out.println("工作");
    }

    private void paly() {
        System.out.println("玩");
    }
}
