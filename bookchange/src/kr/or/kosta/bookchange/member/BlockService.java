package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.util.PageUtil;


public class BlockService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BlockService() {
		super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf=8");
		String method=request.getParameter("method");
		if (method==null) {
			method="addBlock";
		}if("addBlock".equals(method)){
			addBlock(request,response);
		}else if("editBlock".equals(method)){
			editBlock(request, response);
		}else if("removeBlock".equals(method)){
			removeBlock(request, response);
		}else if("searchBlockList".equals(method)){
			searchBlockList(request, response);
		}
	}
	/**
	 * 신고리스트에 접수내용 추가
	 * 
	 * @param request
	 * @param response
	 */
	public void addBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		

		String blockcontent=request.getParameter("blockcontent");
		String blockemail=request.getParameter("blockemail");
		String registeremail=request.getParameter("registeremail");
		
		Block block=new Block();
		block.setBlockContent(blockcontent);
		
		Member member=new Member();
		member.setEmail(blockemail);
		block.setBlockmember(member);
		
		Member member2=new Member();
		member2.setEmail(registeremail);
		block.setMember(member2);
		
		BlockDAO.insertBlock(block);
		
		RequestDispatcher rd=request.getRequestDispatcher("/BlockService?method=addBlock.jsp");
		rd.forward(request, response);
	}

	/**
	 * 신고상태(검토중인지, 검토완료인지)수정할 때 사용
	 * 
	 * @param request
	 * @param response
	 */
	public void editBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		String blockConditionresult=request.getParameter("blockcConditionresult");
		String blockno=request.getParameter("blockno");
		
		Block block=new Block();
		block.setBlockNo(Integer.parseInt(blockno));
		
		BlockCondition blockCondition=new BlockCondition();
		blockCondition.setBlockConditionResult(Integer.parseInt(blockConditionresult));
		block.setBlockCondition(blockCondition);
		
		BlockDAO.updateBlock(block);
		
		RequestDispatcher rd= request.getRequestDispatcher("/BlockService?method=editBlock");
		rd.forward(request, response);
	}

	/**
	 * 신고리스트에서 삭제
	 * 
	 * @param request
	 * @param response
	 */
	public void removeBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		String blockno=request.getParameter("blockno");
		
		Block block= new Block();
		block.setBlockNo(Integer.parseInt(blockno));
		
		BlockDAO.deleteBlock(Integer.parseInt(blockno));
		
		RequestDispatcher rd= request.getRequestDispatcher("/BlockService?method=removeBlock");
		rd.forward(request, response);
	}

	/**
	 * 신고리스트 검색
	 * 
	 * @param request
	 * @param response
	 */
	public void searchBlockList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		
		//기본 페이지
		int page=1;
		//페이지 파라미터가 존재
		if (request.getParameter("page")!=null) {
			//파라미터 리턴
			page=Integer.parseInt(request.getParameter("page"));
			
		}
		int length=5;
		
		ArrayList<Block> blockList=null;
		int BlockCount=0;

		if(request.getParameter("keyword")==null||
			request.getParameter("keyword").equals("")){
				blockList=
						BlockDAO.selectBlockList(length, page);
				BlockCount=
						BlockDAO.selectBlockCount();
				
		}else{
				blockList=
							BlockDAO.selectBlockbyResult(length, page, request.getParameter("keyword"));
				BlockCount=
						BlockDAO.selectBlockbyResultCount(request.getParameter("keyword"));				
		}
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("BLOCK_LIST",blockList);
		String pageLink=
				PageUtil.generate(page, BlockCount, length, "/BlockService?" +
						"method=searchBlockList&keyword=" +
						request.getParameter("keyword"));
		request.setAttribute("PAGE_LINK", pageLink);

		RequestDispatcher rd=request.getRequestDispatcher("/block/viewBlockList.jsp");
		rd.forward(request, response);
	}
}
