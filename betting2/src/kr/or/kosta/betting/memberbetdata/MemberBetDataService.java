package kr.or.kosta.betting.memberbetdata;

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
import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.betting.BettingDAO;
import kr.or.kosta.betting.betting.IBetting;
import kr.or.kosta.betting.match.IMatch;
import kr.or.kosta.betting.match.MatchDAO;
import kr.or.kosta.betting.member.IMember;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.member.MemberDAO;
import kr.or.kosta.betting.util.PageUtil;
import kr.or.kosta.betting.util.now;

/**
 * Servlet implementation class MemberBetDataService
 */
public class MemberBetDataService implements ModelDriven,IService
	,SessionAware{
	private int maxPage;
	private IMemberBetData memberBetDataDAO;
	private IBetting bettingDAO;
	private IMember memberDAO;
	private IMatch matchDAO;
	private String method;
	private Map session;
	private int page;
	private String SUCCESS;
	private long MINERAL;
	private long RANK;
	private String PAGE_LINK_TAG;
	private MemberBetData mbd = new MemberBetData();
	private List<MemberBetData> MBD_LIST;
	private String mbdnum;
	private int CHECK;
	private Betting BETTING_HOME;
	private Betting BETTING_AWAY;
	private MemberBetData MBD;
	private String matchtime;
	private String home;
	private String away;
	private long bmineral;
	private String districtnum;
	private long emineral;
	
	
	public MemberBetDataService() {
		super();
	}

	public MemberBetDataService(IMemberBetData memberBetDataDAO,
			IBetting bettingDAO, IMember memberDAO, IMatch matchDAO) {
		super();
		this.memberBetDataDAO = memberBetDataDAO;
		this.bettingDAO = bettingDAO;
		this.memberDAO = memberDAO;
		this.matchDAO = matchDAO;
	}

	
	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
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

	public MemberBetData getMBD() {
		return MBD;
	}

	public void setMBD(MemberBetData mBD) {
		MBD = mBD;
	}

	public String getMatchtime() {
		return matchtime;
	}

	public void setMatchtime(String matchtime) {
		this.matchtime = matchtime;
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

	

	public long getBmineral() {
		return bmineral;
	}

	public void setBmineral(long bmineral) {
		this.bmineral = bmineral;
	}

	public String getDistrictnum() {
		return districtnum;
	}

	public void setDistrictnum(String districtnum) {
		this.districtnum = districtnum;
	}

	public long getEmineral() {
		return emineral;
	}

	public void setEmineral(long emineral) {
		this.emineral = emineral;
	}

	public List<MemberBetData> getMBD_LIST() {
		return MBD_LIST;
	}

	public void setMBD_LIST(List<MemberBetData> mBD_LIST) {
		MBD_LIST = mBD_LIST;
	}

	public String getMbdnum() {
		return mbdnum;
	}

	public void setMbdnum(String mbdnum) {
		this.mbdnum = mbdnum;
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

	public MemberBetData getMbd() {
		return mbd;
	}

	public void setMbd(MemberBetData mbd) {
		this.mbd = mbd;
	}
	
@Override
	public Map getSession() {
		
		return session;
	}

@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public Object getModel() {
		return mbd;
	}

	//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MemberBetDataService() {
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
//			method = "viewMemberBetDataByIDList";
//		}
//		if ("viewMemberBetDataByIDList".equals(method)) {
//			viewMemberBetDataByIDList(request, response);
//		}else if("viewMBDByIDForm".equals(method)){
//			viewMBDByIDForm(request,response);
//		}else if("cancleBetting".equals(method)){
//			cancleBetting(request,response);
//		}else if("giveMineral".equals(method)){
//			giveMineral(request,response);
//		}else if("recoveryMineral".equals(method)){
//			recoveryMineral(request,response);
//		}
//	}
	//파라메터 값 구분 메서드
	public String mineral() throws Exception{
		String result = null;
		if(method.equals("giveMineral")){
			result= "givemineral";
		}else if(method.equals("recoveryMineral")){
			result= "recoverymineral";
		}else if(method.equals("cancleBetting")){
			result="canclemineral";
		}
		return result;
	}
	// 취소나 무승부시 미네랄 복구 시켜주는 메서드
	public String recoveryMineral() throws Exception{
		
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
			
			int confirm = memberBetDataDAO.selectMineralConfirm(mbdnum);
			
			if(confirm==1){
				SUCCESS="이미 지급하였습니다.";
				return "success";
			}			
			MINERAL = MINERAL + emineral;
			
			member.setMineral(MINERAL);
			memberDAO.updateMineralByID(member);
			memberBetDataDAO.updateMemberBetData(mbdnum);
			
			SUCCESS= "미네랄을 되돌려 드렸습니다.";
			return "success";
		} else {
			SUCCESS= "로그인 해주세요";
		
			
		}
		return "login";	
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//			long betMineral = Long.parseLong(request.getParameter("bmineral"));
//			long mineral = MemberDAO.selectMineralByID(ID);
//			String mbdNum = request.getParameter("mbdnum");
//			int confirm = MemberBetDataDAO.selectMineralConfirm(mbdNum);
//			
//			if(confirm==1){
//				request.setAttribute("ERROR", "이미 지급하였습니다.");
//				RequestDispatcher rd = request
//						.getRequestDispatcher("/MemberBetDataService?method=viewMBDByIDForm&mbdnum="+mbdNum);
//				rd.forward(request, response);
//				return;
//			}
//			mineral = mineral + betMineral;
//			
//			Member member = new Member();
//			member.setId(ID);
//			member.setMineral(mineral);
//			MemberDAO.updateMineralByID(member);
//			MemberBetDataDAO.updateMemberBetData(mbdNum);
//
//			request.setAttribute("SUCCESS", "미네랄을 돌려드렸습니다.");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("MemberBetDataService?method=viewMBDByIDForm&mbdnum="+mbdNum);
//			rd.forward(request, response);
//		} else {
//			request.setAttribute("ERROR", "로그인 해주세요");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/MemberService?method=loginForm");
//			rd.forward(request, response);
//		}
//		
	}

	/**
	 * 베팅 취소 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String cancleBetting() throws Exception{
		/* default generated stub */;
		Member member = (Member)session.get("LOGIN_MEMBER");
		String result = null;
		if(member!=null){
			String ID = member.getId();
			    
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
			int check = now.hourCheck(matchtime);
			
			MemberBetData mbd1 = memberBetDataDAO.selectMemberBetData(mbdnum);
			
			if(mbd1==null){
				SUCCESS="이미 취소하였습니다.";
				return "success";
			}			
			
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
					homeSeleRating = homeSeleRating - 1;
					homeTotMineral = homeTotMineral - bmineral;

					homeBetRating = ((double) homeTotMineral + awayTotMineral)
							/ homeTotMineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
							/ awayTotMineral;
					MINERAL = MINERAL + bmineral;
					
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

					member.setMineral(MINERAL);
					memberDAO.updateMineralByID(member);

					memberBetDataDAO.deleteMemberbetData(mbdnum);
				
					SUCCESS = "베팅을 취소하였습니다.";
					result="success";
				} else {

					awaySeleRating = awaySeleRating - 1;
					awayTotMineral = awayTotMineral - bmineral;
					awayBetRating = ((double) homeTotMineral + awayTotMineral)
							/ awayTotMineral;
					homeBetRating = ((double) homeTotMineral + awayTotMineral)
							/ homeTotMineral;
					MINERAL = MINERAL + bmineral;

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

					member.setMineral(MINERAL);
					memberDAO.updateMineralByID(member);

					memberBetDataDAO.deleteMemberbetData(mbdnum);
					SUCCESS = "베팅을 취소하였습니다.";
					result="success";
				}
			} else {
				SUCCESS= "경기가 시작되어 취소 할 수 없습니다.";
				result="cancle";
			}
		} else {
			SUCCESS = "로그인 해주세요";
			result="login";
		}
		return result;
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//			String matchTime = request.getParameter("matchtime");
//			int check = now.hourCheck(matchTime);
			
//			if (check == 1) {
//
//				String mbdNum = request.getParameter("mbdnum");
//				String distNum = request.getParameter("distnum");
//				long betMineral = Long.parseLong(request.getParameter("bmineral"));
//				String homeBetNum = request.getParameter("home");
//				String awayBetNum = request.getParameter("away");
//				double homeBetRating = BettingDAO.selectBettingRating(homeBetNum);
//				double awayBetRating = BettingDAO.selectBettingRating(awayBetNum);
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
//					homeSeleRating = homeSeleRating - 1;
//					homeTotMineral = homeTotMineral - betMineral;
//					homeBetRating = ((double) homeTotMineral + awayTotMineral)
//						/ homeTotMineral;
//					awayBetRating = ((double) homeTotMineral + awayTotMineral)
//						/ awayTotMineral;
//					mineral = mineral + betMineral;
//
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
//					Member member = new Member();
//					member.setId(ID);
//					member.setMineral(mineral);
//					MemberDAO.updateMineralByID(member);
//
//					MemberBetDataDAO.deleteMemberbetData(mbdNum);

//				} else {
//
//					awaySeleRating = awaySeleRating - 1;
//					awayTotMineral = awayTotMineral - betMineral;
//					awayBetRating = ((double) homeTotMineral + awayTotMineral)
//							/ awayTotMineral;
//					homeBetRating = ((double) homeTotMineral + awayTotMineral)
//							/ homeTotMineral;
//					mineral = mineral + betMineral;
//
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
//					Member member = new Member();
//					member.setId(ID);
//					member.setMineral(mineral);
//					MemberDAO.updateMineralByID(member);
//
//					MemberBetDataDAO.deleteMemberbetData(mbdNum);
//					
//					request.setAttribute("SUCCESS", "성공적으로 베팅을 취소하였습니다.");
//				}
//			} else {
//				request.setAttribute("ERROR", "경기가 시작되어 취소 할 수 없습니다.");
//			}
//			
//			RequestDispatcher rd = request
//				.getRequestDispatcher("/MemberBetDataService?method=viewMemberBetDataByIDList");
//			rd.forward(request, response);
//		} else {
//			request.setAttribute("ERROR", "로그인 해주세요");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/MemberService?method=loginForm");
//			rd.forward(request, response);
//		}
				
	
		
	}

	/**
	 * 베팅 결과 따라 베팅 미네랄 지급
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String giveMineral() throws Exception{
		/* default generated stub */;
		String result = null;
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
			
			int confirm = memberBetDataDAO.selectMineralConfirm(mbdnum);
			
			if(confirm==1){
				SUCCESS="이미 지급하였습니다.";
				return "success";
			}			
			MINERAL = MINERAL + emineral;
			
			member.setMineral(MINERAL);
			memberDAO.updateMineralByID(member);
			memberBetDataDAO.updateMemberBetData(mbdnum);
			
			SUCCESS= "미네랄을 지급하였습니다.";
			result= "success";
		} else {
			SUCCESS= "로그인 해주세요";
		
			result="login";	
		}
		return result;
//		HttpSession session = request.getSession();
//		Member member1 = (Member) session.getAttribute("LOGIN_MEMBER");
//		if (member1 != null) {
//			String ID = member1.getId();
//			long betMineral = Long.parseLong(request.getParameter("emineral"));
//			long mineral = MemberDAO.selectMineralByID(ID);
//			String mbdNum = request.getParameter("mbdnum");
//			int confirm = MemberBetDataDAO.selectMineralConfirm(mbdNum);
//			
//			if(confirm==1){

//				request.setAttribute("ERROR", "이미 지급하였습니다.");
//				RequestDispatcher rd = request
//						.getRequestDispatcher("MemberBetDataService?method=viewMBDByIDForm&mbdnum="+mbdNum);
//				rd.forward(request, response);
//				return;
//			}
		
//			mineral = mineral + betMineral;
//			
//			Member member = new Member();
//			member.setId(ID);
//			member.setMineral(mineral);
//			MemberDAO.updateMineralByID(member);
//			MemberBetDataDAO.updateMemberBetData(mbdNum);
//			
//			request.setAttribute("SUCCESS", "미네랄을 지급하였습니다.");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/MemberBetDataService?method=viewMBDByIDForm&mbdnum="+mbdNum);
//			rd.forward(request, response);
//		} else {
//			request.setAttribute("ERROR", "로그인 해주세요");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/MemberService?method=loginForm");
//			rd.forward(request, response);
//		}
	}

	/**
	 * 선택된 아이디의 멤버 베팅 테이터 조회 메서드 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String viewMemberBetDataByIDList() throws Exception{
		/* default generated stub */;
		Member member = (Member)session.get("LOGIN_MEMBER");
		//if(member!=null){
			String ID = member.getId();
			
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
		
		int length=5;
		if(page==0){
			page=1;
		}
		MBD_LIST = memberBetDataDAO
				.selectMemberBetDataListByID(page, length, ID);
		int mbdCount = memberBetDataDAO.selectMemberBetDataByIDCount(ID);
		PAGE_LINK_TAG = PageUtil.generate(page, mbdCount, length,
				"viewMemberBetDataByIDList.action");
		maxPage=(mbdCount/length);
		if(mbdCount%length!=0){
			maxPage++;
		}
		return "success";
	}
		
//	} else {
//		SUCCESS= "로그인 해주세요";
//		return "login";
		
	
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
//			
//			int page = 1;
//			if (request.getParameter("page") != null) {
//				page = Integer.parseInt(request.getParameter("page"));
//			}
//			int length = 10;
//
//			List<MemberBetData> mbdList = MemberBetDataDAO
//					.selectMemberBetDataListByID(page, length, ID);
//			request.setAttribute("MBD_LIST", mbdList);
//			int mbdCount = MemberBetDataDAO.selectMemberBetDataByIDCount(ID);
//			String pageLinkTag = PageUtil.generate(page, mbdCount, length,
//					"MemberBetDataService?method=viewMemberBetDataByIDList");
//			request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/mbd/viewMBDByIDList.jsp");
//			rd.forward(request, response);
//		} else {
//			request.setAttribute("ERROR", "로그인 해주세요");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/MemberService?method=loginForm");
//			rd.forward(request, response);
//		}
	


	/**
	 * 선택된 아이디의 멤버 베팅 테이터 조회폼 구현을 위한 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String viewMBDByIDForm() throws Exception {
		/* default generated stub */;
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
			
			String matchNum = memberBetDataDAO.selectMatchNum(mbdnum);
			String matchTime = matchDAO.selectMatchTime(matchNum);
			CHECK = now.hourCheck(matchTime);
			BETTING_HOME = bettingDAO.selectBettingByHome(matchNum);
			BETTING_AWAY = bettingDAO.selectBettingByAway(matchNum);
			MBD = memberBetDataDAO.selectMemberBetData(mbdnum);
			return "success";

		} else {
			SUCCESS= "로그인 해주세요";
			return "login";

		}
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
						
//			String mbdNum = request.getParameter("mbdnum");
//			String matchNum = MemberBetDataDAO.selectMatchNum(mbdNum);
//			String matchTime = MatchDAO.selectMatchTime(matchNum);
//			int check = now.hourCheck(matchTime);
//			request.setAttribute("CHECK", check);
//			Betting bettingHome = BettingDAO.selectBettingByHome(matchNum);
//			request.setAttribute("BETTING_HOME", bettingHome);
//			Betting bettingAway = BettingDAO.selectBettingByAway(matchNum);
//			request.setAttribute("BETTING_AWAY", bettingAway);
//			MemberBetData mbd = MemberBetDataDAO.selectMemberBetData(mbdNum);
//			request.setAttribute("MBD", mbd);
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/mbd/viewMBDByID.jsp");
//			rd.forward(request, response);
//		} else {
//			request.setAttribute("ERROR", "로그인 해주세요");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/MemberService?method=loginForm");
//			rd.forward(request, response);
//		}
	}
	
}
