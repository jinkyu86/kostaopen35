package kr.or.kosta.betting.betting;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.match.MatchDAO;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.member.MemberDAO;
import kr.or.kosta.betting.memberbetdata.MemberBetData;
import kr.or.kosta.betting.memberbetdata.MemberBetDataDAO;
import kr.or.kosta.betting.util.now;

/**
 * Servlet implementation class BettingService
 */
public class BettingService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BettingService() {
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
			method = "todayBettingList";
		}
		if("bettingGameForm".equals(method)){
			bettingGameForm(request,response);
		}else if("todayBettingList".equals(method)){
			todayBettingList(request,response);
		}else if("insertBetting".equals(method)){
			insertBetting(request,response);
		}else if("bettingGame".equals(method)){
			bettingGame(request,response);
		}
	}
	//베팅 테이블 삽입 메서드
	private void insertBetting(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String matchNum = request.getParameter("matchno");
		
		BettingDAO.insertHomeBetting(matchNum);
		BettingDAO.insertAwayBetting(matchNum);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/MatchService?method=viewMatchList");
		rd.forward(request, response);
		
	}

	//오늘자 베팅 리스트 조회
	private void todayBettingList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String ID = member1.getId();
		
			long mineral=MemberDAO.selectMineralByID(ID);
			request.setAttribute("MINERAL", mineral);
		
			long rank =MemberDAO.selectMemberRanking(ID);
			request.setAttribute("RANK", rank);
		}
		String date = now.Date();
		List<Match> matchList = MatchDAO.selectMatchByDate(date);
		request.setAttribute("TODAY_MATCH",matchList);
		RequestDispatcher rd = request
				.getRequestDispatcher("/betting/todayBettingList.jsp");
		rd.forward(request, response);
		
	}


	/**
	 * 베팅 알고리즘 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void bettingGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String ID = member1.getId();
			String matchTime = request.getParameter("matchtime");
			int check = now.hourCheck(matchTime);
			
			if (check == 1) {

				String distNum = request.getParameter("distnum");
				long betMineral = Long.parseLong(request
						.getParameter("betmineral"));
				String homeBetNum = request.getParameter("home");
				String awayBetNum = request.getParameter("away");
				double homeBetRating = BettingDAO
						.selectBettingRating(homeBetNum);
				double awayBetRating = BettingDAO
						.selectBettingRating(awayBetNum);
				long homeSeleRating = BettingDAO
						.selectBettingSeleRating(homeBetNum);
				long awaySeleRating = BettingDAO
						.selectBettingSeleRating(awayBetNum);
				long homeTotMineral = BettingDAO
						.selectBettingTotMineral(homeBetNum);
				long awayTotMineral = BettingDAO
						.selectBettingTotMineral(awayBetNum);
				long mineral = MemberDAO.selectMineralByID(ID);

				if (distNum.equals("1")) {
					homeSeleRating = homeSeleRating + 1;
					homeTotMineral = homeTotMineral + betMineral;

					homeBetRating = ((double) homeTotMineral + awayTotMineral)
							/ homeTotMineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
							/ awayTotMineral;
					mineral = mineral - betMineral;
					
					if(mineral<0){
						String matchNum = request.getParameter("matchno");
						request.setAttribute("ERROR", "미네랄이 부족합니다.");
						RequestDispatcher rd = request
								.getRequestDispatcher("/BettingService?method=bettingGameForm&matchno="+matchNum);
						rd.forward(request, response);
						return;
					}
					if (homeTotMineral == 0) {
						homeBetRating = 1;
					}
					if (awayTotMineral == 0) {
						awayBetRating = 1;
					}

					Betting hBetting = new Betting();
					hBetting.setBatRating(homeBetRating);
					hBetting.setSeleRating(homeSeleRating);
					hBetting.setTotMineral(homeTotMineral);
					hBetting.setNum(homeBetNum);

					BettingDAO.updateBetting(hBetting);

					Betting aBetting = new Betting();
					aBetting.setBatRating(awayBetRating);
					aBetting.setSeleRating(awaySeleRating);
					aBetting.setTotMineral(awayTotMineral);
					aBetting.setNum(awayBetNum);

					BettingDAO.updateBetting(aBetting);

					MemberBetData mbd = new MemberBetData();
					mbd.setBetMineral(betMineral);

					Betting betting1 = new Betting();
					betting1.setNum(homeBetNum);

					Member member = new Member();
					member.setId(ID);
					member.setMineral(mineral);

					mbd.setBetting(betting1);
					mbd.setMember(member);

					MemberBetDataDAO.insultMemberBetData(mbd);
					
					MemberDAO.updateMineralByID(member);
					request.setAttribute("SUCCESS", "성공적으로 베팅에 참여하였습니다.");
				} else {
					awaySeleRating = awaySeleRating + 1;
					awayTotMineral = awayTotMineral + betMineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
							/ awayTotMineral;
					homeBetRating = ((double) homeTotMineral + awayTotMineral)
							/ homeTotMineral;
					mineral = mineral - betMineral;
					
					if(mineral<0){
						String matchNum = request.getParameter("matchno");
						request.setAttribute("ERROR", "미네랄이 부족합니다.");
//						request.setAttribute("CHECK", check);
//						Betting bettingHome = BettingDAO.selectBettingByHome(matchNum);
//						request.setAttribute("BETTING_HOME", bettingHome);
//						Betting bettingAway = BettingDAO.selectBettingByAway(matchNum);
//						request.setAttribute("BETTING_AWAY", bettingAway);
						RequestDispatcher rd = request
								.getRequestDispatcher("/BettingService?method=bettingGameForm&matchno="+matchNum);
						rd.forward(request, response);
						return;
					}
					
					if (homeTotMineral == 0) {
						homeBetRating = 1;
					}
					if (awayTotMineral == 0) {
						awayBetRating = 1;
					}

					Betting aBetting = new Betting();
					aBetting.setBatRating(awayBetRating);
					aBetting.setSeleRating(awaySeleRating);
					aBetting.setTotMineral(awayTotMineral);
					aBetting.setNum(awayBetNum);

					BettingDAO.updateBetting(aBetting);

					Betting hBetting = new Betting();
					hBetting.setBatRating(homeBetRating);
					hBetting.setSeleRating(homeSeleRating);
					hBetting.setTotMineral(homeTotMineral);
					hBetting.setNum(homeBetNum);

					BettingDAO.updateBetting(hBetting);

					MemberBetData mbd = new MemberBetData();
					mbd.setBetMineral(betMineral);

					Betting betting1 = new Betting();
					betting1.setNum(awayBetNum);

					Member member = new Member();
					member.setId(ID);
					member.setMineral(mineral);

					mbd.setBetting(betting1);
					mbd.setMember(member);

					MemberBetDataDAO.insultMemberBetData(mbd);
					MemberDAO.updateMineralByID(member);
					request.setAttribute("SUCCESS", "성공적으로 베팅에 참여하였습니다.");
				}
			} else {
				request.setAttribute("ERROR", "마감 되었습니다.");
			}
			
			String matchNum = request.getParameter("matchno");
			RequestDispatcher rd = request
					.getRequestDispatcher("/BettingService?method=bettingGameForm&matchno="+matchNum);
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "로그인 해주세요.");
			RequestDispatcher rd = request
					.getRequestDispatcher("/MemberService?method=loginForm");
//			"/MemberService?method=loginForm"
			rd.forward(request, response);
		}
		
	}

	/**
	 * 모든 베팅 리스트 조회 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
//	public void viewBettingList(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		/* default generated stub */;
//		int page = 1;
//		if (request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
//		int length = 10;
//
//		ArrayList<Betting> bettingList = BettingDAO.selectBettingList(page, length);
//		request.setAttribute("BETTING_LIST", bettingList);
//		int bettingCount = BettingDAO.selectBettingCount();
//		String pageLinkTag = PageUtil.generate(page, bettingCount, length,
//				"MatchService?method=viewBettingList");
//		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/betting/viewBettingList.jsp");
//		rd.forward(request, response);
//	}

	/**
	 * 베팅 폼 구현 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void bettingGameForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String ID = member1.getId();
		
			long mineral=MemberDAO.selectMineralByID(ID);
			request.setAttribute("MINERAL", mineral);
		
			long rank =MemberDAO.selectMemberRanking(ID);
			request.setAttribute("RANK", rank);
		}
		String matchNum = request.getParameter("matchno");
		String matchTime = MatchDAO.selectMatchTime(matchNum);
		int check = now.hourCheck(matchTime);
		request.setAttribute("CHECK", check);
		Betting bettingHome = BettingDAO.selectBettingByHome(matchNum);
		request.setAttribute("BETTING_HOME", bettingHome);
		Betting bettingAway = BettingDAO.selectBettingByAway(matchNum);
		request.setAttribute("BETTING_AWAY", bettingAway);
		RequestDispatcher rd = request
				.getRequestDispatcher("/betting/viewBettingGame.jsp");
		rd.forward(request, response);
	}

}
