package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberService extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if(method==null){
			
		}if("addMember".equals(method)){
			addMember(request, response);
		}else if("addMemberForm".equals(method)){
			addMemberForm(request, response);
		}else if("checkMemberEmail".equals(method)){
			checkMemberEmail(request, response);
		}else if("editMember".equals(method)){
			editMember(request, response);
		}else if("editMemberForm".equals(method)){
			editMemberForm(request, response);
		}else if("login".equals(method)){
			login(request, response);
		}else if("logout".equals(method)){
			logout(request, response);
		}else if("loginForm".equals(method)){
			loginForm(request, response);
		}
	
	}
	/**
	 * ȸ���߰�
	 * 
	 * @param request
	 * @param response
	 */
	public void addMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		String pw=request.getParameter("pw");
		
		Member member=new Member();
		member.setEmail(email);
		member.setTel(tel);
		member.setAddress(address);
		member.setPw(pw);
		
		MemberDAO.insertMember(member);
		
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMemberList");
		rd.forward(request, response);
		
	}

	/**
	 * ȸ������ â
	 * 
	 * @param request
	 * @param response
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		RequestDispatcher rd=request.getRequestDispatcher("/member/addMember.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * ȸ�����Խ� �ߺ� email �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public void checkMemberEmail(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		
		String email=request.getParameter("email");
		Member member=MemberDAO.selectMember(email);
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		if (member==null) {
			System.out.println(email+"�� ��� ������ ���̵��Դϴ�.");
			out.print(email+"�� ��� ������ ���̵� �Դϴ�.");
		} else {
			System.out.println(email+"�̹� ������� ���̵��Դϴ�.");
			out.print(email+"�� �̹� ������� ���̵� �Դϴ�.");
		}
		
		out.flush();
		out.close();
		
	}

	/**
	 * ȸ������ ����
	 * 
	 * @param request
	 * @param response
	 */
	public void editMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String pw=request.getParameter("pw");
		String tel=request.getParameter("tel");
		
		Member member=new Member();
		member.setAddress(address);
		member.setEmail(email);
		member.setPw(pw);
		member.setTel(tel);
		
		MemberDAO.updateMember(member);
		
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMember&email="+email);
		rd.forward(request, response);
		
	}

	/**
	 * ȸ������ ���� â
	 * 
	 * @param request
	 * @param response
	 */
	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * �α��� ó��
	 * 
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * �α���â
	 * 
	 * @param request
	 * @param response
	 */
	public void loginForm(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * �α׾ƿ� ó��
	 * 
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * ȸ�� Ż��/����
	 * 
	 * @param request
	 * @param response
	 */
	public void removeMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * ȸ����������
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * ȸ����� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * ȸ����� �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}
}
