package cn.dlx.mybatis.mapper;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.dlx.mybatis.pojo.Order;

@SuppressWarnings("all")
public class OrderMapperTest {

	private OrderMapper OrderMapper;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream, "test");
		SqlSession session = build.openSession();
		this.OrderMapper = session.getMapper(OrderMapper.class);

	}

	@Test
	public void queryOrderWithUserByOrderId() {
		Order order = this.OrderMapper.queryOrderWithUserByOrderId(1);
		System.out.println(order);
	}

	@Test
	public void queryOrderWithUserAndOrderDetailByOrderId() {
		Order order = this.OrderMapper.queryOrderWithUserAndOrderDetailByOrderId(1);
		System.out.println(order);
	}

	@Test
	public void queryOrderWithUserAndOrderDetailWithItemByOrderId() {
		Order order = this.OrderMapper.queryOrderWithUserAndOrderDetailWithItemByOrderId(1);
		System.out.println(order);
	}

	@Test
	public void queryOrderByLazy() {
		Order order = this.OrderMapper.queryOrderByLazy("20140921001");
		System.out.println(order.getId());
		System.out.println(order.getUser());
	}

}
