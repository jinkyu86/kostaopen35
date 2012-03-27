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
	 * 회원추가
	 * 
	 * @param request
	 * @param response
	 */
	public void addMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
	}

	/**
	 * 회원가입 창
	 * 
	 * @param request
	 * @param response
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
	
	}

	/**
	 * 회원가입시 중복 email 검색
	 * 
	 * @param request
	 * @param response
	 */
	public void checkMemberEmail(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param request
	 * @param response
	 */
	public void editMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
	
	}

	/**
	 * 회원정보 수정 창
	 * 
	 * @param request
	 * @param response
	 */
	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * 로그인 처리
	 * 
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * 로그인창
	 * 
	 * @param request
	 * @param response
	 */
	public void loginForm(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * 로그아웃 처리
	 * 
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * 회원 탈퇴/삭제
	 * 
	 * @param request
	 * @param response
	 */
	public void removeMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * 회원정보보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * 회원명단 보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * 회원명단 검색
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}
}
