package cc.seiya.spring.annotation.test.bean;

import cc.seiya.spring.annotation.bean.BeanConfig;
import cc.seiya.spring.annotation.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean test
 *
 * @author libo
 * @since 2020/7/4
 */
@Slf4j
public class IOCBeanTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        log.error("{}", bean);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            log.error("namesForType==>{}", bean);
        }
    }
}
