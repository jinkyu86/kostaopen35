package kr.or.kosta.betting.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import kr.or.kosta.betting.util.PageUtil;

/**
 * Servlet implementation class MemberService
 */
public class MemberService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */

		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method == null) {
			method = "viewMemberList";
		}
		if ("viewMemberList".equals(method)) {
			viewMemberList(request, response);
		} else if ("editMemberForm".equals(method)) {
			editMemberForm(request, response);
		} else if ("editMember".equals(method)) {
			editMember(request, response);
		} else if ("removeMember".equals(method)) {
			removeMember(request, response);
		} else if ("addMemberForm".equals(method)) {
			addMemberForm(request, response);
		} else if ("addMember".equals(method)) {
			addMember(request, response);
		} else if ("loginForm".equals(method)) {
			loginForm(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		} else if ("logout".equals(method)) {
			logout(request, response);
		} else if ("checkMemberID".equals(method)) {
			checkMemberID(request, response);
		} else if ("viewMemberRankingListForm".equals(method)) {
			viewMemberRankingListForm(request, response);
		} else if("viewMember".equals(method)){
			viewMember(request,response);
		}
	}// end method doPost

	private void viewMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ID");
		Member member=MemberDAO.selectMemberByID(id);
		
		request.setAttribute("MEMBER", member);

		RequestDispatcher rd = request
				.getRequestDispatcher("/member/editMember.jsp");
		rd.forward(request, response);
		
		
		
	}

	public void addMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 멤버 삽입 메서드
		 * 
		 * @param request
		 * @param response
		 */

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");

		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setPw(pw);
		member.setEmail(email);

		MemberDAO.insultMember(member);
		
		request.setAttribute("SUCCESS","성공적으로 가입하였습니다.");
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");

		rd.forward(request, response);
	}

	/**
	 * 멤버 삽입을 위한 폼 메서드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Member> memberList = MemberDAO.selectMemberList(1, 5);

		request.setAttribute("MEMBER_LIST", memberList);

		RequestDispatcher rd = request
				.getRequestDispatcher("/member/addMember.jsp");

		rd.forward(request, response);
	}

	public void checkMemberID(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		/* default generated stub */;

		/**
		 * 멤버의 아이디가 유일한 값인지 체크하는 메서드
		 * 
		 * @param request
		 * @param response
		 */

		String userid = request.getParameter("userid");
		Member checkuserID = MemberDAO.selectMemberByID(userid);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (checkuserID == null) {
			out.print(userid + "는 사용 가능한 아이디 입니다.");
		} else {
			out.print(userid + "는 이미 사용중인 아이디 입니다.");
		}
		out.flush();
		out.close();

	}

	public void editMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * 멤버데이터를 에디트 하는 메서드
		 * 
		 * @param request
		 * @param response
		 */

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");

		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setPw(pw);
		member.setEmail(email);

		MemberDAO.updateMember(member);

		RequestDispatcher rd = request
				.getRequestDispatcher("/MemberService?method=viewMemberList");

		rd.forward(request, response);

	}

	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * 멤버 데이터를 에디트하기 위한 삽입 데이터를 받기위한 메서드
		 * 
		 * @param request
		 * @param response
		 */
		
		HttpSession session=request.getSession();
		Member member1=(Member)session.getAttribute("LOGIN_MEMBER");
		String ID = member1.getId();

		Member member = MemberDAO.selectMemberByID(ID);

		request.setAttribute("MEMBER", member);

		RequestDispatcher rd = request
				.getRequestDispatcher("/member/editMember.jsp");
		rd.forward(request, response);

	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * 로그인 메서드
		 * 
		 * @param request
		 * @param response
		 */
		
		
		String id = request.getParameter("id");

		String pw = request.getParameter("pw");

		Member member = MemberDAO.selectMemberByID(id);

		if (member == null) {
			request.setAttribute("ERROR", "존재하지 않는 아이디");
		} else {

			if (!member.getPw().equals(pw)) {
				request.setAttribute("ERROR", "비밀번호 오류");
			} else {

				HttpSession session = request.getSession();
				session.setAttribute("LOGIN_MEMBER", member);
			}// end else
		}// end if

		HttpSession session=request.getSession();
		Member member1=(Member)session.getAttribute("LOGIN_MEMBER");
		String ID = member1.getId();

		String rank =MemberDAO.selectMemberRanking(ID);
		request.setAttribute("RANK", rank);
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

	private void loginForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);

	}

	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * 로그아웃메서드
		 * 
		 * @param request
		 * @param response
		 */

		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

	public void removeMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * 가입 탈퇴를 위한 메서드
		 * 
		 * @param request
		 * @param response
		 */

		String ID = request.getParameter("ID");
		MemberDAO.deleteMember(ID);
		RequestDispatcher rd = request
				.getRequestDispatcher("/MemberService?method=viewMemberList");
		rd.forward(request, response);

	}

	public void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * 모든 멤버 데이터를 조회하는 메서드
		 * 
		 * @param request
		 * @param response
		 */

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int length = 10;

		
		ArrayList<Member> memberList = MemberDAO.selectMemberList(length, page);

		request.setAttribute("MEMBER", memberList);

		int MemberCount = MemberDAO.selectMemberCount();
		String pageLinkTag = PageUtil.generate(page, MemberCount, length,
				"/betting/MemberService?method=viewMemberList");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
	
		RequestDispatcher rd = request
				.getRequestDispatcher("/member/viewMemberList.jsp");
	
		rd.forward(request, response);

	}

	
	/**
	 * 모든 멤버리스트를 미네랄로 오름차순 정렬한 메서드
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberRankingList(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	public void viewMemberRankingListForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * 랭킹데이터의 폼 구현 메서드
		 * 
		 * @param request
		 * @param response
		 */

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int length = 10;

		int MemberCount = MemberDAO.selectMemberCount();
		String pageLinkTag = PageUtil.generate(page, MemberCount, length,
				"/betting/MemberService?method=viewMemberRankingListForm");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);

		ArrayList<Member> memberRankingList = MemberDAO
				.selectMemberRankingList(length, page);

		request.setAttribute("MEMBER_LIST", memberRankingList);

		RequestDispatcher rd = request
				.getRequestDispatcher("/member/viewMemberRank.jsp");

		rd.forward(request, response);
	}

}
