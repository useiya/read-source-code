package cc.seiya.spring.annotation.tx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userDao;

    @Transactional(rollbackFor = Exception.class)
    public void insertUser(String name, int age) {
        userDao.insert(name, age);
        log.debug("insert user success");
		int i = 10/0;
    }

}
