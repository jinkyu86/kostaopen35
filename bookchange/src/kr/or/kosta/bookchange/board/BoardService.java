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
	 * �Խù� �߰� */
	public String addBoard() throws Exception {
		if(file!=null){
        	//�ӽ������� ��ο� ���ϸ�
        	String tempFileName=file[0].getAbsolutePath();
        	//�ӽ������� ������ ������ �ִ� ���� ��ü ����
        	File tempFile=new File(tempFileName);
        	//gphoto ������ ��¥ ��� ����
        	String gphotoRealPath=servletContext.getRealPath("bookimg");
        	//�����ϰ��� �ϴ� ������ ���, �̸�
        	//gphoto�� ��¥ ���+������ ��¥�̸�
        	String saveFileName=gphotoRealPath+"/"+fileFileName[0];
        	//������ ������ ������ ������ �ִ� ��ü ����
        	File saveFile=new File(saveFileName);
        	//�����ϰ����ϴ� ���ϰ� ���� �̸��� ������ ������ ��ȣ�� �ٿ��� ����!
        	saveFile=FileRenamePolicy.rename(saveFile);
        	//tempFile�� saveFile�� ����.
        	FileUtils.copyFile(tempFile,saveFile);
        	//tempFile�� �����Ѵٸ� ���� �ε�.
        	tempFile.deleteOnExit();
        	//good�� ���ϸ� ���� 
        	board.setBoardPhoto(saveFile.getName());
        }
		boardDAO.insertBoard(board);
		resultStream=new ByteArrayInputStream("��ϿϷ�".getBytes("UTF-8"));
		ERROR="��ǰ�� ��ϵǾ����ϴ�.";
		return "success";		
	}

	/**
	 * �Խù� �߰� â(��ǰ��� ȭ��) */
	public String addBoardForm() throws Exception {
		LOGIN_EMAIL=(Member)session.get("LOGIN_EMAIL");
		
		if(LOGIN_EMAIL==null){
			ERROR="�α����Ͻñ� �ٶ��ϴ�.";
			
			return "fail";
		}else{
					
		CATEGORY_LIST=categoryDAO.selectCategory();//ī�װ� ���� ��ȸ
		DEAL_LIST=dealDAO.selectDeal();//�ŷ���� ��ȸ

		return "success";
		}
	}

	/**	 * �Խù� ����	 */
	public String editBoard() throws Exception {
		if(file!=null){
        	//�ӽ������� ��ο� ���ϸ�
        	String tempFileName=file[0].getAbsolutePath();
        	//�ӽ������� ������ ������ �ִ� ���� ��ü ����
        	File tempFile=new File(tempFileName);
        	//gphoto ������ ��¥ ��� ����
        	String gphotoRealPath=servletContext.getRealPath("bookimg");
        	//�����ϰ��� �ϴ� ������ ���, �̸�
        	//gphoto�� ��¥ ���+������ ��¥�̸�
        	String saveFileName=gphotoRealPath+"/"+fileFileName[0];
        	//������ ������ ������ ������ �ִ� ��ü ����
        	File saveFile=new File(saveFileName);
        	//�����ϰ����ϴ� ���ϰ� ���� �̸��� ������ ������ ��ȣ�� �ٿ��� ����!
        	saveFile=FileRenamePolicy.rename(saveFile);
        	//tempFile�� saveFile�� ����.
        	FileUtils.copyFile(tempFile,saveFile);
        	//tempFile�� �����Ѵٸ� ���� �ε�.
        	tempFile.deleteOnExit();
        	//good�� ���ϸ� ���� 
        	board.setBoardPhoto(saveFile.getName());
        }
		
		boardDAO.updateBoard(board);		
		ERROR="�����Ǿ����ϴ�.";
		resultStream=new ByteArrayInputStream("��ϿϷ�".getBytes("UTF-8"));
		return "success";
	}

	/**
	 * �Խù� ���� â */
	public String editBoardForm() throws Exception {
		
		BOARD=boardDAO.selectBoard(boardNo);//������ �Խù� ���� ��ȸ
			
		CATEGORY_LIST=categoryDAO.selectCategory();//ī�װ� ���� ��ȸ
		DEAL_LIST=dealDAO.selectDeal();//�ŷ���� ��ȸ
		
		return "success";
	}

	/**
	 * �Խù� ����	 */
	public String removeBoard() throws Exception {
		
		if(conditionResult.equals("0")||conditionResult.equals("3")){
			boardDAO.deleteBoard(boardNo);
			ERROR="�����Ǿ����ϴ�.";
		}else{
			ERROR="��ȯ�������̹Ƿ� ������ �� �����ϴ�.";
		}
		return "success";
	}

	/**
	 * �Խù� ����	 */
	public String viewBoard() throws Exception {
		BOARD=boardDAO.selectBoard(boardNo);
		
		QA_COUNT=qaDAO.selectQaCount(boardNo);
		int length=10;
		//������� ��� ����Ʈ
		
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
		//��� ����Ʈ ��ȸ �Ϸ�
		return "success";
	}

	/**	 * �Խù� ��ü ����Ʈ ����	  */
	public String viewBoardList() throws Exception {

		int length=10;		
		if(page==0){
			page=1;
		}
		
		BOARD_LIST=boardDAO.selectBoardList(length, page);		
		
		CATEGORY_LIST=categoryDAO.selectCategory();//ī�װ� ���� ��ȸ
		
		int boardCount=boardDAO.selectBoardCount();		
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length, "/bookchange/viewBoardList.action");
		
		return "success";
	}

	/**	 * �Խù� �˻�	 */
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
		
		CATEGORY_LIST=categoryDAO.selectCategory();//ī�װ� ���� ��ȸ
		PAGE_LINK_TAG=PageUtil.generate(page, boardCount, length,
				"/bookchange/searchBoardList.action?categoryNo="+CATEGORY+
				"&column="+column+"&keyword="+keyword);
		
		return "success";
	}

	/**	 * �Խù� �˻�(��ȯ��û�Ҷ� �ڱ� ��� �߰��ϱ�)	 */
	public String searchBoardListWhenAdd() throws Exception {
		
		//���� ���ϴ� ���� ����
		
		BOARD=boardDAO.selectBoard(boardNo);
		if(BOARD.getCondition().getConditionResult()==2||BOARD.getCondition().getConditionResult()==3){
			ERROR="������ å�� �̹� ��ȯ���̹Ƿ� ��û�� �� �����ϴ� :)";
			return "fail";
		}else{
	
		//�� ���� ��� ����
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
	 * �Խù� ���� ��û �����Ҷ� �� */
	public String viewBoardWhenAgree() throws Exception {
		
		BOARD=boardDAO.selectBoard(boardNo);
		
		QA_COUNT=qaDAO.selectQaCount(boardNo);
		int length=10;
		//������� ��� ����Ʈ
		
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
		//��� ����Ʈ ��ȸ �Ϸ�

		return "success";
	}

	/**
	 * �Խù� ���� ����Ҷ�	 */
	public String viewBoardWhenCancel() throws Exception {
		
		BOARD=boardDAO.selectBoard(boardNo);
		
		QA_COUNT=qaDAO.selectQaCount(boardNo);
		int length=10;
		//������� ��� ����Ʈ
		
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
		//��� ����Ʈ ��ȸ �Ϸ�
		
		return "success";
	}
}
