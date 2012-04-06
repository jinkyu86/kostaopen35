package kr.or.kosta.moviesystem.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import kr.or.kosta.moviesystem.util.PageUtil;




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
		   String  method=request.getParameter("method");
		   System.out.println(method);
		   if(method==null){
			   RequestDispatcher rd=request.getRequestDispatcher("/MovieService?method=Main");
				rd.forward(request, response);
				
		   }if("viewMemberList".equals(method)){
			   viewMemberList(request,response);
		   }else if("addMemberForm".equals(method)){
			   addMemberForm(request,response);
		   }else if("addMember".equals(method)){
			   addMember(request,response);
		   }else if("loginForm".equals(method)){
			   loginForm(request,response);
		   }else if("login".equals(method)){
			   login(request,response);
		   }else if("checkMemberID".equals(method)){
			   checkMemberID(request,response);
		   }else if("editMemberForm".equals(method)){
			   editMemberForm(request,response);
		   }else if("editMember".equals(method)){
			   editMember(request,response);
		   }else if("viewMember".equals(method)){
			   viewMember(request,response);
		   }else if("dropMember".equals(method)){
			   dropMember(request,response);
		   }else if("dropMemberForm".equals(method)){
			   dropMemberForm(request,response);
		   }else if("findId".equals(method)){
			   findId(request,response);
		   }else if("findIdForm".equals(method)){
			   findIdForm(request,response);
		   }else if("findPwForm".equals(method)){
			   findPwForm(request,response);
		   }else if("findPw".equals(method)){
			   findPw(request,response);
		   }else if("logoutMember".equals(method)){
			   logoutMember(request,response);
		   }else if("mypage".equals(method)){
			      mypage(request, response);
		   }else if("searchMemberList".equals(method)){
			   searchMemberList(request, response);
		   }
	   }
			
	   private void findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String name=request.getParameter("name");
			String email=request.getParameter("email");
			String userid=request.getParameter("userid");
			
			Member member=MemberDAO.findMemberPw(email, name, userid);
			
			
			if(member==null){
				request.setAttribute("ERROR", "입력하신 정보와 일치하는 비밀번호가 없습니다");
				RequestDispatcher rd=request.getRequestDispatcher("member/findPw.jsp");
				rd.forward(request, response);
			}else	{
					HttpSession session=request.getSession();
					session.setAttribute("MEMBER",member);
					RequestDispatcher rd=request.getRequestDispatcher("member/resultFindPw.jsp");
					rd.forward(request, response);
				}//end else
			}		


	private void findPwForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		   RequestDispatcher rd=request.getRequestDispatcher("member/findPw.jsp");
			rd.forward(request, response);
		
	}

	private void findIdForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("member/findId.jsp");
		rd.forward(request, response);
	}

	private void findId(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		Member member=MemberDAO.findMemberId(email, name);
		
		
		if(member==null){
			request.setAttribute("ERROR", "입력하신 정보와 일치하는 아이디가 없습니다");
			RequestDispatcher rd=request.getRequestDispatcher("member/findId.jsp");
			rd.forward(request, response);
		}else	{
				HttpSession session=request.getSession();
				session.setAttribute("MEMBER",member);
				RequestDispatcher rd=request.getRequestDispatcher("member/resultFindId.jsp");
				rd.forward(request, response);
			}//end else
		}		
	

	private void viewMemberList(HttpServletRequest request,
				HttpServletResponse response) 
		throws IOException,ServletException{
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int length=5;
		ArrayList<Member> memberList=MemberDAO.selectMemberList(length, page);
		request.setAttribute("MEMBER_LIST", memberList);
		
		int memberCount=MemberDAO.selectMemberListCount();
		String pageLinkTag=PageUtil.generate
				(page, memberCount, length, "MemberService?method=viewMemberList");
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher
				("/member/viewMemberList.jsp");
		//4.JSP로 페이지 이동
		rd.forward(request, response);
	}

	private void viewMember(HttpServletRequest request,
			HttpServletResponse response) throws  ServletException,IOException{
		String userid=request.getParameter("userid");
		Member member=MemberDAO.selectMemberById(userid);
		
		request.setAttribute("MEMBER",member);
		RequestDispatcher rd=request.getRequestDispatcher("/member/viewMember.jsp");
		rd.forward(request, response);
		
	}

	private void checkMemberID(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		Member member=MemberDAO.selectMemberById(userid);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(member==null){
			out.print(userid+"는 사용가능한 아이디입니다.");
		}else{
			out.print(userid="는 이미 사용중인 아이디입니다.");
		}
		out.flush();
		out.close();

	}

	/**
	 * 회원가입 창으로 이동
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/member/addMember.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 회원 등록
	 * 
	 * @param request
	 * @param response
	 */
	public void addMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String pw=request.getParameter("pw");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String zipcode=request.getParameter("zipcode");
		String addr=request.getParameter("addr");
		
		Member member=new Member();
		member.setUserid(userid);
		member.setName(name);
		member.setPw(pw);
		member.setEmail(email);
		member.setPhone(phone);
		member.setZipcode(zipcode);
		member.setAddr(addr);
		
		MemberDAO.insertMember(member);
		request.setAttribute("ERROR", "회원가입이 되었습니다.");
		
		RequestDispatcher rd=request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * 회원정보 변경 폼으로 이동
	 * 
	 * @param request
	 * @param response
	 */
	public void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String userid=request.getParameter("userid");
		Member member=MemberDAO.selectMemberById(userid);
		request.setAttribute("LOGIN_MEMBER",member);
		
		RequestDispatcher rd=request.getRequestDispatcher("member/editMember.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 회원 정보 수정
	 * 
	 * @param request
	 * @param response
	 */
	public void editMember(HttpServletRequest request,
			HttpServletResponse response)
	 throws IOException,ServletException{
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String pw=request.getParameter("pw");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String zipcode=request.getParameter("zipcode");
		String addr=request.getParameter("addr");
		
		Member member=new Member();
		member.setUserid(userid);
		member.setName(name);
		member.setPhone(phone);
		member.setPw(pw);
		member.setEmail(email);
		member.setZipcode(zipcode);
		member.setAddr(addr);
		
		MemberDAO.editMember(member);
		Member member1=MemberDAO.selectMemberById(member.getUserid());
		request.setAttribute("ERROR","개인정보가 수정되었습니다");
		request.setAttribute("LOGIN_MEMBER", member1);
		
		RequestDispatcher rd=request.getRequestDispatcher("/member/editMember.jsp");
		rd.forward(request, response);
	}

	/**
	 * 로그인 폼으로 이동
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void loginForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 회원 로그인
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String pw=request.getParameter("pw");
		Member member=MemberDAO.selectMemberById(userid);
		
		if(member==null){
			request.setAttribute("ERROR", "존재하지 않는 아이디");
			RequestDispatcher rd=request.getRequestDispatcher("member/login.jsp");
			rd.forward(request, response);
		}else{
			if(!member.getPw().equals(pw)){
				request.setAttribute("ERROR", "비밀번호 오류");
				RequestDispatcher rd=request.getRequestDispatcher("member/login.jsp");
				rd.forward(request, response);
			}else{
				HttpSession session=request.getSession();
				session.setAttribute("LOGIN_MEMBER", member);
				RequestDispatcher rd=request.getRequestDispatcher("/MovieService?method=Main");
				rd.forward(request, response);
			}//end else
		}//end if
	}

	/**
	 * 회원 로그아웃
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void logoutMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		session.invalidate();
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/MovieService?method=Main");
		rd.forward(request, response);
		
	}

	/**
	 * 회원탈퇴 폼으로 이동
	 * 
	 * @param request
	 * @param response
	 */
	public void dropMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		String userid=request.getParameter("userid");
		Member member=MemberDAO.selectMemberById(userid);
		request.setAttribute("LOGIN_MEMBER", member);
		RequestDispatcher rd=request.getRequestDispatcher("/member/dropMember.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 회원 탈퇴
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void dropMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String dropReason=request.getParameter("dropReason");
		
		Member member=new Member();
		member.setUserid(userid);
		member.setName(name);
		member.setDropReason(dropReason);
		
		MemberDAO.dropMember(member);
		logoutMember(request, response);
		
	}
	
	private void mypage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		  // session 객체 받기
		  HttpSession session=request.getSession();
		  // 로그인 세션 정보 받을 객체 생성 
		  Member member = (Member)session.getAttribute("LOGIN_MEMBER");
		  // 주소 저장할 객체 생성
		  String url = null;
		  
		  // 생성된 로그인 세션 정보의 값 확인
		  if(member==null){
		   // 로그인 세션의 정보가 null일 경우 에러 메시지 request로 넘긴 후
		   // login 페이지로 이동하도록 url선언
		   request.setAttribute("ERROR","로그인 후 사용가능한 서비스입니다.");
		   url = "/member/login.jsp";
		   
		  }else{
		   // 로그인 세션 정보가 null이 아닐 경우
		   // mypage.jsp로 이동 하도록 url선언
		   url = "/member/mypage.jsp";
		  }
		  // RequestDispatcher 객체 선언하여 페이지 이동
		  RequestDispatcher rd =request.getRequestDispatcher(url);
		  rd.forward(request, response);
		 }



	public void searchMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//기본페이지 1
		int page=1;
		//파라메터 리턴
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		//한페이지당 보여줄 학생의 수
		int length=5;
		String keyword="";
		if (request.getParameter("keyword")!=null){
			keyword = request.getParameter("keyword");;
		}
		String colum = "";
		if(request.getParameter("column")!=null){
			colum = request.getParameter("column");
		}
		//1.StudentDAO에서 페이지에 해당하는 학생조회 메서드를 호출
		ArrayList<Member>memberList=null;
		int memberCount=0;
		if(request.getParameter("keyword")==null||
				request.getParameter("keyword").equals("")){
			memberList=MemberDAO.selectMemberList(length, page);
			memberCount=MemberDAO.selectMemberListCount();
		}else{
			if(request.getParameter("column").equals("name")){
				memberList=MemberDAO.searchMemberListByName
						(length, page, request.getParameter("keyword"));
				memberCount=MemberDAO.searchMemberListByNameCount(keyword);
			}else if(request.getParameter("column").equals("email")){
				memberList=MemberDAO.searchMemberListByEmail
						(length, page, request.getParameter("keyword"));
				memberCount=MemberDAO.searchMemberListByEmailCount(keyword);
			}else if(request.getParameter("column").equals("addr")){
				memberList=MemberDAO.searchMemberListByAddr
						(length, page, request.getParameter("keyword"));
				memberCount=MemberDAO.searchMemberListByAddrCount(keyword);
			}else if(request.getParameter("column").equals("phone")){
				memberList=MemberDAO.searchMemberListByPhone
						(length, page, request.getParameter("keyword"));
				memberCount=MemberDAO.searchMemberListByPhoneCount(keyword);
			}
		}
		
		//2.request에 1의 페이지에 해당하는 학생 정보 저장
		request.setAttribute("MEMBER_LIST",memberList);
		//다른 페이지로 이동하는 링크태그 만듬
		//PageUtil.getnerate(현페이지,전체건수,한페이지당보여울 row수, 주소);
		String pageLinkTag=PageUtil.generate
				(page, memberCount, length, "/moviesystem/MemberService?method=searchMemberList&column=" +colum+"&keyword="+keyword);
		
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		
		//3./student/viewStudentList.jsp로 페이지 이동
		//객체생성
		RequestDispatcher rd=request.getRequestDispatcher
				("/member/searchMemberList.jsp");
		//4.JSP로 페이지 이동
		rd.forward(request, response);
		
	}



}
