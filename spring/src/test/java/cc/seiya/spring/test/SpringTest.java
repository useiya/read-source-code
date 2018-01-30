package cc.seiya.spring.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: libo
 * @date: 2018/1/30 14:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:bean.xml"})
public class SpringTest {

}
