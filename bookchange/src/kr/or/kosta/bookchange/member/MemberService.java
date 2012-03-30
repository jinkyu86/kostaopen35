package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.or.kosta.util.PageUtil;


public class MemberService extends HttpServlet {


	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if(method==null){
			loginForm(request, response);
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
		}else if("removeMember".equals(method)){
			removeMember(request, response);
		}else if("viewMember".equals(method)){
			viewMember(request, response);
		}else if("viewMemberList".equals(method)){
			viewMemberList(request, response);
		}else if("searchMemberList".equals(method)){
			searchMemberList(request, response);
		}
	
	}
	/**
	 * 회원추가
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
		
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoardList");
		rd.forward(request, response);
		
	}

	/**
	 * 회원가입 창
	 * 
	 * @param request
	 * @param response
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		RequestDispatcher rd=request.getRequestDispatcher("/member/addmember.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * 회원가입시 중복 email 검색
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
			System.out.println(email+"는 사용 가능한 아이디입니다.");
			out.print(email+"는 사용 가능한 아이디 입니다.");
		} else {
			System.out.println(email+"이미 사용중인 아이디입니다.");
			out.print(email+"는 이미 사용중인 아이디 입니다.");
		}
		
		out.flush();
		out.close();
		
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
	 * 회원정보 수정 창
	 * 
	 * @param request
	 * @param response
	 */
	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		RequestDispatcher rd=request.getRequestDispatcher("/student/editStudent.jsp");
		rd.forward(request, response);
	}

	/**
	 * 로그인 처리
	 * 
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		
		Member member =MemberDAO.selectMember(email);
		//학생정보리턴 값이 null 이면 존재 하지 않는 아이디 
		if (member==null) {
			request.setAttribute("ERROR","존재하지 않는 아이디");
		}
		//학생정보리턴 값이 null 값이 아니거나 이전 비번과 입력비번이 같지 않을때 비번오류
		if(member!=null){
			if(!member.getPw().equals(pw)){
				request.setAttribute("ERROR", "비밀번호 오류");
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("LOGIN_EMAIL",member);
				System.out.println(email+"로그인 되었습니다.");
			}
		
		}
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoardList");
		rd.forward(request, response);
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
		RequestDispatcher rd=request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * 로그아웃 처리
	 * 
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		session.invalidate();//세션 강제 종료
		System.out.println("로그아웃되었습니다");
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMember");
		rd.forward(request, response);
		
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
		String email=request.getParameter("email");
		MemberDAO.deleteMember(email);
		System.out.println("회원이 삭제 되었습니다.");
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMemberList");
		rd.forward(request, response);
	}

	/**
	 * 회원정보보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
			String email=request.getParameter("email");
			Member memberList=MemberDAO.selectMember(email);
			request.setAttribute("MEMBER",memberList);
			System.out.println(email+"회원정보가 보입니다.");
			RequestDispatcher rd=request.getRequestDispatcher("/member/viewMember.jsp");
			rd.forward(request, response);
	}

	/**
	 * 회원명단 보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int page=1;//페이지수
		int length=5;//페이지내용크기
		
		ArrayList<Member>memberList=
				MemberDAO.selectMemberList(length, page);//맴버호출 
		if(request.getParameter("page")!=null){//page 값이 널이면
			  page=Integer.parseInt(request.getParameter("page"));
			  //현제 페이지값리턴 
		  }
		 request.setAttribute("MEMBER_LIST", memberList);//요청에 멤버리스트를 스트링값으로 리턴
		 
		 int memberCount=MemberDAO.selectMemberCount();//멤버카운트에 멤버숫자 리턴
		//다른 페이지로 이동하는 링크 테그 만듬
		//PageUtil.getnerate(한페이지,전체건수,한페이지당 보여줄 row수,주소)
		 String pageLink=PageUtil.generate(page, memberCount, length, 
				 "/bookchange/MemberService?method=viewMemberList");
		 request.setAttribute("PAGE_LINK", pageLink);
		 
		 RequestDispatcher rd=request.getRequestDispatcher("/member/viewMemberList.jsp");
		 rd.forward(request, response);
	}

	/**
	 * 회원명단 검색
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//기본 페이지
		int page=1;
		//페이지 파라미터가 존재
		if (request.getParameter("page")!=null) {
			//파라미터 리턴
			page=Integer.parseInt(request.getParameter("page"));
			
		}
		int length=5;
		
		ArrayList<Member> memberList=null;
		int memberCount=0;

		if(request.getParameter("keyword")==null||
			request.getParameter("keyword").equals("")){
				memberList=
						MemberDAO.selectMemberList(length, page);
				memberCount=
						MemberDAO.selectMemberCount();
				
		}else{
				memberList=
							MemberDAO.selectMemberListByEmail(length, page, request.getParameter("keyword"));
				memberCount=
						MemberDAO.selectMemberCount(request.getParameter("keyword"));
				
							
		}
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("MEMBER_LIST",memberList);	
		String pageLink=
				PageUtil.generate(page, memberCount, length, "/MemberService?" +
						"method=searchMemberList&keyword=" +
						request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK", pageLink);

		RequestDispatcher rd=request.getRequestDispatcher("/member/viewMemberList.jsp");
		rd.forward(request, response);
	}
}
