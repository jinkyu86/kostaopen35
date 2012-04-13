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
       
    public MemberService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}else if("loginForm".equals(method)){
			loginForm(request,response);
		}else if("logout".equals(method)){
			logout(request,response);
		}else if("addMember".equals(method)){
			addMember(request, response);
		}else if("addMemberForm".equals(method)){
			addMemberForm(request, response);
		}
		
	}
	
	//회원정보
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String memberid=request.getParameter("memberid");
		String name=request.getParameter("name");
		String reginum=request.getParameter("reginum");
		Member mem = new Member();
		mem.setName(name);
		mem.setRegiNumber(reginum);
		
		Member member=MemberDAO.selectMemberByid(mem);
				
				request.setAttribute("Member",member);
				
				RequestDispatcher rd=
						request.getRequestDispatcher(
								"/board/viewBoard.jsp");
				
				rd.forward(request, response);
	}

	//회원정보 수정
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

	//회원정보 수정폼
	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
				String memberid=request.getParameter("memberid");
				String name=request.getParameter("name");
				String reginum=request.getParameter("reginum");
				
				Member mem = new Member();
				mem.setName(name);
				mem.setRegiNumber(reginum);
				
				Member member=MemberDAO.selectMemberByid(mem);
				
				request.setAttribute("Member",member);
				
				RequestDispatcher rd=
						request.getRequestDispatcher("/board/editBoard.jsp");
				
				rd.forward(request, response);
	}

	//회원탈퇴
	public void removeMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
				String memberid=request.getParameter("memberid");
				String pw=request.getParameter("pw");
				String reginum=request.getParameter("reginum");
//				MemberDAO.deleteMember(pw, reginum);
				
				RequestDispatcher rd=
						request.getRequestDispatcher(
								"/MemberService?method=viewMember");
				
				rd.forward(request, response);
	}

	//회원가입
	public void addMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberid=request.getParameter("memberid");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String regiNumber=request.getParameter("reginum");
		String pwHint=request.getParameter("pwhint");
		String pwAnswer=request.getParameter("pwanswer");
		String zipcode=request.getParameter("zipcode");
	    String address= request.getParameter("address");
		String strAddress= request.getParameter("straddress");
		String email= request.getParameter("email");
		String phoneNumber= request.getParameter("phonenum");
		String telNumber= request.getParameter("telnum");
		
		
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
		
		MemberDAO.insertMember(member);
		
		RequestDispatcher rd=
				request.getRequestDispatcher("/member/loginForm.jsp");
		rd.forward(request, response);
	}

	//회원가입폼
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/member/addMember.jsp");
		rd.forward(request, response);
	}

	//로그인
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberid= request.getParameter("memberid");
		String password = request.getParameter("password");
		Member mem = new  Member();
		mem.setMemberid(memberid);
		mem.setPassword(password);
		
		Member member = MemberDAO.login(mem);
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

	//로그인폼
	public static void loginForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/loginForm.jsp");
		rd.forward(request, response);
	}
	
	//로그아웃
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("GoodService?method=viewGoodList");
		rd.forward(request, response);
	}

	//아이디중복 확인
	public void checkMemberID(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String memberid=request.getParameter("memberid");
		String name=request.getParameter("name");
		String reginum=request.getParameter("reginum");
		
		Member mem = new Member();
		mem.setName(name);
		mem.setRegiNumber(reginum);
		
		Member member =MemberDAO.selectMemberByid(mem);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		if(member==null){
			out.print(memberid+"는 사용 가능한 아이디입니다.");
		}else{
			out.print(memberid+"는 이미 사용중인 아이디입니다.");
		}
		out.flush();
		out.close();
	}


	//회원아이디 찾기
	public void searchMemberID(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	//회원아이디찾기 폼
	public void searchMemberIDForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	//회원 비밀번호찾기
	public void searchMemberPW(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	//회원 비밀번호찾기 폼
	public void searchMemberPwForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	//회원 비밀번호변경
	public void changeMemberPW(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	//회원 비밀번호변경 폼
	public void changeMemberPWForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}
}
