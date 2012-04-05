package kr.or.kosta.betting.memberbetdata;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.betting.BettingDAO;
import kr.or.kosta.betting.match.MatchDAO;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.member.MemberDAO;
import kr.or.kosta.betting.util.PageUtil;
import kr.or.kosta.betting.util.now;

/**
 * Servlet implementation class MemberBetDataService
 */
public class MemberBetDataService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBetDataService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method == null) {
			method = "viewMemberBetDataByIDList";
		}
		if ("viewMemberBetDataByIDList".equals(method)) {
			viewMemberBetDataByIDList(request, response);
		}else if("viewMBDByIDForm".equals(method)){
			viewMBDByIDForm(request,response);
		}else if("cancleBetting".equals(method)){
			cancleBetting(request,response);
		}else if("giveMineral".equals(method)){
			giveMineral(request,response);
		}
	}
	/**
	 * 베팅 취소 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void cancleBetting(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String distNum = request.getParameter("distnum");
		String mbdNum = request.getParameter("mbdnum");
		long betMineral = Long.parseLong(request.getParameter("bmineral"));
		String homeBetNum = request.getParameter("home");
		String awayBetNum = request.getParameter("away");
		double homeBetRating = BettingDAO.selectBettingRating(homeBetNum);
		double awayBetRating = BettingDAO.selectBettingRating(awayBetNum);
		long awayTotMineral = BettingDAO.selectBettingTotMineral(awayBetNum);
		long homeTotMineral=BettingDAO.selectBettingTotMineral(homeBetNum);
		long mineral = MemberDAO.selectMineralByID("jun1");
		
		if(distNum.equals("1")){
			long homeSeleRating = BettingDAO.selectBettingSeleRating(homeBetNum);
			homeSeleRating =  homeSeleRating - 1;
			homeTotMineral = homeTotMineral - betMineral;
			homeBetRating = ((double)homeTotMineral+awayTotMineral)/ homeTotMineral;
			awayBetRating = ((double)homeTotMineral+awayTotMineral)/ awayTotMineral;
			mineral = mineral + betMineral;
			
			Betting hBetting = new Betting();
			hBetting.setBatRating(homeBetRating);
			hBetting.setSeleRating(homeSeleRating);
			hBetting.setTotMineral(homeTotMineral);
			hBetting.setNum(homeBetNum);
						
			BettingDAO.updateBetting(hBetting);
			
			MemberDAO.updateMineralByID("jun1", mineral);
			
			MemberBetDataDAO.deleteMemberbetData(mbdNum);
			
			
			
		}else{
			long awaySeleRating = BettingDAO.selectBettingSeleRating(awayBetNum);
			awaySeleRating =  awaySeleRating - 1;
			awayTotMineral = awayTotMineral - betMineral;
			awayBetRating = ((double)homeTotMineral+awayTotMineral)/ awayTotMineral;
			homeBetRating = ((double)homeTotMineral+awayTotMineral)/ homeTotMineral;
			mineral = mineral + betMineral;
			
			Betting aBetting = new Betting();
			aBetting.setBatRating(awayBetRating);
			aBetting.setSeleRating(awaySeleRating);
			aBetting.setTotMineral(awayTotMineral);
			aBetting.setNum(awayBetNum);
						
			BettingDAO.updateBetting(aBetting);
			
			MemberDAO.updateMineralByID("jun1", mineral);
			
			MemberBetDataDAO.deleteMemberbetData(mbdNum);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("/betting/MemberBetDataService?method=viewMemberBetDataByIDList");
		rd.forward(request, response);
				
	
		
	}

	/**
	 * 아이디와 선택한 일로 정의된 데이터 조회
	 * 
	 * @param request
	 * @param response
	 */
	public void veiwMemberBetDataList(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
		
	}

	/**
	 * 베팅 결과 따라 베팅 미네랄 지급
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void giveMineral(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		long betMineral = Long.parseLong(request.getParameter("emineral"));
		long mineral = MemberDAO.selectMineralByID("id");
		String mbdNum = request.getParameter("mbdnum");
		
		mineral = mineral + betMineral;
		
		MemberDAO.updateMineralByID("jun1", mineral);
		MemberBetDataDAO.updateMemberBetData(mbdNum);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/betting/MemberBetDataService?method=viewMemberBetDataByIDList");
		rd.forward(request, response);
	}

	/**
	 * 선택된 아이디의 멤버 베팅 테이터 조회 메서드 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewMemberBetDataByIDList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int length = 10;
		
		ArrayList<MemberBetData> mbdList = 
				MemberBetDataDAO.selectMemberBetDataListByID(page, length, "jun1");
		request.setAttribute("MBD_LIST", mbdList);
		int mbdCount = MemberBetDataDAO.selectMemberBetDataByIDCount("jun1");
		String pageLinkTag = PageUtil.generate(page, mbdCount, length,
				"MemberBetDataService?method=viewMemberBetDataByIDList");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd = request
				.getRequestDispatcher("/mbd/viewMBDByIDList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 선택된 아이디의 멤버 베팅 테이터 조회폼 구현을 위한 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewMBDByIDForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String mbdNum = request.getParameter("mbdnum");
		String matchNum = MemberBetDataDAO.selectMatchNum(mbdNum);
		String matchTime = MatchDAO.selectMatchTime(matchNum);
		int check = now.hourCheck(matchTime);
		request.setAttribute("CHECK", check);
		Betting bettingHome = BettingDAO.selectBettingListByHome(matchNum);
		request.setAttribute("BETTING_HOME", bettingHome);
		Betting bettingAway = BettingDAO.selectBettingListByAway(matchNum);
		request.setAttribute("BETTING_AWAY", bettingAway);
		MemberBetData mbd = MemberBetDataDAO.selectMemberBetData(mbdNum);
		request.setAttribute("MBD", mbd);
		RequestDispatcher rd = request
				.getRequestDispatcher("/mbd/viewMBDByID.jsp");
		rd.forward(request, response);
	}
	
}
