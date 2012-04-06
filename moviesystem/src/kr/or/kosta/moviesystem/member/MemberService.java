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
				request.setAttribute("ERROR", "�Է��Ͻ� ������ ��ġ�ϴ� ��й�ȣ�� �����ϴ�");
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
			request.setAttribute("ERROR", "�Է��Ͻ� ������ ��ġ�ϴ� ���̵� �����ϴ�");
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
		//4.JSP�� ������ �̵�
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
			out.print(userid+"�� ��밡���� ���̵��Դϴ�.");
		}else{
			out.print(userid="�� �̹� ������� ���̵��Դϴ�.");
		}
		out.flush();
		out.close();

	}

	/**
	 * ȸ������ â���� �̵�
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
	 * ȸ�� ���
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
		request.setAttribute("ERROR", "ȸ�������� �Ǿ����ϴ�.");
		
		RequestDispatcher rd=request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * ȸ������ ���� ������ �̵�
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
	 * ȸ�� ���� ����
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
		request.setAttribute("ERROR","���������� �����Ǿ����ϴ�");
		request.setAttribute("LOGIN_MEMBER", member1);
		
		RequestDispatcher rd=request.getRequestDispatcher("/member/editMember.jsp");
		rd.forward(request, response);
	}

	/**
	 * �α��� ������ �̵�
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
	 * ȸ�� �α���
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
			request.setAttribute("ERROR", "�������� �ʴ� ���̵�");
			RequestDispatcher rd=request.getRequestDispatcher("member/login.jsp");
			rd.forward(request, response);
		}else{
			if(!member.getPw().equals(pw)){
				request.setAttribute("ERROR", "��й�ȣ ����");
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
	 * ȸ�� �α׾ƿ�
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
	 * ȸ��Ż�� ������ �̵�
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
	 * ȸ�� Ż��
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
		  // session ��ü �ޱ�
		  HttpSession session=request.getSession();
		  // �α��� ���� ���� ���� ��ü ���� 
		  Member member = (Member)session.getAttribute("LOGIN_MEMBER");
		  // �ּ� ������ ��ü ����
		  String url = null;
		  
		  // ������ �α��� ���� ������ �� Ȯ��
		  if(member==null){
		   // �α��� ������ ������ null�� ��� ���� �޽��� request�� �ѱ� ��
		   // login �������� �̵��ϵ��� url����
		   request.setAttribute("ERROR","�α��� �� ��밡���� �����Դϴ�.");
		   url = "/member/login.jsp";
		   
		  }else{
		   // �α��� ���� ������ null�� �ƴ� ���
		   // mypage.jsp�� �̵� �ϵ��� url����
		   url = "/member/mypage.jsp";
		  }
		  // RequestDispatcher ��ü �����Ͽ� ������ �̵�
		  RequestDispatcher rd =request.getRequestDispatcher(url);
		  rd.forward(request, response);
		 }



	public void searchMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//�⺻������ 1
		int page=1;
		//�Ķ���� ����
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		//���������� ������ �л��� ��
		int length=5;
		String keyword="";
		if (request.getParameter("keyword")!=null){
			keyword = request.getParameter("keyword");;
		}
		String colum = "";
		if(request.getParameter("column")!=null){
			colum = request.getParameter("column");
		}
		//1.StudentDAO���� �������� �ش��ϴ� �л���ȸ �޼��带 ȣ��
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
		
		//2.request�� 1�� �������� �ش��ϴ� �л� ���� ����
		request.setAttribute("MEMBER_LIST",memberList);
		//�ٸ� �������� �̵��ϴ� ��ũ�±� ����
		//PageUtil.getnerate(��������,��ü�Ǽ�,���������纸���� row��, �ּ�);
		String pageLinkTag=PageUtil.generate
				(page, memberCount, length, "/moviesystem/MemberService?method=searchMemberList&column=" +colum+"&keyword="+keyword);
		
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		
		//3./student/viewStudentList.jsp�� ������ �̵�
		//��ü����
		RequestDispatcher rd=request.getRequestDispatcher
				("/member/searchMemberList.jsp");
		//4.JSP�� ������ �̵�
		rd.forward(request, response);
		
	}



}
