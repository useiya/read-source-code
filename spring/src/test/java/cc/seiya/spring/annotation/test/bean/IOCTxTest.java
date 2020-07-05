package cc.seiya.spring.annotation.test.bean;

import cc.seiya.spring.annotation.bean.BeanConfig;
import cc.seiya.spring.annotation.bean.Person;
import cc.seiya.spring.annotation.tx.TxConfig;
import cc.seiya.spring.annotation.tx.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

/**
 * tx test
 *
 * @author libo
 * @since 2020/7/4
 */
@Slf4j
public class IOCTxTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        String uuid = UUID.randomUUID().toString();
        userService.insertUser(uuid,30);
    }
}
