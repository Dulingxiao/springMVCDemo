package cn.dlx.mybatis.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.dlx.mybatis.dao.impl.UserDAOImpl;
import cn.dlx.mybatis.pojo.User;

public class UserDAOTest {

	private UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		this.userDAO = new UserDAOImpl(session);
	}

	@Test
	public void testQueryUserById() {
		User user = this.userDAO.queryUserById(1);
		System.out.println(user);
	}

	@Test
	public void testQueryUserAll() {
		List<User> list = this.userDAO.queryUserAll();
		System.out.println(list.toString());
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setName("阿萨德");
		user.setAge(14);
		this.userDAO.insertUser(user);
	}

	@Test
	public void testUpdateUser() {
		User user = this.userDAO.queryUserById(2);
		user.setName("007");
		this.userDAO.updateUser(user);

	}

	@Test
	public void testDeleteUserById() {
		this.userDAO.deleteUserById(2);
	}

}
