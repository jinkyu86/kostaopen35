package kr.or.kosta.auction.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MemberService extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @param request
	 * @param response
	 */
	  public MemberService() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
		}
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String  method=request.getParameter("method");
			if(method==null){
				method="viewMemberList";
			}
			if("viewMemberList".equals(method)){
				viewMemberList(request,response);
			}else if("viewMember".equals(method)){
				viewMember(request,response);
			}else if("editMemberForm".equals(method)){
				editMemberForm(request,response);
			}else if("editMember".equals(method)){
				editMember(request,response);
			}else if("removeMember".equals(method)){
				removeMember(request,response);
			}else if("addMemberForm".equals(method)){
				addMemberForm(request,response);
			}else if("addMember".equals(method)){
				addMember(request,response);
			}else if("loginForm".equals(method)){
				loginForm(request,response);
			}else if("login".equals(method)){
				login(request,response);
			}else if("logout".equals(method)){
				logout(request,response);
			}
		}//end method doPost
	private void addMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.파라메터 정보 리턴
				String userid=request.getParameter("userid");
				String pw=request.getParameter("pw");
				String email=request.getParameter("email");
				String name=request.getParameter("name");
				String coin=request.getParameter("coin");
				String emoney=request.getParameter("emoney");
				//2.Student객체 생성 1의 속성을 저장
				Member member=new Member();
				member.setUserid(userid);
				member.setPw(pw);
				member.setEmail(email);
				member.setName(name);
				member.setCoin(coin);
				member.setEmoney(emoney);
				//3.DB에 저장
				MemberDAO.insertMember(member);
				//4.전체 학생리스트 이동 객체
				RequestDispatcher rd=
						request.getRequestDispatcher(
								"/MemberService?method=viewMemberList");
				//5.페이지 이동
				rd.forward(request, response);
				
			}

	/**
	 * @param request
	 * @param response
	 */
	private void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editMember(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewMember(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void removeMember(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void loginForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}
	private void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}
}
