package kr.or.kosta.order;

import java.util.List;

public interface IOrderDAO {

	void insertOrder(Order order);

	Order selectOrder(int ordernum);

	List<Order> selectOrderList(String memberid);

}
