package kr.or.kosta.bookchange.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardService extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public BoardService() {
	        super();
	       
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * �Խù� �߰�
	 * 
	 * @param request
	 * @param response
	 */
	public void addBoard(HttpServletRequest request, HttpServletResponse response) {
	}

	/**
	 * �Խù� �߰� â(��ǰ��� ȭ��)
	 * 
	 * @param request
	 * @param response
	 */
	public void addBoardForm(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * �Խù� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void editBoard(HttpServletRequest request,HttpServletResponse response) {
		
	}

	/**
	 * �Խù� ���� â
	 * 
	 * @param request
	 * @param response
	 */
	public void editBoardForm(HttpServletRequest request,HttpServletResponse response) {

	}

	/**
	 * �Խù� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void removeBoard(HttpServletRequest request,	HttpServletResponse response) {
		
	}

	/**
	 * �Խù� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void viewBoard(HttpServletRequest request,HttpServletResponse response) {
		
	}

	/**
	 * �Խù� ��ü ����Ʈ ����
	 * 
	 * @param request
	 * @param response
	 */
	public void viewBoardList(HttpServletRequest request,HttpServletResponse response) {
		
	}

	/**
	 * �Խù� �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public void searchBoardList(HttpServletRequest request,	HttpServletResponse response) {
		
	}
}
