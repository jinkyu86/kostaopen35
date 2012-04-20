package kr.or.kosta.myrecipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.member.Member;
import kr.or.kosta.util.PageUtil;

import com.opensymphony.xwork2.ModelDriven;

public class MyrecipeService implements ModelDriven{
	private static final long serialVersionUID = 1L;
	private int page; 
	private String PAGE_LINK_TAG;
	private Myrecipe myrecipe;
	
	private List<Myrecipe> MYRECIPE_LIST;
	private Myrecipe MYRECIPE;
	
	@Override
	public Object getModel() {
		return myrecipe;
	}
	
	public Myrecipe getMYRECIPE() {
		return MYRECIPE;
	}

	public void setMYRECIPE(Myrecipe mYRECIPE) {
		MYRECIPE = mYRECIPE;
	}

    public List<Myrecipe> getMYRECIPE_LIST() {
		return MYRECIPE_LIST;
	}

	public void setMYRECIPE_LIST(List<Myrecipe> mYRECIPE_LIST) {
		MYRECIPE_LIST = mYRECIPE_LIST;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}

	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}

	public Myrecipe getMyrecipe() {
		return myrecipe;
	}

	public void setMyrecipe(Myrecipe myrecipe) {
		this.myrecipe = myrecipe;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public MyrecipeService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 레시피목록출력
	 */
	public String viewMyrecipeList() throws Exception {
		//한페이지당 보여줄 학생수
		int length=5;
		if(page==0){
			page=1;
		}
		MYRECIPE_LIST = MyrecipeDAO.selectMyrecipeList(length, page);
		//전체 학생의 수 조회
		int  myrecipeCount=MyrecipeDAO.selectMyrecipeCount();
		//PageUtil.generate(현페이지,
		 //                전체건수,한페이지당보여줄 row 수,주소)
		PAGE_LINK_TAG=PageUtil.generate(page,myrecipeCount, length,"/baking/viewMyrecipeList.action");
		return "success";
	}
	
	/**
	 * 레시피보기
	 */
	public String viewMyrecipe() {
		
		return "success";
	}

	/**
	 * 레시피추가(글작성)
	 */
	public String addMyrecipe() throws Exception {
		//DB에 저장
		MyrecipeDAO.insertMyrecipe(myrecipe);
		return "success";
	}																		

	/**
	 * 글쓰기 폼
	 */
	public String addMyrecipeForm() throws Exception {
		return "success";
	}

	/**
	 * 글수정
	 */
	public void editMyrecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**
	 * 글수정 폼
	 */
	public void editMyrecipeForm(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**
	 * 레시피글 삭제
	 */
	public void removeMyrecipe(HttpServletRequest request,
			HttpServletResponse response) {
		
	}
}