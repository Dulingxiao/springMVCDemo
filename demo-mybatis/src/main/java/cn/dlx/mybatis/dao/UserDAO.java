package cn.dlx.mybatis.dao;

import java.util.List;

import cn.dlx.mybatis.pojo.User;

public interface UserDAO {

	/**
	 * 根据id获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(Integer id);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> queryUserAll();

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 根据id删除用户信息
	 * 
	 * @param id
	 */
	public void deleteUserById(Integer id);

}
