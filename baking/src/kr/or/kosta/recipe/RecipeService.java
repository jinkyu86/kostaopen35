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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.or.kosta.file.receive.FileRenamePolicy;
import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.member.Member;
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
			method="viewRecipeList";
//			method="addRecipe";
//			method="addRecipeForm";
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
			Member member = new Member();
			member.setMemberid("ADMIN");			
			HttpSession session = request.getSession();
			session.setAttribute("member",member);
/////////////////////////////////////////////////
			
			
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
			System.out.println(recipePhotoList);
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
			System.out.println("method addRecipe");
			
			String title =request.getParameter("title");
			String content =request.getParameter("content");
			String img =request.getParameter("photo");
			String material =request.getParameter("material");
			int division =Integer.parseInt(request.getParameter("division"));

			
			Recipe recipe =new Recipe();
			Good_division good_division=new Good_division();
			
			recipe.setTitle(title);
			recipe.setContent(content);
			recipe.setImg(img);
			recipe.setMaterial(material);
			good_division.setDivision(division);
			recipe.setGood_division(good_division);
			
			System.out.println(recipe);
			RecipeDAO.insertRecipe(recipe);
			
			RequestDispatcher rd = request.getRequestDispatcher("/RecipeService?method=viewRecipeList");
			rd.forward(request, response);
	}

	//레시피추가폼
	public void addRecipeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			ArrayList<Good_division> arrayList = GoodDivisionDAO.selectGooddivisionList();
			
			request.setAttribute("DIVISION_LIST", arrayList);
			
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
