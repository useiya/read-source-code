package cc.seiya.spring.test;

import cc.seiya.spring.aop.proxy.CglibProxy;
import cc.seiya.spring.aop.proxy.JdkTaobaoProxy;
import cc.seiya.spring.aop.proxy.OnlineShop;
import cc.seiya.spring.aop.proxy.TeaOnlineShop;
import cc.seiya.spring.aop.proxy.WineOnlineShop;
import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 * @author: libo
 * @date: 2018/1/29 15:20
 */
public class DynamicProxyTest {

    @Test
    public void jdkDynamicProxyTest() {
        TeaOnlineShop teaShop = new TeaOnlineShop();
        OnlineShop o = (OnlineShop) Proxy
                .newProxyInstance(OnlineShop.class.getClassLoader(), new Class[]{OnlineShop.class},
                        new JdkTaobaoProxy(teaShop));
        o.sell(100);
    }

    @Test
    public void cglibDynamicProxyTest(){
        CglibProxy cglibTaobaoProxy = new CglibProxy();
        WineOnlineShop wineOnlineShop = cglibTaobaoProxy.getProxy(WineOnlineShop.class);
        wineOnlineShop.sell(10);
    }
}
