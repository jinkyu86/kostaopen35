package kr.or.kosta.moviesystem.buy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.good.GoodDAO;
import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.member.MemberDAO;


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
		}else if("removeBuyList".equals(method)){
			removeBuyList(request,response);
		}else if("editBuyList".equals(method)){
			editBuyList(request, response);
		}else if("completeBuy".equals(method)){
			completeBuy(request,response);
		}
	}


	/**
	 * 전체 구매 목록
	 * 
	 * @param request
	 * @param response
	 */
	public void viewBuyList(HttpServletRequest request,	HttpServletResponse response)throws ServletException, IOException{
		/* default generated stub */;
		ArrayList<Buy>buyList=BuyDAO.selectBuyList("jun123",1,1);
		//파라미터 userid로 수정하기
		request.setAttribute("BUY_LIST", buyList);
		RequestDispatcher rd=request.getRequestDispatcher("/buy/viewBuyList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 상품을 구매하는 기능
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */
		
		ArrayList<Buy>buyList=null;
		String gnum=request.getParameter("gnum");
		long qty=Long.parseLong(request.getParameter("qty"));
		
		Member member= MemberDAO.selectMemberById("jun123");
		//파라미터 userid로 수정하기
		buyList=BuyDAO.selectBuyList("jun123", 1, 1);
		//파라미터 userid로 수정하기
		
		Good good=GoodDAO.selectGood(gnum);
		Buy buy=new Buy();
		buy.setMember(member);
		buy.setGood(good);
		
		Buy putedBuy=null;
		int putedBuyIndex=-1;
		
		if(buyList==null){
			buy.setQty(qty);
			buy.setTotalPrice(good.getGprice()*qty);
			BuyDAO.insertBuy(buy);
		}else{
			for(int i=0;i<buyList.size();i++){
				putedBuy=buyList.get(i);
				if(putedBuy.getGood().getGnum().equals(gnum)){
					putedBuyIndex=i;
					break;
				}
			}//end for
		}
		if(putedBuyIndex==-1){
			buy.setQty(qty);
			buy.setTotalPrice(good.getGprice()*qty);
			BuyDAO.insertBuy(buy);
		}else{
			putedBuy.setQty(putedBuy.getQty()+qty);
			putedBuy.setTotalPrice(putedBuy.getGood().getGprice()*putedBuy.getQty());
			BuyDAO.editBuy(putedBuy);
		}

		
		buyList=BuyDAO.selectBuyList("jun123", 1, 1);
		//파라미터 userid로 수정하기
		request.setAttribute("BUY_LIST", buyList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/buy/viewBuyList.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 구매목록 삭제
	 * 
	 * @param request
	 * @param response
	 */
	private void removeBuyList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String buynum=request.getParameter("buynum");
		BuyDAO.deleteBuy(buynum);
		ArrayList<Buy> buyList=BuyDAO.selectBuyList("jun123", 1, 1);
		//파라미터 userid로 수정하기
		request.setAttribute("BUY_LIST", buyList);
		RequestDispatcher rd=request.getRequestDispatcher("/buy/viewBuyList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 구매목록 변경
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void editBuyList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */
		String buynum=request.getParameter("buynum");
		long qty=Long.parseLong(request.getParameter("qty"));
		long Price=Long.parseLong(request.getParameter("Price"));
		
		Buy buy=new Buy();
		buy.setBuynum(buynum);
		buy.setQty(qty);
		buy.setTotalPrice(qty*Price);
		BuyDAO.editBuy(buy);
		
		ArrayList<Buy>buyList=BuyDAO.selectBuyList("jun123", 1, 1);
		//파라미터 userid로 수정하기
		request.setAttribute("BUY_LIST", buyList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/buy/viewBuyList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 결제 완료 화면 폼으로 이동
	 * 
	 * @param request
	 * @param response
	 */
	public void completeBuy(HttpServletRequest request,	
			HttpServletResponse response)throws ServletException, IOException {
		/* default generated stub */
		
		ArrayList<Buy>buyList=BuyDAO.selectBuyList("jun123", 1, 1);
		//파라미터 userid로 수정하기
		
		for(int i=0;i<buyList.size();i++){
			Buy buy=buyList.get(i);
			BuyDAO.payBuy(buy.getBuynum());
		}
		
		ArrayList<Buy>completeBuyList=BuyDAO.selectcompleteBuyList("jun123", 1, 1);
		//파라미터 userid로 수정하기
		
		request.setAttribute("COMPLETE_BUY_LIST", completeBuyList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/buy/buyCompleteForm.jsp");
		rd.forward(request, response);
		
		
	}
	
	
}
