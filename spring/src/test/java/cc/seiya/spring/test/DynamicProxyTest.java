package cc.seiya.spring.test;

import cc.seiya.spring.aop.proxy.JdkTaobaoProxy;
import cc.seiya.spring.aop.proxy.OnlineShop;
import cc.seiya.spring.aop.proxy.TeaOnlineShop;
import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 * @author: libo
 * @date: 2018/1/29 15:20
 */
public class JdkDynamicProxyTest {

    @Test
    public void doTest() {
        TeaOnlineShop teaShop = new TeaOnlineShop();
        OnlineShop o = (OnlineShop) Proxy
                .newProxyInstance(OnlineShop.class.getClassLoader(), new Class[]{OnlineShop.class},
                        new JdkTaobaoProxy(teaShop));
        o.sell(100);
    }
}
