package kr.or.kosta.bookchange.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QaService extends HttpServlet {

	/**
	 * 
	 */
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
	 * ��ǰ���� �� �߰�
	 * 
	 * @param request
	 * @param response
	 */
	public void addQa(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * ��ǰ���� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void editQa(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * ��ǰ���� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void removeQa(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * ��ǰ���� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void viewQa(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
