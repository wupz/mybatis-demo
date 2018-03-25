package wu.mapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import wu.model.User;

/**
 *作者：Wu
 *日期：2018-3-25
 **/
public class TestUserMapper {
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	@Test
	public void testSelectUser() throws IOException {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User user = userMapper.selectUser(1);
			System.out.println(user.getEmail());
		} finally {
		  session.close();
		}
	}
	
	@Test
	public void testSelectAllUser() throws IOException {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			List<User> userList = userMapper.selectAllUser();
			for(User user : userList) {
				System.out.println(user.getEmail());
			}
		} finally {
		  session.close();
		}
	}
}
