package cc.seiya.spring.annotation.tx;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(String username,Integer age){
		String sql = "INSERT INTO `tb_user`(name,age) VALUES(?,?)";
		jdbcTemplate.update(sql, username,age);
	}
}
