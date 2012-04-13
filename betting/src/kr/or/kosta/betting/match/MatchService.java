package kr.or.kosta.betting.match;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.betting.betting.BettingDAO;
import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.loc.LocDAO;
import kr.or.kosta.betting.team.Team;
import kr.or.kosta.betting.team.TeamDAO;
import kr.or.kosta.betting.util.PageUtil;

/**
 * Servlet implementation class MatchService
 */
public class MatchService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method == null) {
			method = "viewMatchList";
		}
		if ("viewMatchList".equals(method)) {
			viewMatchList(request, response);
		}else if("editMatchForm".equals(method)){
			editMatchForm(request,response);
		}else if("editMatch".equals(method)){
			editMatch(request,response);
		}else if("addMatch".equals(method)){
			addMatch(request,response);
		}else if("addMatchForm".equals(method)){
			addMatchForm(request,response);
		}else if("removeMatch".equals(method)){
			removeMatch(request,response);
		}else if("viewMatchListToVistor".equals(method)){
			viewMatchListToVistor(request,response);
		}

	}

	private void viewMatchListToVistor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int length = 10;

		List<Match> matchList = MatchDAO.selectMatchList(page,length);
		request.setAttribute("MATCH_LIST", matchList);
		int matchCount = MatchDAO.selectMatchCount();
		String pageLinkTag = PageUtil.generate(page, matchCount, length,
				"MatchService?method=viewMatchListToVistor");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd = request
				.getRequestDispatcher("/match/viewMatchListToVistor.jsp");
		rd.forward(request, response);

	
		
	}

	/**
	 * 메치데이터 입력 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addMatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String homeTeamNo = request.getParameter("hometeamno");
		String awayTeamNo = request.getParameter("awayteamno");
		String locNo = request.getParameter("locno");
		String matchTime = request.getParameter("matchtime");
				
		Match match = new Match();
		match.setMatchTime(matchTime);
				
		Team homeTeam = new Team();
		homeTeam.setNum(homeTeamNo);
				
		Team awayTeam = new Team();
		awayTeam.setNum(awayTeamNo);
				
		Loc loc = new Loc();
		loc.setNum(locNo);
		
		match.setAwayTeam(awayTeam);
		match.setHomeTeam(homeTeam);
		match.setLoc(loc);
		
		MatchDAO.insertMatch(match);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/MatchService?method=viewMatchList");
		rd.forward(request, response);
	}

	/**
	 * 메치데이터 입력 메서드의 폼구현
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addMatchForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		List<Team> teamList = TeamDAO.selectTeamList();
		List<Loc> locList = LocDAO.selectLocList();
		request.setAttribute("TEAM_LIST", teamList);
		request.setAttribute("LOC_LIST",locList);
		RequestDispatcher rd = request
				.getRequestDispatcher("/match/addMatch.jsp");
		rd.forward(request, response);
	}

	/**
	 * 수정하기 위한 폼 설정을 위한 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void editMatchForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String matchNo = request.getParameter("matchno");
		Match match = MatchDAO.selectMatch(matchNo);
		List<Team> teamList = TeamDAO.selectTeamList();
		List<Loc> locList = LocDAO.selectLocList();
		int betting = 0;
		if(BettingDAO.selectBettingByHome(matchNo).equals(null)){
			
		}else{
			betting = 2;
		}
		
		request.setAttribute("BETTING", betting);
		request.setAttribute("TEAM_LIST", teamList);
		request.setAttribute("MATCH", match);
		request.setAttribute("LOC_LIST",locList);
		RequestDispatcher rd = request
				.getRequestDispatcher("/match/editMatch.jsp");
		rd.forward(request, response);
	}

	/**
	 * 메치 수정 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void editMatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String matchNo = request.getParameter("matchno");
		String homeTeamNo = request.getParameter("hometeamno");
		String awayTeamNo = request.getParameter("awayteamno");
		String winTeamNo = request.getParameter("winteamno");
		String locNo = request.getParameter("locno");
		String matchTime = request.getParameter("matchtime");
		String score = request.getParameter("score");
		
		Match match = new Match();
		match.setNum(matchNo);
		match.setMatchTime(matchTime);
		match.setScore(score);
		
		Team homeTeam = new Team();
		homeTeam.setNum(homeTeamNo);
				
		Team awayTeam = new Team();
		awayTeam.setNum(awayTeamNo);
				
		Team winTeam = new Team();
		winTeam.setNum(winTeamNo);
				
		Loc loc = new Loc();
		loc.setNum(locNo);
		
		match.setWinTeam(winTeam);
		match.setAwayTeam(awayTeam);
		match.setHomeTeam(homeTeam);
		match.setLoc(loc);
		
		MatchDAO.updateMatch(match);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/MatchService?method=editMatch&matchno="
						+ matchNo);
		rd.forward(request, response);
	}

	/**
	 * 메치 데이터 삭제 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void removeMatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String matchNum = request.getParameter("matchno");
		MatchDAO.deleteMatch(matchNum);
		RequestDispatcher rd = request
				.getRequestDispatcher("/MatchService?method=viewMatchList");
		rd.forward(request, response);
	}

	/**
	 * 모든 메치 데이터 조회
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void viewMatchList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int length = 10;

		List<Match> matchList = MatchDAO.selectMatchList(page,length);
		request.setAttribute("MATCH_LIST", matchList);
		int matchCount = MatchDAO.selectMatchCount();
		String pageLinkTag = PageUtil.generate(page, matchCount, length,
				"MatchService?method=viewMatchList");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd = request
				.getRequestDispatcher("/match/viewMatchList.jsp");
		rd.forward(request, response);

	}

	/**
	 * 선택한 번호의 메치데이
	 * 
	 * @param request
	 * @param response
	 */

	public void veiwMatch(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

}
