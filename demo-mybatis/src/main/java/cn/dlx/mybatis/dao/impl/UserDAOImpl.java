package cn.dlx.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.dlx.mybatis.dao.UserDAO;
import cn.dlx.mybatis.pojo.User;

public class UserDAOImpl implements UserDAO {

	private SqlSession sqlSession;

	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public User queryUserById(Integer id) {

		return this.sqlSession.selectOne("UserMapper.queryUserById", id);
	}

	@Override
	public List<User> queryUserAll() {

		return this.sqlSession.selectList("UserMapper.queryUserAll");
	}

	@Override
	public void insertUser(User user) {
		this.sqlSession.insert("UserMapper.insertUser", user);
		this.sqlSession.commit();
	}

	@Override
	public void updateUser(User user) {
		this.sqlSession.update("UserMapper.updateUser", user);
		this.sqlSession.commit();
	}

	@Override
	public void deleteUserById(Integer id) {
		this.sqlSession.delete("UserMapper.deleteUserById", id);
		this.sqlSession.commit();
	}

}
