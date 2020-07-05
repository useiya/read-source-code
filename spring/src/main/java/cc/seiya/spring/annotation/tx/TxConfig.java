package cc.seiya.spring.annotation.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;
import java.lang.reflect.Method;

/**
 * 声明式事务
 * <p>
 * 环境搭建：
 * 1.导入 数据库驱动(mysql)、datasource(druid)、spring-jdbc模块;
 * <p>
 * 2、配置数据源、JdbcTemplate {@link org.springframework.jdbc.core.JdbcTemplate}（Spring提供的简化数据库操作的工具）;
 * <p>
 * 3.方法上添加 @Transactional  {@link org.springframework.transaction.annotation.Transactional} 注解, 表示当前方法是事务方法；
 * <p>
 * 4.配置类上添加 @EnableTransactionManagement {@link org.springframework.transaction.annotation.EnableTransactionManagement}注解，表示开启基于注解的事务支持；
 * <p>
 * 5.配置事务管理器 {@link org.springframework.transaction.PlatformTransactionManager} ,
 * 实例化 @{link {@link org.springframework.jdbc.datasource.DataSourceTransactionManager};
 * <p>
 * <p>
 * 事务原理：
 * 注解 {@link EnableTransactionManagement} 导入
 * {@link org.springframework.transaction.annotation.TransactionManagementConfigurationSelector}
 * TransactionManagementConfigurationSelector解析: 根据 AdviceMode 初始化组件,AdviceMode 通过注解 {@link EnableTransactionManagement#mode()}指定 默认为 PROXY:
 * 1.   PROXY
 * 初始化组件：
 * {@link org.springframework.context.annotation.AutoProxyRegistrar}
 * {@link org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration}
 * 1）AutoProxyRegistrar
 * 1.1）核心方法：AopConfigUtils.registerAutoProxyCreatorIfNecessary(registry);
 * 1.2）向容器中注册 InfrastructureAdvisorAutoProxyCreator 组件，它是一个后置处理器，
 * 1.3）利用后置处理器机制包装对象并返回一个代理对象，代理对象执行方法利用拦截器链进行调用；
 * 2）ProxyTransactionManagementConfiguration
 * ProxyTransactionManagementConfiguration是配置类，初始化一批与事务相关的bean
 * 2.1）{@link ProxyTransactionManagementConfiguration#transactionAdvisor()}
 * 创建生成事务属性增强器{@link org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor},包装事务注解解析器、事务拦截器
 * <p>
 * 2.2）{@link ProxyTransactionManagementConfiguration#transactionAttributeSource()}
 * 创建事务注解属性增强器{@link org.springframework.transaction.annotation.AnnotationTransactionAttributeSource}，事务注解解析器(SpringTransactionAnnotationParser)
 * 解析 {@link org.springframework.transaction.annotation.Transactional}注解,
 * 核心方法:{@link org.springframework.transaction.annotation.SpringTransactionAnnotationParser#parseTransactionAnnotation(AnnotationAttributes)}
 * <p>
 * 2.3）{@link ProxyTransactionManagementConfiguration#transactionInterceptor()}
 * 创建事务拦截器{@link org.springframework.transaction.interceptor.TransactionInterceptor} 并注入事务管理器,它是一个 MethodInterceptor
 * 在目标方法执行的时候会执行拦截器链和事务拦截器（AOP 原理）,{@link org.springframework.transaction.interceptor.TransactionInterceptor#invoke}
 * 执行事务拦截器 即调用 {@link org.springframework.transaction.interceptor.TransactionInterceptor#invokeWithinTransaction}方法：
 * 1）、获取事务相关的属性;
 * 2）、获取事务管理器 PlatformTransactionManager，若没有指定任何 transactionmanger 则从容器中按照类型获取PlatformTransactionManager；
 * 3）、执行目标方法，invocation.proceedWithInvocation()
 * 如果异常，利用事务管理回滚事务 {@link org.springframework.transaction.interceptor.TransactionAspectSupport#completeTransactionAfterThrowing};
 * 如果正常，利用事务管理器提交事务 {@link org.springframework.transaction.interceptor.TransactionAspectSupport#commitTransactionAfterReturning};
 * 不管事务执行结果如何将事务重新放到ThreadLocal中 {@link TransactionAspectSupport#cleanupTransactionInfo};
 * 2.   ASPECTJ
 *
 * @author libo
 * @since 2020/7/4
 */
@Configuration
@ComponentScan(basePackages = {"cc.seiya.spring.annotation.tx"})
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class TxConfig {

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
