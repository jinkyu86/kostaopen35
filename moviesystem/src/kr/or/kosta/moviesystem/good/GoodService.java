package kr.or.kosta.moviesystem.good;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

import org.apache.commons.io.FileUtils;
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
import kr.or.kosta.moviesystem.movie.FileRenamePolicy;
import kr.or.kosta.moviesystem.util.PageUtil;

public class GoodService implements ModelDriven, ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware{
	private static final long serialVersionUID = 1L;
	private IGoodDAO goodDAO;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;
	
	
	private File[] file;
	private String[] fileFileName;
	private String[] fileContentType;
	private InputStream resultStream;
	
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
	
	
	public GoodService(IGoodDAO goodDAO) {
		super();
		System.out.println("GoodService(GoodDAO)")	;
		this.goodDAO = goodDAO;
	}

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
		
		GOOD_LIST=goodDAO.selectGoodList(length,page);
		int goodCount=goodDAO.selectGoodListCount();	
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
		GOOD=goodDAO.selectGood(gnum);
		return "success";
	}
	
	public String viewCartList() throws Exception{
		return "success";
	}
	
	public String addCartList() throws Exception{

		GOOD=goodDAO.selectGood(gnum);

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
			GOOD_LIST=goodDAO.selectGoodList(length, page);
			goodCount=goodDAO.selectGoodListCount();
		}
		else{
			GOOD_LIST=goodDAO.selectGoodListByName(length, page, keyword);
			goodCount=goodDAO.selectGoodListByNameCount(keyword);
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
		
		GOOD_LIST=goodDAO.selectGoodList(length,page);
		int goodCount=goodDAO.selectGoodListCount();
		
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
			if(file!=null){
				//임시파일의 경로와 파일명
				String tempFileName=file[0].getAbsolutePath();
				//임시파일의 정보를 가지고있는 파일 객체 생성
				File tempFile=new File(tempFileName);
				//gphoto폴더의 진짜 경로 리턴
				String gphotoRealPath=servletContext.getRealPath("gphoto");
				//저장하고자 하는 파일의 경로,이름
				//gphoto진짜 경로+파일의 진짜이름
				String saveFileName=gphotoRealPath+"/"+fileFileName[0];
				//저장할 파일의 정보를 가지고있는 객체 생성
				File saveFile=new File(saveFileName);
				//저장하고자하는 파일과 같은 이름의 파일이 있으면
				//번호를 붙여서 리턴
				saveFile=FileRenamePolicy.rename(saveFile);
				//tempFile을 saveFile으로 복사
				FileUtils.copyFile(tempFile,saveFile);
				//tempFile이 존재한다면 삭제
				tempFile.deleteOnExit();
				//good에 파일 명 설정
				good.setPhoto(saveFile.getName());
				}
			gnum=goodDAO.insertGood(good);
			resultStream=new ByteArrayInputStream(	"등록완료".getBytes("UTF-8"));
			return "success";
		}
		
		public String deleteGood()throws Exception{
			
			goodDAO.deleteGood(gnum);
			return "success";
		}
		
		public String editGoodForm()throws Exception {
			
			GOOD=goodDAO.selectGood(gnum);
			return "success";	
		}

	public String editGood()throws Exception  {
		goodDAO.editGood(good);
		return "success";	
	}

}
