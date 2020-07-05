package cc.seiya.spring.annotation.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

@Configuration  //告诉Spring这是一个配置类, 配置类==配置文件
@PropertySource(value = "classpath:/person.properties")
//@ComponentScans(
//        value = {
//                @ComponentScan(value = "cc.seiya.spring", includeFilters = {
//						/*@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
//						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
//                        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//                }, useDefaultFilters = false)
//        }
//)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
@Slf4j
public class BeanConfig {

    public BeanConfig() {
        log.info("MainConfig 无参构建器");
    }

    /**
     * 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
     */
    @Bean("person")
    public Person person() {
        return new Person("lisi", 20);
    }

}
