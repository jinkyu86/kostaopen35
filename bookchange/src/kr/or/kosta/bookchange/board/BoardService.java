package kr.or.kosta.bookchange.board;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.bookchange.change.Condition;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;
import kr.or.kosta.file.receive.FileRenamePolicy;
import kr.or.kosta.util.PageUtil;

public class BoardService implements ModelDriven, ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware { 
	private IBoardDAO boardDAO;
	private ICategoryDAO categoryDAO;
	private IDealDAO dealDAO;
	private IQaDAO qaDAO;
	private static final long serialVersionUID = 1L;
	private Board board=new Board();
	private Member LOGIN_EMAIL;
	private Member MEMBER;
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
	private String CATEGORY;
	private String column;
	private String title;
	private String email;
	private String conditionResult;
	private File[] file;
	private String[] fileFileName;
	private String[] fileContentType;
	private InputStream resultStream;
	private String WhenAgree;
	
	
	public String getWhenAgree() {
		return WhenAgree;
	}



	public void setWhenAgree(String whenAgree) {
		WhenAgree = whenAgree;
	}



	public BoardService(){
		super();
	}
	
	

	public BoardService(IBoardDAO boardDAO, ICategoryDAO categoryDAO,
			IDealDAO dealDAO, IQaDAO qaDAO) {
		super();
		System.out.println("BoardService(IBoardDAO boardDAO, ICategoryDAO categoryDAO," +
				"IDealDAO dealDAO, IQaDAO qaDAO)");
		System.out.println("boardDAO:"+boardDAO);
		System.out.println("categoryDAO:"+categoryDAO);
		System.out.println("dealDAO:"+dealDAO);
		System.out.println("qaDAO:"+qaDAO);
		
		this.boardDAO = boardDAO;
		this.categoryDAO = categoryDAO;
		this.dealDAO = dealDAO;
		this.qaDAO = qaDAO;
	}



	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public InputStream getResultStream() {
		return resultStream;
	}

	public void setResultStream(InputStream resultStream) {
		this.resultStream = resultStream;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public String getConditionResult() {
		return conditionResult;
	}

	public void setConditionResult(String conditionResult) {
		this.conditionResult = conditionResult;
	}

	public Member getMEMBER() {
		return MEMBER;
	}

	public void setMEMBER(Member mEMBER) {
		MEMBER = mEMBER;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

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

	public String viewMemberInfo() throws Exception {
		MEMBER=boardDAO.viewMemberInfo(email);
		return "success";
				
	}

	public String boardListAtMain() throws Exception {
		int page=1;
		
		int length=8;
		
		BOARD_LIST=boardDAO.selectBoardList(length, page);
				
		int boardCount=boardDAO.selectBoardCount();
		
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length, "/bookchange/viewBoardList.action");
		
		return "success";
	}

	/**
	 * 게시물 추가 */
	public String addBoard() throws Exception {
		if(file!=null){
        	//임시파일의 경로와 파일명
        	String tempFileName=file[0].getAbsolutePath();
        	//임시파일의 정보를 가지고 있는 파일 객체 생성
        	File tempFile=new File(tempFileName);
        	//gphoto 폴더의 진짜 경로 리턴
        	String gphotoRealPath=servletContext.getRealPath("bookimg");
        	//저장하고자 하는 파일의 경로, 이름
        	//gphoto의 진짜 경로+파일의 진짜이름
        	String saveFileName=gphotoRealPath+"/"+fileFileName[0];
        	//저장할 파일의 정보를 가지고 있는 객체 생성
        	File saveFile=new File(saveFileName);
        	//저장하고자하는 파일과 같은 이름의 파일이 있으면 번호를 붙여서 리턴!
        	saveFile=FileRenamePolicy.rename(saveFile);
        	//tempFile을 saveFile로 복사.
        	FileUtils.copyFile(tempFile,saveFile);
        	//tempFile이 존재한다면 삭제 두둥.
        	tempFile.deleteOnExit();
        	//good에 파일명 설정 
        	board.setBoardPhoto(saveFile.getName());
        }
		boardDAO.insertBoard(board);
		resultStream=new ByteArrayInputStream("등록완료".getBytes("UTF-8"));
		ERROR="물품이 등록되었습니다.";
		return "success";		
	}

	/**
	 * 게시물 추가 창(물품등록 화면) */
	public String addBoardForm() throws Exception {
		LOGIN_EMAIL=(Member)session.get("LOGIN_EMAIL");
		
		if(LOGIN_EMAIL==null){
			ERROR="로그인하시기 바랍니다.";
			
			return "fail";
		}else{
					
		CATEGORY_LIST=categoryDAO.selectCategory();//카테고리 정보 조회
		DEAL_LIST=dealDAO.selectDeal();//거래방법 조회

		return "success";
		}
	}

	/**	 * 게시물 수정	 */
	public String editBoard() throws Exception {
		if(file!=null){
        	//임시파일의 경로와 파일명
        	String tempFileName=file[0].getAbsolutePath();
        	//임시파일의 정보를 가지고 있는 파일 객체 생성
        	File tempFile=new File(tempFileName);
        	//gphoto 폴더의 진짜 경로 리턴
        	String gphotoRealPath=servletContext.getRealPath("bookimg");
        	//저장하고자 하는 파일의 경로, 이름
        	//gphoto의 진짜 경로+파일의 진짜이름
        	String saveFileName=gphotoRealPath+"/"+fileFileName[0];
        	//저장할 파일의 정보를 가지고 있는 객체 생성
        	File saveFile=new File(saveFileName);
        	//저장하고자하는 파일과 같은 이름의 파일이 있으면 번호를 붙여서 리턴!
        	saveFile=FileRenamePolicy.rename(saveFile);
        	//tempFile을 saveFile로 복사.
        	FileUtils.copyFile(tempFile,saveFile);
        	//tempFile이 존재한다면 삭제 두둥.
        	tempFile.deleteOnExit();
        	//good에 파일명 설정 
        	board.setBoardPhoto(saveFile.getName());
        }
		
		boardDAO.updateBoard(board);		
		ERROR="수정되었습니다.";
		resultStream=new ByteArrayInputStream("등록완료".getBytes("UTF-8"));
		return "success";
	}

	/**
	 * 게시물 수정 창 */
	public String editBoardForm() throws Exception {
		
		BOARD=boardDAO.selectBoard(boardNo);//수정할 게시물 정보 조회
			
		CATEGORY_LIST=categoryDAO.selectCategory();//카테고리 정보 조회
		DEAL_LIST=dealDAO.selectDeal();//거래방법 조회
		
		return "success";
	}

	/**
	 * 게시물 삭제	 */
	public String removeBoard() throws Exception {
		
		if(conditionResult.equals("0")||conditionResult.equals("3")){
			boardDAO.deleteBoard(boardNo);
			ERROR="삭제되었습니다.";
		}else{
			ERROR="교환진행중이므로 삭제할 수 없습니다.";
		}
		return "success";
	}

	/**
	 * 게시물 보기	 */
	public String viewBoard() throws Exception {
		BOARD=boardDAO.selectBoard(boardNo);
		
		QA_COUNT=qaDAO.selectQaCount(boardNo);
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
				
		QA_LIST=qaDAO.selectQaList(length, qapage, boardNo);
		
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
		
		BOARD_LIST=boardDAO.selectBoardList(length, page);		
		
		CATEGORY_LIST=categoryDAO.selectCategory();//카테고리 정보 조회
		
		int boardCount=boardDAO.selectBoardCount();		
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length, "/bookchange/viewBoardList.action");
		
		return "success";
	}

	/**	 * 게시물 검색	 */
	public String searchBoardList() throws Exception {
				
		if(page==0){
			page=1;
		}
		
		int length=10;
		
		int boardCount=0;	
		
		if(!CATEGORY.equals("")){
			if(column.equals("title")){
				if(keyword==null||keyword.equals("")){
					BOARD_LIST=boardDAO.selectBoardListbyCategory(length, page, CATEGORY);
					boardCount=boardDAO.selectBoardCategoryCount(CATEGORY);
					}else{
					BOARD_LIST=boardDAO.selectBoardListbyCategoryandTitle(length, page, CATEGORY, keyword);
					boardCount=boardDAO.selectBoardCategoryandTitleCount(CATEGORY, keyword);
					}
						}else if(keyword==null||keyword.equals("")){
							BOARD_LIST=boardDAO.selectBoardListbyCategory(length, page, CATEGORY);
							boardCount=boardDAO.selectBoardCategoryCount(CATEGORY);
							} 
						else {
						BOARD_LIST=boardDAO.selectBoardListbyCategoryandEmail(length, page,CATEGORY, keyword);
						boardCount=boardDAO.selectBoardCategoryandEmailCount(CATEGORY, keyword);
					}
		}
		
		if(CATEGORY.equals("")){
			if(column.equals("title")){
				if(keyword==null||keyword.equals("")){
					BOARD_LIST=boardDAO.selectBoardList(length, page);
					boardCount=boardDAO.selectBoardCount();
					}else{
					BOARD_LIST=boardDAO.selectBoardListbyTitle(length, page, keyword);
					boardCount=boardDAO.selectBoardTitleCount(keyword);
					}
						}else if(keyword==null||keyword.equals("")){
								BOARD_LIST=boardDAO.selectBoardList(length, page);
								boardCount=boardDAO.selectBoardCount();
								}
						else{
							BOARD_LIST=boardDAO.selectBoardListbyEmail(length, page, keyword);
							boardCount=boardDAO.selectBoardEmailCount(keyword);
						}
		}
		
		CATEGORY_LIST=categoryDAO.selectCategory();//카테고리 정보 조회
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length,
				"/bookchange/searchBoardList.action?categoryNo="+CATEGORY+
				"&column="+column+"&keyword="+keyword);
		
		return "success";
	}

	/**	 * 게시물 검색(교환신청할때 자기 목록 뜨게하기)	 */
	public String searchBoardListWhenAdd() throws Exception {
		
		//내가 원하는 물건 리턴
		
		BOARD=boardDAO.selectBoard(boardNo);
		if(BOARD.getCondition().getConditionResult()==2||BOARD.getCondition().getConditionResult()==3){
			ERROR="선택한 책은 이미 교환중이므로 신청할 수 없습니다 :)";
			return "fail";
		}else{
	
		//내 물건 목록 리턴
		if(page==0){
			page=1;
		}
		
		int length=10;
		
		int boardCount=0;
		
		BOARD_LIST=boardDAO.selectBoardListbyEmailWhenAdd(length, page, keyword);
		boardCount=boardDAO.selectBoardEmailWhenAddCount(keyword);
				
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length,
				"/bookchange/searchBoardListWhenAdd.action?keyword="+keyword);
		
		return "success";
		}
	}

	/**
	 * 게시물 보기 요청 수락할때 ㅋ */
	public String viewBoardWhenAgree() throws Exception {
		
		BOARD=boardDAO.selectBoard(boardNo);
		
		QA_COUNT=qaDAO.selectQaCount(boardNo);
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
				
		QA_LIST=qaDAO.selectQaList(length, qapage, boardNo);
		
		PAGE_LINK_TAG=PageUtil.generate(qapage, QA_COUNT, length, "/bookchange/viewBoard.action?boardNo="+boardNo);
		//댓글 리스트 조회 완료

		return "success";
	}

	/**
	 * 게시물 보기 취소할때	 */
	public String viewBoardWhenCancel() throws Exception {
		
		BOARD=boardDAO.selectBoard(boardNo);
		
		QA_COUNT=qaDAO.selectQaCount(boardNo);
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
				
		QA_LIST=qaDAO.selectQaList(length, qapage, boardNo);
		
		PAGE_LINK_TAG=PageUtil.generate(qapage, QA_COUNT, length, "/bookchange/viewBoard.action?boardNo="+boardNo);
		//댓글 리스트 조회 완료
		
		return "success";
	}
}
