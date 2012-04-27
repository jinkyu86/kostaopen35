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
	

	//회원정보
	public String viewMember() throws Exception {
		return "success";
	}

	//회원정보 수정
	public String editMember() throws Exception {
		memberDAO.updateMember(member);
		session.put("member", memberDAO.login(member));
		return "success";
	}

	//회원정보 수정폼
	public String editMemberForm() throws Exception {
		return "success";
	}

	//회원탈퇴
	public String removeMember() throws Exception {
		memberDAO.deleteMember(memberid);
		session.remove("member");
		return "success";
	}

	//회원가입
	public String addMember() throws Exception {
		memberDAO.insertMember(member);
		session.put("member", memberDAO.login(member));
		return "success";
	}

	//회원가입폼
	public String addMemberForm() throws Exception {
		return "success";
	}

	//로그인
	public String login() throws Exception {
		Member loginMember = memberDAO.login(member);
		session.put("member", loginMember);
		return "success";
		
	}

	//로그인폼
	public String loginForm() throws Exception {
		return "success";
	}
	
	//로그아웃
	public String logout() throws Exception {
		session.remove("member");
		return "success";
	}

	//아이디중복 확인
	public String checkMemberID() throws IOException {

//		response.setCharacterEncoding("utf-8");
//		PrintWriter out=response.getWriter();
//		if(MemberDAO.selectMemberByid(member)==null){
//			out.print(memberid+"는 사용 가능한 아이디입니다.");
//		}else{
//			out.print(memberid+"는 이미 사용중인 아이디입니다.");
//		}
//		out.flush();
//		out.close();
		return "success";
	}


	//회원아이디 찾기
	public String searchMemberID() throws Exception{
		MEMBER=memberDAO.selectMemberByid(member);
		return "success";
	}

	//회원아이디찾기 폼
	public String searchMemberIDForm() throws Exception {
		return "success";
	}

	//회원 비밀번호찾기
	public String searchMemberPW() throws Exception{
		MEMBER=memberDAO.selectMemberBypw(member);
		return "success";
	}

	//회원 비밀번호찾기 폼
	public String searchMemberPwForm() throws Exception{
		return "success";
	}

	//회원 비밀번호변경
	public String changeMemberPW() throws Exception{
		memberDAO.updateMember(member);
		return "success";
	}

	//회원 비밀번호변경 폼
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
