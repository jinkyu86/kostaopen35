package kr.or.kosta.gooddivision;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodDivisionService {
	private IGoodDivisionDAO goodDivisionDAO;
	
	
	public GoodDivisionService(IGoodDivisionDAO goodDivisionDAO) {
		super();
		this.goodDivisionDAO = goodDivisionDAO;
	}


	/**
	 * 상품목록조회
	 * 
	 * @param request
	 * @param response
	 */
	
	public void viewGoodDivisionList(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;
//		return null;
	}
}
