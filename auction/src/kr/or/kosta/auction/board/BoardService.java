package kr.or.kosta.auction.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.util.PageUtil;

public class BoardService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String  method=request.getParameter("method");
		if(method==null){
			method="viewBoardList";
		}if("addBoard".equals(method)){
			addBoard(request, response);
		}else if("addBoardForm".equals(method)){
			addBoardForm(request, response);
		}else if("editBoard".equals(method)){
			editBoard(request, response);
		}else if("editBoardForm".equals(method)){
			editBoardForm(request, response);
		}else if("viewBoard".equals(method)){
			viewBoard(request, response);
		}else if("viewBoardList".equals(method)){
			viewBoardList(request, response);
		}else if("removeBoard".equals(method)){
			removeBoard(request, response);
		}else if("searchBoardList".equals(method)){
			searchBoardList(request, response);
		}
		
	}//end method doPost

	private void addBoard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid=
				request.getParameter("userid");
		String title=
				request.getParameter("title");
		String content=
				request.getParameter("content");
		Board board=new Board();
		board.setTitle(title);
		board.setContent(content);
		Member member = new Member();
		member.setUserid(userid);
		board.setMember(member);
		
		BoardDAO.insertBoard(board);
		
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/BoardService?method=viewBoardList");
		rd.forward(request, response);
	}

	private void addBoardForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/board/addBoard.jsp");
		rd.forward(request, response);
	}

	private void editBoard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bNum=request.getParameter("bNum");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		Board board=new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setbNum(bNum);
		
		BoardDAO.updateBoard(board);
		
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/BoardService?method=viewBoard&" +
						"bNum="+bNum);
		
		rd.forward(request, response);
	}

	private void editBoardForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bNum=request.getParameter("bNum");
		Board board=BoardDAO.selectBoard(bNum);
		request.setAttribute("BOARD",board);
		RequestDispatcher rd=
				request.getRequestDispatcher("/board/editBoard.jsp");
		rd.forward(request, response);
	}

	private void viewBoard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bNum=request.getParameter("bNum");
		Board  board=BoardDAO.selectBoard(bNum);
		request.setAttribute("BOARD",board);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/board/viewBoard.jsp");
		rd.forward(request, response);
	}

	private void viewBoardList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> boardList=	BoardDAO.selectBoardList();
		request.setAttribute("BOARD_LIST",boardList);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/board/viewBoardList.jsp");
		rd.forward(request, response);
	}

	private void removeBoard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("bNum");
		BoardDAO.deleteBoard(num);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/BoardService?method=viewBoardList");
		rd.forward(request, response);
	}

	private void searchBoardList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int length=10;
		
		ArrayList<Board> boardList=null;
		int boardCount = 0;
		if(request.getParameter("keyword")==null||request.getParameter("keyword").equals("")){
			boardList = BoardDAO.selectBoardList(length, page);
			boardCount = BoardDAO.selectBoardCount();
		}else{
			if(request.getParameter("column").equals("title")){
				boardList = BoardDAO.selectBoardListByTitle(length, page, request.getParameter("keyword"));
				boardCount = BoardDAO.selectBoardListByTitleCount(request.getParameter("keyword"));
			}else{
				boardList = BoardDAO.selectBoardListByUserid(length, page, request.getParameter("keyword"));
				boardCount = BoardDAO.selectBoardListByUseridCount(request.getParameter("keyword"));
			}
		}

		request.setAttribute("BOARD_LIST", boardList);

		String pageLinkTag=PageUtil.generate(page, boardCount, length, 
				"/auction/BoardService?method=searchBoardList&column=" +
				request.getParameter("column") + "&keyword=" + request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardList.jsp");

		rd.forward(request, response);
	}
}