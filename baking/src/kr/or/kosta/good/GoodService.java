package kr.or.kosta.good;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import kr.or.kosta.file.receive.FileRenamePolicy;
import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.gooddivision.IGoodDivisionDAO;
import kr.or.kosta.photo.IPhotoDAO;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;
import kr.or.kosta.recipe.IRecipeDAO;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.recipe.RecipeDAO;

import com.opensymphony.xwork2.ModelDriven;

public class GoodService implements ModelDriven,ServletContextAware{
	private IGoodDAO goodDAO;
	private IRecipeDAO recipeDAO;
	private IGoodDivisionDAO goodDivisionDAO;
	private IPhotoDAO	photoDAO;
	
	private static final long serialVersionUID = 1L;
    private int goodNum;
    private List<Good> GOOD_LIST;
    private List<Recipe> GOOD_RECIPELIST;
    private List<Photo> PHOTO_LIST;
    private Good GOOD;
    private Good good=new Good();
    private List<Good_division> DIVISION_LIST;
	private int division;
	
	private File[] file;
	private String[] fileFileName;
	private String[] fileContentType;
	private ServletContext servletContext;
	private InputStream resultStream;
	
	
	
	public GoodService(IGoodDAO goodDAO, IRecipeDAO recipeDAO,
			IGoodDivisionDAO goodDivisionDAO, IPhotoDAO photoDAO) {
		super();
		this.goodDAO = goodDAO;
		this.recipeDAO = recipeDAO;
		this.goodDivisionDAO = goodDivisionDAO;
		this.photoDAO = photoDAO;
	}


	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}
	
	
    public File[] getFile() {
		return file;
	}


	public void setFile(File[] file) {
		this.file = file;
	}


	public String[] getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
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


	@Override
	public Object getModel() {
		return good;
	}

	public List<Good_division> getDIVISION_LIST() {
		return DIVISION_LIST;
	}

	public void setDIVISION_LIST(List<Good_division> dIVISION_LIST) {
		DIVISION_LIST = dIVISION_LIST;
	}



	public int getDivision() {
		System.out.println("get");
		return division;
	}



	public void setDivision(int division) {
		this.division = division;
		System.out.println("set");
	}



	public List<Recipe> getGOOD_RECIPELIST() {
		return GOOD_RECIPELIST;
	}


	public void setGOOD_RECIPELIST(List<Recipe> gOOD_RECIPELIST) {
		GOOD_RECIPELIST = gOOD_RECIPELIST;
	}


	public List<Photo> getPHOTO_LIST() {
		return PHOTO_LIST;
	}


	public void setPHOTO_LIST(List<Photo> pHOTO_LIST) {
		PHOTO_LIST = pHOTO_LIST;
	}


	public Good getGOOD() {
		return GOOD;
	}


	public void setGOOD(Good gOOD) {
		GOOD = gOOD;
	}


	public List<Good> getGOOD_LIST() {
		return GOOD_LIST;
	}


	public void setGOOD_LIST(List<Good> gOOD_LIST) {
		GOOD_LIST = gOOD_LIST;
	}


	public Good getGood() {
		return good;
	}


	public void setGood(Good good) {
		this.good = good;
	}


	public int getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	/**
     * @see HttpServlet#HttpServlet()
     */
    public GoodService() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * 홈화면.viewGoodList와 동일한 기능. jsp만 다름
	 */
	public String viewIndex() throws Exception {
		GOOD_LIST= goodDAO.selectGoodList();
		return "success";
	}

	/**
	 * 상품리스트보기
	 */
	public String viewGoodList() throws Exception {
		GOOD_LIST = goodDAO.selectGoodList();
		return "success";
	}

	/**
	 * 상품정보보기
	 */
	public String viewGood() throws Exception {
		//데이터 베이스에서 상품정보 조회
		System.out.println(goodNum);
		GOOD = goodDAO.selectGood(goodNum);
		//상품 관련 레시피 조회
		GOOD_RECIPELIST = recipeDAO.selectGoodRelationRecipeList(goodNum);
		PHOTO_LIST = photoDAO.selectGoodPhotoList(goodNum);
		return "success";
	}

	/**
	 * 상품추가
	 */
	public String addGood() throws Exception {
		System.out.println(file);
		if(file!=null){
			//임시파일의 경로와 파일명
			String tempFileName=file[0].getAbsolutePath();
			//임시파일의 정보를 가지고있는 파일 객체 생성
			File tempFile=new File(tempFileName);
			//gphoto폴더의 진짜 경로 리턴
			String gphotoRealPath = servletContext.getRealPath("img");
			//저장하고자 하는 파일의 경로,이름
			//gphoto진짜 경로+파일의 진짜이름
			String divisionName =null;
			if(division==1){
				 divisionName ="cookie";
			}else if(division==2){
				 divisionName ="cake";
			}else{
				 divisionName ="chocolete";
			}
			String saveFileName=
					gphotoRealPath+"/"+divisionName+"/"+fileFileName[0];
			//저장할 파일의 정보를 가지고 있는 객체 생성
			File saveFile=new File(saveFileName);
			//저장하고자하는 파일과 같은 이름의 파일이 있으면
			//번호를 붙여서 리턴
			saveFile=FileRenamePolicy.rename(saveFile);
			//tempFile을 saveFile로 복사
			FileUtils.copyFile(tempFile, saveFile);
			//tempFile이 존재한다면 삭제
			tempFile.deleteOnExit();
			//good에 파일명 설정
			good.setImg(saveFile.getName());
		}
		goodDAO.insertGood(good);
		resultStream=new ByteArrayInputStream("등록완료".getBytes("UTF-8"));
		return "success";
	}

	/**
	 * 상품추가폼
	 */
	public String addGoodForm() throws Exception {
		DIVISION_LIST = goodDivisionDAO.selectGooddivisionList();
		return "success";
	}

	/**
	 * 상품수정
	 */
	public String editGood() throws Exception {
		//3.DB에 저장
		goodDAO.updateGood(good);
		//4. 전체 학생리스트 이동객체 생성
		return "success";
	}

	/**
	 * 상품수정폼
	 */
	public String editGoodForm() throws Exception {
		DIVISION_LIST = goodDivisionDAO.selectGooddivisionList();
		GOOD= goodDAO.selectGood(goodNum);
		return "success";
	}

	/**
	 * 상품삭제
	 */
	public String removeGood() throws Exception {
		goodDAO.deleteGood(goodNum);
		return "success";
	}
	
	/**
	 * 상품구분별 상품리스트 조회
	 */
	public String viewDivisionGoodList() throws Exception {
		GOOD_LIST = goodDAO.viewDivisionGoodList(division);
		return "success";
	}

	
}
