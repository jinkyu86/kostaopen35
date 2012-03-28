package kr.or.kosta.bookchange.board;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.util.PageUtil;

public class BoardService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	 public BoardService() {
	        super();
	       
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if(method==null){
			method="viewBoardList";
		}
		if("viewBoardList".equals(method)){
			viewBoardList(request,response);
		}else if("viewBoard".equals(method)){
			viewBoard(request,response);
		}else if("editBoardFrom".equals(method)){
			editBoardForm(request,response);
		}else if("removeBoard".equals(method)){
			removeBoard(request,response);
		}else if("addBoardForm".equals(method)){
			addBoardForm(request,response);
		}
	}

	/**
	 * �Խù� �߰�	 
	 * @throws IOException 
	 * @throws ServletException */
	public void addBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> categoryList=CategoryDAO.selectCategory();//ī�װ� ���� ��ȸ
		ArrayList<Deal> dealList=DealDAO.selectDeal();//�ŷ���� ��ȸ
		
		request.setAttribute("CATEGORY_LIST",categoryList);
		request.setAttribute("DEAL_LIST",dealList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/addBoard.jsp");
		rd.forward(request, response);
	}

	/**
	 * �Խù� �߰� â(��ǰ��� ȭ��)
	 * 
	 * @param request
	 * @param response
	 */
	public void addBoardForm(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * �Խù� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void editBoard(HttpServletRequest request,HttpServletResponse response) {
		
	}

	/**
	 * �Խù� ���� â */
	public void editBoardForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		Board board=BoardDAO.selectBoard(boardNo);//������ �Խù� ���� ��ȸ
		
		String email=request.getParameter("email");
		MemberDAO
		
		ArrayList<Category> categoryList=CategoryDAO.selectCategory();//ī�װ� ���� ��ȸ
		ArrayList<Deal> dealList=DealDAO.selectDeal();//�ŷ���� ��ȸ
		
		request.setAttribute("BOARD",board);
		request.setAttribute("CATEGORY_LIST",categoryList);
		request.setAttribute("DEAL_LIST",dealList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/editBoard.jsp");
		rd.forward(request, response);

	}

	/**
	 * �Խù� ����
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void removeBoard(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		BoardDAO.deleteBoard(boardNo);
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardList.jsp");
		rd.forward(request, response);
	}

	/**
	 * �Խù� ����	 */
	public void viewBoard(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		Board board=BoardDAO.selectBoard(boardNo);
		request.setAttribute("BOARD",board);
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoard.jsp");
		rd.forward(request, response);
	}

	/**	 * �Խù� ��ü ����Ʈ ����	  */
	public void viewBoardList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int length=10;
		
		ArrayList<Board> boardList=BoardDAO.selectBoardList(length, page);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("BOARD_LIST",boardList);
		
		int boardCount=BoardDAO.selectBoardCount();
		
		String pageLinkTag=PageUtil.generate(page, boardCount, length, "/bookchange/BoardService?" +
				"method=viewBoardList");
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardList.jsp");
		rd.forward(request, response);
	}

	/**
	 * �Խù� �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public void searchBoardList(HttpServletRequest request,	HttpServletResponse response) {
		
	}
}
