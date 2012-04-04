package kr.or.kosta.moviesystem.good;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.moviesystem.buy.Buy;
import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.good.GoodDAO;
import kr.or.kosta.moviesystem.util.PageUtil;

public class GoodService extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    public GoodService() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		
		if(method==null){
			method="viewGoodList";
		}
		if("viewGoodList".equals(method)){
			viewGoodList(request,response);
		}else if("viewGood".equals(method)){
			viewGood(request,response);
		}else if("viewCartList".equals(method)){
			viewCartList(request,response);
		}else if("addCartList".equals(method)){
			addCartList(request,response);
		}else if("removeCartList".equals(method)){
			removeCartList(request,response);
		}else if("editCartList".equals(method)){
			editCartList(request,response);
		}else if("searchGoodList".equals(method)){
			searchGoodList(request, response);
		}
//		else if("addGoodForm".equals(method)){
//			addGoodForm(request,response);
//		}else if("addGood".equals(method)){
//			addGood(request,response);
//		}
	}
	private void searchGoodList(HttpServletRequest request,
			HttpServletResponse response)throws IOException, ServletException {
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));	
		}
		int length=8;
		
		ArrayList<Good>goodList=null;
		int goodCount=0;
		String keyword=request.getParameter("keyword");
		
		if(keyword==null||keyword.equals("")){
			goodList=GoodDAO.selectGoodList(length, page);
			goodCount=GoodDAO.selectGoodCount();
		}
		else{
			goodList=GoodDAO.selectGoodListByName(length, page, keyword);
			goodCount=GoodDAO.selectGoodListByNameCount(keyword);
		}
		request.setAttribute("GOOD_LIST", goodList);
		
		String pageLinkTag=PageUtil.generate(page, goodCount, length, "GoodService?method=searchGoodList&keyword="+keyword);
		System.out.println(pageLinkTag);
		
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGoodList.jsp");
		rd.forward(request, response);
	}

	private void editCartList(HttpServletRequest request,
			HttpServletResponse response)throws IOException, ServletException {

		int index=Integer.parseInt(request.getParameter("index"));
		String qty=request.getParameter("qty");
		HttpSession session=request.getSession();
		ArrayList<Buy>cartList=(ArrayList)session.getAttribute("CART_LIST");
		Buy buy=cartList.get(index);
		buy.setQty(Long.parseLong(qty));
		cartList.set(index, buy);
		session.setAttribute("CART_LIST", cartList);
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewCartList.jsp");
		rd.forward(request, response);
		
	}

	private void removeCartList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
	
		int index=Integer.parseInt(request.getParameter("index"));
		HttpSession session=request.getSession();
		ArrayList<Buy>cartList=(ArrayList)session.getAttribute("CART_LIST");
		Buy buy=cartList.get(index);
//		if(buy.getQty()==1){
			cartList.remove(index);
//		}
//		else{
//			long qty=buy.getQty();
//			buy.setQty(qty-1);
//			cartList.set(index, buy);
//		}
		
		session.setAttribute("CART_LIST",cartList);
		RequestDispatcher rd= request.getRequestDispatcher("/good/viewCartList.jsp");
		rd.forward(request, response);
	}
	

	private void viewCartList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewCartList.jsp");
		rd.forward(request, response);
	}

	private void addCartList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String gnum=request.getParameter("gnum");
		String qty=request.getParameter("qty");

		Good good=GoodDAO.selectGood(gnum);

		Buy buy=new Buy();
		buy.setGood(good);
		buy.setQty(Long.parseLong(qty));

		HttpSession session=request.getSession();
		ArrayList<Buy>cartList=null;
		int putedBuyIndex=-1;
		
		if(session.getAttribute("CART_LIST")==null){
			cartList=new ArrayList<Buy>();
		}
		else{
			cartList=(ArrayList)session.getAttribute("CART_LIST");
			
			for(int i=0;i<cartList.size();i++){
				Buy putedBuy=cartList.get(i);
				if(putedBuy.getGood().getGnum().equals(gnum)){
					putedBuyIndex=i;
					break;
				}
			}
		}
		if(putedBuyIndex==-1){
			cartList.add(buy);
		}
		else{
			Buy putedBuy=cartList.get(putedBuyIndex);
			putedBuy.setQty(putedBuy.getQty()+Long.parseLong(qty));
			cartList.set(putedBuyIndex, putedBuy);
		}
		
		session.setAttribute("CART_LIST", cartList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewCartList.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 전체 상품 목록 리스트
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewGoodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int length=8;
		
		ArrayList<Good>goodList=GoodDAO.selectGoodList(length,page);
		int goodCount=GoodDAO.selectGoodCount();
		request.setAttribute("GOOD_LIST", goodList);
		
		String pageLinkTag=PageUtil.generate(page, goodCount, length, "/moviesystem/GoodService?method=viewGoodList");
		System.out.println(pageLinkTag);
		
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGoodList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 선택한 상품이 보여지는 기능
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String gnum=request.getParameter("gnum");
		Good good=GoodDAO.selectGood(gnum);
		request.setAttribute("GOOD", good);
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGood.jsp");
		rd.forward(request, response);
	}

	/**
	 * 상품 등록 폼
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
//	public void addGoodForm(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
//		/* default generated stub */;
//		RequestDispatcher rd=request.getRequestDispatcher("/good/addGood.jsp");
//		rd.forward(request, response);
//	}
//
//	/**
//	 * 상품 등록
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	public void addGood(HttpServletRequest request, HttpServletResponse response) {
//		/* default generated stub */;
//		
//	}
}
