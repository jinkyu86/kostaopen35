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
	
	//�����Ǹ���Ʈ 
	public void viewRecipeList(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//����������
	public void viewRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//�������߰�
	public void addRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//�������߰���
	public void addRecipeForm(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//�����Ǽ���
	public void editRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//�����Ǽ�����
	public void editRecipeForm(HttpServletRequest request,
			HttpServletResponse response) {
	}

	//�����ǻ���
	public void removeRecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}
}
