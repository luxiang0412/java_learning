package luxiang.top.design_pattern.proxy_pattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHander implements InvocationHandler {

    private Subject subject;

    public MyInvocationHander(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (method.getName().equals("speak")) {
            method.invoke(subject, objects);
        } else if (method.getName().equals("draw")) {
            method.invoke(subject, objects);
        }
        return null;
    }
}
