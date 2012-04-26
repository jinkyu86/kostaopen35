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
	 * Ȩȭ��.viewGoodList�� ������ ���. jsp�� �ٸ�
	 */
	public String viewIndex() throws Exception {
		GOOD_LIST= goodDAO.selectGoodList();
		return "success";
	}

	/**
	 * ��ǰ����Ʈ����
	 */
	public String viewGoodList() throws Exception {
		GOOD_LIST = goodDAO.selectGoodList();
		return "success";
	}

	/**
	 * ��ǰ��������
	 */
	public String viewGood() throws Exception {
		//������ ���̽����� ��ǰ���� ��ȸ
		System.out.println(goodNum);
		GOOD = goodDAO.selectGood(goodNum);
		//��ǰ ���� ������ ��ȸ
		GOOD_RECIPELIST = recipeDAO.selectGoodRelationRecipeList(goodNum);
		PHOTO_LIST = photoDAO.selectGoodPhotoList(goodNum);
		return "success";
	}

	/**
	 * ��ǰ�߰�
	 */
	public String addGood() throws Exception {
		System.out.println(file);
		if(file!=null){
			//�ӽ������� ��ο� ���ϸ�
			String tempFileName=file[0].getAbsolutePath();
			//�ӽ������� ������ �������ִ� ���� ��ü ����
			File tempFile=new File(tempFileName);
			//gphoto������ ��¥ ��� ����
			String gphotoRealPath = servletContext.getRealPath("img");
			//�����ϰ��� �ϴ� ������ ���,�̸�
			//gphoto��¥ ���+������ ��¥�̸�
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
			//������ ������ ������ ������ �ִ� ��ü ����
			File saveFile=new File(saveFileName);
			//�����ϰ����ϴ� ���ϰ� ���� �̸��� ������ ������
			//��ȣ�� �ٿ��� ����
			saveFile=FileRenamePolicy.rename(saveFile);
			//tempFile�� saveFile�� ����
			FileUtils.copyFile(tempFile, saveFile);
			//tempFile�� �����Ѵٸ� ����
			tempFile.deleteOnExit();
			//good�� ���ϸ� ����
			good.setImg(saveFile.getName());
		}
		goodDAO.insertGood(good);
		resultStream=new ByteArrayInputStream("��ϿϷ�".getBytes("UTF-8"));
		return "success";
	}

	/**
	 * ��ǰ�߰���
	 */
	public String addGoodForm() throws Exception {
		DIVISION_LIST = goodDivisionDAO.selectGooddivisionList();
		return "success";
	}

	/**
	 * ��ǰ����
	 */
	public String editGood() throws Exception {
		//3.DB�� ����
		goodDAO.updateGood(good);
		//4. ��ü �л�����Ʈ �̵���ü ����
		return "success";
	}

	/**
	 * ��ǰ������
	 */
	public String editGoodForm() throws Exception {
		DIVISION_LIST = goodDivisionDAO.selectGooddivisionList();
		GOOD= goodDAO.selectGood(goodNum);
		return "success";
	}

	/**
	 * ��ǰ����
	 */
	public String removeGood() throws Exception {
		goodDAO.deleteGood(goodNum);
		return "success";
	}
	
	/**
	 * ��ǰ���к� ��ǰ����Ʈ ��ȸ
	 */
	public String viewDivisionGoodList() throws Exception {
		GOOD_LIST = goodDAO.viewDivisionGoodList(division);
		return "success";
	}

	
}
