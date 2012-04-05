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
		}else if("viewOrder".equals(method)){		//주문조회
			viewOrder(request,response);
		}else if("addOrder".equals(method)){		//주문하기
			addOrder(request,response);
		}else if("addOrderForm".equals(method)){	//주문하기폼
			addOrderForm(request,response);
		}else if("removeCart".equals(method)){		//장바구니 삭제
			removeCart(request,response);
		}else if("editOrder".equals(method)){		//주문수정
			editOrder(request,response);
		}else if("editOrderForm".equals(method)){	//주문수정폼
			editOrderForm(request,response);
		}else if("addCartForm".equals(method)){		//장바구니폼
			addCartForm(request,response);
		}else if("viewCartList".equals(method)){	//장바구니조회
			viewCartList(request,response);
		}
	}

	private void viewCartList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		Member member1=new Member();
		member1.setMemberid("yubi");
		HttpSession session1=request.getSession();
		session1.setAttribute("LOGIN",member1);
		
		RequestDispatcher rd=request.getRequestDispatcher("/order/viewCartList.jsp");
		rd.forward(request, response);
	}

	private void addCartForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int goodnum=Integer.parseInt(request.getParameter("goodNum"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		
		Good good=GoodDAO.selectGood(goodnum);
		
		Order order=new Order();
		order.setGood(good);
		order.setQty(qty);
		//카트에대한 세션추가
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
		//viewcartList이동
		RequestDispatcher rd=request.getRequestDispatcher("/OrderService?method=viewCartList");
		rd.forward(request, response);
	}

	//아이디를 이용한 주문리스트 조회
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
		RequestDispatcher rd=request.getRequestDispatcher("/order/addOrder.jsp");
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
		
		int goodNum=Integer.parseInt(request.getParameter("goodNum"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		Good good=GoodDAO.selectGood(goodNum);
		Order order=new Order();
		order.setGood(good);
		order.setQty(qty);
		HttpSession session=request.getSession();
		ArrayList<Order>cartList=null;
		session.setAttribute("CART_LIST",cartList);
		
		String memberid=request.getParameter("memberid");
		Member member=MemberDAO.selsctMember(memberid);
		order.setMember(member);
		request.setAttribute("MEMBER",order);
		System.out.println(order);
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
	
	//장바구니수정
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
			//cartList에 장바구니에 담은 물건 번호 num과
			//일치하는 물건이 이미 담겨있는가?
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
	
	//장바구니수정폼
	public void editOrderForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		Order order=OrderDAO.selectOrder(orderNum);
		request.setAttribute("ORDER_LIST",order);
		RequestDispatcher rd=request.getRequestDispatcher("/order/editOrder.jsp");
		rd.forward(request, response);
	}
}
