package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.kosta.bookchange.board.BoardDAO;
import kr.or.kosta.bookchange.board.Category;
import kr.or.kosta.bookchange.board.CategoryDAO;
import kr.or.kosta.bookchange.board.Deal;
import kr.or.kosta.bookchange.board.DealDAO;

import org.junit.Test;

public class BoardDAOTestCategoryCount {

	@Test
	public void test() {
		List<Deal> categoryList=DealDAO.selectDeal();
		System.out.println(categoryList);
		}

}
