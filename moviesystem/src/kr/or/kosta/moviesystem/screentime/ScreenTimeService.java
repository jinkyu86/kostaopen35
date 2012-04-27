package kr.or.kosta.moviesystem.screentime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ModelDriven;

/**
 * Servlet implementation class ScreenTimeService
 */
public class ScreenTimeService implements ModelDriven {
	private static final long serialVersionUID = 1L;
	private List<ScreenTime> SCREENTIME_LIST ;
	private String mnum;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
  
	
	
    public List<ScreenTime> getSCREENTIME_LIST() {
		return SCREENTIME_LIST;
	}



	public void setSCREENTIME_LIST(List<ScreenTime> sCREENTIME_LIST) {
		SCREENTIME_LIST = sCREENTIME_LIST;
	}



	public String getMnum() {
		return mnum;
	}



	public void setMnum(String mnum) {
		this.mnum = mnum;
	}



	public ScreenTimeService() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    public String viewScreenTimeListBymnum() throws Exception {
    	System.out.println("viewScreenTimeListBymnum���� ");
    	System.out.println("��ȭ�� �����ؼ� �ش� ��ȭ�� �ð��� �����ֱ� ���� ��");
		System.out.println("mnum==== "+mnum+"==");
		SCREENTIME_LIST=ScreenTimeDAO.selectScreen(mnum);
		System.out.println("SCREENTIME_LIST= "+SCREENTIME_LIST);
		System.out.println("viewScreenTimeListBymnum���� ");
		return "success";

	}



}