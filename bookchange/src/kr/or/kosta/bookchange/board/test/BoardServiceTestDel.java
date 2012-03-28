package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BoardServiceTestDel {

	@Test
	public void test() throws ServletException, IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("boardNo","41");
		request.addParameter("conditionResult","1");		
				
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		BoardService service=new BoardService();
		service.removeBoard(request, response);
		
	}

}
