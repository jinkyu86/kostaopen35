package kr.or.kosta.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.member.Member;
import kr.or.kosta.member.MemberDAO;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;

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
		}else if("viewOrder".equals(method)){		//상세주문조회
			viewOrder(request,response);
		}else if("addOrder".equals(method)){		//주문하기
			addOrder(request,response);
		}else if("addOrderForm".equals(method)){	//주문하기
			addOrderForm(request,response);
		}else if("removeCart".equals(method)){		//장바구니 삭제
			removeCart(request,response);
		}else if("editCart".equals(method)){		//장바구니 수정
			editCart(request,response);
		}else if("viewCartList".equals(method)){	//장바구니
			viewCartList(request,response);
		}else if("CartList".equals(method)){		//장바구니
			CartList(request,response);
		}
	}

	private void CartList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewCartList.jsp");
		rd.forward(request, response);
	}

	private void viewCartList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
	
		int goodnum=Integer.parseInt(request.getParameter("goodNum"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		
		Good good=GoodDAO.selectGood(goodnum);
		
		Order order=new Order();
		order.setGood(good);
		order.setQty(qty);
		HttpSession session=request.getSession();
		ArrayList<Order>cartList=null;
		int putedBuyIndex=-1;
		if(session.getAttribute("CART_LIST")==null){
			cartList=new ArrayList<Order>();
		}else{
			cartList=(ArrayList)session.getAttribute("CART_LIST");
			for(int i=0; i<cartList.size(); i++){
				Order putedBuy=cartList.get(i);
				if(putedBuy.getGood().getGoodNum()==goodnum){
					putedBuyIndex=i;
					break;
				}
			}
		}
		if(putedBuyIndex==-1){
			cartList.add(order);
		}else{
			Order putedBuy=cartList.get(putedBuyIndex);
			putedBuy.setQty(putedBuy.getQty()+qty);
			cartList.set(putedBuyIndex, putedBuy);
		}
		session.setAttribute("CART_LIST",cartList);
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewCartList.jsp");
		rd.forward(request, response);
	}

	//아이디를 이용한 주문리스트 조회
	public void viewOrderList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN");
		String memberid=member.getMemberid();
		List<Order>orderList=OrderDAO.selectOrderList(memberid);
		request.setAttribute("ORDER_LIST",orderList);
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewOrderList.jsp");
		rd.forward(request, response);
	}

	//주문확인
	public void viewOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		Order order=OrderDAO.selectOrder(orderNum);
		request.setAttribute("ORDER",order);
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewOrder.jsp");
		rd.forward(request, response);
	}

	//주문하기
	public void addOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN");
		
		ArrayList<Order>cartList=(ArrayList)session.getAttribute("CART_LIST");
		for(int i=0; i<cartList.size(); i++){
			Order order=cartList.get(i);
			order.setMember(member);
			Good good=GoodDAO.selectGood(order.getGood().getGoodNum());
			good.setQty(good.getQty()-order.getQty());
			GoodDAO.updateGood(good);
			OrderDAO.insertOrder(order);
		}
		session.removeAttribute("CART_LIST");
		RequestDispatcher rd=request.getRequestDispatcher("/OrderService?method=viewOrderList");
		rd.forward(request, response);
	}

	//주문하기
	public void addOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN");
		
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=loginForm");
			rd.forward(request, response);
			return;
		}
		
		Member member1=MemberDAO.selsctMember(member.getMemberid());
		request.setAttribute("MEMBER",member1);
		RequestDispatcher rd=request.getRequestDispatcher("order/addOrder.jsp");
		rd.forward(request, response);
	}

	//장바구니 삭제
	public void removeCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		
		int index=Integer.parseInt(request.getParameter("index"));
		HttpSession session=request.getSession();
		ArrayList<Order>orderList=(ArrayList)session.getAttribute("CART_LIST");
		Order order=orderList.get(index);
		if(order.getQty()==1){
			orderList.remove(index);
		}else{
			int qty=order.getQty();
			order.setQty(qty-1);
			orderList.set(index,order);
		}
		session.setAttribute("CART_LIST",orderList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewCartList.jsp");
		rd.forward(request, response);
	}
	
	//장바구니수정
	public void editCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int index=Integer.parseInt(request.getParameter("index"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		HttpSession session=request.getSession();
		ArrayList<Order>cartList=(ArrayList)session.getAttribute("CART_LIST");
		Order order=cartList.get(index);
		order.setQty(qty);
		cartList.set(index, order);
		session.setAttribute("CART_LIST",cartList);
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewCartList.jsp");
		rd.forward(request, response);
	}
}
