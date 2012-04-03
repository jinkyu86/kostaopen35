package kr.or.kosta.moviesystem.buy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.good.GoodDAO;
import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.member.MemberDAO;
import kr.or.kosta.moviesystem.buy.Buy;
import kr.or.kosta.moviesystem.buy.BuyDAO;
import kr.or.kosta.moviesystem.util.PageUtil;



public class BuyService extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    public BuyService() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		
		if(method==null){
			method="viewBuyList";
		}
		if("viewBuyList".equals(method)){
			viewBuyList(request,response);
		}else if("addBuy".equals(method)){
			addBuy(request,response);
		}
//		else if("removeBuyList".equals(method)){
//			removeBuyList(request,response);
//		}
//		else if("editBuyList".equals(method)){
//			editBuyList(request, response);
//		}
//		else if("completeBuy".equals(method)){
//			completeBuy(request,response);
//		}
	}


	/**
	 * ��ü ���� ���
	 * 
	 * @param request
	 * @param response
	 */
	public void viewBuyList(HttpServletRequest request,	HttpServletResponse response)throws ServletException, IOException{

		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int length=5;
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String userid=member.getUserid();
		
		ArrayList<Buy>buyList=BuyDAO.selectBuyList(userid,length, page);
		int buyCount=BuyDAO.selectBuyCountByUerid(userid);
		request.setAttribute("BUY_LIST", buyList);
		
		String pageLinkTag=PageUtil.generate(page, buyCount, length, "/moviesystem/BuyService?method=viewBuyList&userid="+userid);
		System.out.println(pageLinkTag);
		
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/buy/viewBuyList.jsp");
		rd.forward(request, response);
	}

	/**
	 * ��ǰ�� �����ϴ� ���
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		
		if(member==null){
			RequestDispatcher rd = request.getRequestDispatcher("/MemberService?method=loginForm");
			rd.forward(request, response);
			return;
		}
		ArrayList<Buy>cartList=(ArrayList)session.getAttribute("CART_LIST");
				
		for(int i=0;i<cartList.size();i++){
			Buy buy=cartList.get(i);
			buy.setMember(member);
			BuyDAO.insertBuy(buy);
		}
		session.removeAttribute("CART_LIST");

		RequestDispatcher rd=request.getRequestDispatcher("/BuyService?method=viewBuyList");
		rd.forward(request, response);
		
	}

//	/**
//	 * ���Ÿ�� ����
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	private void removeBuyList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//		
//		String buynum=request.getParameter("buynum");
//		BuyDAO.deleteBuy(buynum);
//		ArrayList<Buy> buyList=BuyDAO.selectBuyList("jun123", 1, 1);
//		//�Ķ���� userid�� �����ϱ�
//		request.setAttribute("BUY_LIST", buyList);
//		RequestDispatcher rd=request.getRequestDispatcher("/buy/viewBuyList.jsp");
//		rd.forward(request, response);
//	}
//
//	/**
//	 * ���Ÿ�� ����
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws IOException 
//	 * @throws ServletException 
//	 */
//	public void editBuyList(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		/* default generated stub */
//		String buynum=request.getParameter("buynum");
//		long qty=Long.parseLong(request.getParameter("qty"));
//		long Price=Long.parseLong(request.getParameter("Price"));
//		
//		Buy buy=new Buy();
//		buy.setBuynum(buynum);
//		buy.setQty(qty);
//		buy.setTotalPrice(qty*Price);
//		BuyDAO.editBuy(buy);
//		
//		ArrayList<Buy>buyList=BuyDAO.selectBuyList("jun123", 1, 1);
//		//�Ķ���� userid�� �����ϱ�
//		request.setAttribute("BUY_LIST", buyList);
//		
//		RequestDispatcher rd=request.getRequestDispatcher("/buy/viewBuyList.jsp");
//		rd.forward(request, response);
//	}
//
//	/**
//	 * ���� �Ϸ� ȭ�� ������ �̵�
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	public void completeBuy(HttpServletRequest request,	
//			HttpServletResponse response)throws ServletException, IOException {
//		/* default generated stub */
//		
//		ArrayList<Buy>buyList=BuyDAO.selectBuyList("jun123", 1, 1);
//		//�Ķ���� userid�� �����ϱ�
//		
//		for(int i=0;i<buyList.size();i++){
//			Buy buy=buyList.get(i);
//			BuyDAO.payBuy(buy.getBuynum());
//		}
//		
//		ArrayList<Buy>completeBuyList=BuyDAO.selectcompleteBuyList("jun123", 1, 1);
//		//�Ķ���� userid�� �����ϱ�
//		
//		request.setAttribute("COMPLETE_BUY_LIST", completeBuyList);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/buy/buyCompleteForm.jsp");
//		rd.forward(request, response);
//		
//		
//	}
	
	
}
