package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.board.QaService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class QaServiceTestEdit {

	@Test
	public void test() throws ServletException, IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("qaContent","�����մϴ� ��");
		request.addParameter("email","kiki@nate.com");//���� �Ұ�
		request.addParameter("boardNo","5");//���� �Ұ�
		request.addParameter("qaNo","21");
				
		//request.addParameter("pw","1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		//MockHttpSession session=new MockHttpSession();
		//request.setSession(session);
		
		QaService service=new QaService();
		service.editQa(request, response);
	}

}
