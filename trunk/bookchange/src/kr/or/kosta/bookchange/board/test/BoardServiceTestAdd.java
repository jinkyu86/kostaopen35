package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BoardServiceTestAdd {

	@Test
	public void test() throws ServletException, IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("boardTitle","�����Դϴ�");
		request.addParameter("boardWant","�������� ���ؿ�");
		request.addParameter("boardPhoto","v.jpg");
		request.addParameter("boardContent","���� �Ƴ��� �����Դϴ�. ���̻� �ʿ䰭 ��� �÷���.");
		request.addParameter("email","kiki@nate.com");
		request.addParameter("categoryNo","1");
		request.addParameter("dealNo","0");
				
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		BoardService service=new BoardService();
		service.addBoard(request, response);
		
		Board board=(Board) request.getAttribute("BOARD");
		System.out.println(board);
	}

}
