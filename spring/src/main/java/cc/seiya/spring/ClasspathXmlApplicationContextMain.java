package cc.seiya.spring;

import cc.seiya.spring.service.SayService;
import cc.seiya.spring.service.SpringSimpleMultiBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: libo
 * @date: 2018/1/26 17:26
 */
public class ClasspathXmlApplicationContextMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        SpringSimpleMultiBean sayService = ctx.getBean(SpringSimpleMultiBean.class);
        sayService.say();
    }

}
