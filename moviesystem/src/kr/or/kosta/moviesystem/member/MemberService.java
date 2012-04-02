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

import org.apache.catalina.connector.Request;


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
			   method="viewMemberList";
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
		
		RequestDispatcher rd=request.getRequestDispatcher("member/viewMemberList.jsp");
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
		request.setAttribute("MEMBER",member);
		
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
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMember" +
				"&userid="+userid);
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
		}else{
			if(!member.getPw().equals(pw)){
				request.setAttribute("ERROR", "��й�ȣ ����");
			}else{
				HttpSession session=request.getSession();
				session.setAttribute("LOGIN_MEMBER", member);
			}//end else
		}//end if
		RequestDispatcher rd=request.getRequestDispatcher("/MovieService?method=Main");
		rd.forward(request, response);
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
		request.setAttribute("MEMBER", member);
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
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/MemberService?method=viewMemberList");
		rd.forward(request, response);
		
	}

//	/**
//	 * �˻��� ȸ������Ʈ
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	public void searchSelectMemberList(HttpServletResponse request,
//			HttpServletResponse response) {
//		/* default generated stub */;
//		
//	}
//
//
//	/**
//	 * ȸ�� ���� ã��
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	public void findMemberInfo(HttpServletRequest request,
//			HttpServletResponse response) {
//		/* default generated stub */;
//		
//	}
}
