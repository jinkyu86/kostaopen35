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
		
		if("viewRecipeList".equals(method)){				// ��ü������ ����Ʈ 
			viewRecipeList(request,response);				
		}else if("recipeRelativeGoodList".equals(method)){  // �����Ǳ��� ����Ʈ
			recipeRelativeGoodList(request,response);
		}else if("viewRecipe".equals(method)){				// ����������
			viewRecipe(request,response);
		}else if("addRecipe".equals(method)){				// �������߰�
			addRecipe(request, response);
		}else if("addRecipeForm".equals(method)){			// �������߰� ��
			addRecipeForm(request, response);
		}else if("editRecipe".equals(method)){				// �����Ǽ���
			editRecipe(request, response);
		}else if("editRecipeForm".equals(method)){			// �����Ǽ��� ��
			editRecipeForm(request, response);
		}else if("removeRecipe".equals(method)){			// �����ǻ���
			removeRecipe(request, response);
		}
	}
	
	// ��ü������ ����Ʈ 
	public void viewRecipeList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
//			�����ͺ��̽����� ��ü������ ��ȸ
			ArrayList<Recipe> recipeList= RecipeDAO.selectRecipeList();
//			request�� ��ü ������ ����Ʈ ����
			request.setAttribute("RECIPE_LIST", recipeList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/recipe/viewRecipeList.jsp");
			rd.forward(request, response);
	}
	
	// �����Ǳ��� ����Ʈ
	public void recipeRelativeGoodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			int division=Integer.parseInt(request.getParameter("division"));
			
//			�����ͺ��̽����� �����Ǳ��и���Ʈ ��ȸ
			ArrayList<Recipe> recipeList= RecipeDAO.selectRecipeList(division);
//			request�� �����Ǳ��и���Ʈ ����Ʈ ����
			request.setAttribute("RECIPE_DIVISION_LIST", recipeList);
		
			RequestDispatcher rd = request.getRequestDispatcher("/recipe/recipeRelativeGoodList.jsp");
			rd.forward(request, response);
	}
	
	//����������
	public void viewRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			int recipeNum=Integer.parseInt(request.getParameter("num"));

//			�����ͺ��̽����� ���������� ��ȸ
			Recipe recipe =RecipeDAO.selectRecipe(recipeNum);
//			�����ǰ��� ��ǰ���� ��ȸ
			ArrayList<Good>recipeRelativeGoodList=GoodDAO.selectRecipeList(recipeNum);
			
//			request�� ����������, �����ǰ��� ��ǰ���� ����
			request.setAttribute("RECIPE", recipe);
			request.setAttribute("RECIPE_GOODLIST", recipeRelativeGoodList);
			
			RequestDispatcher rd =request.getRequestDispatcher("/recipe/viewRecipe.jsp");
			rd.forward(request, response);
	}

	//�������߰�
	public void addRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	//�������߰���
	public void addRecipeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("/recipe/addRecipe.jsp");
		rd.forward(request, response);
	}

	//�����Ǽ���
	public void editRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	//�����Ǽ�����
	public void editRecipeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("/recipe/editRecipe.jsp");
		rd.forward(request, response);
	}

	//�����ǻ���
	public void removeRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int recipeNum=Integer.parseInt(request.getParameter("num"));
		
//		�����ͺ��̽����� �ش緹���ǹ�ȣ�� �����ǻ���
		RecipeDAO.deleteRecipe(recipeNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("/RecipeService?method=viewRecipeList");
		rd.forward(request, response);
	}
}
