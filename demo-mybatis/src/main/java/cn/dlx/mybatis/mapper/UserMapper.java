package cn.dlx.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dlx.mybatis.pojo.User;

public interface UserMapper {

	/**
	 * 根据id获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(Long id);

	/**
	 * 根据多个id查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<User> queryUserByIds(@Param("ids") Long[] ids);

	/**
	 * @Title: loginMap
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param map
	 * @param: @return
	 * @return: User
	 * @throws
	 */
	public User loginMap(Map<String, Object> map);

	/**
	 * @Title: queryUserByUserName
	 * @Description: 查询男性用户，如果输入了用户名，按用户名模糊查询
	 * @param: @param userName
	 * @param: @return
	 * @return: User
	 * @throws
	 */
	public List<User> queryUserByUserName(@Param("userName") String userName);

	/**
	 *
	 * @Description:查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
	 * @param userName
	 * @return
	 *         List<User>
	 * @throws
	 */
	public List<User> queryUserByUserNameOrAge(@Param("userName") String userName, @Param("age") Integer age);

	/**
	 *
	 * @Description:查询所有用户，如果输入了用户名按照用户名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立
	 * @param userName
	 * @param age
	 * @return
	 *         List<User>
	 * @throws
	 */
	public List<User> queryUserByUserNameAndAge(@Param("userName") String userName, @Param("age") Integer age);

	/**
	 * @Title: login
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param userName
	 * @param: @param password
	 * @param: @return
	 * @return: User
	 * @throws
	 */
	public User login(@Param("userName") String userName, @Param("password") String password);

	/**
	 * @Title: queryUserByTableName
	 * @Description: 通过表名查询用户
	 * @param: @param tableName
	 * @param: @return
	 * @return: List<User>
	 * @throws
	 */
	public List<User> queryUserByTableName(@Param("tableName") String tableName);

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
	public void deleteUserById(Long id);

}
