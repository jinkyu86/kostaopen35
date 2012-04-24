package kr.or.kosta.auction.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.member.MemberDAO;
import kr.or.kosta.auction.util.PageUtil;

public class BoardService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Board>BOARD_LIST;
	private Board BOARD;
	private String bNum;
	private Board board = new Board();

	
    public List<Board> getBOARD_LIST() {
		return BOARD_LIST;
	}

	public void setBOARD_LIST(List<Board> bOARD_LIST) {
		BOARD_LIST = bOARD_LIST;
	}

	public Board getBOARD() {
		return BOARD;
	}

	public void setBOARD(Board bOARD) {
		BOARD = bOARD;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public BoardService() {
        super();
        // TODO Auto-generated constructor stub
    }

	public String addBoard() throws Exception {
		bNum = BoardDAO.insertBoard(board);
		return "success";
	}

	public String addBoardForm() throws Exception {
		return "success";
	}

	public String editBoard() throws Exception {
		BoardDAO.updateBoard(board);
		return "success";
	}

	public String editBoardForm() throws Exception {
		BOARD = BoardDAO.selectBoard(bNum);
		return "success";
	}

	public String viewBoard() throws Exception {
		BOARD = BoardDAO.selectBoard(bNum);
		return "success";
	}

	public String viewBoardList() throws Exception {
		BOARD_LIST = BoardDAO.selectBoardList();
		return "success";
	}

	public String removeBoard() throws Exception {
		BoardDAO.deleteBoard(bNum);
		return "success";
	}

	private void searchBoardList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int length=10;
		
		List<Board> boardList=null;
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