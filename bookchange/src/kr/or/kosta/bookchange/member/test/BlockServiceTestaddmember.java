package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.member.MemberService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class BlockServiceTestaddmember {

	@Test
	public void test() throws ServletException,IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("email", "hogo@nate.com");
		request.addParameter("tel", "02-123-4531");
		request.addParameter("address", "°æºÏ Ã¢¿ø");
		request.addParameter("pw", "1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		
		MockHttpSession session=new MockHttpSession();
		request.setSession(session);
		
		MemberService service=new MemberService();
		service.addMember(request, response);
	
		System.out.println(request);
		System.out.println(response);
	}

}
