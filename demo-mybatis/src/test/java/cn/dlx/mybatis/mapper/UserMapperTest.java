package cn.dlx.mybatis.mapper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.dlx.mybatis.pojo.User;

@SuppressWarnings("all")
public class UserMapperTest {

	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream, "test");
		SqlSession session = build.openSession();
		this.userMapper = session.getMapper(UserMapper.class);

	}

	@Test
	public void testQueryUserById() {
		User user = this.userMapper.queryUserById(1l);
		System.out.println(user);
	}

	@Test
	public void testQueryUserByIds() {
		List<User> user = this.userMapper.queryUserByIds(new Long[] { 1l, 2l, 3l });
		for (User user2 : user) {
			System.out.println(user2);
		}
	}

	@Test
	public void queryUserByUserName() {
		List<User> user = this.userMapper.queryUserByUserName("  ");
		for (User user2 : user) {
			System.out.println(user2);
		}

	}

	@Test
	public void queryUserByUserNameOrAge() {
		List<User> user = this.userMapper.queryUserByUserNameOrAge(null, 30);
		for (User user2 : user) {
			System.out.println(user2);
		}

	}

	@Test
	public void queryUserByUserNameAndAge() {
		List<User> user = this.userMapper.queryUserByUserNameAndAge(null, 30);
		for (User user2 : user) {
			System.out.println(user2);
		}

	}

	@Test
	public void testQueryUserAll() {
		List<User> list = this.userMapper.queryUserAll();
		System.out.println(list.toString());
	}

	@Test
	public void login() {
		User login = this.userMapper.login("zhangsan", "123456");
		System.out.println(login);
	}

	@Test
	public void loginMap() {
		Map map = new HashMap();
		map.put("userName", "zhangsan");
		map.put("password", "123456");

		User login = this.userMapper.loginMap(map);
		System.out.println(login);

	}

	@Test
	public void queryUserByTableName() {

		List<User> list = this.userMapper.queryUserByTableName("tb_user");

		System.out.println(list.toString());
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setName("阿萨德");
		user.setAge(14);
		this.userMapper.insertUser(user);
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(2l);
		user.setPassword("123456");
		user.setUserName("yanyan2");
		this.userMapper.updateUser(user);
		System.out.println(user);
	}

	@Test
	public void testDeleteUserById() {
		this.userMapper.deleteUserById(2l);
	}

}
