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
			method="boardListAtMain";
		}
		if("viewBoardList".equals(method)){
			viewBoardList(request,response);
		}else if("viewBoard".equals(method)){
			viewBoard(request,response);
		}else if("editBoardForm".equals(method)){
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
		}else if("searchBoardListWhenAdd".equals(method)){
			searchBoardListWhenAdd(request,response);
		}else if("viewBoardWhenAgree".equals(method)){
			viewBoardWhenAgree(request,response);
		}else if("viewBoardWhenCancel".equals(method)){
			viewBoardWhenCancel(request,response);
		}else if("boardListAtMain".equals(method)){
			boardListAtMain(request,response);
		}else if("viewMemberInfo".equals(method)){
			viewMemberInfo(request,response);
		}
	}

	private void viewMemberInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		Member member=BoardDAO.viewMemberInfo(email);
		
		request.setAttribute("MEMBER",member);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewMemberInfo.jsp");
		rd.forward(request, response);
		
		
		
	}

	private void boardListAtMain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int length=8;
		
		ArrayList<Board> boardList=BoardDAO.selectBoardList(length, page);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("BOARD_LIST",boardList);
				
		int boardCount=BoardDAO.selectBoardCount();
		
		String pageLinkTag=PageUtil.generate(page, boardCount, length, "/bookchange/BoardService?" +
				"method=viewBoardList");
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
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
		
		request.setAttribute("ERROR","등록되었습니다.");
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoardList");
		rd.forward(request, response);
		
	}

	/**
	 * 게시물 추가 창(물품등록 화면) */
	public void addBoardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member member=(Member) session.getAttribute("LOGIN_EMAIL");
		if(member==null){
			request.setCharacterEncoding("utf-8");
			request.setAttribute("ERROR","로그인하시기 바랍니다.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		}else{
					
		ArrayList<Category> categoryList=CategoryDAO.selectCategory();//카테고리 정보 조회
		ArrayList<Deal> dealList=DealDAO.selectDeal();//거래방법 조회
		
		request.setAttribute("CATEGORY_LIST",categoryList);
		request.setAttribute("DEAL_LIST",dealList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/addBoard.jsp");
		rd.forward(request, response);
		}
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
		String error="수정되었습니다.";
		request.setAttribute("ERROR",error);
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
		
		if(conditionResult.equals("0")||conditionResult.equals("3")){
			BoardDAO.deleteBoard(boardNo);
			String complete="삭제되었습니다.";
			request.setAttribute("ERROR",complete);
		}else{
			request.setCharacterEncoding("utf-8");
			String delete="교환진행중이므로 삭제할 수 없습니다.";
			request.setAttribute("ERROR",delete);
			//System.out.println("교환중이므로 삭제할 수 없습니다.");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoardList");
		rd.forward(request, response);
	}

	/**
	 * 게시물 보기	 */
	public void viewBoard(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		
		Board board=BoardDAO.selectBoard(boardNo);
		
		int qaCount=QaDAO.selectQaCount(boardNo);
		int length=10;
		//여기부턴 댓글 리스트
		int page=(qaCount/length)+1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
				
		ArrayList<Qa> qaList=QaDAO.selectQaList(length, page, boardNo);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("QA_LIST",qaList);
				
		//int qaCount=QaDAO.selectQaCount(boardNo);
		
		String pageLinkTag=PageUtil.generate(page, qaCount, length, "/bookchange/BoardService?" +
				"method=viewBoard&boardNo="+boardNo);
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		//댓글 리스트 조회 완료
		
		request.setAttribute("BOARD",board);
		request.setAttribute("QA_LIST",qaList);
		request.setAttribute("QA_COUNT",qaCount);
		
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
		
		ArrayList<Category> categoryList=CategoryDAO.selectCategory();//카테고리 정보 조회
		
		request.setAttribute("CATEGORY_LIST",categoryList);
				
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
		
		if(!request.getParameter("categoryNo").equals("")){
			if(request.getParameter("column").equals("title")){
				if(request.getParameter("keyword")==null||request.getParameter("keyword").equals("")){
					boardList=BoardDAO.selectBoardListbyCategory(length, page, request.getParameter("categoryNo"));
					boardCount=BoardDAO.selectBoardCategoryCount(request.getParameter("categoryNo"));
					}else{
					boardList=BoardDAO.selectBoardListbyCategoryandTitle(length, page, request.getParameter("categoryNo"), request.getParameter("keyword"));
					boardCount=BoardDAO.selectBoardCategoryandTitleCount(request.getParameter("categoryNo"), request.getParameter("keyword"));
					}
						}else if(request.getParameter("keyword")==null||request.getParameter("keyword").equals("")){
							boardList=BoardDAO.selectBoardListbyCategory(length, page, request.getParameter("categoryNo"));
							boardCount=BoardDAO.selectBoardCategoryCount(request.getParameter("categoryNo"));
							} 
						else {
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
						}else if(request.getParameter("keyword")==null||request.getParameter("keyword").equals("")){
								boardList=BoardDAO.selectBoardList(length, page);
								boardCount=BoardDAO.selectBoardCount();
								}
						else{
							boardList=BoardDAO.selectBoardListbyEmail(length, page, request.getParameter("keyword"));
							boardCount=BoardDAO.selectBoardEmailCount(request.getParameter("keyword"));
						}
		}
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("BOARD_LIST", boardList);
		//카테고리 넘버 보내줘서 검색할때 selected되게 사용
		String categoryNo=request.getParameter("categoryNo");
		request.setAttribute("CATEGORY",categoryNo);
		
		ArrayList<Category> categoryList=CategoryDAO.selectCategory();//카테고리 정보 조회
		request.setAttribute("CATEGORY_LIST",categoryList);
		
		String pageLinkTag=PageUtil.generate(page, boardCount, length,
				"/bookchange/BoardService?method=searchBoardList&categoryNo="+request.getParameter("categoryNo")+
				"&column="+request.getParameter("column")+"&keyword="+request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardList.jsp");
		rd.forward(request,response);
	}

	/**	 * 게시물 검색(교환신청할때 자기 목록 뜨게하기)	 */
	public void searchBoardListWhenAdd(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		
		//내가 원하는 물건 리턴
		String boardNo=request.getParameter("boardNo");
		Board board=BoardDAO.selectBoard(boardNo);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("BOARD", board);
		
		
		//내 물건 목록 리턴
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int length=10;
		
		ArrayList<Board> boardList=null;
		int boardCount=0;
		
		boardList=BoardDAO.selectBoardListbyEmailWhenAdd(length, page, request.getParameter("keyword"));
		boardCount=BoardDAO.selectBoardEmailWhenAddCount(request.getParameter("keyword"));
				
		request.setCharacterEncoding("utf-8");
		request.setAttribute("BOARD_LIST", boardList);
		
		String pageLinkTag=PageUtil.generate(page, boardCount, length,
				"/bookchange/BoardService?method=searchBoardListWhenAdd&keyword="+request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardListWhenAdd.jsp");
		rd.forward(request,response);
	}

	/**
	 * 게시물 보기	 */
	public void viewBoardWhenAgree(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		String agreeBoardNo=request.getParameter("agreeBoardNo");
		
		Board board=BoardDAO.selectBoard(boardNo);
		
		int qaCount=QaDAO.selectQaCount(boardNo);
		int length=10;
		//여기부턴 댓글 리스트
		int page=(qaCount/length)+1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		ArrayList<Qa> qaList=QaDAO.selectQaList(length, page, boardNo);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("QA_LIST",qaList);
		
		String pageLinkTag=PageUtil.generate(page, qaCount, length, "/bookchange/BoardService?" +
				"method=viewBoard&boardNo="+boardNo);
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		//댓글 리스트 조회 완료
		
		request.setAttribute("BOARD",board);
		request.setAttribute("QA_LIST",qaList);
		request.setAttribute("AGREE_BOARD_NO",agreeBoardNo);
		request.setAttribute("QA_COUNT",qaCount);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardWhenAgree.jsp");
		rd.forward(request, response);
	}

	/**
	 * 게시물 보기 취소할때	 */
	public void viewBoardWhenCancel(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");//상대방 번호
		String agreeBoardNo=request.getParameter("agreeBoardNo");//내 번호
		
		Board board=BoardDAO.selectBoard(boardNo);
		
		int qaCount=QaDAO.selectQaCount(boardNo);
		int length=10;
		//여기부턴 댓글 리스트
		int page=(qaCount/length)+1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		ArrayList<Qa> qaList=QaDAO.selectQaList(length, page, boardNo);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("QA_LIST",qaList);

		String pageLinkTag=PageUtil.generate(page, qaCount, length, "/bookchange/BoardService?" +
				"method=viewBoard&boardNo="+boardNo);
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		//댓글 리스트 조회 완료
		
		request.setAttribute("BOARD",board);
		request.setAttribute("QA_LIST",qaList);
		request.setAttribute("AGREE_BOARD_NO",agreeBoardNo);
		request.setAttribute("QA_COUNT",qaCount);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardWhenCancel.jsp");
		rd.forward(request, response);
	}
}
