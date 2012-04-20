
package kr.or.kosta.auction.auction;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.bid.BidDAO;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;

public class AuctionService implements ModelDriven  {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return auction;
	}

	/**
	 * @param request
	 * @param response
	 */
	 private int page;
	    
	    private String aNum;
	    private String gNum;
	    private Auction AUCTION;
	    private Good GOOD;
	    private Bid BID;
	    private String img;
	    
	   
		private Auction auction = new Auction();
	    private Good good = new Good();
	    private List<Auction>AUCTION_LIST;
	    private List<Auction>SOLD_LIST;
	    
	    private String PAGE_LINK_TAG;
	    
	    private List<Good>GOOD_LIST;
	    private List<Bid>BID_LIST;
	    
	     

	public List<Auction> getSOLD_LIST() {
			return SOLD_LIST;
		}

		public void setSOLD_LIST(List<Auction> sOLD_LIST) {
			SOLD_LIST = sOLD_LIST;
		}

	public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public String getaNum() {
			return aNum;
		}

		public void setaNum(String aNum) {
			this.aNum = aNum;
		}

		public String getAnum() {
			return aNum;
		}
		public void setAnum(String aNum) {
			this.aNum = aNum;
		}

		public String getgNum() {
			return gNum;
		}
		public void setgNum(String gNum) {
			this.gNum = gNum;
		}

		public Auction getAUCTION() {
			return AUCTION;
		}

		public void setAUCTION(Auction aUCTION) {
			AUCTION = aUCTION;
		}

		public Good getGOOD() {
			return GOOD;
		}

		public void setGOOD(Good gOOD) {
			GOOD = gOOD;
		}

		public Bid getBID() {
			return BID;
		}

		public void setBID(Bid bID) {
			BID = bID;
		}

		public Auction getAuction() {
			return auction;
		}

		public void setAuction(Auction auction) {
			this.auction = auction;
		}

		public Good getGood() {
			return good;
		}

		public void setGood(Good good) {
			this.good = good;
		}

		public List<Auction> getAUCTION_LIST() {
			return AUCTION_LIST;
		}

		public void setAUCTION_LIST(List<Auction> aUCTION_LIST) {
			AUCTION_LIST = aUCTION_LIST;
		}

		public String getPAGE_LINK_TAG() {
			return PAGE_LINK_TAG;
		}

		public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
			PAGE_LINK_TAG = pAGE_LINK_TAG;
		}

		public List<Good> getGOOD_LIST() {
			return GOOD_LIST;
		}

		public void setGOOD_LIST(List<Good> gOOD_LIST) {
			GOOD_LIST = gOOD_LIST;
		}

		public List<Bid> getBID_LIST() {
			return BID_LIST;
		}

		public void setBID_LIST(List<Bid> bID_LIST) {
			BID_LIST = bID_LIST;
		}

	public String addAuction() throws Exception {
		AuctionDAO.insertAuction(auction);
		return "success";
	}
	
	public String addAuctionForm() throws Exception{
		// 1.전체 물품 리스트 조회
		GOOD_LIST= GoodDAO.selectGoodList();
		GOOD = GoodDAO.selectGood(gNum);
		return "success";
	}

	/**
	 * @param request
	 * @param response
	 */
	public String editAuction() throws Exception{
		AuctionDAO.updateAuction(auction);
		return "success";
	}

	/**
	 * @param request
	 * @param response
	 */
	public String editAuctionForm() throws Exception{
		//1.수정할 경매의 경매 번호 리턴
		AUCTION = AuctionDAO.selectAuction(aNum);
				//3.전체 물품 리스트 조회
		GOOD_LIST = GoodDAO.selectGoodList();
		return "success";
	}

	/**
	 * @param request
	 * @param response
	 */
	public String viewAuction() throws Exception{
				//1.a_num 파라메터 리턴받아서 변수에 저장
				//2.DB에서 경매번호가 일치하는 경매 조회
				int size=5;
				AUCTION = AuctionDAO.selectAuction(aNum);
				BID_LIST = BidDAO.selectBidListByAuctionNum(aNum, size);
				//3.request에 2에서 조회한 경매의 정보 저장
				//   이름-STUDENT
				//4./auction/viewAuction.jsp로 이동 객체 생성
				//5.4의 JSP로 이동	
			return "success";
	}

	public String viewAuctionList() throws Exception{
		//1.AuctionDAO에서 전체 경매조회 메서드 호출
		AUCTION_LIST=AuctionDAO.selectAuctionList();
		SOLD_LIST=AuctionDAO.selectAuctionSoldList();
		return "success";
	    
	}

	public String removeAuction() throws Exception{
		AuctionDAO.deleteAuction(aNum);
		return "success";
///AuctionService?method=viewAuctionList
	}
}

/*
package kr.or.kosta.auction.auction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.bid.BidDAO;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;

public class AuctionService implements ModelDriven {
	private static final long serialVersionUID = 1L;
	private List<Auction> AUCTION_LIST;
	private List<Auction> SOLD_LIST;
	
	public List<Auction> getAUCTION_LIST() {
		return AUCTION_LIST;
	}

	public void setAUCTION_LIST(List<Auction> aUCTION_LIST) {
		AUCTION_LIST = aUCTION_LIST;
	}

	public List<Auction> getSOLD_LIST() {
		return SOLD_LIST;
	}

	public void setSOLD_LIST(List<Auction> sOLD_LIST) {
		SOLD_LIST = sOLD_LIST;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param request
	 * @param response
	 
	public AuctionService() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
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
		auction.setsPrice(sPrice);
		auction.setImPrice(imPrice);
		auction.setCuPrice(cuPrice);
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
		List<Good>goodList=
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
		String userid=request.getParameter("userid");
		
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
		auction.setUserid(userid);
		
		
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
	 
	private void editAuctionForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.수정할 경매의 경매 번호 리턴
				String aNum = request.getParameter("aNum");
				//2.수정할 학생의 정보 조회
				Auction  auction = AuctionDAO.selectAuction(aNum);
				//3.전체 물품 리스트 조회
				List<Good> goodList=
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
	 
	private void viewAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
				//1.a_num 파라메터 리턴받아서 변수에 저장
				String aNum=request.getParameter("aNum");
				//2.DB에서 경매번호가 일치하는 경매 조회
				int size=5;
				Auction auction = AuctionDAO.selectAuction(aNum);
				List<Bid> bidList=BidDAO.selectBidListByAuctionNum(aNum, size);
				//3.request에 2에서 조회한 경매의 정보 저장
				//   이름-STUDENT
				request.setAttribute("AUCTION",auction);
				request.setAttribute("BID_LIST", bidList);
				//4./auction/viewAuction.jsp로 이동 객체 생성
				RequestDispatcher rd=
						request.getRequestDispatcher("/auction/viewAuction.jsp");
				//5.4의 JSP로 이동	
				rd.forward(request, response);
	}

	public String viewAuctionList() throws Exception{
		//1.AuctionDAO에서 전체 경매조회 메서드 호출
		AUCTION_LIST=AuctionDAO.selectAuctionList();
		SOLD_LIST=AuctionDAO.selectAuctionSoldList();
		return "success";
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
*/