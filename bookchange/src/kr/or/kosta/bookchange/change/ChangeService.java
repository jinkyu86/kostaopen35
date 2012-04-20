package kr.or.kosta.bookchange.change;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.PageUtil;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

public class ChangeService implements ModelDriven,ServletContextAware,
ServletRequestAware,ServletResponseAware,SessionAware {
	
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;
	
	private Change change=new Change();
	private Member member;
	private List<Change>AGREE_CHANGE_LIST;
	private List<Change>DEMAND_CHANGE_LIST;
	private List<Change>MATCH_LIST;
	
	private int page;
	private String email;
	private String PAGE_LINK_TAG;
	private String demandBoardNo;
	private String ChangeNo;
	private String BoardNo;
	private String result;
	
	public Object getModel() {
		return change;
	}
	/**========================= Method=============================== **/	
	public String acceptChangeList() throws Exception{
		int length=10;
		if(page==0){
			page=1;
		}
		member=(Member)session.get("LOGIN_EMAIL");
		email=member.getEmail();
		AGREE_CHANGE_LIST=ChangeDAO.selectChangeMyboardList(length, page, email);
		int agreeChangeCount=ChangeDAO.selectChangeMyboardCount(email);
		PAGE_LINK_TAG=PageUtil.generate(page, agreeChangeCount, length, 
				"/bookchange/acceptChangeList.action");
		return "success";
	}

	public String requestChangeList() throws Exception{
		int length=10;
		if(page==0){
			page=1;
		}
		member=(Member)session.get("LOGIN_EMAIL");
		email=member.getEmail();
		DEMAND_CHANGE_LIST=ChangeDAO.selectChangeRequestList(length, page, email);
		int demandChangeCount=ChangeDAO.selectChangeRequestCount(email);
		PAGE_LINK_TAG=PageUtil.generate(page, demandChangeCount, length, 
				"/bookchange/requestChangeList.action");
		return "success";
	}
	
	public String matchChangeList() throws Exception{
		int length=10;
		if(page==0){
			page=1;
		}
		member=(Member)session.get("LOGIN_EMAIL");
		email=member.getEmail();
		MATCH_LIST=ChangeDAO.selectMatchList(length, page, email);
		int demandChangeCount=ChangeDAO.selectChangeRequestCount(email);
		PAGE_LINK_TAG=PageUtil.generate(page, demandChangeCount, length, 
				"/bookchange/matchChangeList.action");
		return "success";
	}
	
	public String matchChangeResultList() throws Exception{
		int length=10;
		if(page==0){
			page=1;
		}
		member=(Member)session.get("LOGIN_EMAIL");
		email=member.getEmail();	
		MATCH_LIST=ChangeDAO.selectMatchResultList(length, page, email);
		int matchChangeCount=ChangeDAO.selectChangeRequestCount(email);
		PAGE_LINK_TAG=PageUtil.generate(page, matchChangeCount, length, 
				"/bookchange/matchChangeList.action");
		return "success";
	}

	public String addChange() throws Exception {
		ChangeDAO.insertChange(change);
		request.setAttribute("ERROR","교환 신청되었습니다.");
		return "success";
	}
	
	public String cancelChange() throws Exception{
		demandBoardNo=request.getParameter("demandBoardNo");
		ChangeDAO.cancelChange(Integer.parseInt(demandBoardNo));
		request.setAttribute("ERROR","교환요청이 취소되었습니다.");
		return "success";
	}
	
	public String matchChange() throws Exception {
		result=request.getParameter("conditionResult");
		
		if(result.equals("2") || result.equals("3")){
			request.setAttribute("ERROR","이미 다른 분과 교환중이므로 교환할 수 없습니다 :)");
			return "fail";
		}else{		
		ChangeDAO.matchChange(change);
		request.setAttribute("ERROR","교환신청을 수락하셨습니다.");
		return "success";
		}
	}
	
	public String completeChange() throws Exception {
			ChangeDAO.completeChange(Integer.parseInt(ChangeNo), Integer.parseInt(BoardNo));
			request.setAttribute("ERROR", "교환이 완료되었습니다.");
			return "success";
	}

	/**=========================Getter&Setter=============================== **/	
	public String getChangeNo() {
		return ChangeNo;
	}

	public void setChangeNo(String changeNo) {
		ChangeNo = changeNo;
	}

	public String getBoardNo() {
		return BoardNo;
	}

	public void setBoardNo(String boardNo) {
		BoardNo = boardNo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDemandBoardNo() {
		return demandBoardNo;
	}

	public void setDemandBoardNo(String demandBoardNo) {
		this.demandBoardNo = demandBoardNo;
	}

	public List<Change> getMATCH_LIST() {
		return MATCH_LIST;
	}

	public void setMATCH_LIST(List<Change> mATCH_LIST) {
		MATCH_LIST = mATCH_LIST;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Change> getDEMAND_CHANGE_LIST() {
		return DEMAND_CHANGE_LIST;
	}

	public void setDEMAND_CHANGE_LIST(List<Change> dEMAND_CHANGE_LIST) {
		DEMAND_CHANGE_LIST = dEMAND_CHANGE_LIST;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Change getChange() {
		return change;
	}

	public void setChange(Change change) {
		this.change = change;
	}

	public List<Change> getAGREE_CHANGE_LIST() {
		return AGREE_CHANGE_LIST;
	}

	public void setAGREE_CHANGE_LIST(List<Change> aGREE_CHANGE_LIST) {
		AGREE_CHANGE_LIST = aGREE_CHANGE_LIST;
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

	public ChangeService() {
	        super();
	}
	
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public void setServletContext(ServletContext context) {
		this.servletContext=context;
	}
}
