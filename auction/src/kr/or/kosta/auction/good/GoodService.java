package kr.or.kosta.auction.good;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ModelDriven;

/**
 * Servlet implementation class GoodService
 */
public class GoodService implements ModelDriven {
	private static final long serialVersionUID = 1L;
	private Good good = new Good();
	private List<Good> GOOD_LIST;
	private String gNum;
	private Good GOOD;

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	@Override
	public Object getModel() {
		return null;
	}

	public Good getGOOD() {
		return GOOD;
	}

	public void setGOOD(Good gOOD) {
		GOOD = gOOD;
	}

	public String getGnum() {
		return gNum;
	}

	public void setGnum(String gNum) {
		this.gNum = gNum;
	}

	public String getgNum() {
		return gNum;
	}

	public void setgNum(String gNum) {
		this.gNum = gNum;
	}

	public List<Good> getGOOD_LIST() {
		return GOOD_LIST;
	}

	public void setGOOD_LIST(List<Good> gOOD_LIST) {
		GOOD_LIST = gOOD_LIST;
	}

	public GoodService() {
		super();
	}

	public String addGood() throws Exception {
		gNum = GoodDAO.insertGood(good);
		return "success";
	}

	public String addGoodForm() throws Exception {
		return "success";
	}

	public String editGood() throws Exception {

		GoodDAO.updateGood(good);
		return "success";

	}

	public String editGoodForm() throws Exception {

		GOOD = GoodDAO.selectGood(gNum);
		return "success";

	}

	public String viewGood() throws Exception {
		GOOD = GoodDAO.selectGood(gNum);
		return "success";
	}

	public String viewGoodList() throws Exception {
		GOOD_LIST = GoodDAO.selectGoodList();
		return "success";
	}

	public String removeGood() throws Exception {
		GoodDAO.deleteGood(gNum);
		return "success";

	}

}
