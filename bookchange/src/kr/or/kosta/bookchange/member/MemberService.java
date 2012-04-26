package kr.or.kosta.bookchange.member;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import kr.or.kosta.util.PageUtil;


public class MemberService implements ModelDriven,ServletContextAware,ServletRequestAware,ServletResponseAware,SessionAware {
	private IMemberDAO memberDAO;

	private static final long serialVersionUID = 1L;
	private Member member;
	private String email;
	
	private String ERROR;
	private String pw;
	private String tel;
	private Member LOGIN_EMAIL;
	private String MEMBER_LIST;
	private List<Member> memberList;
	
	private ServletContext context;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private Map session;
	
	private Member MEMBER=new Member();
	
	public MemberService(){
		super();
	}
	public MemberService(IMemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return member;
	}

	
	public IMemberDAO getMemberDAO() {
		return memberDAO;
	}
	public void setMemberDAO(IMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getERROR() {
		return ERROR;
	}
	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public Member getLOGIN_EMAIL() {
		return LOGIN_EMAIL;
	}
	public void setLOGIN_EMAIL(Member lOGIN_EMAIL) {
		LOGIN_EMAIL = lOGIN_EMAIL;
	}
	public String getMEMBER_LIST() {
		return MEMBER_LIST;
	}
	public void setMEMBER_LIST(String mEMBER_LIST) {
		MEMBER_LIST = mEMBER_LIST;
	}
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public Map getSession() {
		return session;
	}
	
	public Member getMEMBER() {
		return MEMBER;
	}
	public void setMEMBER(Member mEMBER) {
		MEMBER = mEMBER;
	}
	@Override
	public void setSession(Map<String, Object> session ) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context=context;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	

	public String viewMemberPwAndEmail() throws Exception{

		return "success";
	}
	public String removeMemberForm() throws Exception {
		LOGIN_EMAIL=(Member)session.get("LOGIN_EMAIL");
		return "success";
	}
	/**
	 * 회원추가
	 *
	 * @param request
	 * @param response
	 */
	public String addMember() throws Exception{
		
		
		
		memberDAO.insertMember(member);
		
		return "success";
	}

	/**
	 * 회원가입 창
	 * 
	 * @param request
	 * @param response
	 */
	public String addMemberForm() throws Exception {
	 
		return "success";
	}

	/**
	 * 회원가입시 중복 email 검색
	 * 
	 * @param request
	 * @param response
	 */
	public String checkMemberEmail(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		
		member=memberDAO.selectMemberemail(email);
		
		
		if (member==null) {
			ERROR="사용가능한 아이디입니다";
			
		} else {
			ERROR="이미 사용중인 아이디입니다";
		
		}
		
		return "success";
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param request
	 * @param response
	 */
	public String editMember() throws Exception{
		/* default generated stub */;
//		String email=request.getParameter("email");
//		String address=request.getParameter("address");
//		String pw=request.getParameter("pw");
//		String tel=request.getParameter("tel");
		
		
		memberDAO.updateMember(member);
		
		ERROR= "정보수정이 완료되었습니다.";
		
		return "success";
	}

	/**
	 * 회원정보 수정 창
	 * 
	 * @param request
	 * @param response
	 */
	public String editMemberForm()throws Exception {
		/* default generated stub */;
		LOGIN_EMAIL=(Member)session.get("LOGIN_EMAIL");
		return "success";
	}

	/**
	 * 로그인 처리
	 * 
	 * @param request
	 * @param response
	 */
	public String login() throws Exception {
		/* default generated stub */;
		
		member =memberDAO.selectMemberemail(email);
		
		if (member==null) {
			ERROR="존재하지 않는 아이디";
		}
		
		if(member!=null){
			if(!member.getPw().equals(pw)){
				ERROR= "비밀번호 오류";
			}else {
				
				session.put("LOGIN_EMAIL",member);
				
			}
	
		}
		return "success";
	}
	
	/**
	 * 로그인창
	 * 
	 * @param request
	 * @param response
	 */
	public String loginForm()throws Exception {
		/* default generated stub */;
	
		return "success";
	}

	/**
	 * 로그아웃 처리
	 * 
	 * @param request
	 * @param response
	 */
	public String logout() throws Exception{
		HttpSession session=request.getSession();
		session.invalidate();//세션 강제 종료
		System.out.println("로그아웃되었습니다");
		
		return "success";
	}
	/**
	 * 회원탈퇴를 위한 비밀번호 입력창 
	 */

	public String PwInMember() throws Exception{

//			RequestDispatcher rd=request.getRequestDispatcher("/member/outPwkeyword.jsp");
//			rd.forward(request, response);
	  return "success";	
	}
	
	
	
	/**
	 * 회원 탈퇴/삭제
	 * 
	 * @param request
	 * @param response
	 */
	public String removeMember() throws Exception{
		/* default generated stub */;
		LOGIN_EMAIL=(Member) session.get("LOGIN_EMAIL");
		
		if(pw==null||pw.equals("")){
			ERROR="비밀번호를 입력하시오.";
		}else if (!LOGIN_EMAIL.getPw().equals(pw)) {
			ERROR="비밀번호를 잘못 입력하셨습니다.";
		}else if (LOGIN_EMAIL.getPw().equals(pw)) {
		
			memberDAO.deleteMember(email);
			System.out.println("회원이 삭제 되었습니다.");
			ERROR="탈퇴되었습니다.";
			
//			RequestDispatcher rd=request.getRequestDispatcher("/main.jsp");
//			rd.forward(request, response);
		 
		}
		return "success";
	}

	/**
	 * 회원정보보기
	 * 
	 * @param request
	 * @param response
	 */
	public String viewMember()throws Exception {
		
		LOGIN_EMAIL=(Member) session.get("LOGIN_EMAIL");
		if(LOGIN_EMAIL==null){
			ERROR="로그인하시기 바랍니다.";
			
		}else{
			email=LOGIN_EMAIL.getEmail();
			MEMBER=memberDAO.selectMemberemail(email);
		
		}
		return "success";
	}
/**
 * 전화번호로 이메일 검색
 * @param request
 * @param response
 * @throws IOException
 * @throws ServletException
 */
	
	public String viewMemberEmail()throws Exception {
	       	   
		      member=memberDAO.selectMemberemailTel(tel);
		
		
			if(tel==null||tel.equals("")){
				ERROR="전화번호를 입력하시오.";
			
			}else if (member==null) {
				ERROR="전화번호를 잘못 입력하셨습니다.";
			}else{
				
				email=member.getEmail();
				ERROR="당신의 Email은 "+email+"입니다";
			}
			return "success";
	}
	/**
	 * 이메일과 전화번호로 검색
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	
	public String viewMemberPw()throws Exception {
			
		
			member=memberDAO.selectMemberListByPw(email, tel);
			
			if(tel.equals(null)||tel.equals("")||email.equals(null)||email.equals("")){
				ERROR="이메일과 전화번호를 입력하시오.";
			}else if (member==null) {
				ERROR="이메일과 전화번호를 잘못 입력하였습니다.";
			}else {
				
				pw=member.getPw();
				ERROR="당신의 Email은 "+pw+"입니다";
				
			}
			return "success";
		
	}

	/**
	 * 전체 회원명단 보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberList() throws Exception{
		int page=1;//페이지수

		
		if(request.getParameter("page")!=null){//page 값이 널이면
			  page=Integer.parseInt(request.getParameter("page"));
			  //현제 페이지값리턴 
		  }
		int length=5;//페이지내용크기

	    List<Member>memberList=
				memberDAO.selectMemberList(page, length);//맴버호출 
		  
		 
		 int memberCount=memberDAO.selectMemberCount();
		 String pageLink=PageUtil.generate(page, memberCount, length, 
				 "/bookchange/MemberService?method=viewMemberList");
		 request.setAttribute("PAGE_LINK_TAG", pageLink);
		 
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
		
		List<Member> memberList=null;
		int memberCount=0;

		if(request.getParameter("keyword")==null||
			request.getParameter("keyword").equals("")){
				memberList=
						memberDAO.selectMemberList(page, length);
				memberCount=
						memberDAO.selectMemberCount();
				
		}else{
				memberList=
							memberDAO.selectMemberListByEmail(length, page, request.getParameter("keyword"));
				memberCount=
						memberDAO.selectMemberCountemail(request.getParameter("keyword"));
				
							
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
