package kr.or.kosta.auction.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.auction.AuctionDAO;
import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.bid.BidDAO;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;

public class MemberService implements ModelDriven, SessionAware  {
	private static final long serialVersionUID = 1L;
	private List<Member> MEMBER_LIST;
	private Member MEMBER;
	private String userid;
	private Member member = new Member();
    private String ERROR;
    private Map session;
    
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public Object getModel() {

		return member;
	}

	public List<Member> getMEMBER_LIST() {
		return MEMBER_LIST;
	}

	public void setMEMBER_LIST(List<Member> mEMBER_LIST) {
		MEMBER_LIST = mEMBER_LIST;
	}

	public Member getMEMBER() {
		return MEMBER;
	}

	public void setMEMBER(Member member) {
		this.member = member;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public MemberService() {
		super();

	}

	public String addMemberForm() throws Exception {

		return "success";

	}

	public String removeMember() throws Exception {

		MemberDAO.deleteMember(userid);
		return "success";
	}

	public String editMember() throws Exception {

		MemberDAO.updateMember(member);

		return "success";

	}

	public String editMemberForm() throws Exception {

		MEMBER = MemberDAO.selectMember(userid);
		return "success";

	}

	public String viewMember() throws Exception {
		MEMBER = MemberDAO.selectMember(userid);
		return "success";

	}

	public String addMember() throws Exception {
		/*
		 * �Ӽ��� �����ϸ� num �Ķ���ͷ� viewBoard()�޼���� ���� -getNum(),setNum()ȣ���ؼ������ϹǷ�
		 * setter/getter �ݵ�� �־����
		 */
		MemberDAO.insertMember(member);
		return "success";
	}

	public String viewMemberList() throws Exception {
		// ��ü �Խù� ����Ʈ ����
		MEMBER_LIST = MemberDAO.selectMemberList();
		return "success";
	}

	public String login() throws Exception {

		
		 Member member1 = MemberDAO.selectMember(member.getUserid());
		 
		 String pw=member1.getPw();
		// 4.3�� ���ϰ��� null�̸�
		// request�� �Ӽ���:ERROR ��:�������� �ʴ� ���̵�
		// ����
		if (member1==null) {
			ERROR="�������� �ʴ� ���̵�";
		} else {
			// 5.3�� ���ϰ��� null�� �ƴϸ� 3�� ȸ���� �����
			// 2�� �Է��� ��� �� �ٸ���
			// request �� �Ӽ���:ERROR ��:��й�ȣ ���� ����
			if (!member.getPw().equals(pw)) {
				ERROR="��й�ȣ ����";
			} else {
				// 6.5���� ��й�ȣ�� ��ġ�ϸ�
				// HttpSession���� �Ӽ���:LOGIN_MEMBER
				// ��:3�� ��ü
				session.put("MEMBER", member);
				
			}// end else
		}// end if
		return "success";

	}

	/**
	 * @param request
	 * @param response
	 */
	public String logout() throws Exception {
		session.remove("MEMBER");
		return "success";
	}

	/**
	 * @param request
	 * @param response
	 */
	public String loginForm() throws Exception {		
		return "success";
	}
	
	 public String editMemberByadmin() throws Exception {
	
	 //3.ȸ�������� �����ϴ� �޼��� ȣ��
	 MemberDAO.updateMember(member);
	 return "success";
	
	
	 }


}     
// public class MemberService extends HttpServlet {
// private static final long serialVersionUID = 1L;
//
// /**
// * @param request
// * @param response
// */
// public MemberService() {
// super();
// }
//
// protected void doGet(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// doPost(request, response);
// }
//
// protected void doPost(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
//
// request.setCharacterEncoding("utf-8");
// String method = request.getParameter("method");
// if(method==null){
// method="viewMemberList";
// }
// if("viewMemberList".equals(method)){
// viewMemberList(request,response);
// }else if ("viewMember".equals(method)) {
// viewMember(request, response);
// } else if ("editMemberForm".equals(method)) {
// editMemberForm(request, response);
// } else if ("editMember".equals(method)) {
// editMember(request, response);
// } else if ("removeMember".equals(method)) {
// removeMember(request, response);
// } else if ("addMemberForm".equals(method)) {
// addMemberForm(request, response);
// } else if ("addMember".equals(method)) {
// addMember(request, response);
// } else if ("loginForm".equals(method)) {
// loginForm(request, response);
// } else if ("login".equals(method)) {
// login(request, response);
// } else if ("logout".equals(method)) {
// logout(request, response);
// } else if ("checkuserID".equals(method)){
// checkuserID(request, response);
// } else if ("editMemberByadmin".equals(method)){
// editMemberByadmin(request,response);
// }
// }// end method doPost
//
//
//
//
//
//
// private void editMemberByadmin(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// String userid=request.getParameter("userid");
// String pw=request.getParameter("pw");
// String email=request.getParameter("email");
// String name=request.getParameter("name");
// String coin=request.getParameter("coin");
// String emoney=request.getParameter("emoney");
// //2.1�� ������ �̿��ؼ� Member ��ü ����
// Member member=new Member();
// member.setUserid(userid);
// member.setPw(pw);
// member.setEmail(email);
// member.setName(name);
// member.setCoin(coin);
// member.setEmoney(emoney);
//
//
// //3.ȸ�������� �����ϴ� �޼��� ȣ��
// MemberDAO.updateMember(member);
// //4.ȸ������ ��ȸȭ������ �̵� ��ü ����
// RequestDispatcher
// rd=request.getRequestDispatcher("/MemberService?method=viewMemberList");
// rd.forward(request, response);
//
// }
//
// private void checkuserID(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException{
// // TODO Auto-generated method stubString userid =
// request.getParameter("userid");
// String userid = request.getParameter("userid");
// Member member = MemberDAO.selectMember(userid);
// response.setContentType("text/html;charset=utf-8");
// PrintWriter out = response.getWriter();
// if(member==null){
// out.print(userid+"�� ��� ������ ���̵� �Դϴ�.");
// }else{
// out.print(userid+"�� �̹� ������� ���̵� �Դϴ�.");
// }
// out.flush();
// out.close();
//
// }
//
// private void addMember(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// // 1.�Ķ���� ���� ����
// String userid = request.getParameter("userid");
// String pw = request.getParameter("pw");
// String email = request.getParameter("email");
// String name = request.getParameter("name");
// String coin = request.getParameter("coin");
// String emoney = request.getParameter("emoney");
// // 2.Member ��ü ���� 1�� �Ӽ��� ����
// Member member = new Member();
// member.setUserid(userid);
// member.setPw(pw);
// member.setEmail(email);
// member.setName(name);
// member.setCoin(coin);
// member.setEmoney(emoney);
// // 3.DB�� ����
// MemberDAO.insertMember(member);
// // 4.��ü ȸ������Ʈ �̵� ��ü
// RequestDispatcher rd =
// request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
// // 5.������ �̵�
// rd.forward(request, response);
//
// }
//
// /**
// * @param request
// * @param response
// */
// private void addMemberForm(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
//
// //1.ȸ���߰� ������ �̵� ��ü ����
// RequestDispatcher rd=request.getRequestDispatcher("/member/addMember.jsp");
// //2.������ �̵�
// rd.forward(request, response);
//
// }
//
// /**
// * @param request
// * @param response
// */
// private void editMember(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// String userid=request.getParameter("userid");
// String pw=request.getParameter("pw");
// String email=request.getParameter("email");
// String name=request.getParameter("name");
// String coin=request.getParameter("coin");
// String emoney=request.getParameter("emoney");
// //2.1�� ������ �̿��ؼ� Member ��ü ����
// Member member=new Member();
// member.setUserid(userid);
// member.setPw(pw);
// member.setEmail(email);
// member.setName(name);
// member.setCoin(coin);
// member.setEmoney(emoney);
//
//
// //3.ȸ�������� �����ϴ� �޼��� ȣ��
// MemberDAO.updateMember(member);
// //4.ȸ������ ��ȸȭ������ �̵� ��ü ����
// RequestDispatcher
// rd=request.getRequestDispatcher("/MemberService?method=viewMember");
// rd.forward(request, response);
// }
//
// /**
// * @param request
// * @param response
// */
// private void editMemberForm(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// RequestDispatcher rd= request.getRequestDispatcher("/member/editMember.jsp");
// rd.forward(request, response);
// }
//
// /**
// * @param request
// * @param response
// */
// private void viewMember(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// //���ǿ��� ������� ����
// HttpSession session=request.getSession();
// Member member=(Member)session.getAttribute("MEMBER");
// //���̵� ����
// String userid=member.getUserid();
//
// //DB�� �ִ� ������ ȸ������ ����
// member=MemberDAO.selectMember(userid);
// //�ش�ID�� �ֱ� ������ 5���� ��������Ʈ ȣ��
// List<Bid> bidList=BidDAO.selectBidListByID(5, 1, userid);
// //�ش�ID�� ������ ��������Ʈ
// List<Auction> soldList=AuctionDAO.selectAuctionSoldById(userid);
// for(int i=0;i<soldList.size();i++){
// String aNum=soldList.get(i).getaNum();
// BidDAO.updateMoneybackByIdInAuction(userid, aNum);
// }
// //���ǿ� ���� ����
// session.setAttribute("MEMBER", member);
// session.setAttribute("BID_LIST", bidList);
// session.setAttribute("SOLD_LIST",soldList);
// RequestDispatcher rd=
// request.getRequestDispatcher("/member/viewMember.jsp");
// rd.forward(request, response);
//
// }
//
// /**
// * @param request
// * @param response
// */
// private void removeMember(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// HttpSession session=request.getSession();
// String userid=request.getParameter("userid");
// BidDAO.deleteBidById(userid);
// MemberDAO.deleteMember(userid);
//
// Member member=(Member)session.getAttribute("MEMBER");
// if("admin".equals(member.getUserid())){
// RequestDispatcher
// rd=request.getRequestDispatcher("/MemberService?method=viewMemberList");
// rd.forward(request, response);
// }else{
// session.invalidate();
// RequestDispatcher
// rd=request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
// rd.forward(request, response);
// }
//
// }
//
// /**
// * @param request
// * @param response
// */
// private void login(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException {
// // 1.userid �Ķ���� ����
// String userid = request.getParameter("userid");
// // 2.pw �Ķ���� ����
// String pw = request.getParameter("pw");
// // 3.���̵� ��ġ�ϴ� ȸ������ ��ȸ
// Member member = MemberDAO.selectMember(userid);
// // 4.3�� ���ϰ��� null�̸�
// // request�� �Ӽ���:ERROR ��:�������� �ʴ� ���̵�
// // ����
// if (member == null) {
// request.setAttribute("ERROR", "�������� �ʴ� ���̵�");
// } else {
// // 5.3�� ���ϰ��� null�� �ƴϸ� 3�� ȸ���� �����
// // 2�� �Է��� ��� �� �ٸ���
// // request �� �Ӽ���:ERROR ��:��й�ȣ ���� ����
// if (!member.getPw().equals(pw)) {
// request.setAttribute("ERROR", "��й�ȣ ����");
// } else {
// // 6.5���� ��й�ȣ�� ��ġ�ϸ�
// // HttpSession���� �Ӽ���:LOGIN_MEMBER
// // ��:3�� ��ü
// HttpSession session = request.getSession();
// session.setAttribute("MEMBER", member);
// }// end else
// }// end if
// // 7. /GoodService?method=viewGoodList�� �̵�
// RequestDispatcher rd =
// request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
// rd.forward(request, response);
//
// }
//
// /**
// * @param request
// * @param response
// */
// private void logout(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException {
// HttpSession session = request.getSession();
// session.invalidate();
// RequestDispatcher rd =
// request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
// rd.forward(request, response);
//
// }
//
// /**
// * @param request
// * @param response
// */
// private void loginForm(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// RequestDispatcher rd=request.getRequestDispatcher("/member/login.jsp");
// rd.forward(request, response);
//
// }
//
//
// private void viewMemberList(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
// List<Member> memberList=MemberDAO.selectMemberList();
// request.setAttribute("MEMBER_LIST",memberList);
// RequestDispatcher
// rd=request.getRequestDispatcher("/member/viewMemberList.jsp");
// rd.forward(request, response);
// }
// }
