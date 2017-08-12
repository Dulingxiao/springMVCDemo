package cn.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			// 加载驱动
			/* Class.forName("com.mysql.jdbc.Driver"); */
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接

			// 获取连接
			String url = "jdbc:mysql://127.0.0.1:3306/demo";
			String user = "root";
			String passwrod = "123456";
			Connection connection = DriverManager.getConnection(url, user, passwrod);
			// 获取statement preparedStatement
			String sql = "select * from user where id = ?";
			// 设置参数
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, 1);
			// 查询结果集
			ResultSet resultSet = prepareStatement.executeQuery();
			// 处理结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("age"));
				System.out.println(resultSet.getString("id"));
			}
			resultSet.close();
			prepareStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
