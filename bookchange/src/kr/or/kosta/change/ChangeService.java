package kr.or.kosta.change;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.PageUtil;

public class ChangeService {
	
	private static final long serialVersionUID = 1L;
	
	public ChangeService() {
	        super();
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if(method==null){
			method="viewChangeList";
		}
		if("viewChangeList".equals(method)){
			viewChangeList(request,response);
		}else if("agreeChangeList".equals(method)){
			agreeChangeList(request,response);
		}else if("demandChangeList".equals(method)){
			demandChangeList(request,response);
		}else if("addChangeForm".equals(method)){
			addChangeForm(request,response);
		}else if("addChange".equals(method)){
			addChange(request, response);
		}else if("matchChangeForm".equals(method)){
			matchChangeForm(request,response);
		}else if("matchChange".equals(method)){
			matchChange(request,response);
		}
		
	}
	
	private void matchChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		
		HttpSession session=request.getSession();
		ArrayList<Change>agreeList=(ArrayList<Change>)session.getAttribute("AGREE_LIST");
		if(agreeList==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		
	}

	private void matchChangeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_EMAIL");
		int page=1;
		int length=7;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		String memberEmail=member.getEmail();
		ArrayList<Change>changeList=ChangeDAO.selectChangeMyboardList(length, page, memberEmail);
		request.setAttribute("AGREE_LIST", changeList);
		int changeCount=ChangeDAO.selectChangeMyboardCount(memberEmail);
		String pageLinkTag=PageUtil.generate(page, changeCount, length, "");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request, response);
		
	}

	private void addChangeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_EMAIL");
		int page=1;
		int length=7;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		String memberEmail=member.getEmail();
		ArrayList<Board>boardList=BoardDAO.selectBoardListbyEmail(length, page, memberEmail);
		request.setAttribute("MY_BOARD_LIST", boardList);
		int boardCount=BoardDAO.selectBoardEmailCount(memberEmail);
		String pageLinkTag=PageUtil.generate(page, boardCount, length, "");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request, response);
	}

	/**교환리스트에 새로운 교환 추가**/
	private void addChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		
		HttpSession session=request.getSession();
		Board selectBoard=(Board)session.getAttribute("BOARD");
		if(selectBoard==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		String demandBoardNo=request.getParameter("demandBoardNo");
		int agreeBoardNo=selectBoard.getBoardNo();
		
		Board demandBoard=new Board();
		demandBoard.setBoardNo(Integer.parseInt(demandBoardNo));
		Board agreeBoard=new Board();
		agreeBoard.setBoardNo(agreeBoardNo);
		
		Change change=new Change();
		change.setAgreeBoard(agreeBoard);
		change.setDemandBoard(demandBoard);
		
		ChangeDAO.insertChange(change);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request, response);
	}

	/**로그인후 전체 교환관련 리스트 보기**/
	private void viewChangeList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int length=5;
		
		ArrayList<Change> changeList=ChangeDAO.selectChangeList(length, page);
		request.setAttribute("CHANGE_LIST", changeList);
		int  changeCount=ChangeDAO.selectChangeCount();
		String pageLinkTag=	PageUtil.generate(page, changeCount, length, "ChangeService?method=viewChangeList");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("/change/viewChangeList.jsp");
		rd.forward(request, response);
//		HttpSession session=request.getSession();
//		Member member=(Member)session.getAttribute("LOGIN_EMAIL");
//		int page=1;
//		int length=7;
//		if(request.getParameter("page")!=null){
//			page=Integer.parseInt(request.getParameter("page"));
//		}
//		if(member==null){
//			RequestDispatcher rd=request.getRequestDispatcher("");
//			rd.forward(request, response);
//			return;
//		}
//		String memberEmail=member.getEmail();
//		ArrayList<Change>agreeList=ChangeDAO.selectChangeMyboardList(length, page, memberEmail);
//		session.setAttribute("MY_CHANGE_LIST", agreeList);
//		ArrayList<Change>demandList=ChangeDAO.selectChangeRequestList(length, page, memberEmail);
//		session.setAttribute("MY_CHANGE_LIST", demandList);
//		int agreeChangeCount=ChangeDAO.selectChangeMyboardCount(memberEmail);
//		int demandChangeCount=ChangeDAO.selectChangeRequestCount(memberEmail);
//		int changeCount=agreeChangeCount+demandChangeCount;
//		String pageLinkTag=PageUtil.generate(page, changeCount, length, "");
//		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
//		RequestDispatcher rd=request.getRequestDispatcher("");
//		rd.forward(request, response);
	}

	/**로그인후 나에게 교환을 신청한 LIST보기**/
	private void agreeChangeList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_EMAIL");
		int page=1;
		int length=7;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		String memberEmail=member.getEmail();
		ArrayList<Change>agreeList=ChangeDAO.selectChangeMyboardList(length, page, memberEmail);
		session.setAttribute("AGREE_CHANGE_LIST", agreeList);
		int changeCount=ChangeDAO.selectChangeMyboardCount(memberEmail);
		String pageLinkTag=PageUtil.generate(page, changeCount, length, "");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request, response);	
	}
	
	/**로그인후 내가 교환을 요청한 LIST보기**/
	private void demandChangeList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
	
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_EMAIL");
		int page=1;
		int length=7;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		String memberEmail=member.getEmail();
		ArrayList<Change>demandList=ChangeDAO.selectChangeRequestList(length, page, memberEmail);
		session.setAttribute("DEMAND_CHANGE_LIST", demandList);
		int changeCount=ChangeDAO.selectChangeRequestCount(memberEmail);
		String pageLinkTag=PageUtil.generate(page, changeCount, length, "");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request, response);
	}
}
