package kr.or.kosta.bookchange.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BlockService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BlockService() {
		super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	/**
	 * 신고리스트에 접수내용 추가
	 * 
	 * @param request
	 * @param response
	 */
	public void addBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * 신고상태(검토중인지, 검토완료인지)수정할 때 사용
	 * 
	 * @param request
	 * @param response
	 */
	public void editBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * 신고리스트에서 삭제
	 * 
	 * @param request
	 * @param response
	 */
	public void removeBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
	}

	/**
	 * 신고리스트 검색
	 * 
	 * @param request
	 * @param response
	 */
	public void searchBlockList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
		
	}
}
