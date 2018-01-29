package cc.seiya.spring.aop;


import org.aspectj.lang.JoinPoint;

/**
 * @author: libo
 * @date: 2018/1/29 14:40
 */
public class LoggerAspect {

    public void before(JoinPoint jp) {
        System.out.println(
                "Logger aspect, " + jp.getTarget().getClass().getName() + "." + jp.getSignature()
                        .getName());
    }
}
