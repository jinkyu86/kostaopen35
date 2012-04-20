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
	 * �����Ǹ�����
	 */
	public String viewMyrecipeList() throws Exception {
		//���������� ������ �л���
		int length=5;
		if(page==0){
			page=1;
		}
		MYRECIPE_LIST = MyrecipeDAO.selectMyrecipeList(length, page);
		//��ü �л��� �� ��ȸ
		int  myrecipeCount=MyrecipeDAO.selectMyrecipeCount();
		//PageUtil.generate(��������,
		 //                ��ü�Ǽ�,���������纸���� row ��,�ּ�)
		PAGE_LINK_TAG=PageUtil.generate(page,myrecipeCount, length,"/baking/viewMyrecipeList.action");
		return "success";
	}
	
	/**
	 * �����Ǻ���
	 */
	public String viewMyrecipe() {
		
		return "success";
	}

	/**
	 * �������߰�(���ۼ�)
	 */
	public String addMyrecipe() throws Exception {
		//DB�� ����
		MyrecipeDAO.insertMyrecipe(myrecipe);
		return "success";
	}																		

	/**
	 * �۾��� ��
	 */
	public String addMyrecipeForm() throws Exception {
		return "success";
	}

	/**
	 * �ۼ���
	 */
	public void editMyrecipe(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**
	 * �ۼ��� ��
	 */
	public void editMyrecipeForm(HttpServletRequest request,
			HttpServletResponse response) {
	}

	/**
	 * �����Ǳ� ����
	 */
	public void removeMyrecipe(HttpServletRequest request,
			HttpServletResponse response) {
		
	}
}