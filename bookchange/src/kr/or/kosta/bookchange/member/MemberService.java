package kr.or.kosta.bookchange.member;

import java.io.IOException;

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
		
	}
	/**
	 * ȸ���߰�
	 * 
	 * @param request
	 * @param response
	 */
	public void addMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
	}

	/**
	 * ȸ������ â
	 * 
	 * @param request
	 * @param response
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
	
	}

	/**
	 * ȸ�����Խ� �ߺ� email �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public void checkMemberEmail(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
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
