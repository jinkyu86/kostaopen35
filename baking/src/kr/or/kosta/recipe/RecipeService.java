package kr.or.kosta.recipe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;



public class RecipeService {

    public RecipeService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if(method==null){
			method="viewRecipeList";
		}
		
		if("viewRecipeList".equals(method)){				// 전체레시피 리스트 
			viewRecipeList(request,response);				
		}else if("recipeRelativeGoodList".equals(method)){  // 레시피구분 리스트
			recipeRelativeGoodList(request,response);
		}else if("viewRecipe".equals(method)){				// 레시피정보
			viewRecipe(request,response);
		}else if("addRecipe".equals(method)){				// 레시피추가
			addRecipe(request, response);
		}else if("addRecipeForm".equals(method)){			// 레시피추가 폼
			addRecipeForm(request, response);
		}else if("editRecipe".equals(method)){				// 레시피수정
			editRecipe(request, response);
		}else if("editRecipeForm".equals(method)){			// 레시피수정 폼
			editRecipeForm(request, response);
		}else if("removeRecipe".equals(method)){			// 레시피삭제
			removeRecipe(request, response);
		}
	}
	
	// 전체레시피 리스트 
	public void viewRecipeList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
//			데이터베이스에서 전체레시피 조회
			ArrayList<Recipe> recipeList= RecipeDAO.selectRecipeList();
//			request에 전체 레시피 리스트 저장
			request.setAttribute("RECIPE_LIST", recipeList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/recipe/viewRecipeList.jsp");
			rd.forward(request, response);
	}
	
	// 레시피구분 리스트
	public void recipeRelativeGoodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			int division=Integer.parseInt(request.getParameter("division"));
			
//			데이터베이스에서 레시피구분리스트 조회
			ArrayList<Recipe> recipeList= RecipeDAO.selectRecipeList(division);
//			request에 레시피구분리스트 리스트 저장
			request.setAttribute("RECIPE_DIVISION_LIST", recipeList);
		
			RequestDispatcher rd = request.getRequestDispatcher("/recipe/recipeRelativeGoodList.jsp");
			rd.forward(request, response);
	}
	
	//레시피정보
	public void viewRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			int recipeNum=Integer.parseInt(request.getParameter("num"));

//			데이터베이스에서 레시피정보 조회
			Recipe recipe =RecipeDAO.selectRecipe(recipeNum);
//			레시피관련 상품정보 조회
			ArrayList<Good>recipeRelativeGoodList=GoodDAO.selectRecipeList(recipeNum);
			
//			request에 레시피정보, 레시피관련 상품정보 저장
			request.setAttribute("RECIPE", recipe);
			request.setAttribute("RECIPE_GOODLIST", recipeRelativeGoodList);
			
			RequestDispatcher rd =request.getRequestDispatcher("/recipe/viewRecipe.jsp");
			rd.forward(request, response);
	}

	//레시피추가
	public void addRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	//레시피추가폼
	public void addRecipeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("/recipe/addRecipe.jsp");
		rd.forward(request, response);
	}

	//레시피수정
	public void editRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	//레시피수정폼
	public void editRecipeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("/recipe/editRecipe.jsp");
		rd.forward(request, response);
	}

	//레시피삭제
	public void removeRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int recipeNum=Integer.parseInt(request.getParameter("num"));
		
//		데이터베이스에서 해당레시피번호의 레시피삭제
		RecipeDAO.deleteRecipe(recipeNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("/RecipeService?method=viewRecipeList");
		rd.forward(request, response);
	}
}
