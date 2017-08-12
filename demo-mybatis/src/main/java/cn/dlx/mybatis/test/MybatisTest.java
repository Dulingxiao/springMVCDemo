package cn.dlx.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.dlx.mybatis.pojo.User;

public class MybatisTest {
	public static void main(String[] args) throws IOException {
		SqlSession session = null;
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
			User selectOne = session.selectOne("UserMapper.queryUserById", 1);
			System.out.println(selectOne);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
