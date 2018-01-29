package cc.seiya.spring;

import cc.seiya.spring.service.SayService;
import cc.seiya.spring.service.SpringSimpleMultiBean;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: libo
 * @date: 2018/1/26 17:26
 */
public class SpringApplicationMain {

    public static void main(String[] args) {
        xmlApplication();
    }

    private static void xmlApplication(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        SpringSimpleMultiBean springSimpleMultiBean = ctx.getBean(SpringSimpleMultiBean.class);
//        SayService sayService = ctx.getBean(SayService.class);
        springSimpleMultiBean.say();
    }
}
