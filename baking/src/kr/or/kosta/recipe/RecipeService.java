package kr.or.kosta.recipe;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.file.receive.FileRenamePolicy;
import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.good.IGoodDAO;
import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.gooddivision.IGoodDivisionDAO;
import kr.or.kosta.member.Member;
import kr.or.kosta.photo.IPhotoDAO;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;



public class RecipeService implements ModelDriven, ServletContextAware{
	private IRecipeDAO recipeDAO;
	private IGoodDAO goodDAO;
	private IPhotoDAO photoDAO;
	private IGoodDivisionDAO goodDivisionDAO;
	
	private List<Recipe> RECIPE_LIST;
	private List<Recipe> RECIPE_DIVISION_LIST;
	private List<Good> RECIPE_GOODLIST;
	private List<Photo> RECIPE_PHOTO;
	private List<Good_division> DIVISION_LIST;
	
	private Recipe RECIPE;
	private Recipe recipe=new Recipe();
	private int recipeNum;
	private int division;
	
	private static File[] file=new File[100];
	private  String method;
	

	private static int index=0;
    private static String[] fileFileName=new String[100];
    private String[] fileContentType;
    private ServletContext servletContext;
    private InputStream resultStream;
	

	public RecipeService(IRecipeDAO recipeDAO, IGoodDAO goodDAO,
			IPhotoDAO photoDAO, IGoodDivisionDAO goodDivisionDAO) {
		super();
		this.recipeDAO = recipeDAO;
		this.goodDAO = goodDAO;
		this.photoDAO = photoDAO;
		this.goodDivisionDAO = goodDivisionDAO;
	}

	public String viewRecipeList() throws Exception{
		System.out.println("RECIPE_LIST");
		RECIPE_LIST= recipeDAO.selectRecipeList();
		return "success";
	}
	
	// �����Ǳ��� ����Ʈ
	public String recipeRelativeGoodList() throws Exception{
		RECIPE_DIVISION_LIST= recipeDAO.selectDivisionRecipeList(division);
		return "success";
	}
	
	//����������
	public String viewRecipe() throws Exception{
		RECIPE=recipeDAO.selectRecipe(recipeNum);
//		�����ǰ��� ��ǰ���� ��ȸ
		RECIPE_GOODLIST=goodDAO.selectRecipeList(recipeNum);
//		�����ǰ��� �̹��� ��ȸ
		RECIPE_PHOTO=photoDAO.selectRecipePhotoList(recipeNum);
		return "success";
	}

	//�������߰�(�̱���)
	public String addRecipe() throws Exception {
		if(!"complete".equals(method)){
			return "success";
		}else{
		Good_division good_division = new Good_division();
		good_division.setDivision(division);
		recipe.setGood_division(good_division);
		String forderName="";
	
		for (int i = 0; i < file.length; i++) {
			System.out.println(i);
			//�ӽ������� ���ϸ�/���
			String tempFileName=file[i].getAbsolutePath();
			File tempFile= new File(tempFileName);
			//gphoto������ ��¥ ��� ����
			
			if(division==1){
				forderName="cookie";
			}else if(division==2){
				forderName="cake";
			}else if(division==3){
				forderName="chocolete";
			}
			
			String gphotoRealPath="c://devlopement/workspace/baking/WebContent/img/recipe_"+forderName;
			System.out.println(gphotoRealPath);
			//�����ϰ��ϴ� ������ ���,�̸�
			//gphoto��¥ ���+������ ��¥�̸�
			String saveFileName=gphotoRealPath+"/"+fileFileName[i];
			File saveFile= new File(saveFileName);
			//�����ϰ����ϴ� ���ϰ� ���� �̸��� ������ ������ ��ȣ�� �ٿ��� ���� 
			saveFile=FileRenamePolicy.rename(saveFile);
		
			//tempFile�� saveFile�� ����
			FileUtils.copyFile(tempFile,saveFile);
			
			//tempFile�� �����ϸ� ����
			tempFile.deleteOnExit();
			
		}
		
		resultStream=new ByteArrayInputStream("��ϿϷ�".getBytes("UTF-8"));
		index=0;
		this.file=new File[100];
		}
		return "success";
	}

	//�������߰���
	public String addRecipeForm() throws Exception {
			DIVISION_LIST = goodDivisionDAO.selectGooddivisionList();
			return "success";	
			
	}
	

	//�����Ǽ���(�̱���)
	public String editRecipe() throws Exception {			
			recipeDAO.updateRecipe(recipe);
			return "success";
	}

	//�����Ǽ�����
	public String editRecipeForm() throws Exception {
		DIVISION_LIST = goodDivisionDAO.selectGooddivisionList();
		return "success";
	}

	//�����ǻ���
	public String removeRecipe() throws Exception {
		recipeDAO.deleteRecipe(recipeNum);
		return "success";
	}
	
	@Override
	public Object getModel() {
		return recipe;
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext=context;
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

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file[index]= file[0];
		index++;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName[index] = fileFileName[0];
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public InputStream getResultStream() {
		return resultStream;
	}

	public void setResultStream(InputStream resultStream) {
		this.resultStream = resultStream;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}
	
	public  String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	// ��ü������ ����Ʈ 
		public static int getIndex() {
			return index;
		}

		public static void setIndex(int index) {
			RecipeService.index = index;
		}
	
}
