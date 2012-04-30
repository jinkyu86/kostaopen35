package kr.or.kosta.auction.board;

import java.io.IOException;
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

import kr.or.kosta.aop.IService;
import kr.or.kosta.auction.member.IMemberDAO;
import kr.or.kosta.auction.util.PageUtil;

public class BoardService extends HttpServlet implements ModelDriven,SessionAware,IService {
	IBoardDAO boardDAO;
	IMemberDAO memberDAO;
	private static final long serialVersionUID = 1L;
	private List<Board> BOARD_LIST;
	private Board BOARD;
	private Map session;
	
	private String bNum;
	private Board board = new Board();
	private String keyword;
	private String column;
	private int page;
	private String PAGE_LINK_TAG;

	public BoardService(IBoardDAO boardDAO,IMemberDAO memberDAO) {
		super();
		this.boardDAO = boardDAO;
		this.memberDAO = memberDAO;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}

	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}

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

	public String getBnum() {
		return bNum;
	}

	public void setBnum(String bNum) {
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
		bNum = boardDAO.insertBoard(board);
		return "success";
	}

	public String addBoardForm() throws Exception {
		return "success";
	}

	public String editBoard() throws Exception {
		boardDAO.updateBoard(board);
		return "success";
	}

	public String editBoardForm() throws Exception {
		BOARD = boardDAO.selectBoard(bNum);
		return "success";
	}

	public String viewBoard() throws Exception {
		BOARD = boardDAO.selectBoard(bNum);
		return "success";
	}

	public String viewBoardList() throws Exception {
		int length = 10;
		if (page == 0) {
			page = 1;
		}

		List<Board> boardList = null;
		int boardCount = 0;
		
		boardList = boardDAO.selectBoardList(page, length);
		boardCount = boardDAO.selectBoardCount();
		
		BOARD_LIST = boardList;

		String pageLinkTag = PageUtil.generate(page, boardCount, length,
				"/auction/viewBoardList.action");
		PAGE_LINK_TAG = pageLinkTag;
		
		return "success";
	}

	public String removeBoard() throws Exception {
		boardDAO.deleteBoard(bNum);
		return "success";
	}

	public String searchBoardList() throws Exception {
		int length = 10;
		if (page == 0) {
			page = 1;
		}

		List<Board> boardList = null;
		int boardCount = 0;
		if (keyword == null || keyword.equals("")) {
			boardList = boardDAO.selectBoardList(page, length);
			boardCount = boardDAO.selectBoardCount();
		} else {
			if (column.equals("title")) {
				boardList = boardDAO.selectBoardListByTitle(page, length,
						keyword);
				boardCount = boardDAO.selectBoardListByTitleCount(keyword);
			} else {
					boardList = boardDAO.selectBoardListByUserid(page, length,
							keyword);
				boardCount = boardDAO.selectBoardListByUseridCount(keyword);
			}
		}

		BOARD_LIST = boardList;

		String pageLinkTag = PageUtil.generate(page, boardCount, length,
				"/auction/searchBoardList.action?column=" + column + "&keyword="
						+ keyword);
		PAGE_LINK_TAG = pageLinkTag;

		return "success";
	}

	@Override
	public Object getModel() {
		return board;
	}

	@Override
	public Map getSession() {
		// TODO Auto-generated method stub
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	
	
}