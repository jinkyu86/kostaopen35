package kr.or.kosta.bookchange.change;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.PageUtil;

public class ChangeService extends HttpServlet {
	
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
		}else if("viewChange".equals(method)){
			viewChange(request,response);
		}else if("addChange".equals(method)){
			addChange(request,response);
		}
	}
	
	private void addChange(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		String agreeBoardNo=request.getParameter("agreeBoardNo");
		String demandBoardNo=request.getParameter("demandBoardNo");
		
		Board agreeBoard=new Board();
		agreeBoard.setBoardNo(Integer.parseInt(agreeBoardNo));
		
		Board demandBoard=new Board();
		demandBoard.setBoardNo(Integer.parseInt(demandBoardNo));
		
		Change change=new Change();
		change.setAgreeBoard(agreeBoard);
		change.setDemandBoard(demandBoard);
		
		ChangeDAO.insertChange(change);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request, response);
		
	}
	
	private void viewChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		String num=request.getParameter("boardNo");
		Board board=BoardDAO.selectBoard(num);
		request.setAttribute("CHANGEBOARD", board);
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoard.jsp");
		rd.forward(request, response);
	}

	/**전체 교환관련 리스트 보기**/
	private void viewChangeList(HttpServletRequest request,
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
		session.setAttribute("MY_CHANGE_LIST", agreeList);
		ArrayList<Change>demandList=ChangeDAO.selectChangeRequestList(length, page, memberEmail);
		session.setAttribute("MY_CHANGE_LIST", demandList);
		int agreeChangeCount=ChangeDAO.selectChangeMyboardCount(memberEmail);
		int demandChangeCount=ChangeDAO.selectChangeRequestCount(memberEmail);
		int changeCount=agreeChangeCount+demandChangeCount;
		String pageLinkTag=PageUtil.generate(page, changeCount, length, "");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("");
		rd.forward(request, response);
	}

	
}
