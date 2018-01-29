package cc.seiya.spring.aop.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author: libo
 * @date: 2018/1/29 15:24
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public <T> T getProxy(Class<T> clazz){
        // 用enhancer 重新编制传入的class的对象
        enhancer.setSuperclass(clazz);
        // 回调实现CallBack接口的类（MethodInterceptor基础于CallBack）此处就是回调TaobaoProxy
        enhancer.setCallback(this);
        return (T)enhancer.create();

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("CglibTaobao Proxy say: " + args[0]);

        Object result = methodProxy.invokeSuper(obj, args);
        return result;
    }
}
