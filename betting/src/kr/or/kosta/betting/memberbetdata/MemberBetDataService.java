package kr.or.kosta.betting.memberbetdata;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		}else if("recoveryMineral".equals(method)){
			recoveryMineral(request,response);
		}
	}
	// 취소나 무승부시 미네랄 복구 시켜주는 메서드
	private void recoveryMineral(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String ID = member1.getId();
			long betMineral = Long.parseLong(request.getParameter("bmineral"));
			long mineral = MemberDAO.selectMineralByID(ID);
			String mbdNum = request.getParameter("mbdnum");
		
			mineral = mineral + betMineral;
			
			Member member = new Member();
			member.setId(ID);
			member.setMineral(mineral);
			MemberDAO.updateMineralByID(member);
			MemberBetDataDAO.updateMemberBetData(mbdNum);
		
			request.setAttribute("SUCCESS", "미네랄을 돌려드렸습니다.");
			RequestDispatcher rd = request
				.getRequestDispatcher("/MemberBetDataService?method=viewMemberBetDataByIDList");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "로그인 해주세요");
			RequestDispatcher rd = request
					.getRequestDispatcher("/MemberService?method=loginForm");
			rd.forward(request, response);
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
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String ID = member1.getId();
			String matchTime = request.getParameter("matchtime");
			int check = now.hourCheck(matchTime);
			
			if (check == 1) {

				String mbdNum = request.getParameter("mbdnum");
				String distNum = request.getParameter("distnum");
				long betMineral = Long.parseLong(request.getParameter("bmineral"));
				String homeBetNum = request.getParameter("home");
				String awayBetNum = request.getParameter("away");
				double homeBetRating = BettingDAO.selectBettingRating(homeBetNum);
				double awayBetRating = BettingDAO.selectBettingRating(awayBetNum);
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
					homeSeleRating = homeSeleRating - 1;
					homeTotMineral = homeTotMineral - betMineral;
					homeBetRating = ((double) homeTotMineral + awayTotMineral)
						/ homeTotMineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
						/ awayTotMineral;
					mineral = mineral + betMineral;

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

					Member member = new Member();
					member.setId(ID);
					member.setMineral(mineral);
					MemberDAO.updateMineralByID(member);

					MemberBetDataDAO.deleteMemberbetData(mbdNum);

				} else {

					awaySeleRating = awaySeleRating - 1;
					awayTotMineral = awayTotMineral - betMineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
							/ awayTotMineral;
					homeBetRating = ((double) homeTotMineral + awayTotMineral)
							/ homeTotMineral;
					mineral = mineral + betMineral;

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

					Member member = new Member();
					member.setId(ID);
					member.setMineral(mineral);
					MemberDAO.updateMineralByID(member);

					MemberBetDataDAO.deleteMemberbetData(mbdNum);
					
					request.setAttribute("SUCCESS", "성공적으로 베팅을 취소하였습니다.");
				}
			} else {
				request.setAttribute("ERROR", "경기가 시작되어 취소 할 수 없습니다.");
			}
			
			RequestDispatcher rd = request
				.getRequestDispatcher("/MemberBetDataService?method=viewMemberBetDataByIDList");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "로그인 해주세요");
			RequestDispatcher rd = request
					.getRequestDispatcher("/MemberService?method=loginForm");
			rd.forward(request, response);
		}
				
	
		
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
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String ID = member1.getId();
			long betMineral = Long.parseLong(request.getParameter("emineral"));
			long mineral = MemberDAO.selectMineralByID(ID);
			String mbdNum = request.getParameter("mbdnum");
		
			mineral = mineral + betMineral;
			
			Member member = new Member();
			member.setId(ID);
			member.setMineral(mineral);
			MemberDAO.updateMineralByID(member);
			MemberBetDataDAO.updateMemberBetData(mbdNum);
		
			request.setAttribute("SUCCESS", "미네랄을 지급하였습니다.");
			RequestDispatcher rd = request
					.getRequestDispatcher("/MemberBetDataService?method=viewMemberBetDataByIDList");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "로그인 해주세요");
			RequestDispatcher rd = request
					.getRequestDispatcher("/MemberService?method=loginForm");
			rd.forward(request, response);
		}
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
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String ID = member1.getId();

			int page = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			int length = 10;

			List<MemberBetData> mbdList = MemberBetDataDAO
					.selectMemberBetDataListByID(page, length, ID);
			request.setAttribute("MBD_LIST", mbdList);
			int mbdCount = MemberBetDataDAO.selectMemberBetDataByIDCount(ID);
			String pageLinkTag = PageUtil.generate(page, mbdCount, length,
					"MemberBetDataService?method=viewMemberBetDataByIDList");
			request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
			RequestDispatcher rd = request
					.getRequestDispatcher("/mbd/viewMBDByIDList.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "로그인 해주세요");
			RequestDispatcher rd = request
					.getRequestDispatcher("/MemberService?method=loginForm");
			rd.forward(request, response);
		}
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
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
		if (member1 != null) {
			String mbdNum = request.getParameter("mbdnum");
			String matchNum = MemberBetDataDAO.selectMatchNum(mbdNum);
			String matchTime = MatchDAO.selectMatchTime(matchNum);
			int check = now.hourCheck(matchTime);
			request.setAttribute("CHECK", check);
			Betting bettingHome = BettingDAO.selectBettingByHome(matchNum);
			request.setAttribute("BETTING_HOME", bettingHome);
			Betting bettingAway = BettingDAO.selectBettingByAway(matchNum);
			request.setAttribute("BETTING_AWAY", bettingAway);
			MemberBetData mbd = MemberBetDataDAO.selectMemberBetData(mbdNum);
			request.setAttribute("MBD", mbd);
			RequestDispatcher rd = request
					.getRequestDispatcher("/mbd/viewMBDByID.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "로그인 해주세요");
			RequestDispatcher rd = request
					.getRequestDispatcher("/MemberService?method=loginForm");
			rd.forward(request, response);
		}
	}
	
}
