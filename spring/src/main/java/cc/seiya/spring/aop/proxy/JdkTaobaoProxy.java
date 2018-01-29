package cc.seiya.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: libo
 * @date: 2018/1/29 15:18
 */
public class JdkTaobaoProxy implements InvocationHandler {

    private Object target;

    public JdkTaobaoProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JdkTaobaoProxy say: " + args[0]
                + "$ money temp save to taobao to increase my gmv");

        return method.invoke(target,args);
    }
}
