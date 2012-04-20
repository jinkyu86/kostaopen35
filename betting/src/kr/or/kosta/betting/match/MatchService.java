package kr.or.kosta.betting.match;
  
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.betting.BettingDAO;
import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.loc.LocDAO;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.member.MemberDAO;
import kr.or.kosta.betting.team.Team;
import kr.or.kosta.betting.team.TeamDAO;
import kr.or.kosta.betting.util.PageUtil;

/**
 * Servlet implementation class MatchService
 */
public class MatchService implements ModelDriven
	,SessionAware{
	private Map session;
	private Match match = new Match();
	private int page;
	private String SUCCESS;
	private long MINERAL;
	private long RANK;
	private String PAGE_LINK_TAG;
	private List<Team>TEAM_LIST;
	private List<Loc>LOC_LIST;
	private String matchno;
	private String BETTING;
	private Match MATCH;
    private List<Match> MATCH_LIST;
	
    
	public List<Match> getMATCH_LIST() {
		return MATCH_LIST;
	}

	public void setMATCH_LIST(List<Match> mATCH_LIST) {
		MATCH_LIST = mATCH_LIST;
	}

	public Match getMATCH() {
		return MATCH;
	}

	public void setMATCH(Match mATCH) {
		MATCH = mATCH;
	}

	public String getMatchno() {
		return matchno;
	}

	public void setMatchno(String matchno) {
		this.matchno = matchno;
	}

	public List<Team> getTEAM_LIST() {
		return TEAM_LIST;
	}

	public void setTEAM_LIST(List<Team> tEAM_LIST) {
		TEAM_LIST = tEAM_LIST;
	}

	public List<Loc> getLOC_LIST() {
		return LOC_LIST;
	}

	public void setLOC_LIST(List<Loc> lOC_LIST) {
		LOC_LIST = lOC_LIST;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSUCCESS() {
		return SUCCESS;
	}

	public void setSUCCESS(String sUCCESS) {
		SUCCESS = sUCCESS;
	}

	public long getMINERAL() {
		return MINERAL;
	}

	public void setMINERAL(long mINERAL) {
		MINERAL = mINERAL;
	}

	public long getRANK() {
		return RANK;
	}

	public void setRANK(long rANK) {
		RANK = rANK;
	}

	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}

	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}

	public String getBETTING() {
		return BETTING;
	}

	public void setBETTING(String bETTING) {
		BETTING = bETTING;
	}
	
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public Object getModel() {
		return match;
	}
	
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MatchService() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String method = request.getParameter("method");
//		if (method == null) {
//			method = "viewMatchList";
//		}
//		if ("viewMatchList".equals(method)) {
//			viewMatchList(request, response);
//		}else if("editMatchForm".equals(method)){
//			editMatchForm(request,response);
//		}else if("editMatch".equals(method)){
//			editMatch(request,response);
//		}else if("addMatch".equals(method)){
//			addMatch(request,response);
//		}else if("addMatchForm".equals(method)){
//			addMatchForm(request,response);
//		}else if("removeMatch".equals(method)){
//			removeMatch(request,response);
//		}else if("viewMatchListToVistor".equals(method)){
//			viewMatchListToVistor(request,response);
//		}



//	}

	public String viewMatchListToVistor() throws Exception{
		
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = MemberDAO.selectMineralByID(ID);
			RANK = MemberDAO.selectMemberRanking(ID);
		}
		int length=10;
		if(page==0){
			page=1;
		}
		MATCH_LIST = MatchDAO.selectMatchList(page,length);
		int matchCount = MatchDAO.selectMatchCount();
		PAGE_LINK_TAG = PageUtil.generate(page, matchCount, length,
			"viewMatchListToVistor.action");
		return "success";
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//		
//			long mineral=MemberDAO.selectMineralByID(ID);
//			request.setAttribute("MINERAL", mineral);
//		
//			long rank =MemberDAO.selectMemberRanking(ID);
//			request.setAttribute("RANK", rank);
//		}
//		int page = 1;
//		if (request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
//		int length = 10;
//
//		List<Match> matchList = MatchDAO.selectMatchList(page,length);
//		request.setAttribute("MATCH_LIST", matchList);
//		int matchCount = MatchDAO.selectMatchCount();
//		String pageLinkTag = PageUtil.generate(page, matchCount, length,
//				"MatchService?method=viewMatchListToVistor");
//		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/match/viewMatchListToVistor.jsp");
//		rd.forward(request, response);

	
		
	}

	/**
	 * 메치데이터 입력 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String addMatch() throws Exception{
		/* default generated stub */;
		MatchDAO.insertMatch(match);
		SUCCESS="경기 데이터를 삽입하였습니다.";
		return "success";
//		String homeTeamNo = request.getParameter("hometeamno");
//		String awayTeamNo = request.getParameter("awayteamno");
//		String locNo = request.getParameter("locno");
//		String matchTime = request.getParameter("matchtime");
//				
//		Match match = new Match();
//		match.setMatchTime(matchTime);
//				
//		Team homeTeam = new Team();
//		homeTeam.setNum(homeTeamNo);
//				
//		Team awayTeam = new Team();
//		awayTeam.setNum(awayTeamNo);
//				
//		Loc loc = new Loc();
//		loc.setNum(locNo);
//		
//		match.setAwayTeam(awayTeam);
//		match.setHomeTeam(homeTeam);
//		match.setLoc(loc);
//		
//		MatchDAO.insertMatch(match);
//		
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/MatchService?method=viewMatchList");
//		rd.forward(request, response);
	}

	/**
	 * 메치데이터 입력 메서드의 폼구현
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String addMatchForm() throws Exception{
		/* default generated stub */;
		
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = MemberDAO.selectMineralByID(ID);
			RANK = MemberDAO.selectMemberRanking(ID);
		}
		TEAM_LIST = TeamDAO.selectTeamList();
		LOC_LIST= LocDAO.selectLocList();
		return "success";
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//		
//			long mineral=MemberDAO.selectMineralByID(ID);
//			request.setAttribute("MINERAL", mineral);
//		
//			long rank =MemberDAO.selectMemberRanking(ID);
//			request.setAttribute("RANK", rank);
//		}
//		List<Team> teamList = TeamDAO.selectTeamList();
//		List<Loc> locList = LocDAO.selectLocList();
//		request.setAttribute("TEAM_LIST", teamList);
//		request.setAttribute("LOC_LIST",locList);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/match/addMatch.jsp");
//		rd.forward(request, response);
	}

	/**
	 * 수정하기 위한 폼 설정을 위한 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String editMatchForm() throws Exception{
		/* default generated stub */
		
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = MemberDAO.selectMineralByID(ID);
			RANK = MemberDAO.selectMemberRanking(ID);
		}
		MATCH = MatchDAO.selectMatch(matchno);
		TEAM_LIST = TeamDAO.selectTeamList();
		LOC_LIST= LocDAO.selectLocList();
		Betting betting1 = BettingDAO.selectBettingByHome(matchno);
		BETTING = "0";
		if(betting1==null){
		
		}else{
			BETTING= "2";
		}
		return "success";
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//		
//			long mineral=MemberDAO.selectMineralByID(ID);
//			request.setAttribute("MINERAL", mineral);
//		
//			long rank =MemberDAO.selectMemberRanking(ID);
//			request.setAttribute("RANK", rank);
//		}
//		String matchNo = request.getParameter("matchno");
//		Match match = MatchDAO.selectMatch(matchNo);
//		List<Team> teamList = TeamDAO.selectTeamList();
//		List<Loc> locList = LocDAO.selectLocList();
//		Betting betting = BettingDAO.selectBettingByHome(matchNo);
//		int bettingnum = 0;
//		if(betting==null){
//		
//		}else{
//			bettingnum= 2;
//		}
//		
//		request.setAttribute("BETTING", bettingnum);
//		request.setAttribute("TEAM_LIST", teamList);
//		request.setAttribute("MATCH", match);
//		request.setAttribute("LOC_LIST",locList);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/match/editMatch.jsp");
//		rd.forward(request, response);
	}



	/**
	 * 메치 수정 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String editMatch() throws Exception{
		/* default generated stub */
		MatchDAO.updateMatch(match);
		SUCCESS="경기 데이터를 수정하였습니다.";
		return "success";
//		String matchNo = request.getParameter("matchno");
//		String homeTeamNo = request.getParameter("hometeamno");
//		String awayTeamNo = request.getParameter("awayteamno");
//		String winTeamNo = request.getParameter("winteamno");
//		String locNo = request.getParameter("locno");
//		String matchTime = request.getParameter("matchtime");
//		String score = request.getParameter("score");
//		
//		Match match = new Match();
//		match.setNum(matchNo);
//		match.setMatchTime(matchTime);
//		match.setScore(score);
//		
//		Team homeTeam = new Team();
//		homeTeam.setNum(homeTeamNo);
//				
//		Team awayTeam = new Team();
//		awayTeam.setNum(awayTeamNo);
//				
//		Team winTeam = new Team();
//		winTeam.setNum(winTeamNo);
//				
//		Loc loc = new Loc();
//		loc.setNum(locNo);
//		
//		match.setWinTeam(winTeam);
//		match.setAwayTeam(awayTeam);
//		match.setHomeTeam(homeTeam);
//		match.setLoc(loc);
//		
//		MatchDAO.updateMatch(match);
//		
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/MatchService?method=editMatch&matchno="
//						+ matchNo);
//		rd.forward(request, response);
	}

	/**
	 * 메치 데이터 삭제 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String removeMatch() throws Exception {
		/* default generated stub */;
		MatchDAO.deleteMatch(matchno);
		
		SUCCESS = "경기 데이터를 삭제 하였습니다.";
		return "success";
//		String matchNum = request.getParameter("matchno");
//		MatchDAO.deleteMatch(matchno);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/MatchService?method=viewMatchList");
//		rd.forward(request, response);
	}

	/**
	 * 모든 메치 데이터 조회
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public String viewMatchList() throws Exception{
		/* default generated stub */
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = MemberDAO.selectMineralByID(ID);
			RANK = MemberDAO.selectMemberRanking(ID);
		}
		int length=10;
		if(page==0){
			page=1;
		}
		MATCH_LIST = MatchDAO.selectMatchList(page,length);
		int matchCount = MatchDAO.selectMatchCount();
		PAGE_LINK_TAG = PageUtil.generate(page, matchCount, length,
			"viewMatchList.action");
		return "success";
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//		
//			long mineral=MemberDAO.selectMineralByID(ID);
//			request.setAttribute("MINERAL", mineral);
//		
//			long rank =MemberDAO.selectMemberRanking(ID);
//			request.setAttribute("RANK", rank);
//		}
//		int page = 1;
//		if (request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
//		int length = 10;
//
//		List<Match> matchList = MatchDAO.selectMatchList(page,length);
//		request.setAttribute("MATCH_LIST", matchList);
//		int matchCount = MatchDAO.selectMatchCount();
//		String pageLinkTag = PageUtil.generate(page, matchCount, length,
//				"MatchService?method=viewMatchList");
//		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/match/viewMatchList.jsp");
//		rd.forward(request, response);

	}

//	/**
//	 * 선택한 번호의 메치데이
//	 * 
//	 * @param request
//	 * @param response
//	 */
//
//	public void veiwMatch(HttpServletRequest request,
//			HttpServletResponse response) {
//		/* default generated stub */;
//
//	}

}
