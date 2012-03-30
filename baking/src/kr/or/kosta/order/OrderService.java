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
		if("viewOrderList".equals(method)){			//아이디를 이용한 주문리스트 조회
			viewOrderList(request,response);
		}else if("viewOrder".equals(method)){		//주문조회
			viewOrder(request,response);
		}else if("addOrder".equals(method)){		//주문하기
			addOrder(request,response);
		}else if("addOrderForm".equals(method)){	//주문하기폼
			addOrderForm(request,response);
		}else if("removeOrder".equals(method)){		//주문삭제
			removeOrder(request,response);
		}else if("editOrder".equals(method)){		//주문수정
			editOrder(request,response);
		}else if("editOrderForm".equals(method)){	//주문수정폼
			editOrderForm(request,response);
		}
	}

	//아이디를 이용한 주문리스트 조회
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

	//주문확인
	public void viewOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		//클릭한 주문 번호
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		//번호가 일치하는 데이터 조회
		Order order=OrderDAO.selectOrder(orderNum);
		//request에 주문정보저장
		request.setAttribute("ORDER",order);
		//이동 객체 생성
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewOrder.jsp");
		rd.forward(request, response);
	}

	/**
	 * 주문확인폼
	 * 
	 * @param request
	 * @param response
	 */
//	public void viewOrderForm(HttpServletRequest request,
//			HttpServletResponse response) throws IOException, ServletException{
		/* default generated stub */;
//		return null;
//	}

	//주문하기
	public void addOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		//HttpSession 객체 리턴
		//HttpSession session=request.getSession();
		//로그인 정보 입력
		//Member member=(Member)session.getAttribute("LOGIN");
		//로그인 안한상태
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
	 * 주문하기폼
	 * 
	 * @param request
	 * @param response
	 */
	public void addOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher rd=request.getRequestDispatcher("/order/addOrder.jsp");
		rd.forward(request, response);
	}

	//주문 삭제
	public void removeOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//삭제할 주문 번호
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		//주문 삭제
		OrderDAO.deleteOrder(orderNum);
		//주문리스트페이지 이동
		RequestDispatcher rd=request.getRequestDispatcher("OrderService?method=viewOrderList");
		rd.forward(request, response);
	}

	/**
	 * 주문삭제폼
	 * 
	 * @param request
	 * @param response
	 */
//	public void removeOrderForm(HttpServletRequest request,
//			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
//	}
	
	//주문수정
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
	
	//주문수정폼
	public void editOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		Order order=OrderDAO.selectOrder(orderNum);
		request.setAttribute("ORDER",order);
		RequestDispatcher rd=request.getRequestDispatcher("/order/editOrder.jsp");
		rd.forward(request, response);
	}
}
