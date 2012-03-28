package kr.or.kosta.bookchange.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.bookchange.member.Member;

public class QaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public QaService() {
	        super();
	       
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * 상품문의 글 추가
	 * 
	 * @param request
	 * @param response
	 */
	public void addQa(HttpServletRequest request, HttpServletResponse response) {
		//String qaNo=request.getParameter("qaNo");
		String qaContent=request.getParameter("qaContent");
		String email=request.getParameter("email");
		String boardNo=request.getParameter("boardNo");
		
		Qa qa=new Qa();
		//qa.setQaNo(Integer.parseInt(qaNo));
		qa.setQaContent(qaContent);
		
		Member member=new Member();
		member.setEmail(email);	
		qa.setMember(member);
		
		Board board=new Board();
		board.setBoardNo(Integer.parseInt(boardNo));
		qa.setBoard(board);
		
		QaDAO.insertQa(qa);
		
	}

	/**
	 * 상품문의 수정
	 * 
	 * @param request
	 * @param response
	 */
	public void editQa(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * 상품문의 삭제
	 * 
	 * @param request
	 * @param response
	 */
	public void removeQa(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * 상품문의 보기
	 * 
	 * @param request
	 * @param response
	 */
	public void viewQa(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
