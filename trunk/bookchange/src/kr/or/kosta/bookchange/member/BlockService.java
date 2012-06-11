package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.aop.IService;
import kr.or.kosta.util.PageUtil;


public class BlockService implements IService,ModelDriven,ServletContextAware,ServletRequestAware,ServletResponseAware,SessionAware{
	
	private IBlockDAO blockDAO; 
	
	private static final long serialVersionUID = 1L;
	private Block block=new Block();
	private BlockCondition blockCondition;
	private String email;
	private String ERROR;
	private String PAGE_LINK_TAG;
	private Member LOGIN_EMAIL;
	private Member blockmember;
	private Member member;

	private int resultNo;
	private int blockNo;
	private List<Block> MyBlockList;
	private List<Block> BlockList;
	
	private ServletContext context;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private Map session;
	private Block BLOCK=new Block();
	private BlockCondition BLOCKCONDITION= new BlockCondition();
	
	
	public List<Block> getMyBlockList() {
		return MyBlockList;
	}
	public void setMyBlockList(List<Block> myBlockList) {
		MyBlockList = myBlockList;
	}
	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}
	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}

	public int getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(int blockNo) {
		this.blockNo = blockNo;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Member getBlockmember() {
		return blockmember;
	}
	public void setBlockmember(Member blockmember) {
		this.blockmember = blockmember;
	}
	public int getResultNo() {
		return resultNo;
	}
	public void setResultNo(int resultNo) {
		this.resultNo = resultNo;
	}
	public int getBlockno() {
		return blockNo;
	}
	public void setBlockno(int blockno) {
		this.blockNo = blockno;
	}


	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return block;
	}
	public IBlockDAO getBlockDAO() {
		return blockDAO;
	}
	public void setBlockDAO(IBlockDAO blockDAO) {
		this.blockDAO = blockDAO;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	public BlockCondition getBlockCondition() {
		return blockCondition;
	}
	public void setBlockCondition(BlockCondition blockCondition) {
		this.blockCondition = blockCondition;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getERROR() {
		return ERROR;
	}
	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}
	public Member getLOGIN_EMAIL() {
		return LOGIN_EMAIL;
	}
	public void setLOGIN_EMAIL(Member lOGIN_EMAIL) {
		LOGIN_EMAIL = lOGIN_EMAIL;
	}
	public List<Block> getBlockList() {
		return BlockList;
	}
	public void setBlockList(List<Block> blockList) {
		BlockList = blockList;
	}
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public Block getBLOCK() {
		return BLOCK;
	}
	public void setBLOCK(Block bLOCK) {
		BLOCK = bLOCK;
	}
	public BlockCondition getBLOCKCONDITION() {
		return BLOCKCONDITION;
	}
	public void setBLOCKCONDITION(BlockCondition bLOCKCONDITION) {
		BLOCKCONDITION = bLOCKCONDITION;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
		
	}
	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context=context;
	}

	@Override
	public Map getSession() {
		// TODO Auto-generated method stub
		return session;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request,response);
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String method=request.getParameter("method");
//		if (method==null) {
//			method="searchBlockList";
//		}if("addBlock".equals(method)){
//			addBlock(request,response);
//		}else if("editBlock".equals(method)){
//			editBlock(request, response);
//		}else if("removeBlock".equals(method)){
//			removeBlock(request, response);
//		}else if("searchBlockList".equals(method)){
//			searchBlockList(request, response);
//		}else if("addBlockForm".equals(method)){
//			addBlockForm(request,response);
//		}else if("selectMyBlockList".equals(method)){
//			selectMyBlockList(request,response);
//		}
//	}
	/**
	 * 내가 신고한 불량회원 리스트 보기
	 * @return
	 * @throws Exception
	 */
	public String selectMyBlockList() throws Exception {
	
		LOGIN_EMAIL=(Member)session.get("LOGIN_EMAIL");
	
		int page=1;
		int length=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("");
			rd.forward(request, response);
			return ERROR;
		}
		String memberEmail=member.getEmail();
		MyBlockList=blockDAO.selectMyBlockList(length, page, memberEmail);
		
	
		int blockCount=blockDAO.selectBlockCount();
		
		PAGE_LINK_TAG = PageUtil.generate(page, blockCount, length, "/bookchange/BlockService?method=selectMyBlockList"+BlockList);
		
		return "success";
	}
	/**
	 * 내가 신고한 불량회원 리스트 보기
	 * @return
	 * @throws Exception
	 */
	public String selectBlockList() throws Exception {
	
	
		int page=1;
		int length=10;
		
		BlockList=blockDAO.selectBlockList(page, length);
		
	
		int blockCount=blockDAO.selectBlockCount();
		
		PAGE_LINK_TAG = PageUtil.generate(page, blockCount, length, "/bookchange/BlockService?method=selectBlockList"+BlockList);
		
		return "success";
	}

	public String addBlockForm() throws Exception{
		return "success";
	}

	/**
	 * 신고리스트에 접수내용 추가
	 * 
	 * @param request
	 * @param response
	 */
	public String addBlock() throws Exception {
		

//		String blockcontent=request.getParameter("blockcontent");
//		String blockemail=request.getParameter("blockemail");
//		String registeremail=request.getParameter("registeremail");
//		
//		Block block=new Block();
//		block.setBlockContent(blockcontent);
//		
//		Member member=new Member();
//		member.setEmail(blockemail);
//		block.setBlockmember(member);
//		
//		Member member2=new Member();
//		member2.setEmail(registeremail);
//		block.setMember(member2);
//		
		blockDAO.insertBlock(block);
		

		return "success";

	}

	/**
	 * 신고상태(검토중인지, 검토완료인지)수정할 때 사용
	 * 
	 * @param request
	 * @param response
	 */
	public String editBlock()throws Exception{

//		String blockConditionresult=request.getParameter("blockConditionresult");
//		String blockNo=request.getParameter("blockNo");
//		
//		Block block=new Block();
//		block.setBlockNo(Integer.parseInt(blockNo));
//		
//		BlockCondition blockCondition=new BlockCondition();
//		blockCondition.setBlockConditionResult(Integer.parseInt(blockConditionresult));
//		block.setBlockCondition(blockCondition);
		

		
		blockDAO.updateBlock(block);
		
		return "success";
		
	}

	/**
	 * 신고리스트에서 삭제
	 * 
	 * @param request
	 * @param response
	 */
	public String removeBlock() throws Exception {
//		String blockno=request.getParameter("blockNo");
//		
//		Block block= new Block();
//		block.setBlockNo(Integer.parseInt(blockno));
		
		blockDAO.deleteBlock(blockNo);
		
		return "success";
	}

	/**
	 * 신고리스트 검색
	 * 
	 * @param request
	 * @param response
	 */
	public String searchBlockList() throws Exception {
		
		//기본 페이지
		int page=1;
		//페이지 파라미터가 존재
		if (request.getParameter("page")!=null) {
			//파라미터 리턴
			page=Integer.parseInt(request.getParameter("page"));
			
		}
		int length=5;
		
	
		int BlockCount=0;

		if(request.getParameter("keyword")==null||
			request.getParameter("keyword").equals("")){
			    BlockList=
						blockDAO.selectBlockList(length, page);
				BlockCount=
						blockDAO.selectBlockCount();
				
		}else{
				BlockList=
						blockDAO.selectBlockbyResult(length, page, request.getParameter("keyword"));
				
				BlockCount=
						blockDAO.selectBlockbyResultCount(resultNo);				
		}
		 PAGE_LINK_TAG = PageUtil.generate(page, BlockCount, length, "/BlockService?" +
				"method=searchBlockList&keyword=viewBlockList"+BlockList);
			
	
		 return "success";
	
	}



}
