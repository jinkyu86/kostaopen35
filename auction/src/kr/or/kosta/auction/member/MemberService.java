package kr.or.kosta.auction.member;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.bid.BidDAO;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;





public class MemberService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 */
	public MemberService() {
		super();		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if(method==null){
			method="viewMemberList";
		}
		if("viewMemberList".equals(method)){
			viewMemberList(request,response);
		}else if ("viewMember".equals(method)) {
			viewMember(request, response);
		} else if ("editMemberForm".equals(method)) {
			editMemberForm(request, response);
		} else if ("editMember".equals(method)) {
			editMember(request, response);
		} else if ("removeMember".equals(method)) {
			removeMember(request, response);
		} else if ("addMemberForm".equals(method)) {
			addMemberForm(request, response);
		} else if ("addMember".equals(method)) {
			addMember(request, response);
		} else if ("loginForm".equals(method)) {
			loginForm(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		} else if ("logout".equals(method)) {
			logout(request, response);
		}
	}// end method doPost

	
	
		
	

	private void addMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.파라메터 정보 리턴
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String coin = request.getParameter("coin");
		String emoney = request.getParameter("emoney");
		// 2.Member 객체 생성 1의 속성을 저장
		Member member = new Member();
		member.setUserid(userid);
		member.setPw(pw);
		member.setEmail(email);
		member.setName(name);
		member.setCoin(coin);
		member.setEmoney(emoney);
		// 3.DB에 저장
		MemberDAO.insertMember(member);
		// 4.전체 회원리스트 이동 객체
		RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		// 5.페이지 이동
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void addMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//1.회원추가 페이지 이동 객체 생성
		RequestDispatcher rd=request.getRequestDispatcher("/member/addMember.jsp");
		//2.페이지 이동
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				String userid=request.getParameter("userid");
				String pw=request.getParameter("pw");
				String email=request.getParameter("email");
				String name=request.getParameter("name");
				String coin=request.getParameter("coin");
				String emoney=request.getParameter("emoney");
				//2.1의 정보를 이용해서 Member 객체 생성
				Member member=new Member();
				member.setUserid(userid);
				member.setPw(pw);
				member.setEmail(email);
				member.setName(name);
				member.setCoin(coin);
				member.setEmoney(emoney);
				
				
				//3.회원정보를 수정하는 메서드 호출
				MemberDAO.updateMember(member);
				//4.회원정보 조회화면으로 이동 객체 생성
				RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewMember");
				rd.forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 */
	private void editMemberForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {				
				RequestDispatcher  rd=
						request.getRequestDispatcher("/member/editMember.jsp");
				rd.forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//세션에서 멤버정보 추출
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("MEMBER");
		//아이디 추출
		String userid=member.getUserid();
		
		//DB에 있는 정보로 회원정보 갱신
		member=MemberDAO.selectMember(userid);
		//해당ID의 최근 입찰한 5개의 입찰리스트 호출
		ArrayList<Bid> bidList=BidDAO.selectBidListByID(5, 1, userid);
		//세션에 정보 저장
		session.setAttribute("BID_LIST", bidList);
		RequestDispatcher rd=
				request.getRequestDispatcher("/member/viewMember.jsp");
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void removeMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		String userid=request.getParameter("userid");
		BidDAO.deleteBidById(userid);
		MemberDAO.deleteMember(userid);
		RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=viewAuctionList");
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.userid 파라메터 리턴
		String userid = request.getParameter("userid");
		// 2.pw 파라메터 리턴
		String pw = request.getParameter("pw");
		// 3.아이디가 일치하는 회원정보 조회
		Member member = MemberDAO.selectMember(userid);
		// 4.3의 리턴값이 null이면
		// request에 속성명:ERROR 값:존재하지 않는 아이디
		// 저장
		if (member == null) {
			request.setAttribute("ERROR", "존재하지 않는 아이디");
		} else {
			// 5.3의 리턴값이 null이 아니면 3의 회원의 비번과
			// 2의 입력한 비번 비교 다르면
			// request 에 속성명:ERROR 값:비밀번호 오류 저장
			if (!member.getPw().equals(pw)) {
				request.setAttribute("ERROR", "비밀번호 오류");
			} else {
				// 6.5에서 비밀번호가 일치하면
				// HttpSession리턴 속성명:LOGIN_MEMBER
				// 값:3의 객체
				HttpSession session = request.getSession();
				session.setAttribute("MEMBER", member);
			}// end else
		}// end if
			// 7. /GoodService?method=viewGoodList로 이동
		RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void loginForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);

	}
	
	
	private void viewMemberList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> memberList=MemberDAO.selectMemberList();
		request.setAttribute("MEMBER_LIST",memberList);
		RequestDispatcher rd=request.getRequestDispatcher("/member/viewMemberList.jsp");
		rd.forward(request, response);
	}
}
