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
		request.addParameter("boardTitle","오래된 사전입니다");
		request.addParameter("boardWant","여성잡지 원합니다");
		request.addParameter("boardPhoto","v.jpg");
		request.addParameter("boardContent","달달 외워서 필요가 없네요 이제.");
		request.addParameter("email","kiki@nate.com");//수정 불가
		request.addParameter("categoryNo","1");
		request.addParameter("dealNo","0");
		request.addParameter("conditionResult","1");//관리자만 수정 가능
		request.addParameter("boardNo","41");//수정 불가
				
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
