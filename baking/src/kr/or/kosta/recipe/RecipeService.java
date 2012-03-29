package kr.or.kosta.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
		}
	}
	
	//레시피리스트 
	public void viewRecipeList(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//레시피정보
	public void viewRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//레시피추가
	public void addRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//레시피추가폼
	public void addRecipeForm(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//레시피수정
	public void editRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//레시피수정폼
	public void editRecipeForm(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//레시피삭제
	public void removeRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}
}
