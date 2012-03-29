package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.member.BlockService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class BlockServiceTestremove {

	@Test
	public void test() throws IOException, ServletException  {
		MockHttpServletRequest request=new MockHttpServletRequest();
		
		request.addParameter("blockno", "1");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		
		MockHttpSession session=new MockHttpSession();
		request.setSession(session);
		
		BlockService service=new BlockService();
		service.removeBlock(request, response);
		System.out.println(service);
	
	}

}
