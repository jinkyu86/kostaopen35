package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BoardServiceTestUpdate {

	@Test
	public void test() throws ServletException, IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("boardTitle","������ �����Դϴ�");
		request.addParameter("boardWant","�������� ���մϴ�");
		request.addParameter("boardPhoto","v.jpg");
		request.addParameter("boardContent","�޴� �ܿ��� �ʿ䰡 ���׿� ����.");
		request.addParameter("email","kiki@nate.com");//���� �Ұ�
		request.addParameter("categoryNo","1");
		request.addParameter("dealNo","0");
		request.addParameter("conditionResult","1");//�����ڸ� ���� ����
		request.addParameter("boardNo","41");//���� �Ұ�
				
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		BoardService service=new BoardService();
		service.editBoard(request, response);
		
		Board board=(Board) request.getAttribute("BOARD");
		System.out.println(board);
	}

}
