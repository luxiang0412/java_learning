package luxiang.top.design_pattern.proxy_pattern.dynamic_proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        MyInvocationHander myInvocationHander = new MyInvocationHander(subject);

        Subject proxyInstance = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHander);
        proxyInstance.draw("proxy");
        proxyInstance.speak();
    }
}
