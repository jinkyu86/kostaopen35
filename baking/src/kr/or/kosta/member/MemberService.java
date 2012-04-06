package kr.or.kosta.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		String method=request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}else if("loginForm".equals(method)){
			loginForm(request,response);
		}else if("logout".equals(method)){
			logout(request,response);
		}
		
		
	}
	
	
	/**
	 * ȸ����������
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String memberid=request.getParameter("memberid");
		String name=request.getParameter("name");
		String reginum=request.getParameter("reginum");
		
		Member member=MemberDAO.selectMemberByid(name, reginum);
				
				request.setAttribute("Member",member);
				
				RequestDispatcher rd=
						request.getRequestDispatcher(
								"/board/viewBoard.jsp");
				
				rd.forward(request, response);
	}

	/**
	 * ȸ����������
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void editMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
				String memberid=request.getParameter("memberid");
				String password=request.getParameter("password");
				String name=request.getParameter("name");
				String regiNumber=request.getParameter("regiNumber");
				String pwHint=request.getParameter("pwHint");
				String pwAnswer=request.getParameter("pwAnswer");
				String zipcode=request.getParameter("zipcode");
				String address=request.getParameter("address");
				String strAddress=request.getParameter("strAddress");
				String email=request.getParameter("email");
				String phoneNumber=request.getParameter("phoneNumber");
				String telNumber=request.getParameter("telNumber");
				
				
				Member member=new Member();
				member.setMemberid(memberid);
				member.setPassword(password);
				member.setName(name);
				member.setRegiNumber(regiNumber);
				member.setPwHint(pwHint);
				member.setPwAnswer(pwAnswer);
				member.setZipcode(zipcode);
				member.setAddress(address);
				member.setStrAddress(strAddress);
				member.setEmail(email);
				member.setPhoneNumber(phoneNumber);
				member.setTelNumber(telNumber);
				
				MemberDAO.updateMember(member);
				
				RequestDispatcher rd=
						request.getRequestDispatcher(
								"/MemberService?method=viewMember&" +
								"memberid="+memberid);
				
				rd.forward(request, response);
	}

	/**
	 * ȸ������������
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
				String memberid=request.getParameter("memberid");
				String name=request.getParameter("name");
				String reginum=request.getParameter("reginum");
				
				Member member=MemberDAO.selectMemberByid(name, reginum);
				
				request.setAttribute("Member",member);
				
				RequestDispatcher rd=
						request.getRequestDispatcher("/board/editBoard.jsp");
				
				rd.forward(request, response);
	}

	/**
	 * ȸ��Ż��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void removeMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
				String memberid=request.getParameter("memberid");
				String pw=request.getParameter("pw");
				String reginum=request.getParameter("reginum");
				MemberDAO.deleteMember(pw, reginum);
				
				RequestDispatcher rd=
						request.getRequestDispatcher(
								"/MemberService?method=viewMember");
				
				rd.forward(request, response);
	}

	/**
	 * ȸ������
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberid=request.getParameter("memberid");
		String name=
				request.getParameter("name");
		String password=
				request.getParameter("password");
		String regiNumber=
				request.getParameter("regiNumber");
		String pwHint=request.getParameter("pwHint");
		String pwAnswer=
				request.getParameter("pwAnswer");
		String zipcode=
				request.getParameter("zipcode");
	    String address= request.getParameter("address");
		String strAddress= request.getParameter("strAddress");
		String email= request.getParameter("email");
		String phoneNumber= request.getParameter("phoneNumber");
		String telNumber= request.getParameter("telNumber");
		
		
		Member member=new Member();
		member.setMemberid(memberid);
		member.setPassword(password);
		member.setName(name);
		member.setRegiNumber(regiNumber);
		member.setPwHint(pwHint);
		member.setPwAnswer(pwAnswer);
		member.setZipcode(zipcode);
		member.setAddress(address);
		member.setStrAddress(strAddress);
		member.setEmail(email);
		member.setPhoneNumber(phoneNumber);
		member.setTelNumber(telNumber);
		
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/MemberService?method=viewMember");
		rd.forward(request, response);
	}

	/**
	 * ȸ��������
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/member/addMember.jsp");
		rd.forward(request, response);
	}

	/**
	 * �α���
	 */
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberid= request.getParameter("memberid");
		String password = request.getParameter("password");
		Member member = MemberDAO.login(memberid,password);
		if(member!=null){
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN", member);
			RequestDispatcher rd = request.getRequestDispatcher("GoodService?method=viewGoodList");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/member/loginFail.jsp");
			rd.forward(request, response);
		}
		
	
	}

	/**
	 * �α����������̵�
	 */
	public static void loginForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/loginForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * �α׾ƿ�
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("GoodService?method=viewGoodList");
		rd.forward(request, response);
	}

	/**
	 * ���̵��ߺ� Ȯ��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */

//	public void checkMemberID(HttpServletRequest request,
//			HttpServletResponse response) {
//		String memberid=request.getParameter("memberid");
//		String name=request.getParameter("name");
//		String reginum=request.getParameter("reginum");
//		Member member =MemberDAO.selectMemberByid(name,reginum);
//		
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out=response.getWriter();
//		
//		if(member==null){
//			out.print(memberid+"�� ��� ������ ���̵��Դϴ�.");
//		}else{
//			out.print(memberid+"�� �̹� ������� ���̵��Դϴ�.");
//		}
//		out.flush();
//		out.close();
//	}

	public void checkMemberID(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String memberid=request.getParameter("memberid");
		String name=request.getParameter("name");
		String reginum=request.getParameter("reginum");
		Member member =MemberDAO.selectMemberByid(name,reginum);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		if(member==null){
			out.print(memberid+"�� ��� ������ ���̵��Դϴ�.");
		}else{
			out.print(memberid+"�� �̹� ������� ���̵��Դϴ�.");
		}
		out.flush();
		out.close();
	}


	/**
	 * ȸ�����̵� ã��
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberID(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * ȸ�����̵�ã�� ��
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberIDForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * ȸ����й�ȣ ã��
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberPW(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * ȸ����й�ȣã�� ��
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberPwForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * ��й�ȣ ����
	 * 
	 * @param request
	 * @param response
	 */
	public void changeMemberPW(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * ��й�ȣ ���� ��
	 * 
	 * @param request
	 * @param response
	 */
	public void changeMemberPWForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}
}
