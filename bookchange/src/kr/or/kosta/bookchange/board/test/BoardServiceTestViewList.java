package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class BoardServiceTestViewList {

	@Test
	public void test() throws ServletException, IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("page","1");
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		BoardService service=new BoardService();
		service.viewBoardList(request, response);
		
		ArrayList<Board> board1List=(ArrayList)request.getAttribute("BOARD_LIST");
		for(int i=0;i<board1List.size();i++){
			Board board=board1List.get(i);
			System.out.println(board);
		}
			
		System.out.println(request);
		System.out.println(response);
		//System.out.println("testLogin:session:%s\n",session);
	}

}
