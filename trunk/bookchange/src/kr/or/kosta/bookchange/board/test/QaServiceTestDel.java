package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.board.QaService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class QaServiceTestDel {

	@Test
	public void test() throws ServletException, IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("qaNo","21");
		request.addParameter("boardNo", "5");		
				
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		QaService service=new QaService();
		service.removeQa(request, response);
	}

}
