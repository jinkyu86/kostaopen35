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

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.file.receive.FileRenamePolicy;
import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.member.Member;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;



public class RecipeService implements ModelDriven{
	private List<Recipe> RECIPE_LIST;
	private List<Recipe> RECIPE_DIVISION_LIST;
	private List<Good> RECIPE_GOODLIST;
	private List<Photo> RECIPE_PHOTO;
	private List<Good_division> DIVISION_LIST;
	private Recipe RECIPE;
	private Recipe recipe;
	private int recipeNum;
	private int division;
	
	
	@Override
	public Object getModel() {
		return recipe;
	}
	
	
	public List<Recipe> getRECIPE_LIST() {
		return RECIPE_LIST;
	}

	public void setRECIPE_LIST(List<Recipe> rECIPE_LIST) {
		RECIPE_LIST = rECIPE_LIST;
	}

	public List<Recipe> getRECIPE_DIVISION_LIST() {
		return RECIPE_DIVISION_LIST;
	}

	public void setRECIPE_DIVISION_LIST(List<Recipe> rECIPE_DIVISION_LIST) {
		RECIPE_DIVISION_LIST = rECIPE_DIVISION_LIST;
	}

	public List<Good> getRECIPE_GOODLIST() {
		return RECIPE_GOODLIST;
	}

	public void setRECIPE_GOODLIST(List<Good> rECIPE_GOODLIST) {
		RECIPE_GOODLIST = rECIPE_GOODLIST;
	}

	public List<Photo> getRECIPE_PHOTO() {
		return RECIPE_PHOTO;
	}

	public void setRECIPE_PHOTO(List<Photo> rECIPE_PHOTO) {
		RECIPE_PHOTO = rECIPE_PHOTO;
	}

	public List<Good_division> getDIVISION_LIST() {
		return DIVISION_LIST;
	}

	public void setDIVISION_LIST(List<Good_division> dIVISION_LIST) {
		DIVISION_LIST = dIVISION_LIST;
	}

	public Recipe getRECIPE() {
		return RECIPE;
	}

	public void setRECIPE(Recipe rECIPE) {
		RECIPE = rECIPE;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}
	
	public int getRecipeNum() {
		return recipeNum;
	}

	public void setRecipeNum(int recipeNum) {
		this.recipeNum = recipeNum;
	}

	// 전체레시피 리스트 
	public String viewRecipeList() throws Exception{
		System.out.println("RECIPE_LIST");
		RECIPE_LIST= RecipeDAO.selectRecipeList();
		return "success";
	}
	
	// 레시피구분 리스트
	public String recipeRelativeGoodList() throws Exception{
		RECIPE_DIVISION_LIST= RecipeDAO.selectDivisionRecipeList(division);
		return "success";
	}
	
	//레시피정보
	public String viewRecipe() throws Exception{
		RECIPE=RecipeDAO.selectRecipe(recipeNum);
//		레시피관련 상품정보 조회
		RECIPE_GOODLIST=GoodDAO.selectRecipeList(recipeNum);
//		레시피관련 이미지 조회
		RECIPE_PHOTO=PhotoDAO.selectRecipePhotoList(recipeNum);
		return "success";
	}

	//레시피추가(미구현)
	public String addRecipe() throws Exception {
			RecipeDAO.insertRecipe(recipe);
			return "success";	
	}

	//레시피추가폼
	public String addRecipeForm() throws Exception {
			DIVISION_LIST = GoodDivisionDAO.selectGooddivisionList();
			return "success";	
	}
	

	//레시피수정(미구현)
	public String editRecipe() throws Exception {			
			RecipeDAO.updateRecipe(recipe);
			return "success";
	}

	//레시피수정폼
	public String editRecipeForm() throws Exception {
		DIVISION_LIST = GoodDivisionDAO.selectGooddivisionList();
		return "success";
	}

	//레시피삭제
	public String removeRecipe() throws Exception {
		RecipeDAO.deleteRecipe(recipeNum);
		return "success";
	}

	
}
