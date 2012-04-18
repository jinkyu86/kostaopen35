package kr.or.kosta.good;

import java.util.List;

import javax.servlet.http.HttpServlet;

import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.recipe.RecipeDAO;

import com.opensymphony.xwork2.ModelDriven;

public class GoodService implements ModelDriven{
	private static final long serialVersionUID = 1L;
    private int goodNum;
    private List<Good> GOOD_LIST;
    private List<Recipe> GOOD_RECIPELIST;
    private List<Photo> PHOTO_LIST;
    private Good GOOD;
    private Good good=new Good();
    private List<Good_division> DIVISION_LIST;
	private int division;
	
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
		return division;
	}



	public void setDivision(int division) {
		this.division = division;
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
		System.out.println("get");
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
		System.out.println("set");
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
		GOOD_LIST= GoodDAO.selectGoodList();
		return "success";
	}

	/**
	 * 상품리스트보기
	 */
	public String viewGoodList() throws Exception {
		GOOD_LIST = GoodDAO.selectGoodList();
		return "success";
	}

	/**
	 * 상품정보보기
	 */
	public String viewGood() throws Exception {
		//데이터 베이스에서 상품정보 조회
		GOOD = GoodDAO.selectGood(goodNum);
		//상품 관련 레시피 조회
		GOOD_RECIPELIST = RecipeDAO.selectGoodRelationRecipeList(goodNum);
		PHOTO_LIST = PhotoDAO.selectGoodPhotoList(goodNum);
		System.out.println("GOOD:"+GOOD);
		System.out.println("GOOD_RECIPELIST:"+GOOD_RECIPELIST);
		System.out.println("PHOTO_LIST:"+PHOTO_LIST);
		return "success";
	}

	/**
	 * 상품추가
	 */
	public String addGood() throws Exception {
		goodNum=GoodDAO.insertGood(good);
		return "success";
	}

	/**
	 * 상품추가폼
	 */
	public String addGoodForm() throws Exception {
		return "success";
	}

	/**
	 * 상품수정
	 */
	public String editGood() throws Exception {
		//3.DB에 저장
		GoodDAO.updateGood(good);
		//4. 전체 학생리스트 이동객체 생성
		return "success";
	}

	/**
	 * 상품수정폼
	 */
	public String editGoodForm() throws Exception {
		DIVISION_LIST = GoodDivisionDAO.selectGooddivisionList();
		GOOD= new GoodDAO().selectGood(goodNum);
		return "success";
	}

	/**
	 * 상품삭제
	 */
	public String removeGood() throws Exception {
		GoodDAO.deleteGood(goodNum);
		return "success";
	}
	
	/**
	 * 상품구분별 상품리스트 조회
	 */
	public String viewDivisionGoodList() throws Exception {
		GOOD_LIST = GoodDAO.viewDivisionGoodList(division);
	/*	List<Good> goodList = GoodDAO.viewDivisionGoodList(division);
		request.setAttribute("viewGoodList", goodList);
		RequestDispatcher rd = request.getRequestDispatcher("/good/viewDivisionGoodList.jsp");
		rd.forward(request, response);*/
		return "success";
	}
}
