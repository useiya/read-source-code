package cc.seiya.spring.aop.proxy;

/**
 * @author: libo
 * @date: 2018/1/29 15:16
 */
public class WineOnlineShop implements OnlineShop {

    @Override
    public void sell(double money) {
        System.out.println(this.getClass().getName() + " say: " + money);
    }
}
