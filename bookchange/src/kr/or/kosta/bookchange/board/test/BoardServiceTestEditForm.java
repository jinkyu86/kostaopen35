package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardService;
import kr.or.kosta.bookchange.board.Category;
import kr.or.kosta.bookchange.board.CategoryDAO;
import kr.or.kosta.bookchange.board.Deal;
import kr.or.kosta.bookchange.board.DealDAO;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BoardServiceTestEditForm {

	@Test
	public void test() throws ServletException, IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("boardNo","2");
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		BoardService service=new BoardService();
		service.editBoardForm(request, response);
		
		Board board=(Board) request.getAttribute("BOARD");
		System.out.println(board);
		
		ArrayList<Category> categoryList=(ArrayList<Category>) request.getAttribute("CATEGORY_LIST");
		for(int i=0;i<categoryList.size();i++){
			Category category=categoryList.get(i);
			System.out.println(category);
		}
			
		ArrayList<Deal> dealList=(ArrayList<Deal>) request.getAttribute("DEAL_LIST");//거래방법 조회
		for(int i=0;i<dealList.size();i++){
			Deal deal=dealList.get(i);
			System.out.println(deal);
		}
	}

}
