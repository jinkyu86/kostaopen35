package kr.or.kosta.moviesystem.buy;

import java.io.IOException;
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

import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.good.GoodDAO;
import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.member.MemberDAO;
import kr.or.kosta.moviesystem.aop.IService;
import kr.or.kosta.moviesystem.buy.Buy;
import kr.or.kosta.moviesystem.buy.BuyDAO;
import kr.or.kosta.moviesystem.util.PageUtil;



public class BuyService implements ModelDriven, ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware, IService{
	private static final long serialVersionUID = 1L;
	private IBuyDAO buyDAO;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;
	
	private int page;
	private String PAGE_LINK_TAG;
	private List<Buy>BUY_LIST;
	private int buynum;
	private Buy BUY;
	private Buy buy=new Buy();
	private String[] chkbox;
	private int maxPage;	
	
	
    public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public BuyService() {
        super();
    }
	
    public BuyService(IBuyDAO buyDAO) {
    	super();
    	System.out.println("BuyService(BuyDAO)");
    	this.buyDAO = buyDAO;
    }


	@Override
	public Object getModel() {
		return buy;
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

	@Override
	public Map getSession() {
		return session;
	}
	
	public int getPage() {
		return page;
	}

	public String[] getChkbox() {
		return chkbox;
	}

	public void setChkbox(String[] chkbox) {
		this.chkbox = chkbox;
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

	public List<Buy> getBUY_LIST() {
		return BUY_LIST;
	}

	public void setBUY_LIST(List<Buy> bUY_LIST) {
		BUY_LIST = bUY_LIST;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	public Buy getBUY() {
		return BUY;
	}

	public void setBUY(Buy bUY) {
		BUY = bUY;
	}

	public Buy getBuy() {
		return buy;
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}

	/**
	 * 상품을 구매하는 기능
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String addBuy() throws Exception {

		Member member=(Member)session.get("LOGIN_MEMBER");
//		
//		if(member==null){
//			return "login";
//		}
		List<Buy>cartList=(List)session.get("CART_LIST");
				
		for(int i=0;i<cartList.size();i++){
			Buy buy=cartList.get(i);
			buy.setMember(member);
			buy.setTotalPrice(buy.getQty()*buy.getGood().getGprice());
			buyDAO.insertBuy(buy);
		}
		session.remove("CART_LIST");
		return "success";
	}
	
	/**
	 * 전체 구매 목록
	 * 
	 * @param request
	 * @param response
	 */
	public String viewBuyList()throws Exception{
 
		if(page==0){
			page=1;
		}
		int length=10;
		
		Member member=(Member)session.get("LOGIN_MEMBER");
		String userid=member.getUserid();
		
		BUY_LIST=buyDAO.selectBuyList(userid,length, page);
		int buyCount=buyDAO.selectBuyCountByUerid(userid);
		maxPage=(buyCount/length);
		if(buyCount%length!=0){
			maxPage++;
		}
		PAGE_LINK_TAG=PageUtil.generate(page, buyCount, length, 
				"/moviesystem/viewBuyList.action?userid="+userid);
		return "success";
		
	}
	
	//일주일 전까지 구매한 물품만 취소가능합니다. 
	//일주일 전 구입한 물품리스트만 cancelable buyList보내줌.
	public String cancelBuyListForm() throws Exception{
		if(page==0){
			page=1;
		}
		int length=10;
		
		Member member=(Member)session.get("LOGIN_MEMBER");
		String userid=member.getUserid();
		
		BUY_LIST=buyDAO.selectCancelableBuyList(userid,length, page);
		int buyCount=buyDAO.selectCancelableBuyListCount(userid);
		maxPage=(buyCount/length);
		if(buyCount%length!=0){
			maxPage++;
		}
		PAGE_LINK_TAG=PageUtil.generate(page, buyCount, length, 
				"/moviesystem/cancelBuyListForm.action?userid="+userid);
		return "success";
	}
	
	//체크리스트에서 선택한 물품을 삭제(pay_state를 1로 set)합니다.
	public String cancelBuy()throws Exception {
		if(chkbox!=null){
			for(int i=0;i<chkbox.length;i++){
				buyDAO.cancelBuy(chkbox[i]);
			}
		}
		return "success";
	}
	
	//취소처리된 물품들이 출력됩니다. 이 부분만 취소날짜가 나옵니다.
	public String viewCanceledBuyList() throws Exception{
		if(page==0){
			page=1;
		}
		int length=10;
		
		Member member=(Member)session.get("LOGIN_MEMBER");
		String userid=member.getUserid();
		
		BUY_LIST=buyDAO.selectCanceledBuyList(userid,length, page);
		int buyCount=buyDAO.selectCanceledBuyListCount(userid);
		maxPage=(buyCount/length);
		if(buyCount%length!=0){
			maxPage++;
		}
		PAGE_LINK_TAG=PageUtil.generate(page, buyCount, length, 
				"/moviesystem/viewCanceledBuyList.action?userid="+userid);

		return "success";		
	}

	/**
	 * 결제 완료 화면 폼으로 이동
	 * 
	 * @param request
	 * @param response
	 */
	public String completeBuy()throws Exception {
		return "success";	
	}


	
}
