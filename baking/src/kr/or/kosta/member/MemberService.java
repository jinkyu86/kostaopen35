package kr.or.kosta.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import kr.or.kosta.aop.IService;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;


public class MemberService implements IService, ModelDriven, SessionAware{
	private IMemberDAO memberDAO;
	
	private static final long serialVersionUID = 1L;
	
	private Map session;
	private Member MEMBER;
	private Member member = new Member();
	private String memberid;
	
	@Override
	public Map getSession() {
		return session;
	}

	public MemberService(IMemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	
	public MemberService() {
	}
	

	//ȸ������
	public String viewMember() throws Exception {
		return "success";
	}

	//ȸ������ ����
	public String editMember() throws Exception {
		memberDAO.updateMember(member);
		session.put("member", memberDAO.login(member));
		return "success";
	}

	//ȸ������ ������
	public String editMemberForm() throws Exception {
		return "success";
	}

	//ȸ��Ż��
	public String removeMember() throws Exception {
		memberDAO.deleteMember(memberid);
		session.remove("member");
		return "success";
	}

	//ȸ������
	public String addMember() throws Exception {
		memberDAO.insertMember(member);
		session.put("member", memberDAO.login(member));
		return "success";
	}

	//ȸ��������
	public String addMemberForm() throws Exception {
		return "success";
	}

	//�α���
	public String login() throws Exception {
		Member loginMember = memberDAO.login(member);
		session.put("member", loginMember);
		return "success";
		
	}

	//�α�����
	public String loginForm() throws Exception {
		return "success";
	}
	
	//�α׾ƿ�
	public String logout() throws Exception {
		session.remove("member");
		return "success";
	}

	//���̵��ߺ� Ȯ��
	public String checkMemberID() throws IOException {

//		response.setCharacterEncoding("utf-8");
//		PrintWriter out=response.getWriter();
//		if(MemberDAO.selectMemberByid(member)==null){
//			out.print(memberid+"�� ��� ������ ���̵��Դϴ�.");
//		}else{
//			out.print(memberid+"�� �̹� ������� ���̵��Դϴ�.");
//		}
//		out.flush();
//		out.close();
		return "success";
	}


	//ȸ�����̵� ã��
	public String searchMemberID() throws Exception{
		MEMBER=memberDAO.selectMemberByid(member);
		return "success";
	}

	//ȸ�����̵�ã�� ��
	public String searchMemberIDForm() throws Exception {
		return "success";
	}

	//ȸ�� ��й�ȣã��
	public String searchMemberPW() throws Exception{
		MEMBER=memberDAO.selectMemberBypw(member);
		return "success";
	}

	//ȸ�� ��й�ȣã�� ��
	public String searchMemberPwForm() throws Exception{
		return "success";
	}

	//ȸ�� ��й�ȣ����
	public String changeMemberPW() throws Exception{
		memberDAO.updateMember(member);
		return "success";
	}

	//ȸ�� ��й�ȣ���� ��
	public String changeMemberPWForm() throws Exception{
		return "success";
	}
	
	@Override
	public Object getModel() {
		return member;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	public Member getMEMBER() {
		return MEMBER;
	}

	public void setMEMBER(Member mEMBER) {
		MEMBER = mEMBER;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	


}
