package kr.or.kosta.betting.memberbetdata;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.betting.match.MatchDAO;
import kr.or.kosta.betting.util.PageUtil;

/**
 * Servlet implementation class MemberBetDataService
 */
public class MemberBetDataService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBetDataService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method == null) {
			method = "viewMemberBetDataByIDList";
		}
		if ("viewMemberBetDataByIDList".equals(method)) {
			viewMemberBetDataByIDList(request, response);
		}
	}
	/**
	 * ��� ���� ������ ���� �޼���
	 * 
	 * @param request
	 * @param response
	 */
	public void removeMemberBetData(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
		
	}

	/**
	 * ���̵�� ������ �Ϸ� ���ǵ� ������ ��ȸ
	 * 
	 * @param request
	 * @param response
	 */
	public void veiwMemberBetDataList(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
		
	}

	/**
	 * ���� ��� ��ȸ �޼���
	 * 
	 * @param request
	 * @param response
	 */
	public void resultMemberBet(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
		
	}

	/**
	 * ���õ� ���̵��� ��� ���� ������ ��ȸ �޼��� 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewMemberBetDataByIDList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int length = 10;
		
		ArrayList<MemberBetData> mbdList = 
				MemberBetDataDAO.selectMemberBetDataListByID(page, length, "jun1");
		request.setAttribute("MBD_LIST", mbdList);
		int matchCount = MatchDAO.selectMatchCount();
		String pageLinkTag = PageUtil.generate(page, matchCount, length,
				"MemberBetDataService?method=viewMBDByIDList");
		request.setAttribute("PAGE_LINK_TAG", pageLinkTag);
		RequestDispatcher rd = request
				.getRequestDispatcher("/mbd/viewMBDByIDList.jsp");
		rd.forward(request, response);
	}

	/**
	 * ���õ� ���̵��� ��� ���� ������ ��ȸ�� ������ ���� �޼���
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMemberBetDataForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
		
	}
}
