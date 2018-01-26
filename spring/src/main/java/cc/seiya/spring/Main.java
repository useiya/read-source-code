package cc.seiya.spring;

import cc.seiya.spring.service.SayService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: libo
 * @date: 2018/1/26 17:26
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        SayService sayService = ctx.getBean(SayService.class);
        sayService.say();
    }

}
