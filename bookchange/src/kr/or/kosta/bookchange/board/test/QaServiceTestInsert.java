package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardService;
import kr.or.kosta.bookchange.board.QaService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class QaServiceTestInsert {

	@Test
	public void test() {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("qaContent","이거 구입한지 얼마나 됐어요?");
		request.addParameter("email","kiki@nate.com");
		request.addParameter("boardNo","5");
				
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		QaService service=new QaService();
		service.addQa(request, response);
	}

}
