package kr.or.kosta.auction.auction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;

public class AuctionService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 */
	public AuctionService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method==null){
			method ="viewAuctionList";
		}
		if("viewAuctionList".equals(method)){
			viewAuctionList(request,response);
		}else if("viewAuction".equals(method)){
			viewAuction(request,response);
		}else if("addAuction".equals(method)){
			addAuction(request,response);
		}else if("addAuctionForm".equals(method)){
			addAuctionForm(request,response);
		}else if("editAuction".equals(method)){
			editAuction(request,response);
		}else if("editAuctionForm".equals(method)){
			editAuctionForm(request,response);
		}else if("removeAuction".equals(method)){
			removeAuction(request,response);
		}
		
	}

	private void addAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		String aNum = request.getParameter("aNum");
		String gNum = request.getParameter("gNum");
		String sPrice = request.getParameter("sPrice");
		String imPrice = request.getParameter("imPrice");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String sold=request.getParameter("sold");
		String cuPrice = request.getParameter("cuPrice");
	
		Good good = new Good();
		good.setgNum(gNum);
		
		Auction auction = new Auction();
		auction.setaNum(aNum);	
		auction.setsPrice("10");
		auction.setImPrice(imPrice);
		auction.setsTime(sTime);
		auction.seteTime(eTime);
		auction.setSold(Integer.parseInt(sold));
		auction.setCuPrice("10");
		auction.setGood(good);
		
		AuctionDAO.insertAuction(auction);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);
	}
	
	private void addAuctionForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		// 1.전체 물품 리스트 조회
		ArrayList<Good>goodList=
				GoodDAO.selectGoodList();
		//2.request에 저장
		request.setAttribute("GOOD_LIST",goodList);
		
		String gNum = request.getParameter("gNum");
		Good good = GoodDAO.selectGood(gNum);
		request.setAttribute("GOOD", good);
		
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/auction/addAuction.jsp");
		//4.페이지 이동
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.파라메터정보 리턴
		String aNum = request.getParameter("aNum");
		String gNum = request.getParameter("gNum");
		String sPrice = request.getParameter("sPrice");
		String imPrice = request.getParameter("imPrice");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String sold=request.getParameter("sold");
		String cuPrice = request.getParameter("cuPrice");
		
		//2.1의 정보를 이용해서 Auction객체 생성
		Good good = new Good();
		good.setgNum(gNum);
		
		Auction auction = new Auction();
		
		auction.setaNum(aNum);
		auction.setsPrice(sPrice);
		auction.setImPrice(imPrice);
		auction.setsTime(sTime);
		auction.seteTime(eTime);
		auction.setSold(Integer.parseInt(sold));
		auction.setCuPrice(cuPrice);
		auction.setGood(good);
		
		
		//Department department=new Department();
		//department.setDeptno(deptno);
		
		//student.setDepartment(department);
		//3.경매정보를 수정하는 메서드 호출
		AuctionDAO.updateAuction(auction);
		//4.경매정보 조회화면으로 이동 객체 생성
		//RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/AuctionService?method=viewAuction&aNum="+aNum);
		rd.forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 */
	private void editAuctionForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.수정할 경매의 경매 번호 리턴
				String aNum = request.getParameter("aNum");
				//2.수정할 학생의 정보 조회
				Auction  auction = AuctionDAO.selectAuction(aNum);
				//3.전체 물품 리스트 조회
				ArrayList<Good> goodList=
						GoodDAO.selectGoodList();
				//4.request에 저장
				request.setAttribute("AUCTION", auction);
				request.setAttribute("GOOD_LIST",
						goodList);
				//5./student/editStudent.jsp이동 객체 생성
				RequestDispatcher  rd=
						request.getRequestDispatcher("/auction/editAuction.jsp");
				rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.a_num 파라메터 리턴받아서 변수에 저장
				String aNum=request.getParameter("aNum");
				//2.DB에서 경매번호가 일치하는 경매 조회
				Auction auction = AuctionDAO.selectAuction(aNum);
				//3.request에 2에서 조회한 경매의 정보 저장
				//   이름-STUDENT
				request.setAttribute("AUCTION",auction);
				//4./auction/viewAuction.jsp로 이동 객체 생성
				RequestDispatcher rd=
						request.getRequestDispatcher("/auction/viewAuction.jsp");
				//5.4의 JSP로 이동	
				rd.forward(request, response);
	}

	private void viewAuctionList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.AuctionDAO에서 전체 경매조회 메서드 호출
		ArrayList<Auction> auctionList=AuctionDAO.selectAuctionList();
		ArrayList<Auction> soldList=AuctionDAO.selectSoldList();
		//2.request에 1의 전체 경매 정보 저장
		request.setAttribute("AUCTION_LIST", auctionList);
		request.setAttribute("SOLD_LIST", soldList);
		//3. /auction/viewAuctionList.jsp로 페이지이동
		RequestDispatcher rd=request.getRequestDispatcher("/auction/viewAuctionList.jsp");
		//4.JSP로 페이지 이동
		rd.forward(request, response);
	}

	private void removeAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		String aNum=request.getParameter("aNum");
		AuctionDAO.deleteAuction(aNum);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/AuctionService?method=viewAuctionList");
		rd.forward(request, response);
///AuctionService?method=viewAuctionList
	}
}
