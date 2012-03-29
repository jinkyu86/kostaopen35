package kr.or.kosta.good;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodService
 */
public class GoodService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodService() {
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
		String method=request.getParameter("method");
		if(method==null){
			method="viewGoodList";
		}
		if("viewGoodList".equals(method)){
			viewGoodList(request,response);
		}else if("viewGood".equals(method)){
			viewGood(request,response);
		}else if("addGood".equals(method)){
			addGood(request,response);
		}else if("addGoodForm".equals(method)){
			addGoodForm(request,response);
		}else if("editGood".equals(method)){
			editGood(request,response);
		}else if("editGoodForm".equals(method)){
			editGoodForm(request,response);
		}else if("removeGood".equals(method)){
			removeGood(request,response);
		}else if("relationRecipe".equals(method)){
			relationRecipe(request,response);
		}
	}

	/**
	 * 상품리스트보기
	 */
	public void viewGoodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodDAO goodDAO = new GoodDAO();
		ArrayList<Good> goodList = goodDAO.selectGoodList();
		request.setAttribute("GOOD_LIST",goodList);
		RequestDispatcher rd = request.getRequestDispatcher("/good/viewGoodList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 상품정보보기
	 */
	public void viewGood(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 상품추가
	 */
	public void addGood(HttpServletRequest request, HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 상품추가폼
	 */
	public void addGoodForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 상품수정
	 */
	public void editGood(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 상품수정폼
	 */
	public void editGoodForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 상품삭제
	 */
	public void removeGood(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 상품관련 레시피 출력
	 */
	public void relationRecipe(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}
}
