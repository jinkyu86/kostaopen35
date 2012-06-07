package kr.or.kosta.betting.betting;

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

import kr.or.kosta.betting.aop.IService;
import kr.or.kosta.betting.match.IMatch;
import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.match.MatchDAO;
import kr.or.kosta.betting.member.IMember;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.member.MemberDAO;
import kr.or.kosta.betting.memberbetdata.IMemberBetData;
import kr.or.kosta.betting.memberbetdata.MemberBetData;
import kr.or.kosta.betting.memberbetdata.MemberBetDataDAO;
import kr.or.kosta.betting.util.now;

/**
 * Servlet implementation class BettingService
 */
public class BettingService implements ModelDriven,IService
	,SessionAware{
	private IBetting bettingDAO;
	private IMember memberDAO;
	private IMatch matchDAO;
	private IMemberBetData memberBetDataDAO;
	private Map session;
	private Betting betting = new Betting();
	private String SUCCESS;
	private long MINERAL;
	private long RANK;
	private String matchno;
	private List<Match> TODAY_MATCH;
	private String matchtime;
	private String districtnum;
	private long betmineral;
	private String home;
	private String away;
	private int CHECK;
	private Betting BETTING_HOME;
	private Betting BETTING_AWAY;
	
	
	public BettingService() {
		super();
	}


	public BettingService( IMember memberDAO,IBetting bettingDAO,
			IMatch matchDAO, IMemberBetData memberBetDataDAO) {
		super();
		this.memberDAO = memberDAO;
		this.bettingDAO = bettingDAO;
		this.matchDAO = matchDAO;
		this.memberBetDataDAO = memberBetDataDAO;
	}


	public String getMatchtime() {
		return matchtime;
	}

	public void setMatchtime(String matchtime) {
		this.matchtime = matchtime;
	}

	

	public String getDistrictnum() {
		return districtnum;
	}

	public void setDistrictnum(String districtnum) {
		this.districtnum = districtnum;
	}

	public long getBetmineral() {
		return betmineral;
	}

	public void setBetmineral(long betmineral) {
		this.betmineral = betmineral;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public int getCHECK() {
		return CHECK;
	}

	public void setCHECK(int cHECK) {
		CHECK = cHECK;
	}

	public Betting getBETTING_HOME() {
		return BETTING_HOME;
	}

	public void setBETTING_HOME(Betting bETTING_HOME) {
		BETTING_HOME = bETTING_HOME;
	}

	public Betting getBETTING_AWAY() {
		return BETTING_AWAY;
	}

	public void setBETTING_AWAY(Betting bETTING_AWAY) {
		BETTING_AWAY = bETTING_AWAY;
	}

	public List<Match> getTODAY_MATCH() {
		return TODAY_MATCH;
	}

	public void setTODAY_MATCH(List<Match> tODAY_MATCH) {
		TODAY_MATCH = tODAY_MATCH;
	}

	public String getMatchno() {
		return matchno;
	}

	public void setMatchno(String matchno) {
		this.matchno = matchno;
	}

	public Betting getBetting() {
		return betting;
	}

	public void setBetting(Betting betting) {
		this.betting = betting;
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
	
	
	@Override
	public Map getSession() {
		// TODO Auto-generated method stub
		return session;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public Object getModel() {
		return betting;
	}

	//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BettingService() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request,response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String method = request.getParameter("method");
//		if (method == null) {
//			method = "todayBettingList";
//		}
//		if("bettingGameForm".equals(method)){
//			bettingGameForm(request,response);
//		}else if("todayBettingList".equals(method)){
//			todayBettingList(request,response);
//		}else if("insertBetting".equals(method)){
//			insertBetting(request,response);
//		}else if("bettingGame".equals(method)){
//			bettingGame(request,response);
//		}
//	}
	//베팅 테이블 삽입 메서드
	public String insertBetting() throws Exception {

		bettingDAO.insertHomeBetting(matchno);
		bettingDAO.insertAwayBetting(matchno);
		SUCCESS = "경기정보가 베팅 테이블에 삽입 되었습니다.";
		return "success";
//		String matchNum = request.getParameter("matchno");
//		
//		BettingDAO.insertHomeBetting(matchNum);
//		BettingDAO.insertAwayBetting(matchNum);
//		
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/MatchService?method=viewMatchList");
//		rd.forward(request, response);
		
	}

	//오늘자 베팅 리스트 조회
	public String todayBettingList() throws Exception{
		
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
		}
		String date = now.Date();
		TODAY_MATCH = matchDAO.selectMatchByDate(date);
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
//		String date = now.Date();
//		List<Match> matchList = MatchDAO.selectMatchByDate(date);
//		request.setAttribute("TODAY_MATCH",matchList);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/betting/todayBettingList.jsp");
//		rd.forward(request, response);
		
	}


	/**
	 * 베팅 알고리즘 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String bettingGame() throws Exception{
		/* default generated stub */;
		Member member = (Member)session.get("LOGIN_MEMBER");
		String ID = null;
		if(member!=null){
			ID = member.getId();
			
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
		
			int check = now.hourCheck(matchtime);
		
			if (check == 1) {
				double homeBetRating = bettingDAO
					.selectBettingRating(home);
				double awayBetRating = bettingDAO
					.selectBettingRating(away);
				long homeSeleRating = bettingDAO
					.selectBettingSeleRating(home);
				long awaySeleRating = bettingDAO
					.selectBettingSeleRating(away);
				long homeTotMineral = bettingDAO
					.selectBettingTotMineral(home);
				long awayTotMineral = bettingDAO
					.selectBettingTotMineral(away);
				
				
				if (districtnum.equals("1")) {
					homeSeleRating = homeSeleRating + 1;
					homeTotMineral = homeTotMineral + betmineral;

					homeBetRating = ((double) homeTotMineral + awayTotMineral)
							/ homeTotMineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
							/ awayTotMineral;
					MINERAL = MINERAL - betmineral;
					
					if(MINERAL<0){
						SUCCESS ="미네랄이 부족합니다.";
						return "success";
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
					hBetting.setNum(home);

					bettingDAO.updateBetting(hBetting);

					Betting aBetting = new Betting();
					aBetting.setBatRating(awayBetRating);
					aBetting.setSeleRating(awaySeleRating);
					aBetting.setTotMineral(awayTotMineral);
					aBetting.setNum(away);

					bettingDAO.updateBetting(aBetting);

					MemberBetData mbd = new MemberBetData();
					mbd.setBetMineral(betmineral);

					member.setMineral(MINERAL);

					mbd.setBetting(hBetting);
					mbd.setMember(member);

					memberBetDataDAO.insultMemberBetData(mbd);
					
					memberDAO.updateMineralByID(member);
					
					SUCCESS="베팅에 참여하셨습니다";
					return "success";
				} else {
					awaySeleRating = awaySeleRating + 1;
					awayTotMineral = awayTotMineral + betmineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
							/ awayTotMineral;
					homeBetRating = ((double) homeTotMineral + awayTotMineral)
							/ homeTotMineral;
					MINERAL = MINERAL - betmineral;
					
					if(MINERAL<0){
						SUCCESS ="미네랄이 부족합니다.";
						return "success";
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
					aBetting.setNum(away);

					bettingDAO.updateBetting(aBetting);

					Betting hBetting = new Betting();
					hBetting.setBatRating(homeBetRating);
					hBetting.setSeleRating(homeSeleRating);
					hBetting.setTotMineral(homeTotMineral);
					hBetting.setNum(home);

					bettingDAO.updateBetting(hBetting);

					MemberBetData mbd = new MemberBetData();
					mbd.setBetMineral(betmineral);

					member.setMineral(MINERAL);

					mbd.setBetting(aBetting);
					mbd.setMember(member);

					memberBetDataDAO.insultMemberBetData(mbd);
					memberDAO.updateMineralByID(member);
					SUCCESS="베팅에 참여하셨습니다.";
					return "success";
				}
			} else {
				SUCCESS= "마감 되었습니다.";
				return "success";
			}
		} else {
			SUCCESS= "로그인 하셔야 베팅에 참여 하실 수 있습니다.";
			return "login";
		}
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//			String matchTime = request.getParameter("matchtime");
//			int check = now.hourCheck(matchTime);
//			
//			if (check == 1) {
//
//				String distNum = request.getParameter("distnum");
//				long betMineral = Long.parseLong(request
//						.getParameter("betmineral"));
//				String homeBetNum = request.getParameter("home");
//				String awayBetNum = request.getParameter("away");
//				double homeBetRating = BettingDAO
//						.selectBettingRating(homeBetNum);
//				double awayBetRating = BettingDAO
//						.selectBettingRating(awayBetNum);
//				long homeSeleRating = BettingDAO
//						.selectBettingSeleRating(homeBetNum);
//				long awaySeleRating = BettingDAO
//						.selectBettingSeleRating(awayBetNum);
//				long homeTotMineral = BettingDAO
//						.selectBettingTotMineral(homeBetNum);
//				long awayTotMineral = BettingDAO
//						.selectBettingTotMineral(awayBetNum);
//				long mineral = MemberDAO.selectMineralByID(ID);

//				if (distNum.equals("1")) {
//					homeSeleRating = homeSeleRating + 1;
//					homeTotMineral = homeTotMineral + betMineral;
//
//					homeBetRating = ((double) homeTotMineral + awayTotMineral)
//							/ homeTotMineral;
//					awayBetRating = ((double) homeTotMineral + awayTotMineral)
//							/ awayTotMineral;
//					mineral = mineral - betMineral;
//					
//					if(mineral<0){
//						String matchNum = request.getParameter("matchno");
//						request.setAttribute("ERROR", "미네랄이 부족합니다.");
//						RequestDispatcher rd = request
//								.getRequestDispatcher("/BettingService?method=bettingGameForm&matchno="+matchNum);
//						rd.forward(request, response);
//						return;
//					}
//					if (homeTotMineral == 0) {
//						homeBetRating = 1;
//					}
//					if (awayTotMineral == 0) {
//						awayBetRating = 1;
//					}
//
//					Betting hBetting = new Betting();
//					hBetting.setBatRating(homeBetRating);
//					hBetting.setSeleRating(homeSeleRating);
//					hBetting.setTotMineral(homeTotMineral);
//					hBetting.setNum(homeBetNum);
//
//					BettingDAO.updateBetting(hBetting);
//
//					Betting aBetting = new Betting();
//					aBetting.setBatRating(awayBetRating);
//					aBetting.setSeleRating(awaySeleRating);
//					aBetting.setTotMineral(awayTotMineral);
//					aBetting.setNum(awayBetNum);
//
//					BettingDAO.updateBetting(aBetting);
//
//					MemberBetData mbd = new MemberBetData();
//					mbd.setBetMineral(betMineral);
//
//					Betting betting1 = new Betting();
//					betting1.setNum(homeBetNum);
//
//					Member member = new Member();
//					member.setId(ID);
//					member.setMineral(mineral);
//
//					mbd.setBetting(betting1);
//					mbd.setMember(member);
//
//					MemberBetDataDAO.insultMemberBetData(mbd);
//					
//					MemberDAO.updateMineralByID(member);
//					request.setAttribute("SUCCESS", "성공적으로 베팅에 참여하였습니다.");
//				} else {
//					awaySeleRating = awaySeleRating + 1;
//					awayTotMineral = awayTotMineral + betMineral;
//					awayBetRating = ((double) homeTotMineral + awayTotMineral)
//							/ awayTotMineral;
//					homeBetRating = ((double) homeTotMineral + awayTotMineral)
//							/ homeTotMineral;
//					mineral = mineral - betMineral;
					
//					if(mineral<0){
//						String matchNum = request.getParameter("matchno");
//						request.setAttribute("ERROR", "미네랄이 부족합니다.");
//						RequestDispatcher rd = request
//								.getRequestDispatcher("/BettingService?method=bettingGameForm&matchno="+matchNum);
//						rd.forward(request, response);
//						return;
//					}
					
//					if (homeTotMineral == 0) {
//						homeBetRating = 1;
//					}
//					if (awayTotMineral == 0) {
//						awayBetRating = 1;
//					}
//
//					Betting aBetting = new Betting();
//					aBetting.setBatRating(awayBetRating);
//					aBetting.setSeleRating(awaySeleRating);
//					aBetting.setTotMineral(awayTotMineral);
//					aBetting.setNum(awayBetNum);
//
//					BettingDAO.updateBetting(aBetting);
//
//					Betting hBetting = new Betting();
//					hBetting.setBatRating(homeBetRating);
//					hBetting.setSeleRating(homeSeleRating);
//					hBetting.setTotMineral(homeTotMineral);
//					hBetting.setNum(homeBetNum);
//
//					BettingDAO.updateBetting(hBetting);
//
//					MemberBetData mbd = new MemberBetData();
//					mbd.setBetMineral(betMineral);
//
//					Betting betting1 = new Betting();
//					betting1.setNum(awayBetNum);
//
//					Member member = new Member();
//					member.setId(ID);
//					member.setMineral(mineral);
//
//					mbd.setBetting(betting1);
//					mbd.setMember(member);
//
//					MemberBetDataDAO.insultMemberBetData(mbd);
//					MemberDAO.updateMineralByID(member);
//					request.setAttribute("SUCCESS", "성공적으로 베팅에 참여하였습니다.");
//				}
//			} else {
//				request.setAttribute("ERROR", "마감 되었습니다.");
//			}
//			
//			String matchNum = request.getParameter("matchno");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/BettingService?method=bettingGameForm&matchno="+matchNum);
//			rd.forward(request, response);
//		} else {
//			request.setAttribute("ERROR", "로그인 해주세요.");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/MemberService?method=loginForm");
//			rd.forward(request, response);
//		}
//		
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
	public String bettingGameForm() throws Exception{
		/* default generated stub */;
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
		}
		String matchTime = matchDAO.selectMatchTime(matchno);
		CHECK = now.hourCheck(matchTime);
		BETTING_HOME = bettingDAO.selectBettingByHome(matchno);
		BETTING_AWAY = bettingDAO.selectBettingByAway(matchno);
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
//		String matchNum = request.getParameter("matchno");
//		String matchTime = MatchDAO.selectMatchTime(matchNum);
//		int check = now.hourCheck(matchTime);
//		request.setAttribute("CHECK", check);
//		Betting bettingHome = BettingDAO.selectBettingByHome(matchNum);
//		request.setAttribute("BETTING_HOME", bettingHome);
//		Betting bettingAway = BettingDAO.selectBettingByAway(matchNum);
//		request.setAttribute("BETTING_AWAY", bettingAway);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/betting/viewBettingGame.jsp");
//		rd.forward(request, response);
	}

}
