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
		}else if("editOrder".equals(method)){		//�ֹ�����
			editOrder(request,response);
		}else if("editOrderForm".equals(method)){	//�ֹ�������
			editOrderForm(request,response);
		}
	}

	//���̵� �̿��� �ֹ�����Ʈ ��ȸ
	public void viewOrderList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
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
		//HttpSession ��ü ����
		//HttpSession session=request.getSession();
		//�α��� ���� �Է�
		//Member member=(Member)session.getAttribute("LOGIN");
		//�α��� ���ѻ���
		//if(member==null){
//			RequestDispatcher rd=request.getRequestDispatcher("");
//			rd.forward(request, response);
//			return;
//		}
//		ArrayList<Order>cartList=(ArrayList)session.getAttribute("CART");
//		for(int i=0;i<cartList.size();i++){
//			Order order=cartList.get(i);
//			order.setMember(member);
//			OrderDAO.insertOrder(order);
//		}
		String memberid=request.getParameter("memberid");
		int goodNum=Integer.parseInt(request.getParameter("goodNum"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		int price=Integer.parseInt(request.getParameter("price"));
		
		Order order=new Order();
		order.setMemberid(memberid);
		order.setGoodNum(goodNum);
		order.setQty(qty);
		order.setPrice(price);
		
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
		//������ �ֹ� ��ȣ
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		//�ֹ� ����
		OrderDAO.deleteOrder(orderNum);
		//�ֹ�����Ʈ������ �̵�
		RequestDispatcher rd=request.getRequestDispatcher("OrderService?method=viewOrderList");
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
	
	//�ֹ�����
	public void editOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		String name=request.getParameter("name");
		String zipcode=request.getParameter("zipcode");
		String address=request.getParameter("address");
		String strAddress=request.getParameter("strAddress");
		String phoneNumber=request.getParameter("phoneNumber");
		String telNumber=request.getParameter("telNumber");
		int qty=Integer.parseInt(request.getParameter("qty"));
		int price=Integer.parseInt("price");
		int orderNum=Integer.parseInt("orderNum");
		
		Member member=new Member();
		member.setName(name);
		member.setZipcode(zipcode);
		member.setAddress(address);
		member.setStrAddress(strAddress);
		member.setPhoneNumber(phoneNumber);
		member.setTelNumber(telNumber);
		
		Order order=new Order();
		order.setQty(qty);
		order.setPrice(price);
		
		order.setMember(member);
		
		OrderDAO.updateOrder(order);
		RequestDispatcher rd=request.getRequestDispatcher("OrderService?method=viewOrder&orderNum="+orderNum);
		rd.forward(request, response);
	}
	
	//�ֹ�������
	public void editOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		Order order=OrderDAO.selectOrder(orderNum);
		request.setAttribute("ORDER",order);
		RequestDispatcher rd=request.getRequestDispatcher("/order/editOrder.jsp");
		rd.forward(request, response);
	}
}
