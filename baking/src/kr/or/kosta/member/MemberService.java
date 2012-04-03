package kr.or.kosta.member;

import java.io.IOException;

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
	 * 회원정보보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 회원정보수정
	 * 
	 * @param request
	 * @param response
	 */
	public void editMember(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 회원정보수정폼
	 * 
	 * @param request
	 * @param response
	 */
	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 회원탈퇴
	 * 
	 * @param request
	 * @param response
	 */
	public void removeMember(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 회원가입
	 * 
	 * @param request
	 * @param response
	 */
	public void addMember(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 회원가입폼
	 * 
	 * @param request
	 * @param response
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 로그인
	 */
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberid= request.getParameter("memberid");
		String password = request.getParameter("password");
		Member member = MemberDAO.login(memberid, password);
		if(member!=null){
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("GoodService?method=viewGoodList");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/member/loginFail.jsp");
			rd.forward(request, response);
		}
		
	
	}

	/**
	 * 로그인페이지이동
	 */
	public static void loginForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/loginForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * 로그아웃
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("GoodService?method=viewGoodList");
		rd.forward(request, response);
	}

	/**
	 * 아이디중복 확인
	 * 
	 * @param request
	 * @param response
	 */
	public void checkMemberID(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 회원아이디 찾기
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
	 * 회원아이디찾기 폼
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
	 * 회원비밀번호 찾기
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
	 * 회원비밀번호찾기 폼
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
	 * 비밀번호 변경
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
	 * 비밀번호 변경 폼
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
