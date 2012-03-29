package kr.or.kosta.gooddivision.test;

import java.util.ArrayList;

import kr.or.kosta.gooddivision.GoodDivisionDAO;

import org.junit.Test;

public class GoodDivisionDAOTest {

	@Test
	public void testSelectGooddivisionList() {
		GoodDivisionDAO goodDivisionDAO = new GoodDivisionDAO();
		ArrayList gooddivisionList = goodDivisionDAO.selectGooddivisionList();
		System.out.println(gooddivisionList);
	}
}
