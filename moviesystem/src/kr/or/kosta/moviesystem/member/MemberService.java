package kr.or.kosta.moviesystem.member;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;
import kr.or.kosta.moviesystem.util.PageUtil;

public class MemberService implements ModelDriven,ServletContextAware,ServletRequestAware,
ServletResponseAware,SessionAware {
	
	private IMemberDAO memberDAO;
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;
	private Member member=new Member();
	private int page;
	private String userNum;
	private String userid;
	private String pw;
	private Member MEMBER;
	private List<Member>MEMBER_LIST;
	private String PAGE_LINK_TAG;  
	private String keyword;
	private String column; 
	private InputStream resultStream;
		
		
	  public InputStream getResultStream() {
		return resultStream;
	}

	public void setResultStream(InputStream resultStream) {
		this.resultStream = resultStream;
	}

	public MemberService(IMemberDAO memberDAO) {
		super();
		System.out.println("memberDAO��ü����");
		this.memberDAO = memberDAO;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		  this.session=session;		
		}

	  @Override
	public void setServletResponse(HttpServletResponse response) {
		  this.response=response;
	}

	  @Override
	public void setServletRequest(HttpServletRequest request) {
		  this.request=request;
		}
	  
	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext=context;			
	}

	@Override
	public Object getModel() {
			return member;
	}
	
	   
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}

	

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserid() {
		return userid;
	}





	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Member getMEMBER() {
		return MEMBER;
	}



	public void setMEMBER(Member mEMBER) {
		MEMBER = mEMBER;
	}



	public List<Member> getMEMBER_LIST() {
		return MEMBER_LIST;
	}



	public void setMEMBER_LIST(List<Member> mEMBER_LIST) {
		MEMBER_LIST = mEMBER_LIST;
	}



	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}



	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}



	public MemberService() {
	        super();
	     
	    }
	   
//	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			doPost(request,response);
//		}
//	   
//	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		   request.setCharacterEncoding("utf-8");
//		   String  method=request.getParameter("method");
//		   System.out.println(method);
//		   if(method==null){
//			   RequestDispatcher rd=request.getRequestDispatcher("/MovieService?method=Main");
//				rd.forward(request, response);
//				
//		   }if("viewMemberList".equals(method)){
//			   viewMemberList(request,response);
//		   }else if("addMemberForm".equals(method)){
//			   addMemberForm(request,response);
//		   }else if("addMember".equals(method)){
//			   addMember(request,response);
//		   }else if("loginForm".equals(method)){
//			   loginForm(request,response);
//		   }else if("login".equals(method)){
//			   login(request,response);
//		   }else if("checkMemberID".equals(method)){
//			   checkMemberID(request,response);
//		   }else if("editMemberForm".equals(method)){
//			   editMemberForm(request,response);
//		   }else if("editMember".equals(method)){
//			   editMember(request,response);
//		   }else if("viewMember".equals(method)){
//			   viewMember(request,response);
//		   }else if("dropMember".equals(method)){
//			   dropMember(request,response);
//		   }else if("dropMemberForm".equals(method)){
//			   dropMemberForm(request,response);
//		   }else if("findId".equals(method)){
//			   findId(request,response);
//		   }else if("findIdForm".equals(method)){
//			   findIdForm(request,response);
//		   }else if("findPwForm".equals(method)){
//			   findPwForm(request,response);
//		   }else if("findPw".equals(method)){
//			   findPw(request,response);
//		   }else if("logoutMember".equals(method)){
//			   logoutMember(request,response);
//		   }else if("mypage".equals(method)){
//			      mypage(request, response);
//		   }else if("searchMemberList".equals(method)){
//			   searchMemberList(request, response);
//		   }
//	   }
			
	public String findPwForm() throws Exception {
		   return "success";		
	}

	public String findPw() throws Exception {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String userid=request.getParameter("userid");
			
		Member member=memberDAO.findMemberPw(email, name, userid);
			
			
			if(member==null){
				request.setAttribute("ERROR", "�Է��Ͻ� ������ ��ġ�ϴ� ��й�ȣ�� �����ϴ�");
				return "findPw";
			}else	{
				session.put("MEMBER",member);
				return "success";
				}//end else
			}	
	
	public String findIdForm() throws Exception {
		return "success";
	}

	public String findId() throws Exception { 
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		Member member=memberDAO.findMemberId(email, name);
		
		
		if(member==null){
			request.setAttribute("ERROR", "�Է��Ͻ� ������ ��ġ�ϴ� ���̵� �����ϴ�");
			return "findId";
		}else	{
				session.put("MEMBER",member);
				return "success";
			}//end else
		}		
	
	public String viewMemberList() throws Exception{
		if(page==0){
			page=1;
		}
		int length=5;
		MEMBER_LIST=memberDAO.selectMemberList(length, page);
		int memberCount=memberDAO.selectMemberListCount();
		PAGE_LINK_TAG=
				PageUtil.generate(page,memberCount,length,"/moviesystem/viewMemberList.action");
		return "success";
	}

	public String viewMember() throws Exception{
		
		MEMBER=memberDAO.selectMember(userNum);
		return "success";		
	}

	public String checkMemberID() throws Exception {
		MEMBER=memberDAO.selectMemberById(userid);
		if(MEMBER==null){
			String msg=userid+"�� ��밡���� ���̵��Դϴ�.";
			byte[]msgArray=msg.getBytes("UTF-8");
			
			resultStream=
					new ByteArrayInputStream(msgArray);
		}else{
			String msg=userid+"�� �̹� ������� ���̵��Դϴ�.";
			byte[]msgArray=msg.getBytes("UTF-8");
			
			resultStream=
					new ByteArrayInputStream(msgArray);
		}
	
		return "success";

//		String userid=request.getParameter("userid");
//		Member member=MemberDAO.selectMemberById(userid);
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out=response.getWriter();
//		if(member==null){
//			out.print(userid+"�� ��밡���� ���̵��Դϴ�.");
//		}else{
//			out.print(userid="�� �̹� ������� ���̵��Դϴ�.");
//		}
//		out.flush();
//		out.close();

	}

	/**
	 * ȸ������ â���� �̵�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String addMemberForm() throws Exception {
		return "success";
		
	}

	public String addMember() throws Exception{
		userNum=memberDAO.insertMember(member);
		return "success";
		
	}

	/**
	 * ȸ������ ���� ������ �̵�
	 * 
	 * @param request
	 * @param response
	 */
	public String editMemberForm() throws Exception{
		Member member1=(Member)session.get("LOGIN_MEMBER");		
		Member member=memberDAO.selectMember(member1.getUserNum());
		session.put("LOGIN_MEMBER", member);
		return "success";
	}

	/**
	 * ȸ�� ���� ����
	 * 
	 * @param request
	 * @param response
	 */
	public String editMember() throws Exception{
		memberDAO.editMember(member);
		//userNum=member.getUserNum();
		//Member member1=MemberDAO.selectMember(member.getUserNum());
		request.setAttribute("ERROR","���������� �����Ǿ����ϴ�");
		session.put("LOGIN_MEMBER",member);
		return "success";
	}

	public String loginForm() throws Exception {
		return "success";
		
	}
	public String login() throws Exception {
		String userid=request.getParameter("userid");
		String pw=request.getParameter("pw");
		Member member=memberDAO.selectMemberById(userid);
		
		if(member==null){
			request.setAttribute("ERROR", "�������� �ʴ� ���̵�");
			return "login";	
		}else{
			if(!member.getPw().equals(pw)){
				request.setAttribute("ERROR", "��й�ȣ ����");
				return "login";	 
			}else{
				session.put("LOGIN_MEMBER",member);
				return "success";
			}//end else
		}
	}
	
//	public void login(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		String userid=request.getParameter("userid");
//		String pw=request.getParameter("pw");
//		Member member=MemberDAO.selectMemberById(userid);
//		
//		if(member==null){
//			request.setAttribute("ERROR", "�������� �ʴ� ���̵�");
//			RequestDispatcher rd=request.getRequestDispatcher("member/login.jsp");
//			rd.forward(request, response);
//		}else{
//			if(!member.getPw().equals(pw)){
//				request.setAttribute("ERROR", "��й�ȣ ����");
//				RequestDispatcher rd=request.getRequestDispatcher("member/login.jsp");
//				rd.forward(request, response);
//			}else{
//				HttpSession session=request.getSession();
//				session.setAttribute("LOGIN_MEMBER", member);
//				RequestDispatcher rd=request.getRequestDispatcher("/MovieService?method=Main");
//				rd.forward(request, response);
//			}//end else
//		}//end if
//	}

	/**
	 * ȸ�� �α׾ƿ�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String logoutMember() throws Exception {
		
		session.remove("LOGIN_MEMBER");
		return "success";
		
	}

	/**
	 * ȸ��Ż�� ������ �̵�
	 * 
	 * @param request
	 * @param response
	 */
	public String dropMemberForm() throws Exception{	
		Member member1=(Member)session.get("LOGIN_MEMBER");		
		Member member=memberDAO.selectMember(member1.getUserNum());
		session.put("LOGIN_MEMBER", member);
		return "success";
		
	}

	/**
	 * ȸ�� Ż��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String dropMember() throws Exception {
			
		memberDAO.dropMember(member);
		logoutMember();
		return "success";
		
	}
	
	public String mypage() throws Exception{
		Member member=(Member)session.get("LOGIN_MEMBER");	 
		if(member==null){
			 request.setAttribute("ERROR","�α��� �� ��밡���� �����Դϴ�.");
			 return "login";
			 // �ּ� ������ ��ü ����
			 //String url = null;
		  
			 // ������ �α��� ���� ������ �� Ȯ��
		 
			 // �α��� ������ ������ null�� ��� ���� �޽��� request�� �ѱ� ��
			 // login �������� �̵��ϵ��� url����
			 //url = "/member/login.jsp";
		   
		  }else{
			  session.put("LOGIN_MEMBER",member);
			  return "success";
		   // �α��� ���� ������ null�� �ƴ� ���
		   // mypage.jsp�� �̵� �ϵ��� url����
		   //url = "/member/mypage.jsp";
		  }
		  
		 }



	public String searchMemberList() throws Exception{
		if(page==0){
			page=1;
		}
		int length=5;
		int memberCount=0;
		keyword="";
		if (keyword!=null){
			keyword = request.getParameter("keyword");;
		}
		column = "";
		if(column!=null){
			column = request.getParameter("column");
		}
		//1.StudentDAO���� �������� �ش��ϴ� �л���ȸ �޼��带 ȣ��
		
		if(keyword==null||keyword.equals("")){
			MEMBER_LIST=memberDAO.selectMemberList(length, page);
			memberCount=memberDAO.selectMemberListCount();
		}else{
			if(column.equals("name")){
				MEMBER_LIST=memberDAO.searchMemberListByName
						(length, page, request.getParameter("keyword"));
				memberCount=memberDAO.searchMemberListByNameCount(keyword);
			}else if(column.equals("email")){
				MEMBER_LIST=memberDAO.searchMemberListByEmail
						(length, page, request.getParameter("keyword"));
				memberCount=memberDAO.searchMemberListByEmailCount(keyword);
			}else if(column.equals("addr")){
				MEMBER_LIST=memberDAO.searchMemberListByAddr
						(length, page, request.getParameter("keyword"));
				memberCount=memberDAO.searchMemberListByAddrCount(keyword);
			}else if(column.equals("phone")){
				MEMBER_LIST=memberDAO.searchMemberListByPhone
						(length, page, request.getParameter("keyword"));
				memberCount=memberDAO.searchMemberListByPhoneCount(keyword);
			}
		}
		
		PAGE_LINK_TAG=PageUtil.generate
				(page, memberCount, length, "/moviesystem/searchMemberList.action?column=" +column+"&keyword="+keyword);
		
		return "success";
		
	}



}
