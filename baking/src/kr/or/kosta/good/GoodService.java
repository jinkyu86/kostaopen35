package kr.or.kosta.good;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.recipe.RecipeDAO;

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
		}
	}

	/**
	 * ��ǰ����Ʈ����
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
	 * ��ǰ��������
	 */
	public void viewGood(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int goodNum  = Integer.parseInt(request.getParameter("goodNum"));
		
		//������ ���̽����� ��ǰ���� ��ȸ
		Good good = GoodDAO.selectGood(goodNum);
		//��ǰ ���� ������ ��ȸ
		ArrayList<Recipe> recipeList = RecipeDAO.selectRecipeList(goodNum);
		ArrayList<Photo> photoList = PhotoDAO.selectGoodPhotoList(goodNum);

		request.setAttribute("GOOD", good);
		request.setAttribute("GOOD_RECIPELIST", recipeList);
		request.setAttribute("PHOTO_LIST", photoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/good/viewGood.jsp");
		rd.forward(request, response);
	}

	/**
	 * ��ǰ�߰�
	 */
	public void addGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.�Ķ���� ���� ����
		int goodNum = Integer.parseInt(request.getParameter("goodNum"));
		int division = Integer.parseInt(request.getParameter("division"));
		int goodPrice = Integer.parseInt(request.getParameter("goodPrice"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String name = request.getParameter("name");
		String explantion = request.getParameter("explantion");
		String img = request.getParameter("img");
		String option = request.getParameter("option");
		
		//2.Good ��ü ����, 1�� �Ӽ��� ����
		Good good= new Good();
		good.setGoodNum(goodNum);
		good.setGoodPrice(goodPrice);
		good.setQty(qty);
		good.setName(name);
		good.setExplantion(explantion);
		good.setImg(img);
		good.setOption(option);
		
		Good_division good_division = new Good_division();
		good_division.setDivision(division);
		good.setGood_division(good_division);
		
		//3.DB�� ����
		GoodDAO.insertGood(good);
		//4. ��ü �л�����Ʈ �̵���ü ����
		RequestDispatcher rd = request.getRequestDispatcher("/GoodService?mehtod=viewGoodList");
		rd.forward(request, response);
	}

	/**
	 * ��ǰ�߰���
	 */
	public void addGoodForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 1.��ü �а� ����Ʈ ��ȸ
		ArrayList<Good_division> good_divisionList = GoodDivisionDAO.selectGooddivisionList();
		// 2.request�� ����
		request.setAttribute("DIVISION_LIST", good_divisionList);
		// 3.�л��߰� ������ �̵� ��ü ����
		RequestDispatcher rd = request.getRequestDispatcher("/good/addGood.jsp");
		// 4.������ �̵�
		rd.forward(request, response);
	}

	/**
	 * ��ǰ����
	 */
	public void editGood(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int goodNum = Integer.parseInt(request.getParameter("goodNum"));
		int division = Integer.parseInt(request.getParameter("division"));
		int goodPrice = Integer.parseInt(request.getParameter("goodPrice"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String name = request.getParameter("name");
		String explantion = request.getParameter("explantion");
		String img = request.getParameter("img");
		String option = request.getParameter("option");
		
		//2.Good ��ü ����, 1�� �Ӽ��� ����
		Good good= new Good();
		good.setGoodNum(goodNum);
		good.setGoodPrice(goodPrice);
		good.setQty(qty);
		good.setName(name);
		good.setExplantion(explantion);
		good.setImg(img);
		good.setOption(option);
		
		Good_division good_division = new Good_division();
		good_division.setDivision(division);
		good.setGood_division(good_division);
		
		//3.DB�� ����
		GoodDAO.updateGood(good);
		//4. ��ü �л�����Ʈ �̵���ü ����
		RequestDispatcher rd = request.getRequestDispatcher("/GoodService?mehtod=viewGood&goodNum="+goodNum); //RequestDispatcher�� ������ ������Ʈ���� ���ٴ°Ϳ� ����
		rd.forward(request, response);
	}

	/**
	 * ��ǰ������
	 */
	public void editGoodForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.��ü �а� ����Ʈ ��ȸ
		ArrayList<Good_division> good_divisionList = GoodDivisionDAO.selectGooddivisionList();
		// 2.request�� ����
		request.setAttribute("DIVISION_LIST", good_divisionList);
		// 3.�л��߰� ������ �̵� ��ü ����
		RequestDispatcher rd = request.getRequestDispatcher("/good/editGood.jsp");
		// 4.������ �̵�
		rd.forward(request, response);
	}

	/**
	 * ��ǰ����
	 */
	public void removeGood(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int goodNum=Integer.parseInt(request.getParameter("goodNum"));
		GoodDAO.deleteGood(goodNum);
		RequestDispatcher rd = request.getRequestDispatcher("/GoodService?method=viewGoodList");
		rd.forward(request, response);
	}
}
