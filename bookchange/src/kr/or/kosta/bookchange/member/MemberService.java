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

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;
import kr.or.kosta.bookchange.change.ChangeDAO;
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
		}else if("PwInMember".equals(method)){;
			PwInMember(request,response);
		}else if("removeMemberForm".equals(method)){
			removeMemberForm(request,response);
		}else if ("viewMemberEmail".equals(method)) {
			viewMemberEmail(request, response);
		}else if ("viewMemberPw".equals(method)) {
			viewMemberPw(request, response);
		}else if ("viewMemberPwAndEmail".equals(method)) {
			viewMemberPwAndEmail(request,response);
		}
	}

	private void viewMemberPwAndEmail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{

		RequestDispatcher rd=request.getRequestDispatcher("/member/IdAndPw.jsp");
		rd.forward(request, response);
		
	}
	private void removeMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/member/removeMember.jsp");
		rd.forward(request, response);
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
		
		request.setAttribute("ERROR", "회원가입이 완료되었습니다.");
		RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
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
		RequestDispatcher rd=request.getRequestDispatcher("/member/addMember.jsp");
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
			request.getAttribute("ERROR"+"사용가능한 아이디입니다");
			out.print(email+"는 사용 가능한 아이디 입니다.");
		} else {
			request.getAttribute("ERROR"+"이미 사용중인 아이디입니다");
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
		
		request.setAttribute("ERROR", "정보수정이 완료되었습니다.");
		
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMember");
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
		String email=request.getParameter("email");
		Member member=MemberDAO.selectMember(email);
		request.setAttribute("MEMBER", member);
		RequestDispatcher rd=request.getRequestDispatcher("/member/editmember.jsp");
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
		
		if (member==null) {
			request.setAttribute("ERROR","존재하지 않는 아이디");
		}
		
		if(member!=null){
			if(!member.getPw().equals(pw)){
				request.setAttribute("ERROR", "비밀번호 오류");
			}else {
				
				HttpSession session=request.getSession();
				session.setAttribute("LOGIN_EMAIL",member);
				System.out.println(email+"로그인 되었습니다.");
				
			}
		
		}
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=boardListAtMain");
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
		request.setAttribute("ERROR", "로그아웃 되었습니다.");
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=boardListAtMain");
		rd.forward(request, response);
		
	}
	/**
	 * 회원탈퇴를 위한 비밀번호 입력창 
	 */

	public void PwInMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
//			String email=request.getParameter("email");
//			Member member=MemberDAO.selectMember(email);
//			request.setAttribute("LOGIN_EMAIL", member);
			RequestDispatcher rd=request.getRequestDispatcher("/member/outPwkeyword.jsp");
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
		String pw=request.getParameter("pw");
		Member member=MemberDAO.selectMember(email);
		ArrayList<Board>boardList=BoardDAO.selectBoardListbyEmailWhenDelete(email);		
		if(pw==null){
			request.setAttribute("ERROR", "비밀번호를 입력하세요.");
			RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=boardListAtMain");
			rd.forward(request, response);
		}else if (!member.getPw().equals(pw)) {
			request.setAttribute("ERROR", "비밀번호가 틀렸습니다.");
			RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=boardListAtMain");
			rd.forward(request, response);
		}else if (member.getPw().equals(pw)) {
			for(int i=0; i<boardList.size(); i++){
				Board board=boardList.get(i);
				int boardNo=board.getBoardNo();
				ChangeDAO.deleteChange(boardNo);
			}
			MemberDAO.deleteMember(email);
			BoardDAO.deleteBoardbyEmail(email);
			
			System.out.println("회원이 삭제 되었습니다.");
			request.setAttribute("ERROR", "탈퇴되었습니다.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=logout");
			rd.forward(request, response);
		}
	}

	/**
	 * 회원정보보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
			
		HttpSession session=request.getSession();
		Member member=(Member) session.getAttribute("LOGIN_EMAIL");
		if(member==null){
			request.setCharacterEncoding("utf-8");
			request.setAttribute("ERROR","로그인하시기 바랍니다.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=boardListAtMain");
			rd.forward(request, response);
		}else{
			String email=member.getEmail();
			member=MemberDAO.selectMember(email);
		
			request.setAttribute("MEMBER",member);
			//System.out.println(email+"회원정보가 보입니다.");
		
			RequestDispatcher rd=request.getRequestDispatcher("/member/myInfo.jsp");
			rd.forward(request, response);
		}
	}
	/**
	 * 전화번호로 이메일 검색
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
		
		public void viewMemberEmail(HttpServletRequest request,
				HttpServletResponse response)throws IOException,ServletException {
				
				
				String tel=request.getParameter("tel");
				Member member=MemberDAO.selectMemberTel(tel);
				
		

				if(tel==null||tel.equals("")){
					request.setAttribute("ERROR","전화번호를 입력하시오.");
					RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMemberPwAndEmail");
					rd.forward(request, response);
				}else if (member==null) {
					request.setAttribute("ERROR","전화번호가 일치하는 회원이 없습니다.");
					RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMemberPwAndEmail");
					rd.forward(request, response);
				}else{
					String email=member.getEmail();
					request.setAttribute("ERROR", "당신의 Email은 "+email+"입니다");
					RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=boardListAtMain");
					rd.forward(request, response);
				}
		}
		/**
		 * 이메일과 전화번호로 검색
		 * @param request
		 * @param response
		 * @throws IOException
		 * @throws ServletException
		 */
		
		public void viewMemberPw(HttpServletRequest request,
				HttpServletResponse response)throws IOException,ServletException {
				
				Member member=new Member();
				String email=request.getParameter("email");
				String tel=request.getParameter("tel");
			
				member=MemberDAO.selectMember(email, tel);
				
				if(tel.equals(null)||tel.equals("")||email.equals(null)||email.equals("")){
					request.setAttribute("ERROR","이메일과 전화번호를 입력하시오.");
					RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMemberPwAndEmail");
					rd.forward(request, response);
				}else if (member==null) {
					request.setAttribute("ERROR","일치하는 회원정보가 없습니다.");
					RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMemberPwAndEmail");
					rd.forward(request, response);
				}else {
					String pw=member.getPw();
					request.setAttribute("ERROR", "당신의 비밀번호는 "+pw+"입니다");
					
					RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=boardListAtMain");
					rd.forward(request, response);
				}
				
			
		}

	/**
	 * 전체 회원명단 보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int page=1;//페이지수

		
		if(request.getParameter("page")!=null){//page 값이 널이면
			  page=Integer.parseInt(request.getParameter("page"));
			  //현제 페이지값리턴 
		  }
		int length=5;//페이지내용크기

		ArrayList<Member>memberList=
				MemberDAO.selectMemberList(length, page);//맴버호출 
		request.setCharacterEncoding("utf-8");
		request.setAttribute("MEMBER_LIST", memberList);
		 
		 int memberCount=MemberDAO.selectMemberCount();
		 String pageLink=PageUtil.generate(page, memberCount, length, 
				 "/bookchange/MemberService?method=viewMemberList");
		 request.setAttribute("PAGE_LINK_TAG", pageLink);
		 
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
				PageUtil.generate(page, memberCount, length, "/bookchange/MemberService?" +
						"method=searchMemberList&keyword=" +
						request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK_TAG", pageLink);

		RequestDispatcher rd=request.getRequestDispatcher("/member/viewMemberList.jsp");
		rd.forward(request, response);
	}

}
