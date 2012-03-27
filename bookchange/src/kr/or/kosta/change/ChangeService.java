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

	/**교환리스트에 새로운 교환 추가**/
	public void addChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**교환상태 수정(교환중?교환완료?)**/
	public void editChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**교환리스트에서 삭제**/
	public void removeChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**교환 보기**/
	public void viewChange(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**전체 교환 리스트 보기**/
	public void viewChangeList(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**교환리스트 검색**/
	public void searchChangeList(HttpServletRequest request,
			HttpServletResponse response) {
	}
}
