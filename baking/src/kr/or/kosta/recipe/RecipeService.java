package kr.or.kosta.recipe;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;



public class RecipeService extends HttpServlet{

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
//			method="viewRecipeList";
			method="addRecipe";
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
			ArrayList<Recipe> recipeList= RecipeDAO.selectDivisionRecipeList(division);
//			request�� �����Ǳ��и���Ʈ ����Ʈ ����
			request.setAttribute("RECIPE_DIVISION_LIST", recipeList);
		
			RequestDispatcher rd = request.getRequestDispatcher("/recipe/recipeRelativeGoodList.jsp");
			rd.forward(request, response);
	}
	
	//����������
	public void viewRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			int recipeNum=Integer.parseInt(request.getParameter("recipenum"));

//			�����ͺ��̽����� ���������� ��ȸ
			Recipe recipe =RecipeDAO.selectRecipe(recipeNum);
//			�����ǰ��� ��ǰ���� ��ȸ
			ArrayList<Good>recipeRelativeGoodList=GoodDAO.selectRecipeList(recipeNum);
//			�����ǰ��� �̹��� ��ȸ
			ArrayList<Photo>recipePhotoList=PhotoDAO.selectRecipePhotoList(recipeNum);
			
//			request�� ����������, �����ǰ��� ��ǰ����, �����ǰ��� �̹��� ����
			request.setAttribute("RECIPE", recipe);
			request.setAttribute("RECIPE_GOODLIST", recipeRelativeGoodList);
			request.setAttribute("RECIPE_PHOTO", recipePhotoList);
			
			RequestDispatcher rd =request.getRequestDispatcher("/recipe/viewRecipe.jsp");
			rd.forward(request, response);
	}

	//�������߰�(�̱���)
	public void addRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
			
//			String title =request.getParameter("title");
//			String content =request.getParameter("content");
//			String img =request.getParameter("img");
//			String material =request.getParameter("material");
//			int division =Integer.parseInt(request.getParameter("division"));

			
//			upload
			
//			C:\devlopement\workspace\baking\WebContent
			String tempRealPath = "c://devlopement/workspace/baking/WebContent/temp";
			System.out.println("tempRealPath:" + tempRealPath);
			File tempDeirectory = new File(tempRealPath);
			if (!tempDeirectory.exists()) {
				tempDeirectory.mkdir();
			}
			
			String uploadRealPath = "c://devlopement/workspace/baking/WebContent/upload";
			System.out.println("uploadReadlPath:" + uploadRealPath);
			File uploadDirectory = new File(uploadRealPath);
			if (!uploadDirectory.exists()) {
				tempDeirectory.mkdir();
			}
					
			int fileMaxSize = 1024 * 1000 * 1000;// 1GB			
			DiskFileItemFactory factory = new DiskFileItemFactory(fileMaxSize,
					tempDeirectory);// (�ӽ������ִ������,�ӽ���������)
			
			// �ӽ����Ϸ� ����� �������� ��ü-���ϼ�,�����̸�
			ServletFileUpload upload = new ServletFileUpload(factory);
			// �ӽ������� ������ ������ List����
			List<FileItem> fileList = null;
			try {
				fileList = (List) upload.parseRequest(request);
			} catch (FileUploadException e) {	e.printStackTrace();}

			for (int i = 0; i < fileList.size(); i++) {
				// �ӽ����� �ϳ��� ���� ����
				FileItem file = fileList.get(i);
				// ������ ���� ������ �̸�(Ȯ��������)�� ����
				String originalFileName = file.getName();
//------------------------			
//				PhotoInsertDAO(originalFileName) �߰�
//------------------------				
				System.out.println(originalFileName);
				if (originalFileName != null) {
					// �̵��� ������ ���, ���ϸ� �������� ��ü
					File uploadFile = new File(uploadDirectory + "/"
							+ originalFileName);
				}
			}
			
			
//			and upload
			
			Recipe recipe =new Recipe();
			Good_division good_division=new Good_division();
			
//			recipe.setTitle(title);
//			recipe.setContent(content);
//			recipe.setImg(img);
//			recipe.setMaterial(material);
//			good_division.setDivision(division);
//			recipe.setGood_division(good_division);
			
			RecipeDAO.insertRecipe(recipe);
			
			RequestDispatcher rd = request.getRequestDispatcher("/RecipeService?method=viewRecipeList");
			rd.forward(request, response);
	}

	//�������߰���
	public void addRecipeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd= request.getRequestDispatcher("/recipe/addRecipe.jsp");
			rd.forward(request, response);
	}

	//�����Ǽ���(�̱���)
	public void editRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			int recipeNum=Integer.parseInt(request.getParameter("recipenum"));
			String title =request.getParameter("title");
			String content =request.getParameter("content");
			String img =request.getParameter("img");
			String material =request.getParameter("material");
			int division =Integer.parseInt(request.getParameter("division"));
			
			
			//1.��ǰ���̺��� ��ǰ���� insert
			//2.�̹������̺��� �̹����� insert
			
			Recipe recipe =new Recipe();
			Good_division good_division=new Good_division();
			
			recipe.setRecipeNum(recipeNum);
			recipe.setTitle(title);
			recipe.setContent(content);
			recipe.setImg(img);
			recipe.setMaterial(material);
			good_division.setDivision(division);
			recipe.setGood_division(good_division);
			
			RecipeDAO.updateRecipe(recipe);
			
			RequestDispatcher rd=request.getRequestDispatcher("/RecipeService?method=viewRecipe&recipenum="+recipeNum);
			rd.forward(request, response);

		
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
