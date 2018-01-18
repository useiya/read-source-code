package cc.seiya;

import cc.seiya.domain.Bank;
import cc.seiya.mapper.BankMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author: libo
 * @date: 2018/1/18 17:37
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        BankMapper bankMapper = session.getMapper(BankMapper.class);
        Bank bank = bankMapper.queryById(4123);
        System.out.println(bank);
    }
}
