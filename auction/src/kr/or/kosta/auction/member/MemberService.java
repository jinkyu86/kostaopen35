package kr.or.kosta.auction.member;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





public class MemberService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 */
	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if(method==null){
			method="editMemberForm";
		}
		if("viewMemberList".equals(method)){
			viewMemberList(request,response);
		}else if ("viewMember".equals(method)) {
			viewMember(request, response);
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
		}
	}// end method doPost
//���� ���� ������ؾߵǴ°� ������ �׿��� ������ٸ��״��� �ù� �� ȣ���� �ȵ� �̰� ������Ʈ �̸��̹���
	
	
		
	

	private void addMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.�Ķ���� ���� ����
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String coin = request.getParameter("coin");
		String emoney = request.getParameter("emoney");
		// 2.Student��ü ���� 1�� �Ӽ��� ����
		Member member = new Member();
		member.setUserid(userid);
		member.setPw(pw);
		member.setEmail(email);
		member.setName(name);
		member.setCoin(coin);
		member.setEmoney(emoney);
		// 3.DB�� ����
		MemberDAO.insertMember(member);
		// 4.��ü �������Ʈ �̵� ��ü
		RequestDispatcher rd = request
				.getRequestDispatcher("/MemberService?method=viewMemberList");
		// 5.������ �̵�
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//3.�л��߰� ������ �̵� ��ü ����
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/member/addMember.jsp");
		//4.������ �̵�
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.�Ķ�������� ����
				String userid=request.getParameter("userid");
				String pw=request.getParameter("pw");
				String email=request.getParameter("email");
				String name=request.getParameter("name");
				String coin=request.getParameter("coin");
				String emoney=request.getParameter("emoney");
				//2.1�� ������ �̿��ؼ� Member��ü ����
				Member  member=new Member();
				member.setUserid(userid);
				member.setPw(pw);
				member.setEmail(email);
				member.setName(name);
				member.setCoin(coin);
				member.setEmoney(emoney);
				
				
				//3.�л������� �����ϴ� �޼��� ȣ��
				MemberDAO.updateMember(member);
				//4.�л����� ��ȸȭ������ �̵� ��ü ����
				RequestDispatcher rd=
						request.getRequestDispatcher(
								"/MemberService?method=viewMemberList" +
								"&userid="+userid);
				rd.forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 */
	private void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.������ �л��� �й� ����
				String userid=request.getParameter("userid");
				//2.������ �л��� ���� ��ȸ
				Member member=MemberDAO.selectMember(userid);
				//3.��ü �а� ����Ʈ ��ȸ
				ArrayList<Member> memberList=
						MemberDAO.selectMemberList();
				//4.request�� ����
				request.setAttribute("Member", member);
				request.setAttribute("MEMBER_LIST",
						memberList);
				//5./student/editStudent.jsp�̵� ��ü ����
				RequestDispatcher  rd=
						request.getRequestDispatcher(	"/member/editMember.jsp");
				rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.userid�Ķ���� ���Ϲ޾Ƽ� ������ ����
				String userid=request.getParameter("userid");
				//2.DB���� ���̵� ��ġ�ϴ� ȸ�� ��ȸ
				Member member=MemberDAO.selectMember(userid);
				//3.request�� 2���� ��ȸ�� �л��� ���� ����
				//   �̸�-MEMBER
				request.setAttribute("MEMBER",member);
				//4./student/viewStudent.jsp�� �̵� ��ü ����
				RequestDispatcher rd=
						request.getRequestDispatcher("/member/viewMember.jsp");
				//5.4�� JSP�� �̵�	
				rd.forward(request, response);
			

	}

	/**
	 * @param request
	 * @param response
	 */
	private void removeMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		MemberDAO.deleteMember(userid);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/MemberService?method=viewMemberList");
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.userid�Ķ���� ����
		String userid = request.getParameter("userid");
		// 2.pw�Ķ���� ����
		String pw = request.getParameter("pw");
		// 3.���̵� ��ġ�ϴ� ȸ������ ��ȸ
		Member member = MemberDAO.selectMemberById(userid);
		// 4.3�� ���ϰ��� null�̸�
		// request�� �Ӽ���:ERROR ��:�������� �ʴ� ���̵�
		// ����
		if (member == null) {
			request.setAttribute("ERROR", "�������� �ʴ� ���̵�");
		} else {
			// 5.3�� ���ϰ��� null�� �ƴϸ� 3�� �л��� �����
			// 2�� �Է��� ��� �� �ٸ���
			// request�� �Ӽ���:ERROR ��:��й�ȣ ���� ����
			if (!member.getPw().equals(pw)) {
				request.setAttribute("ERROR", "��й�ȣ ����");
			} else {
				// 6.5���� ��й�ȣ�� ��ġ�ϸ�
				// HttpSession���� �Ӽ���:LOGIN_MEMBER
				// ��:3�� ��ü
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN_MEMBER", member);
			}// end else
		}// end if
			// 7. /GoodService?method=viewGoodList�� �̵�
		RequestDispatcher rd = request
				.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request
				.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void loginForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/member/login.jsp");
		rd.forward(request, response);

	}
	
	
	private void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> memberList=	MemberDAO.selectMemberList();
		request.setAttribute("MEMBER_LIST",memberList);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/member/viewMemberList.jsp");
		rd.forward(request, response);
	}
}
