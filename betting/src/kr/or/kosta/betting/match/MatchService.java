package kr.or.kosta.betting.match;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.betting.util.PageUtil;

/**
 * Servlet implementation class MatchService
 */
public class MatchService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method == null) {
			method = "viewMatchList";
		}
		if ("viewMatchList".equals(method)) {
			viewMatchList(request, response);
		}

	}
	/**
	 * 메치데이터 입력 메서드
	 * 
	 * @param request
	 * @param response
	 */
	public void addMatch(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * 메치데이터 입력 메서드의 폼구현
	 * 
	 * @param request
	 * @param response
	 */
	public void addMatchForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * 수정하기 위한 폼 설정을 위한 메서드
	 * 
	 * @param request
	 * @param response
	 */
	public void editMatchForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * 메치 수정 메서드
	 * 
	 * @param request
	 * @param response
	 */
	public void editMatch(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * 메치 데이터 삭제 메서드
	 * 
	 * @param request
	 * @param response
	 */
	public void removeMatch(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * 모든 메치 데이터 조회
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void viewMatchList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int length = 10;

		ArrayList<Match> matchList = MatchDAO.selectMatchList(length, page);
		request.setAttribute("MATCH_LIST", matchList);
		int matchCount = MatchDAO.selectMatchCount();
		String pageLinkTag = PageUtil.generate(page, matchCount, length,
				"MatchService?method=viewMatchList");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd = request
				.getRequestDispatcher("/match/viewMatchList.jsp");
		rd.forward(request, response);

	}

	/**
	 * 선택한 번호의 메치데이
	 * 
	 * @param request
	 * @param response
	 */

	public void veiwMatch(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

}
