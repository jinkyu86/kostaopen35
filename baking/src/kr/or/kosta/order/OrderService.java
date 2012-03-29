package kr.or.kosta.order;

import java.io.IOException;
import java.util.ArrayList;

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
		}else if("viewOrder".equals(method)){		//�ֹ� ��ȸ
			viewOrder(request,response);
		}else if("addOrder".equals(method)){		//�ֹ��ϱ�
			addOrder(request,response);
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
		int ordernum=Integer.parseInt(request.getParameter("order_num"));
		//��ȣ�� ��ġ�ϴ� ������ ��ȸ
		Order order=OrderDAO.selectOrder(ordernum);
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
		HttpSession session=request.getSession();
		//�α��� ���� �Է�
		Member member=(Member)session.getAttribute("LOGIN");
		//�α��� ���ѻ���
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		ArrayList<Order>cartList=(ArrayList)session.getAttribute("CART");
		for(int i=0;i<cartList.size();i++){
			Order order=cartList.get(i);
			order.setMember(member);
			OrderDAO.insertOrder(order);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/OrderService?method=viewOrderList");
		rd.forward(request, response);
	}

	/**
	 * �ֹ��ϱ���
	 * 
	 * @param request
	 * @param response
	 */
//	public void addOrderForm(HttpServletRequest request,
//			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
//	}

	//�ֹ� ����
	public void removeOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//������ �ֹ� ��ȣ
		int ordernum=Integer.parseInt(request.getParameter("order_num"));
		//�ֹ� ����
		OrderDAO.deleteOrder(ordernum);
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
		String straddress=request.getParameter("straddress");
		String phonenumber=request.getParameter("phong_number");
		String telnumber=request.getParameter("tel_number");
		int qty=Integer.parseInt(request.getParameter("qty"));
		int price=Integer.parseInt("price");
		int ordernum=Integer.parseInt("order_num");
		
		Member member=new Member();
		member.setName(name);
		member.setZipcode(zipcode);
		member.setAddress(address);
		member.setStrAddress(straddress);
		member.setPhoneNumber(phonenumber);
		member.setTelNumber(telnumber);
		
		Order order=new Order();
		order.setQty(qty);
		order.setPrice(price);
		
		order.setMember(member);
		
		OrderDAO.updateOrder(order);
		RequestDispatcher rd=request.getRequestDispatcher("OrderService?method=viewOrder&order_num="+ordernum);
		rd.forward(request, response);
	}
	
	//�ֹ�������
	public void editOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int ordernum=Integer.parseInt(request.getParameter("order_num"));
		Order order=OrderDAO.selectOrder(ordernum);
		request.setAttribute("ORDER",order);
		RequestDispatcher rd=request.getRequestDispatcher("/order/editOrder.jsp");
		rd.forward(request, response);
	}
}
