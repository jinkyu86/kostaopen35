package kr.or.kosta.bookchange.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.bookchange.change.Condition;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;
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
		}else if("editBoard".equals(method)){
			editBoard(request,response);
		}else if("removeBoard".equals(method)){
			removeBoard(request,response);
		}else if("addBoardForm".equals(method)){
			addBoardForm(request,response);
		}else if("addBoard".equals(method)){
			addBoard(request,response);
		}else if("searchBoardList".equals(method)){
			searchBoardList(request,response);
		}
	}

	/**
	 * 게시물 추가 */
	public void addBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle=request.getParameter("boardTitle");
		String boardWant=request.getParameter("boardWant");
		String boardPhoto=request.getParameter("boardPhoto");
		String boardContent=request.getParameter("boardContent");
		String email=request.getParameter("email");
		String categoryNo=request.getParameter("categoryNo");
		String dealNo=request.getParameter("dealNo");
		//String conditionResult=request.getParameter("conditionResult");
		
		Board board=new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardWant(boardWant);
		board.setBoardPhoto(boardPhoto);
		board.setBoardContent(boardContent);
		
		Member member=new Member();
		member.setEmail(email);
		board.setMember(member);
		
		Category category=new Category();
		category.setCategoryNo(Integer.parseInt(categoryNo));
		board.setCategory(category);
		
		Deal deal=new Deal();
		deal.setDealNo(Integer.parseInt(dealNo));
		board.setDeal(deal);
		
		/*Condition condition=new Condition();
		condition.setConditionResult(Integer.parseInt(conditionResult));
		board.setCondition(condition);처음 등록시 자동으로 0으로 추가, 필요 없음*/
		
		BoardDAO.insertBoard(board);
		
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoardList");
		rd.forward(request, response);
		
	}

	/**
	 * 게시물 추가 창(물품등록 화면) */
	public void addBoardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_EMAIL");
		
		/*String email=request.getParameter("email");
		Member member=MemberDAO.selectMember(email);*/
		
		ArrayList<Category> categoryList=CategoryDAO.selectCategory();//카테고리 정보 조회
		ArrayList<Deal> dealList=DealDAO.selectDeal();//거래방법 조회
		
		request.setAttribute("MEMBER", member);
		request.setAttribute("CATEGORY_LIST",categoryList);
		request.setAttribute("DEAL_LIST",dealList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/addBoard.jsp");
		rd.forward(request, response);
	}

	/**	 * 게시물 수정	 */
	public void editBoard(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardTitle=request.getParameter("boardTitle");
		String boardWant=request.getParameter("boardWant");
		String boardPhoto=request.getParameter("boardPhoto");
		String boardContent=request.getParameter("boardContent");
		String email=request.getParameter("email");
		String categoryNo=request.getParameter("categoryNo");
		String dealNo=request.getParameter("dealNo");
		String conditionResult=request.getParameter("conditionResult");
		String boardNo=request.getParameter("boardNo");
		
		Board board=new Board();
		board.setBoardNo(Integer.parseInt(boardNo));
		board.setBoardTitle(boardTitle);
		board.setBoardWant(boardWant);
		board.setBoardPhoto(boardPhoto);
		board.setBoardContent(boardContent);
		
		Member member=new Member();
		member.setEmail(email);
		board.setMember(member);
		
		Category category=new Category();
		category.setCategoryNo(Integer.parseInt(categoryNo));
		board.setCategory(category);
		
		Deal deal=new Deal();
		deal.setDealNo(Integer.parseInt(dealNo));
		board.setDeal(deal);
		
		Condition condition=new Condition();
		condition.setConditionResult(Integer.parseInt(conditionResult));
		board.setCondition(condition);
		
		BoardDAO.updateBoard(board);
		
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoard&boardNo="+boardNo);
		rd.forward(request, response);
	}

	/**
	 * 게시물 수정 창 */
	public void editBoardForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		Board board=BoardDAO.selectBoard(boardNo);//수정할 게시물 정보 조회
			
		ArrayList<Category> categoryList=CategoryDAO.selectCategory();//카테고리 정보 조회
		ArrayList<Deal> dealList=DealDAO.selectDeal();//거래방법 조회
		
		request.setAttribute("BOARD",board);
		request.setAttribute("CATEGORY_LIST",categoryList);
		request.setAttribute("DEAL_LIST",dealList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/editBoard.jsp");
		rd.forward(request, response);

	}

	/**
	 * 게시물 삭제	 */
	public void removeBoard(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		String conditionResult=request.getParameter("conditionResult");
		
		if(conditionResult.equals("0")){
			BoardDAO.deleteBoard(boardNo);
		}else{
			System.out.println("교환중이므로 삭제할 수 없습니다.");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/bookchange/BoardService?method=viewBoardList");
		rd.forward(request, response);
	}

	/**
	 * 게시물 보기	 */
	public void viewBoard(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		
		Board board=BoardDAO.selectBoard(boardNo);
		Qa qa=QaDAO.selectQa(boardNo);
		
		request.setAttribute("BOARD",board);
		request.setAttribute("QA",qa);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoard.jsp");
		rd.forward(request, response);
	}

	/**	 * 게시물 전체 리스트 보기	  */
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

	/**	 * 게시물 검색	 */
	public void searchBoardList(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int length=10;
		
		ArrayList<Board> boardList=null;
		int boardCount=0;
		
		/*if(request.getParameter("keyword")==null||request.getParameter("keyword").equals("")){
			boardList=BoardDAO.selectBoardList(length, page);
			boardCount=BoardDAO.selectBoardCount();		
		}*/
		
		if(!request.getParameter("categoryNo").equals("")){
			if(request.getParameter("column").equals("title")){
				if(request.getParameter("keyword")==null||request.getParameter("keyword").equals("")){
					boardList=BoardDAO.selectBoardListbyCategory(length, page, request.getParameter("categoryNo"));
					boardCount=BoardDAO.selectBoardCategoryCount(request.getParameter("categoryNo"));
					}else{
					boardList=BoardDAO.selectBoardListbyCategoryandTitle(length, page, request.getParameter("categoryNo"), request.getParameter("keyword"));
					boardCount=BoardDAO.selectBoardCategoryandTitleCount(request.getParameter("categoryNo"), request.getParameter("keyword"));
					}
				}else {
				boardList=BoardDAO.selectBoardListbyCategoryandEmail(length, page,request.getParameter("categoryNo"), request.getParameter("keyword"));
				boardCount=BoardDAO.selectBoardCategoryandEmailCount(request.getParameter("categoryNo"), request.getParameter("keyword"));
			}
		}
		
		if(request.getParameter("categoryNo").equals("")){
			if(request.getParameter("column").equals("title")){
				if(request.getParameter("keyword")==null||request.getParameter("keyword").equals("")){
					boardList=BoardDAO.selectBoardList(length, page);
					boardCount=BoardDAO.selectBoardCount();
					}else{
					boardList=BoardDAO.selectBoardListbyTitle(length, page, request.getParameter("keyword"));
					boardCount=BoardDAO.selectBoardTitleCount(request.getParameter("keyword"));
					}
			}else{
				boardList=BoardDAO.selectBoardListbyEmail(length, page, request.getParameter("keyword"));
				boardCount=BoardDAO.selectBoardEmailCount(request.getParameter("keyword"));
			}
		}
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("BOARD_LIST", boardList);
		
		String pageLinkTag=PageUtil.generate(page, boardCount, length,
				"/bookchange/BoardService?method=searchBoardList&column="+
		             request.getParameter("column")+"&keyword="+request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardList.jsp");
		rd.forward(request,response);
	}
}
