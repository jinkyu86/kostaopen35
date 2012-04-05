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
		 * ��� ���� �޼���
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
		
		request.setAttribute("SUCCESS","���������� �����Ͽ����ϴ�.");
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");

		rd.forward(request, response);
	}

	/**
	 * ��� ������ ���� �� �޼���
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
		 * ����� ���̵� ������ ������ üũ�ϴ� �޼���
		 * 
		 * @param request
		 * @param response
		 */

		String userid = request.getParameter("userid");
		Member checkuserID = MemberDAO.selectMemberByID(userid);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (checkuserID == null) {
			out.print(userid + "�� ��� ������ ���̵� �Դϴ�.");
		} else {
			out.print(userid + "�� �̹� ������� ���̵� �Դϴ�.");
		}
		out.flush();
		out.close();

	}

	public void editMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;

		/**
		 * ��������͸� ����Ʈ �ϴ� �޼���
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
		 * ��� �����͸� ����Ʈ�ϱ� ���� ���� �����͸� �ޱ����� �޼���
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
		 * �α��� �޼���
		 * 
		 * @param request
		 * @param response
		 */
		
		
		String id = request.getParameter("id");

		String pw = request.getParameter("pw");

		Member member = MemberDAO.selectMemberByID(id);

		if (member == null) {
			request.setAttribute("ERROR", "�������� �ʴ� ���̵�");
		} else {

			if (!member.getPw().equals(pw)) {
				request.setAttribute("ERROR", "��й�ȣ ����");
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
		 * �α׾ƿ��޼���
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
		 * ���� Ż�� ���� �޼���
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
		 * ��� ��� �����͸� ��ȸ�ϴ� �޼���
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
	 * ��� �������Ʈ�� �̳׶��� �������� ������ �޼���
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
		 * ��ŷ�������� �� ���� �޼���
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
