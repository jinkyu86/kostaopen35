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
	 * �Ű���Ʈ�� �������� �߰�
	 * 
	 * @param request
	 * @param response
	 */
	public void addBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
		
	}

	/**
	 * �Ű����(����������, ����Ϸ�����)������ �� ���
	 * 
	 * @param request
	 * @param response
	 */
	public void editBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		/* default generated stub */;
		
	}

	/**
	 * �Ű���Ʈ���� ����
	 * 
	 * @param request
	 * @param response
	 */
	public void removeBlock(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
	}

	/**
	 * �Ű���Ʈ �˻�
	 * 
	 * @param request
	 * @param response
	 */
	public void searchBlockList(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException {
		/* default generated stub */;
		
	}
}
