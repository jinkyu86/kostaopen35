package kr.or.kosta.auction.auction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;

public class AuctionService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 */
	public AuctionService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method==null){
			method ="viewAuctionList";
		}
		if("viewAuctionList".equals(method)){
			viewAuctionList(request,response);
		}else if("viewAuction".equals(method)){
			viewAuction(request,response);
		}else if("addAuction".equals(method)){
			addAuction(request,response);
		}else if("addAuctionForm".equals(method)){
			addAuctionForm(request,response);
		}else if("editAuction".equals(method)){
			editAuction(request,response);
		}else if("editAuctionForm".equals(method)){
			editAuctionForm(request,response);
		}else if("removeAuction".equals(method)){
			removeAuction(request,response);
		}
		
	}

	private void addAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		String aNum = request.getParameter("aNum");
		String gNum = request.getParameter("gNum");
		String sPrice = request.getParameter("sPrice");
		String imPrice = request.getParameter("imPrice");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String sold=request.getParameter("sold");
		String cuPrice = request.getParameter("cuPrice");
	
		Good good = new Good();
		good.setgNum(gNum);
		
		Auction auction = new Auction();
		auction.setaNum(aNum);	
		auction.setsPrice("10");
		auction.setImPrice(imPrice);
		auction.setsTime(sTime);
		auction.seteTime(eTime);
		auction.setSold(Integer.parseInt(sold));
		auction.setCuPrice("10");
		auction.setGood(good);
		
		AuctionDAO.insertAuction(auction);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);
	}
	
	private void addAuctionForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		// 1.��ü ��ǰ ����Ʈ ��ȸ
		ArrayList<Good>goodList=
				GoodDAO.selectGoodList();
		//2.request�� ����
		request.setAttribute("GOOD_LIST",goodList);
		
		String gNum = request.getParameter("gNum");
		Good good = GoodDAO.selectGood(gNum);
		request.setAttribute("GOOD", good);
		
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/auction/addAuction.jsp");
		//4.������ �̵�
		rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.�Ķ�������� ����
		String aNum = request.getParameter("aNum");
		String gNum = request.getParameter("gNum");
		String sPrice = request.getParameter("sPrice");
		String imPrice = request.getParameter("imPrice");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String sold=request.getParameter("sold");
		String cuPrice = request.getParameter("cuPrice");
		
		//2.1�� ������ �̿��ؼ� Auction��ü ����
		Good good = new Good();
		good.setgNum(gNum);
		
		Auction auction = new Auction();
		
		auction.setaNum(aNum);
		auction.setsPrice(sPrice);
		auction.setImPrice(imPrice);
		auction.setsTime(sTime);
		auction.seteTime(eTime);
		auction.setSold(Integer.parseInt(sold));
		auction.setCuPrice(cuPrice);
		auction.setGood(good);
		
		
		//Department department=new Department();
		//department.setDeptno(deptno);
		
		//student.setDepartment(department);
		//3.��������� �����ϴ� �޼��� ȣ��
		AuctionDAO.updateAuction(auction);
		//4.������� ��ȸȭ������ �̵� ��ü ����
		//RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/AuctionService?method=viewAuction&aNum="+aNum);
		rd.forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 */
	private void editAuctionForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.������ ����� ��� ��ȣ ����
				String aNum = request.getParameter("aNum");
				//2.������ �л��� ���� ��ȸ
				Auction  auction = AuctionDAO.selectAuction(aNum);
				//3.��ü ��ǰ ����Ʈ ��ȸ
				ArrayList<Good> goodList=
						GoodDAO.selectGoodList();
				//4.request�� ����
				request.setAttribute("AUCTION", auction);
				request.setAttribute("GOOD_LIST",
						goodList);
				//5./student/editStudent.jsp�̵� ��ü ����
				RequestDispatcher  rd=
						request.getRequestDispatcher("/auction/editAuction.jsp");
				rd.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.a_num �Ķ���� ���Ϲ޾Ƽ� ������ ����
				String aNum=request.getParameter("aNum");
				//2.DB���� ��Ź�ȣ�� ��ġ�ϴ� ��� ��ȸ
				Auction auction = AuctionDAO.selectAuction(aNum);
				//3.request�� 2���� ��ȸ�� ����� ���� ����
				//   �̸�-STUDENT
				request.setAttribute("AUCTION",auction);
				//4./auction/viewAuction.jsp�� �̵� ��ü ����
				RequestDispatcher rd=
						request.getRequestDispatcher("/auction/viewAuction.jsp");
				//5.4�� JSP�� �̵�	
				rd.forward(request, response);
	}

	private void viewAuctionList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.AuctionDAO���� ��ü �����ȸ �޼��� ȣ��
		ArrayList<Auction> auctionList=AuctionDAO.selectAuctionList();
		ArrayList<Auction> soldList=AuctionDAO.selectSoldList();
		//2.request�� 1�� ��ü ��� ���� ����
		request.setAttribute("AUCTION_LIST", auctionList);
		request.setAttribute("SOLD_LIST", soldList);
		//3. /auction/viewAuctionList.jsp�� �������̵�
		RequestDispatcher rd=request.getRequestDispatcher("/auction/viewAuctionList.jsp");
		//4.JSP�� ������ �̵�
		rd.forward(request, response);
	}

	private void removeAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		String aNum=request.getParameter("aNum");
		AuctionDAO.deleteAuction(aNum);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/AuctionService?method=viewAuctionList");
		rd.forward(request, response);
///AuctionService?method=viewAuctionList
	}
}
