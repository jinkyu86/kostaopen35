package kr.or.kosta.bookchange.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.bookchange.change.Condition;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;
import kr.or.kosta.util.PageUtil;

public class BoardService implements ModelDriven, ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware { 
	private static final long serialVersionUID = 1L;
	private Board board=new Board();
	private Member LOGIN_EMAIL;
	private Board BOARD;
	private int page;
	private int qapage;
	private String boardNo;
	private List<Board> BOARD_LIST;
	private List<Qa> QA_LIST;
	private List<Deal> DEAL_LIST;
	private int QA_COUNT;
	private List<Category> CATEGORY_LIST;
	private String PAGE_LINK_TAG;
	private String ERROR;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;	
	private String keyword;
	private String AGREE_BOARD_NO;
	
	
	
	public String getAGREE_BOARD_NO() {
		return AGREE_BOARD_NO;
	}

	public void setAGREE_BOARD_NO(String aGREE_BOARD_NO) {
		AGREE_BOARD_NO = aGREE_BOARD_NO;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Member getLOGIN_EMAIL() {
		return LOGIN_EMAIL;
	}

	public void setLOGIN_EMAIL(Member lOGIN_EMAIL) {
		LOGIN_EMAIL = lOGIN_EMAIL;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext=context;
		
	}

	public String getERROR() {
		return ERROR;
	}

	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}

	public List<Deal> getDEAL_LIST() {
		return DEAL_LIST;
	}

	public void setDEAL_LIST(List<Deal> dEAL_LIST) {
		DEAL_LIST = dEAL_LIST;
	}

	public int getQapage() {
		return qapage;
	}

	public void setQapage(int qapage) {
		this.qapage = qapage;
	}

	public Board getBOARD() {
		return BOARD;
	}

	public void setBOARD(Board bOARD) {
		BOARD = bOARD;
	}

	public List<Qa> getQA_LIST() {
		return QA_LIST;
	}

	public void setQA_LIST(List<Qa> qA_LIST) {
		QA_LIST = qA_LIST;
	}

	public int getQA_COUNT() {
		return QA_COUNT;
	}

	public void setQA_COUNT(int qA_COUNT) {
		QA_COUNT = qA_COUNT;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public List<Board> getBOARD_LIST() {
		return BOARD_LIST;
	}

	public void setBOARD_LIST(List<Board> bOARD_LIST) {
		BOARD_LIST = bOARD_LIST;
	}

	public List<Category> getCATEGORY_LIST() {
		return CATEGORY_LIST;
	}

	public void setCATEGORY_LIST(List<Category> cATEGORY_LIST) {
		CATEGORY_LIST = cATEGORY_LIST;
	}

	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}

	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}

	@Override
	public Object getModel() {
		return board;
	}
	
	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private void viewMemberInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		Member member=BoardDAO.viewMemberInfo(email);
		
		request.setAttribute("MEMBER",member);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewMemberInfo.jsp");
		rd.forward(request, response);
		
		
		
	}

	public String boardListAtMain() throws Exception {
		int page=1;
		
		int length=8;
		
		BOARD_LIST=BoardDAO.selectBoardList(length, page);
				
		int boardCount=BoardDAO.selectBoardCount();
		
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length, "/bookchange/viewBoardList.action");
		
		return "success";
	}

	/**
	 * 게시물 추가 */
	public String addBoard() throws Exception {
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
	public String addBoardForm() throws Exception {
		LOGIN_EMAIL=(Member)session.get("LOGIN_EMAIL");
		
		if(LOGIN_EMAIL==null){
			ERROR="로그인하시기 바랍니다.";
			
			return "fail";
		}else{
					
		CATEGORY_LIST=CategoryDAO.selectCategory();//카테고리 정보 조회
		DEAL_LIST=DealDAO.selectDeal();//거래방법 조회

		return "success";
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
	public String editBoardForm() throws Exception {
		
		BOARD=BoardDAO.selectBoard(boardNo);//수정할 게시물 정보 조회
			
		CATEGORY_LIST=CategoryDAO.selectCategory();//카테고리 정보 조회
		DEAL_LIST=DealDAO.selectDeal();//거래방법 조회
		
		return "success";
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
	public String viewBoard() throws Exception {
		BOARD=BoardDAO.selectBoard(boardNo);
		
		QA_COUNT=QaDAO.selectQaCount(boardNo);
		int length=10;
		//여기부턴 댓글 리스트
		
		if(QA_COUNT%10==0){
			qapage=QA_COUNT/length;
		}else{
			qapage=(QA_COUNT/length)+1;
		}
		
		if(page!=0){
			qapage=page;
		}
				
		QA_LIST=QaDAO.selectQaList(length, qapage, boardNo);
		
		PAGE_LINK_TAG=PageUtil.generate(qapage, QA_COUNT, length, "/bookchange/viewBoard.action?boardNo="+boardNo);
		//댓글 리스트 조회 완료
		return "success";
	}

	/**	 * 게시물 전체 리스트 보기	  */
	public String viewBoardList() throws Exception {

		int length=10;		
		if(page==0){
			page=1;
		}
		
		BOARD_LIST=BoardDAO.selectBoardList(length, page);				
		CATEGORY_LIST=CategoryDAO.selectCategory();//카테고리 정보 조회
		
		int boardCount=BoardDAO.selectBoardCount();		
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length, "/bookchange/viewBoardList.action");
		
		return "success";
	}

	/**	 * 게시물 검색	 */
	public void searchBoardList(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int length=10;
		
		List<Board> boardList=null;
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
		
		List<Category> categoryList=CategoryDAO.selectCategory();//카테고리 정보 조회
		request.setAttribute("CATEGORY_LIST",categoryList);
		
		String pageLinkTag=PageUtil.generate(page, boardCount, length,
				"/bookchange/BoardService?method=searchBoardList&categoryNo="+request.getParameter("categoryNo")+
				"&column="+request.getParameter("column")+"&keyword="+request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/viewBoardList.jsp");
		rd.forward(request,response);
	}

	/**	 * 게시물 검색(교환신청할때 자기 목록 뜨게하기)	 */
	public String searchBoardListWhenAdd() throws Exception {
		
		//내가 원하는 물건 리턴
		
		BOARD=BoardDAO.selectBoard(boardNo);
		if(BOARD.getCondition().getConditionResult()==2||BOARD.getCondition().getConditionResult()==3){
			ERROR="선택한 책은 이미 교환중이므로 신청할 수 없습니다 :)";
			return "fail";
		}else{
	
		//내 물건 목록 리턴
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int length=10;
		
		int boardCount=0;
		
		BOARD_LIST=BoardDAO.selectBoardListbyEmailWhenAdd(length, page, keyword);
		boardCount=BoardDAO.selectBoardEmailWhenAddCount(keyword);
				
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length,
				"/bookchange/searchBoardListWhenAdd.action?keyword="+keyword);
		
		return "success";
		}
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
		
		List<Qa> qaList=QaDAO.selectQaList(length, page, boardNo);
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
	public String viewBoardWhenCancel() throws Exception {
		
		BOARD=BoardDAO.selectBoard(boardNo);
		
		QA_COUNT=QaDAO.selectQaCount(boardNo);
		int length=10;
		//여기부턴 댓글 리스트
		
		if(QA_COUNT%10==0){
			qapage=QA_COUNT/length;
		}else{
			qapage=(QA_COUNT/length)+1;
		}
		
		if(page!=0){
			qapage=page;
		}
				
		QA_LIST=QaDAO.selectQaList(length, qapage, boardNo);
		
		PAGE_LINK_TAG=PageUtil.generate(qapage, QA_COUNT, length, "/bookchange/viewBoard.action?boardNo="+boardNo);
		//댓글 리스트 조회 완료
		
		return "success";
	}
}
