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
	 * ȸ���߰�
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
	 * ȸ������ â
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
	 * ȸ�����Խ� �ߺ� email �˻�
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
			System.out.println(email+"�� ��� ������ ���̵��Դϴ�.");
			out.print(email+"�� ��� ������ ���̵� �Դϴ�.");
		} else {
			System.out.println(email+"�̹� ������� ���̵��Դϴ�.");
			out.print(email+"�� �̹� ������� ���̵� �Դϴ�.");
		}
		
		out.flush();
		out.close();
		
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
	 * ȸ������ ���� â
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
	 * �α��� ó��
	 * 
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		/* default generated stub */;
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		
		Member member =MemberDAO.selectMember(email);
		//�л��������� ���� null �̸� ���� ���� �ʴ� ���̵� 
		if (member==null) {
			request.setAttribute("ERROR","�������� �ʴ� ���̵�");
		}
		//�л��������� ���� null ���� �ƴϰų� ���� ����� �Էº���� ���� ������ �������
		if(member!=null){
			if(!member.getPw().equals(pw)){
				request.setAttribute("ERROR", "��й�ȣ ����");
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("LOGIN_EMAIL",member);
				System.out.println(email+"�α��� �Ǿ����ϴ�.");
			}
		
		}
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoardList");
		rd.forward(request, response);
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
		RequestDispatcher rd=request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * �α׾ƿ� ó��
	 * 
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		session.invalidate();//���� ���� ����
		System.out.println("�α׾ƿ��Ǿ����ϴ�");
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMember");
		rd.forward(request, response);
		
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
		String email=request.getParameter("email");
		MemberDAO.deleteMember(email);
		System.out.println("ȸ���� ���� �Ǿ����ϴ�.");
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMemberList");
		rd.forward(request, response);
	}

	/**
	 * ȸ����������
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMember(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
			String email=request.getParameter("email");
			Member memberList=MemberDAO.selectMember(email);
			request.setAttribute("MEMBER",memberList);
			System.out.println(email+"ȸ�������� ���Դϴ�.");
			RequestDispatcher rd=request.getRequestDispatcher("/member/viewMember.jsp");
			rd.forward(request, response);
	}

	/**
	 * ȸ����� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		int page=1;//��������
		int length=5;//����������ũ��
		
		ArrayList<Member>memberList=
				MemberDAO.selectMemberList(length, page);//�ɹ�ȣ�� 
		if(request.getParameter("page")!=null){//page ���� ���̸�
			  page=Integer.parseInt(request.getParameter("page"));
			  //���� ������������ 
		  }
		 request.setAttribute("MEMBER_LIST", memberList);//��û�� �������Ʈ�� ��Ʈ�������� ����
		 
		 int memberCount=MemberDAO.selectMemberCount();//���ī��Ʈ�� ������� ����
		//�ٸ� �������� �̵��ϴ� ��ũ �ױ� ����
		//PageUtil.getnerate(��������,��ü�Ǽ�,���������� ������ row��,�ּ�)
		 String pageLink=PageUtil.generate(page, memberCount, length, 
				 "/bookchange/MemberService?method=viewMemberList");
		 request.setAttribute("PAGE_LINK", pageLink);
		 
		 RequestDispatcher rd=request.getRequestDispatcher("/member/viewMemberList.jsp");
		 rd.forward(request, response);
	}

	/**
	 * ȸ����� �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMemberList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//�⺻ ������
		int page=1;
		//������ �Ķ���Ͱ� ����
		if (request.getParameter("page")!=null) {
			//�Ķ���� ����
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
