package cc.seiya.spring;

import cc.seiya.spring.service.SayService;
import cc.seiya.spring.service.SpringSimpleMultiBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: libo
 * @date: 2018/1/26 17:26
 */
public class SpringApplicationMain {

    public static void main(String[] args) {

        // 基于xml配置
//        xmlApplication();

        // 基于注解
        annotationAppliction();
    }

    private static void xmlApplication() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        SpringSimpleMultiBean springSimpleMultiBean = ctx.getBean(SpringSimpleMultiBean.class);
        SayService sayService = ctx.getBean(SayService.class);
        springSimpleMultiBean.say();
    }

    private  static void annotationAppliction(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("cc.seiya.spring.service");
        SpringSimpleMultiBean springSimpleMultiBean = ctx.getBean(SpringSimpleMultiBean.class);
        SayService sayService = ctx.getBean(SayService.class);
        springSimpleMultiBean.say();
    }

}
