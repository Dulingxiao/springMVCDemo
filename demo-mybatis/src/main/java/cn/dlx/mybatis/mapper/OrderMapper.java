package cn.dlx.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import cn.dlx.mybatis.pojo.Order;

public interface OrderMapper {

	/**
	 *
	 * @Description:查询出订单信息，并查询出下单人信息
	 * @param id
	 * @return
	 *         Order
	 * @throws
	 */
	public Order queryOrderWithUserByOrderId(@Param("id") Integer id);

	/**
	 *
	 * @Description:查询订单，查询出下单人信息并且查询出订单详情。
	 * @param id
	 * @return
	 *         Order
	 * @throws
	 */
	public Order queryOrderWithUserAndOrderDetailByOrderId(@Param("id") Integer id);

	/**
	 *
	 * @Description:查询订单，查询出下单人信息并且查询出订单详情中的商品数据。
	 * @param id
	 * @return
	 *         Order
	 * @throws
	 */
	public Order queryOrderWithUserAndOrderDetailWithItemByOrderId(@Param("id") Integer id);

	/**
	 *
	 * @Description:懒加载
	 * @param id
	 * @return
	 *         Order
	 * @throws
	 */
	public Order queryOrderByLazy(@Param("number") String number);
}
