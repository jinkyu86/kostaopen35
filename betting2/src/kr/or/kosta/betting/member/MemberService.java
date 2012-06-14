package kr.or.kosta.betting.member;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.betting.aop.IService;
import kr.or.kosta.betting.util.PageUtil;


/**
 * Servlet implementation class MemberService
 */
public class MemberService implements ModelDriven,IService
	,SessionAware{
	private int maxPage;
	private IMember memberDAO;
	private Map session;
	private Member member = new Member();
	private int page;
	private String SUCCESS;
	private Member MEMBER;
	private long MINERAL;
	private long RANK;
	private String PAGE_LINK_TAG;
	private String id;
	private List<Member> MEMBER_LIST;
	private InputStream resultStream;
	
	
	public MemberService() {
		super();
	}

	public MemberService(IMember memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	
	
	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public InputStream getResultStream() {
		return resultStream;
	}

	public void setResultStream(InputStream resultStream) {
		this.resultStream = resultStream;
	}

	public List<Member> getMEMBER_LIST() {
		return MEMBER_LIST;
	}

	public void setMEMBER_LIST(List<Member> mEMBER_LIST) {
		MEMBER_LIST = mEMBER_LIST;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}

	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}

	public Member getMEMBER() {
		return MEMBER;
	}

	public void setMEMBER(Member mEMBER) {
		MEMBER = mEMBER;
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
		// TODO Auto-generated method stub
		return member;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public MemberService() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		/**
//		 * @see HttpServlet#doPost(HttpServletRequest request,
//		 *      HttpServletResponse response)
//		 */
//
//		request.setCharacterEncoding("utf-8");
//		String method = request.getParameter("method");
//		if (method == null) {
//			method = "viewMemberList";
//		}
//		if ("viewMemberList".equals(method)) {
//			viewMemberList(request, response);
//		} else if ("editMemberForm".equals(method)) {
//			editMemberForm(request, response);
//		} else if ("editMember".equals(method)) {
//			editMember(request, response);
//		} else if ("removeMember".equals(method)) {
//			removeMember(request, response);
//		} else if ("addMemberForm".equals(method)) {
//			addMemberForm(request, response);
//		} else if ("addMember".equals(method)) {
//			addMember(request, response);
//		} else if ("loginForm".equals(method)) {
//			loginForm(request, response);
//		} else if ("login".equals(method)) {
//			login(request, response);
//		} else if ("logout".equals(method)) {
//			logout(request, response);
//		} else if ("checkMemberID".equals(method)) {
//			checkMemberID(request, response);
//		} else if ("viewMemberRankingListForm".equals(method)) {
//			viewMemberRankingListForm(request, response);
//		} else if("viewMember".equals(method)){
//			viewMember(request,response);
//		} else if("viewHome".equals(method)){
//			viewHome(request,response);
//		}
//	}// end method doPost



	
	public String viewHome() throws Exception{
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			MEMBER = memberDAO.selectMemberByID(ID);
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
			
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
//			
//			RequestDispatcher rd = request
//					.getRequestDispatcher("index.jsp");
//			rd.forward(request, response);
//		
	}

	public String addMember() throws Exception {

		/**
		 * ��� ���� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		Member checkuserID = memberDAO.selectMemberByID(member.getId());
		if (checkuserID == null) {
			memberDAO.insultMember(member);
			SUCCESS = member.getId()
						+"�� ������ �����մϴ�. 5000�̳׶��� ���޵˴ϴ�.";
			return "success";
		} else {
			SUCCESS = member.getId()
					+"�� ����� �� ���� ���̵� �Դϴ�.";
			return "error";
		}
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String pw = request.getParameter("pw");
//		String email = request.getParameter("email");
//
//		Member member = new Member();
//		member.setId(id);
//		member.setName(name);
//		member.setPw(pw);
//		member.setEmail(email);

//		MemberDAO.insultMember(member);
//		
//		request.setAttribute("SUCCESS", name+"���� ������ �����մϴ�. 5000�̳׶��� ���޵˴ϴ�.");
//		RequestDispatcher rd = request
//				.getRequestDispatcher("index.jsp");
//
//		rd.forward(request, response);
	}

	/**
	 * ��� ������ ���� �� �޼���
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public String addMemberForm() throws Exception{
		SUCCESS="��������";
		return "success";
//		List<Member> memberList = MemberDAO.selectMemberList(1, 5);
//
//		request.setAttribute("MEMBER_LIST", memberList);
//
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/member/addMember.jsp");
//
//		rd.forward(request, response);
	}

	public String checkMemberID() throws IOException {
		/* default generated stub */;

		/**
		 * ����� ���̵� ������ ������ üũ�ϴ� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		Member checkuserID = memberDAO.selectMemberByID(id);
		String msg = null;
		if (checkuserID == null) {
			msg = id + "�� ��� ������ ���̵� �Դϴ�.";
		} else {
			msg = id  + "�� �̹� ������� ���̵� �Դϴ�.";
		}
		byte[] msgArray=msg.getBytes("UTF-8");
		resultStream = new ByteArrayInputStream(msgArray);
		return "success";
//		String userid = request.getParameter("id");
//		Member checkuserID = MemberDAO.selectMemberByID(userid);
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		if (checkuserID == null) {
//			out.print(userid + "�� ��� ������ ���̵� �Դϴ�.");
//		} else {
//			out.print(userid + "�� �̹� ������� ���̵� �Դϴ�.");
//		}
//		out.flush();
//		out.close();

	}

	public String editMember() throws Exception{
		/* default generated stub */;

		/**
		 * ��������͸� ����Ʈ �ϴ� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		memberDAO.updateMember(member);
		SUCCESS = member.getId()+"���� ������ �����Ͽ����ϴ�.";
		return "success";
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String pw = request.getParameter("pw");
//		String email = request.getParameter("email");
//
//		Member member = new Member();
//		member.setId(id);
//		member.setName(name);
//		member.setPw(pw);
//		member.setEmail(email);
//
//		MemberDAO.updateMember(member);
//
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/MemberService?method=viewMemberList");
//
//		rd.forward(request, response);

	}

	public String editMemberForm() throws Exception{
		/* default generated stub */;

		/**
		 * ��� �����͸� ����Ʈ�ϱ� ���� ���� �����͸� �ޱ����� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		String ID = null;
		if(id!=null){
			ID=id;
		}else{
			Member member = (Member)session.get("LOGIN_MEMBER");
			ID=member.getId();
		}
		MEMBER = memberDAO.selectMemberByID(ID);
		MINERAL = memberDAO.selectMineralByID(ID);
		RANK = memberDAO.selectMemberRanking(ID);
		return "success";
//		HttpSession session=request.getSession();
//			
//		Member member1=(Member)session.getAttribute("LOGIN_MEMBER");
//		String ID = member1.getId();
//
//		Member member = MemberDAO.selectMemberByID(ID);
//		
//		
//		request.setAttribute("MEMBER", member);
//		long mineral=MemberDAO.selectMineralByID(ID);
//		request.setAttribute("MINERAL", mineral);
//	
//		long rank =MemberDAO.selectMemberRanking(ID);
//		request.setAttribute("RANK", rank);
//		
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/member/editMember.jsp");
//		rd.forward(request, response);

	}

	public String login()throws Exception{
		/* default generated stub */;

		/**
		 * �α��� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		if(session.get("LOGIN_MEMBER")==null){
			String id = member.getId();
			String pw = member.getPw();
			System.out.println("���̵�"+id);
			Member member1 = memberDAO.selectMemberByID(id);
			if (member1 == null) {
				SUCCESS = "�������� �ʴ� ���̵� �Դϴ�.";
			} else {

				if (!member1.getPw().equals(pw)) {
					SUCCESS="��й�ȣ�� Ʋ���ϴ�.";
				} else {
					session.put("LOGIN_MEMBER", member1);
					SUCCESS = member.getId()+"�� ȯ���մϴ�.";
				}
			}
		}
		return "success";
//		String id = request.getParameter("id");
//
//		String pw = request.getParameter("pw");
//
//		Member member = MemberDAO.selectMemberByID(id);
//
//		if (member == null) {
//			request.setAttribute("ERROR", "�������� �ʴ� ���̵�");
//		} else {
//
//			if (!member.getPw().equals(pw)) {
//				request.setAttribute("ERROR", "��й�ȣ ����");
//			} else {
//
//				HttpSession session = request.getSession();
//				session.setAttribute("LOGIN_MEMBER", member);
//				
//				long mineral=MemberDAO.selectMineralByID(id);
//				request.setAttribute("MINERAL", mineral);
//				
//				long rank =MemberDAO.selectMemberRanking(id);
//				request.setAttribute("RANK", rank);
//				request.setAttribute("SUCCESS", id+"���� �α��� �ϼ̽��ϴ�.");
//			}// end else
//		}// end if
//		
//		RequestDispatcher rd = request
//				.getRequestDispatcher("index.jsp");
//		rd.forward(request, response);
//		

	}

	public String loginForm() throws Exception{
		
		return "success";	
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/member/login.jsp");
//		rd.forward(request, response);

	}

	public String logout() throws Exception{
		/* default generated stub */;

		/**
		 * �α׾ƿ��޼���
		 * 
		 * @param request
		 * @param response
		 */
		session.remove("LOGIN_MEMBER");
		return "success";
//		HttpSession session = request.getSession();
//		session.invalidate();
//		RequestDispatcher rd = request
//				.getRequestDispatcher("index.jsp");
//		rd.forward(request, response);

	}

	public String removeMember() throws Exception{
		/* default generated stub */;

		/**
		 * Ż�� ���� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		memberDAO.deleteMember(id);
		Member member = (Member)session.get("LOGIN_MEMBER");
		String ID = member.getId();
		if(ID.equals("kosta100")){
			SUCCESS = id+"���� Ż�� ���׽��ϴ�.";
		}else{
			session.remove("LOGIN_MEMBER");
			SUCCESS = "�׵��� �̿����ּż� �����մϴ�.";
		}
		
		return "success";
//		String ID = request.getParameter("ID");
//		MemberDAO.deleteMember(ID);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/MemberService?method=viewMemberList");
//		rd.forward(request, response);

	}

	public String viewMemberList() throws Exception{
		/* default generated stub */;

		/**
		 * ��� ��� �����͸� ��ȸ�ϴ� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		int length=5;
		if(page==0){
			page=1;
		}
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			MEMBER = memberDAO.selectMemberByID(ID);
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
		}
		MEMBER_LIST = memberDAO.selectMemberList(length, page);
		int memberCount = memberDAO.selectMemberCount();
		PAGE_LINK_TAG = PageUtil.generate(page, memberCount, length,
				"/betting/viewMemberList.action");
		maxPage=(memberCount/length);
		if(memberCount%length!=0){
			maxPage++;
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
//			
//		int page = 1;
//		if (request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
//		int length = 10;
//
//		
//		List<Member> memberList = MemberDAO.selectMemberList(length, page);
//
//		request.setAttribute("MEMBER", memberList);
//
//		int MemberCount = MemberDAO.selectMemberCount();
//		String pageLinkTag = PageUtil.generate(page, MemberCount, length,
//				"/betting/MemberService?method=viewMemberList");
//		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
//	
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/member/viewMemberList.jsp");
//	
//		rd.forward(request, response);

	}

	
	public String viewMemberRankingListForm() throws Exception{
		/* default generated stub */;

		/**
		 * ��ŷ�������� �� ���� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		Member member = (Member)session.get("LOGIN_MEMBER");
		if(member!=null){
			String ID = member.getId();
			MEMBER = memberDAO.selectMemberByID(ID);
			MINERAL = memberDAO.selectMineralByID(ID);
			RANK = memberDAO.selectMemberRanking(ID);
		}
		int length=10;
		if(page==0){
			page=1;
		}
		MEMBER_LIST = memberDAO.selectMemberRankingList(length, page);
		int MemberCount = memberDAO.selectMemberCount();
		PAGE_LINK_TAG = PageUtil.generate(page, MemberCount, length,
				"/betting/viewMemberRankingListForm.action");
		maxPage=(MemberCount/length);
		if(MemberCount%length!=0){
			maxPage++;
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
//			
//		int page = 1;
//		if (request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
//		int length = 10;
//
//		int MemberCount = MemberDAO.selectMemberCount();
//		String pageLinkTag = PageUtil.generate(page, MemberCount, length,
//				"/betting/MemberService?method=viewMemberRankingListForm");
//		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
//
//		List<Member> memberRankingList = MemberDAO
//				.selectMemberRankingList(length, page);
//
//		request.setAttribute("MEMBER_LIST", memberRankingList);
//
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/member/viewMemberRank.jsp");
//
//		rd.forward(request, response);
	}

}
