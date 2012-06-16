package kr.or.kosta.bookchange.member;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.aop.IService;
import kr.or.kosta.util.PageUtil;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;


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
	private Member member =new Member();
	private String keyword;
	private String resultNo;
	private String blockNo;
	private List<Block> MyBlockList;
	private List<Block> BlockList;
	private List<Block> BlockResultList;
	private String resultno;
	private int length;
	private int page;
	private String Resultselect;
	private ServletContext context;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private int BlockCount;
	private Map session;
	private Block BLOCK=new Block();
	private BlockCondition BLOCKCONDITION= new BlockCondition();

	private String conditionResult;
	
	
	

	public int getBlockCount() {
		return BlockCount;
	}
	public void setBlockCount(int blockCount) {
		BlockCount = blockCount;
	}
	public String getResultno() {
		return resultno;
	}
	public void setResultno(String resultno) {
		this.resultno = resultno;
	}
	public String getResultselect() {
		return Resultselect;
	}
	public void setResultselect(String resultselect) {
		Resultselect = resultselect;
	}
	public List<Block> getBlockResultList() {
		return BlockResultList;
	}
	public void setBlockResultList(List<Block> blockResultList) {
		BlockResultList = blockResultList;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getConditionResult() {
		return conditionResult;
	}
	public void setConditionResult(String conditionResult) {
		this.conditionResult = conditionResult;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
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
	public String getResultNo() {
		return resultNo;
	}
	public void setResultNo(String resultNo) {
		this.resultNo = resultNo;
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
	
	
	public BlockService(IBlockDAO blockDAO) {
		super();
		this.blockDAO = blockDAO;
	}

	/**
	 * 내가 신고한 불량회원 리스트 보기
	 * @return
	 * @throws Exception
	 */
	public String viewMyBlockList() throws Exception {
	
		member=(Member)session.get("LOGIN_EMAIL");
	
		if(page==0){
			page=1;
		}
		int length=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(member==null){
		
			return ERROR;
		}
		email=member.getEmail();
		MyBlockList=blockDAO.selectMyBlockList(length, page,  email);
		
	
		int blockCount=blockDAO.selectBlockCount();
		
		PAGE_LINK_TAG = PageUtil.generate(page, blockCount, length, "/bookchange/viewMyBlockList.action");
		
		return "success";
	}
	/**
	 * (관리자모드) 불량회원 리스트 보기
	 * @return
	 * @throws Exception
	 */
	public String viewBlockList() throws Exception {
	
	
		if(page==0){
			page=1;
		}
		int length=10;
		
		BlockList=blockDAO.selectBlockList(page, length);
		
	
		BlockCount=blockDAO.selectBlockCount();
		
		PAGE_LINK_TAG = PageUtil.generate(page, BlockCount, length, "/bookchange/viewBlockList.action");
		
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
	

		block=blockDAO.viewBlock(blockNo);
		
		BLOCKCONDITION.setBlockConditionIng(conditionResult);
		block.setBlockCondition(BLOCKCONDITION);
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
	
		return "success";
	}
	/**
	 * (관리자모드)불량회원 처리상황 변경(대기중-->검토중)
	 * @return
	 * @throws Exception
	 */
	public String viewBlock() throws Exception {
		BLOCK=blockDAO.viewBlock(blockNo);
		if(BLOCK.getBlockCondition().getBlockConditionResult().equals("0")){
			BLOCKCONDITION.setBlockConditionIng("1");
			BLOCK.setBlockCondition(blockCondition);
			blockDAO.updateBlock(BLOCK);
			BLOCK=blockDAO.viewBlock(blockNo);

		}

		return "success";	
	}

	/**
	 * 신고상태(신고완료리스트)
	 * 
	 * @param request
	 * @param response
	 */
	public String viewBlockResult() throws Exception {
		
		//기본 페이지
		if(page==0){
			page=1;
		}
		page=5;
		length=10;
	
		    BlockResultList=blockDAO.selectBlockbyResult(length, page, "3");
			BlockCount=blockDAO.selectBlockbyResultCount("3");
		
		PAGE_LINK_TAG = PageUtil.generate(page, BlockCount, length, "/bookchange/viewBlockResult.action");

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
		
		//페이지 파라미터가 존재
		if (page==0) {
			page=1;
		}
		int length=10;
	
		
	

			   
		   		BlockList=
						blockDAO.selectBlockbyResulting(length, page,resultno);
	
		   		BlockCount
		   				=blockDAO.selectBlockbyResultCounting(resultno);
						
		
		 PAGE_LINK_TAG = PageUtil.generate(page, BlockCount, length, "/BlockService/searchBlockList.action?resultno="+resultno);
			
	
		 return "success";
	
	}
}

