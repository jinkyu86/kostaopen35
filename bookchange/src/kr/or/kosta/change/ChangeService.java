package kr.or.kosta.change;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeService {
	
	private static final long serialVersionUID = 1L;
	
	public ChangeService() {
	        super();
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**��ȯ����Ʈ�� ���ο� ��ȯ �߰�**/
	public void addChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**��ȯ���� ����(��ȯ��?��ȯ�Ϸ�?)**/
	public void editChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**��ȯ����Ʈ���� ����**/
	public void removeChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**��ȯ ����**/
	public void viewChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**��ü ��ȯ ����Ʈ ����**/
	public void viewChangeList(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**��ȯ����Ʈ �˻�**/
	public void searchChangeList(HttpServletRequest request,
			HttpServletResponse response) {
	}
}
