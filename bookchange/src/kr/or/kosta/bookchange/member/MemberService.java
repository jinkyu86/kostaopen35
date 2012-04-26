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
	 * ȸ���߰�
	 *
	 * @param request
	 * @param response
	 */
	public String addMember() throws Exception{
		
		
		
		memberDAO.insertMember(member);
		
		return "success";
	}

	/**
	 * ȸ������ â
	 * 
	 * @param request
	 * @param response
	 */
	public String addMemberForm() throws Exception {
	 
		return "success";
	}

	/**
	 * ȸ�����Խ� �ߺ� email �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public String checkMemberEmail(HttpServletRequest request,
			HttpServletResponse response)throws IOException,ServletException {
		
		member=memberDAO.selectMemberemail(email);
		
		
		if (member==null) {
			ERROR="��밡���� ���̵��Դϴ�";
			
		} else {
			ERROR="�̹� ������� ���̵��Դϴ�";
		
		}
		
		return "success";
	}

	/**
	 * ȸ������ ����
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
		
		ERROR= "���������� �Ϸ�Ǿ����ϴ�.";
		
		return "success";
	}

	/**
	 * ȸ������ ���� â
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
	 * �α��� ó��
	 * 
	 * @param request
	 * @param response
	 */
	public String login() throws Exception {
		/* default generated stub */;
		
		member =memberDAO.selectMemberemail(email);
		
		if (member==null) {
			ERROR="�������� �ʴ� ���̵�";
		}
		
		if(member!=null){
			if(!member.getPw().equals(pw)){
				ERROR= "��й�ȣ ����";
			}else {
				
				session.put("LOGIN_EMAIL",member);
				
			}
	
		}
		return "success";
	}
	
	/**
	 * �α���â
	 * 
	 * @param request
	 * @param response
	 */
	public String loginForm()throws Exception {
		/* default generated stub */;
	
		return "success";
	}

	/**
	 * �α׾ƿ� ó��
	 * 
	 * @param request
	 * @param response
	 */
	public String logout() throws Exception{
		HttpSession session=request.getSession();
		session.invalidate();//���� ���� ����
		System.out.println("�α׾ƿ��Ǿ����ϴ�");
		
		return "success";
	}
	/**
	 * ȸ��Ż�� ���� ��й�ȣ �Է�â 
	 */

	public String PwInMember() throws Exception{

//			RequestDispatcher rd=request.getRequestDispatcher("/member/outPwkeyword.jsp");
//			rd.forward(request, response);
	  return "success";	
	}
	
	
	
	/**
	 * ȸ�� Ż��/����
	 * 
	 * @param request
	 * @param response
	 */
	public String removeMember() throws Exception{
		/* default generated stub */;
		LOGIN_EMAIL=(Member) session.get("LOGIN_EMAIL");
		
		if(pw==null||pw.equals("")){
			ERROR="��й�ȣ�� �Է��Ͻÿ�.";
		}else if (!LOGIN_EMAIL.getPw().equals(pw)) {
			ERROR="��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.";
		}else if (LOGIN_EMAIL.getPw().equals(pw)) {
		
			memberDAO.deleteMember(email);
			System.out.println("ȸ���� ���� �Ǿ����ϴ�.");
			ERROR="Ż��Ǿ����ϴ�.";
			
//			RequestDispatcher rd=request.getRequestDispatcher("/main.jsp");
//			rd.forward(request, response);
		 
		}
		return "success";
	}

	/**
	 * ȸ����������
	 * 
	 * @param request
	 * @param response
	 */
	public String viewMember()throws Exception {
		
		LOGIN_EMAIL=(Member) session.get("LOGIN_EMAIL");
		if(LOGIN_EMAIL==null){
			ERROR="�α����Ͻñ� �ٶ��ϴ�.";
			
		}else{
			email=LOGIN_EMAIL.getEmail();
			MEMBER=memberDAO.selectMemberemail(email);
		
		}
		return "success";
	}
/**
 * ��ȭ��ȣ�� �̸��� �˻�
 * @param request
 * @param response
 * @throws IOException
 * @throws ServletException
 */
	
	public String viewMemberEmail()throws Exception {
	       	   
		      member=memberDAO.selectMemberemailTel(tel);
		
		
			if(tel==null||tel.equals("")){
				ERROR="��ȭ��ȣ�� �Է��Ͻÿ�.";
			
			}else if (member==null) {
				ERROR="��ȭ��ȣ�� �߸� �Է��ϼ̽��ϴ�.";
			}else{
				
				email=member.getEmail();
				ERROR="����� Email�� "+email+"�Դϴ�";
			}
			return "success";
	}
	/**
	 * �̸��ϰ� ��ȭ��ȣ�� �˻�
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	
	public String viewMemberPw()throws Exception {
			
		
			member=memberDAO.selectMemberListByPw(email, tel);
			
			if(tel.equals(null)||tel.equals("")||email.equals(null)||email.equals("")){
				ERROR="�̸��ϰ� ��ȭ��ȣ�� �Է��Ͻÿ�.";
			}else if (member==null) {
				ERROR="�̸��ϰ� ��ȭ��ȣ�� �߸� �Է��Ͽ����ϴ�.";
			}else {
				
				pw=member.getPw();
				ERROR="����� Email�� "+pw+"�Դϴ�";
				
			}
			return "success";
		
	}

	/**
	 * ��ü ȸ����� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberList() throws Exception{
		int page=1;//��������

		
		if(request.getParameter("page")!=null){//page ���� ���̸�
			  page=Integer.parseInt(request.getParameter("page"));
			  //���� ������������ 
		  }
		int length=5;//����������ũ��

	    List<Member>memberList=
				memberDAO.selectMemberList(page, length);//�ɹ�ȣ�� 
		  
		 
		 int memberCount=memberDAO.selectMemberCount();
		 String pageLink=PageUtil.generate(page, memberCount, length, 
				 "/bookchange/MemberService?method=viewMemberList");
		 request.setAttribute("PAGE_LINK_TAG", pageLink);
		 
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
