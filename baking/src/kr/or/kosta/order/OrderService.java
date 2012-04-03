package kr.or.kosta.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mock.web.MockHttpServletRequest;

import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.member.Member;

public class OrderService extends HttpServlet {
	
	public OrderService(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		
		if(method==null){
			//method="addOrder";
			method="viewOrderList";
		}
		if("viewOrderList".equals(method)){			//���̵� �̿��� �ֹ�����Ʈ ��ȸ
			viewOrderList(request,response);
		}else if("viewOrder".equals(method)){		//�ֹ���ȸ
			viewOrder(request,response);
		}else if("addOrder".equals(method)){		//�ֹ��ϱ�
			addOrder(request,response);
		}else if("addOrderForm".equals(method)){	//�ֹ��ϱ���
			addOrderForm(request,response);
		}else if("removeOrder".equals(method)){		//�ֹ�����
			removeOrder(request,response);
		}else if("editOrder".equals(method)){		//��ٱ��ϼ���
			editOrder(request,response);
		}else if("editOrderForm".equals(method)){	//��ٱ��ϼ�����
			editOrderForm(request,response);
		}
	}

	//���̵� �̿��� �ֹ�����Ʈ ��ȸ
	public void viewOrderList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		Member member1=new Member();
		member1.setMemberid("yubi");
		HttpSession session1=request.getSession();
		session1.setAttribute("LOGIN",member1);
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN");
		String memberid=member.getMemberid();
		ArrayList<Order>orderList=OrderDAO.selectOrderList(memberid);
		request.setAttribute("ORDER_LIST",orderList);
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewOrderList.jsp");
		rd.forward(request, response);
	}

	//�ֹ�Ȯ��
	public void viewOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		//Ŭ���� �ֹ� ��ȣ
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		//��ȣ�� ��ġ�ϴ� ������ ��ȸ
		Order order=OrderDAO.selectOrder(orderNum);
		//request�� �ֹ���������
		request.setAttribute("ORDER",order);
		//�̵� ��ü ����
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewOrder.jsp");
		rd.forward(request, response);
	}

	/**
	 * �ֹ�Ȯ����
	 * 
	 * @param request
	 * @param response
	 */
//	public void viewOrderForm(HttpServletRequest request,
//			HttpServletResponse response) throws IOException, ServletException{
		/* default generated stub */;
//		return null;
//	}

	//�ֹ��ϱ�
	public void addOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		int goodNum=Integer.parseInt(request.getParameter("goodNum"));
		String img=request.getParameter("img");
		String name=request.getParameter("name");
		int qty=Integer.parseInt(request.getParameter("qty"));
		int price=Integer.parseInt(request.getParameter("price"));
		String option=request.getParameter("option");
		String explantion=request.getParameter("explantion");
		
		Good good=new Good();
		good.setGoodNum(goodNum);
		good.setImg(img);
		good.setName(name);
		Order order=new Order();
		order.setQty(qty);
		order.setPrice(price);
		good.setOption(option);
		good.setExplantion(explantion);
		order.setGood(good);
		OrderDAO.insertOrder(order);
		
		RequestDispatcher rd=request.getRequestDispatcher("/OrderService?method=viewOrderList");
		rd.forward(request, response);
	}

	/**
	 * �ֹ��ϱ���
	 * 
	 * @param request
	 * @param response
	 */
	public void addOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher rd=request.getRequestDispatcher("/order/addOrder.jsp");
		rd.forward(request, response);
	}

	//�ֹ� ����
	public void removeOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		Member member1=new Member();
		member1.setMemberid("yubi");
		HttpSession session1=request.getSession();
		session1.setAttribute("LOGIN",member1);
		
		int index=Integer.parseInt(request.getParameter("index"));
		HttpSession session=request.getSession();
		ArrayList<Order>orderList=(ArrayList)session.getAttribute("ORDER_LIST");
		Order order=orderList.get(index);
		if(order.getQty()==1){
			orderList.remove(index);
		}else{
			int qty=order.getQty();
			order.setQty(qty-1);
			orderList.set(index,order);
		}
		session.setAttribute("ORDER_LIST",orderList);
		
		RequestDispatcher rd=request.getRequestDispatcher("order/viewOrderList.jsp");
		rd.forward(request, response);
	}

	/**
	 * �ֹ�������
	 * 
	 * @param request
	 * @param response
	 */
//	public void removeOrderForm(HttpServletRequest request,
//			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
//	}
	
	//��ٱ��ϼ���
	public void editOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		String goodnum=request.getParameter("goodNum");
		String qty=request.getParameter("qty");
		Good good=GoodDAO.selectGood(Integer.parseInt(goodnum));
		Order order=new Order();
		order.setGood(good);
		order.setQty(Integer.parseInt(qty));
		
		HttpSession session=request.getSession();
		ArrayList<Order>orderList=null;
		int putedOrderIndex=-1;
		if(session.getAttribute("CART_LIST")==null){
			orderList=new ArrayList<Order>();
		}else{
			orderList=(ArrayList)session.getAttribute("CART_LIST");
			//cartList�� ��ٱ��Ͽ� ���� ���� ��ȣ num��
			//��ġ�ϴ� ������ �̹� ����ִ°�?
			for(int i=0;i<orderList.size();i++){
				Order putedOrder=orderList.get(i);
				if(putedOrder.getGood().getGoodNum()==Integer.parseInt(goodnum)){
					putedOrderIndex=i;
					break;
				}
			}
		}
		if(putedOrderIndex==-1){
			orderList.add(order);
		}else{
			Order putedOrder=orderList.get(putedOrderIndex);
			putedOrder.setQty(putedOrder.getQty()+Integer.parseInt(qty));
			orderList.set(putedOrderIndex, putedOrder);
		}
		session.setAttribute("ORDER_LIST",orderList);
		RequestDispatcher rd=request.getRequestDispatcher("/order/editOrder.jsp");
		rd.forward(request, response);
	}
	
	//��ٱ��ϼ�����
	public void editOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		Order order=OrderDAO.selectOrder(orderNum);
		request.setAttribute("ORDER_LIST",order);
		RequestDispatcher rd=request.getRequestDispatcher("/order/editOrder.jsp");
		rd.forward(request, response);
	}
}
