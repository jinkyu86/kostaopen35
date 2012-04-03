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
			ArrayList<Recipe> recipeList= RecipeDAO.selectDivisionRecipeList(division);
//			request에 레시피구분리스트 리스트 저장
			request.setAttribute("RECIPE_DIVISION_LIST", recipeList);
		
			RequestDispatcher rd = request.getRequestDispatcher("/recipe/recipeRelativeGoodList.jsp");
			rd.forward(request, response);
	}
	
	//레시피정보
	public void viewRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			int recipeNum=Integer.parseInt(request.getParameter("recipenum"));

//			데이터베이스에서 레시피정보 조회
			Recipe recipe =RecipeDAO.selectRecipe(recipeNum);
//			레시피관련 상품정보 조회
			ArrayList<Good>recipeRelativeGoodList=GoodDAO.selectRecipeList(recipeNum);
//			레시피관련 이미지 조회
			ArrayList<Photo>recipePhotoList=PhotoDAO.selectRecipePhotoList(recipeNum);
			
//			request에 레시피정보, 레시피관련 상품정보, 레시피관련 이미지 저장
			request.setAttribute("RECIPE", recipe);
			request.setAttribute("RECIPE_GOODLIST", recipeRelativeGoodList);
			request.setAttribute("RECIPE_PHOTO", recipePhotoList);
			
			RequestDispatcher rd =request.getRequestDispatcher("/recipe/viewRecipe.jsp");
			rd.forward(request, response);
	}

	//레시피추가(미구현)
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
					tempDeirectory);// (임시파일최대사이즈,임시파일폴더)
			
			// 임시파일로 저장된 정보리턴 객체-파일수,월래이름
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 임시파일의 정보를 저장할 List선언
			List<FileItem> fileList = null;
			try {
				fileList = (List) upload.parseRequest(request);
			} catch (FileUploadException e) {	e.printStackTrace();}

			for (int i = 0; i < fileList.size(); i++) {
				// 임시파일 하나의 정보 리턴
				FileItem file = fileList.get(i);
				// 파일의 원래 파일의 이름(확장자포함)을 리턴
				String originalFileName = file.getName();
//------------------------			
//				PhotoInsertDAO(originalFileName) 추가
//------------------------				
				System.out.println(originalFileName);
				if (originalFileName != null) {
					// 이동할 파일의 경로, 파일명 정보저장 객체
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

	//레시피추가폼
	public void addRecipeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd= request.getRequestDispatcher("/recipe/addRecipe.jsp");
			rd.forward(request, response);
	}

	//레시피수정(미구현)
	public void editRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			int recipeNum=Integer.parseInt(request.getParameter("recipenum"));
			String title =request.getParameter("title");
			String content =request.getParameter("content");
			String img =request.getParameter("img");
			String material =request.getParameter("material");
			int division =Integer.parseInt(request.getParameter("division"));
			
			
			//1.상품테이블의 상품정보 insert
			//2.이미지테이블의 이미지명 insert
			
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
