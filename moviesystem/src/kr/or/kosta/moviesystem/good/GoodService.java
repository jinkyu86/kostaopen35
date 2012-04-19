package kr.or.kosta.moviesystem.good;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.moviesystem.buy.Buy;
import kr.or.kosta.moviesystem.buy.BuyDAO;
import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.good.GoodDAO;
import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.util.PageUtil;

public class GoodService implements ModelDriven, ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware{
	private static final long serialVersionUID = 1L;
	
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;
	
	private int page;
	private List<Good>GOOD_LIST;
	private String PAGE_LINK_TAG;
	private Good GOOD;
	private String gnum;
	private List<Buy>CART_LIST;
	private String qty;
	private String keyword;
	private int index;
	
	private Good good=new Good();
	
	@Override
	public Object getModel() {
		return good;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;		
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext=context;
		
	}

	public GoodService() {
        super();
    }
	
    public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public List<Buy> getCART_LIST() {
		return CART_LIST;
	}
	public void setCART_LIST(List<Buy> cART_LIST) {
		CART_LIST = cART_LIST;
	}
	public Good getGOOD() {
		return GOOD;
	}
	public void setGOOD(Good gOOD) {
		GOOD = gOOD;
	}
	public String getGnum() {
		return gnum;
	}
	public void setGnum(String gnum) {
		this.gnum = gnum;
	}
	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Good> getGOOD_LIST() {
		return GOOD_LIST;
	}

	public void setGOOD_LIST(List<Good> gOOD_LIST) {
		GOOD_LIST = gOOD_LIST;
	}

	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}

	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}
	
	/**
	 * 전체 상품 목록 리스트
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String viewGoodList() throws Exception {
		if(page==0){
			page=1;
		}
		int length=8;
		
		GOOD_LIST=GoodDAO.selectGoodList(length,page);
		int goodCount=GoodDAO.selectGoodListCount();	
		PAGE_LINK_TAG=PageUtil.generate(page, goodCount, length,
				"/moviesystem/viewGoodList.action");
		return "success";
	}
	
	/**
	 * 선택한 상품이 보여지는 기능
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String viewGood() throws Exception {
		GOOD=GoodDAO.selectGood(gnum);
		return "success";
	}
	
	public String viewCartList() throws Exception{
		return "success";
	}
	
	public String addCartList() throws Exception{

		GOOD=GoodDAO.selectGood(gnum);

		Buy buy=new Buy();
		buy.setGood(GOOD);
		buy.setQty(Long.parseLong(qty));

		List<Buy>cartList=null;
		int putedBuyIndex=-1;
		
		if(session.get("CART_LIST")==null){
			cartList=new ArrayList<Buy>();
			session.put("CART_LIST", cartList);
		}
		else{
			cartList=(List<Buy>)session.get("CART_LIST");
			
			for(int i=0;i<cartList.size();i++){
				Buy putedBuy=cartList.get(i);
				if(putedBuy.getGood().getGnum().equals(gnum)){
					putedBuyIndex=i;
					break;
				}
			}
		}
		if(putedBuyIndex==-1){
			cartList.add(buy);
		}
		else{
			Buy putedBuy=cartList.get(putedBuyIndex);
			putedBuy.setQty(putedBuy.getQty()+Long.parseLong(qty));
			cartList.set(putedBuyIndex, putedBuy);
		}
		session.put("CART_LIST", cartList);
		return "success";
	}
	
	public String editCartList()throws Exception {
		Map map = request.getParameterMap();
		
		Iterator<String> keys= map.keySet().iterator();
		String qty = null;
		
		while(keys.hasNext()){
			String str = keys.next();
			if(str.indexOf("qty") > -1)
				qty=request.getParameter(str);
		}
		List<Buy>cartList=(List<Buy>)session.get("CART_LIST");
		Buy buy=cartList.get(index);
		buy.setQty(Long.parseLong(qty));
		cartList.set(index, buy);
		session.put("CART_LIST", cartList);
		return "success";
	}

	public String removeCartList() throws Exception{
		List<Buy>cartList=(List<Buy>)session.get("CART_LIST");
		Buy buy=cartList.get(index);
		cartList.remove(index);
		return "success";
	}
	
	public String searchGoodList() throws Exception {
		
		if(page==0){
			page=1;
		}
		int length=8;
		int goodCount=0;
	
		if(keyword==null||keyword.equals("")){
			GOOD_LIST=GoodDAO.selectGoodList(length, page);
			goodCount=GoodDAO.selectGoodListCount();
		}
		else{
			GOOD_LIST=GoodDAO.selectGoodListByName(length, page, keyword);
			goodCount=GoodDAO.selectGoodListByNameCount(keyword);
		}

		PAGE_LINK_TAG=PageUtil.generate(page, goodCount, length, 
				"/moviesystem/searchGoodList.action?keyword="+keyword);
		return "success";

	}
	
	public String viewManageGoodList() throws Exception {
		if(page==0){
			page=1;
		}
		int length=8;
		
		GOOD_LIST=GoodDAO.selectGoodList(length,page);
		int goodCount=GoodDAO.selectGoodListCount();
		
		PAGE_LINK_TAG=PageUtil.generate(page, goodCount, length, 
				"/moviesystem/viewManageGoodList.action");
		
		return "success";
	}
		
		/**
		 * 상품 등록 폼
		 * 
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws ServletException 
		 */
		public String addGoodForm() throws Exception {
			return "success";
		}
	
		/**
		 * 상품 등록
		 * 
		 * @param request
		 * @param response
		 */
		public String addGood() throws Exception{
			gnum=GoodDAO.insertGood(good);
			return "success";
		}
		
		public String deleteGood()throws Exception{
			
			GoodDAO.deleteGood(gnum);
			return "success";
		}
		
		public String editGoodForm()throws Exception {
			
			GOOD=GoodDAO.selectGood(gnum);
			return "success";	
		}

	public String editGood()throws Exception  {
		GoodDAO.editGood(good);
		return "success";	
	}

}
