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
	public void viewGood(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int goodNum  = Integer.parseInt(request.getParameter("goodNum"));
		
		//데이터 베이스에서 상품정보 조회
		Good good = GoodDAO.selectGood(goodNum);
		//상품 관련 레시피 조회
		ArrayList<Recipe> recipeList = RecipeDAO.selectRecipeList(goodNum);
		ArrayList<Photo> photoList = PhotoDAO.selectGoodPhotoList(goodNum);

		request.setAttribute("GOOD", good);
		request.setAttribute("GOOD_RECIPELIST", recipeList);
		request.setAttribute("PHOTO_LIST", photoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/good/viewGood.jsp");
		rd.forward(request, response);
	}

	/**
	 * 상품추가
	 */
	public void addGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라메터 정보 리턴
		int goodNum = Integer.parseInt(request.getParameter("goodNum"));
		int division = Integer.parseInt(request.getParameter("division"));
		int goodPrice = Integer.parseInt(request.getParameter("goodPrice"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String name = request.getParameter("name");
		String explantion = request.getParameter("explantion");
		String img = request.getParameter("img");
		String option = request.getParameter("option");
		
		//2.Good 객체 생성, 1의 속성을 저장
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
		
		//3.DB에 저장
		GoodDAO.insertGood(good);
		//4. 전체 학생리스트 이동객체 생성
		RequestDispatcher rd = request.getRequestDispatcher("/GoodService?mehtod=viewGoodList");
		rd.forward(request, response);
	}

	/**
	 * 상품추가폼
	 */
	public void addGoodForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 1.전체 학과 리스트 조회
		ArrayList<Good_division> good_divisionList = GoodDivisionDAO.selectGooddivisionList();
		// 2.request에 저장
		request.setAttribute("DIVISION_LIST", good_divisionList);
		// 3.학생추가 페이지 이동 객체 생성
		RequestDispatcher rd = request.getRequestDispatcher("/good/addGood.jsp");
		// 4.페이지 이동
		rd.forward(request, response);
	}

	/**
	 * 상품수정
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
		
		//2.Good 객체 생성, 1의 속성을 저장
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
		
		//3.DB에 저장
		GoodDAO.updateGood(good);
		//4. 전체 학생리스트 이동객체 생성
		RequestDispatcher rd = request.getRequestDispatcher("/GoodService?mehtod=viewGood&goodNum="+goodNum); //RequestDispatcher에 쓸때는 프로젝트명은 뺀다는것에 유의
		rd.forward(request, response);
	}

	/**
	 * 상품수정폼
	 */
	public void editGoodForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.전체 학과 리스트 조회
		ArrayList<Good_division> good_divisionList = GoodDivisionDAO.selectGooddivisionList();
		// 2.request에 저장
		request.setAttribute("DIVISION_LIST", good_divisionList);
		// 3.학생추가 페이지 이동 객체 생성
		RequestDispatcher rd = request.getRequestDispatcher("/good/editGood.jsp");
		// 4.페이지 이동
		rd.forward(request, response);
	}

	/**
	 * 상품삭제
	 */
	public void removeGood(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int goodNum=Integer.parseInt(request.getParameter("goodNum"));
		GoodDAO.deleteGood(goodNum);
		RequestDispatcher rd = request.getRequestDispatcher("/GoodService?method=viewGoodList");
		rd.forward(request, response);
	}
}
