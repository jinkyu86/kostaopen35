package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.member.MemberService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class BlockServiceTestchackmember {

	@Test
	public void test() throws ServletException,IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("email", "hogo@nate.com");

		
		MockHttpServletResponse response=new MockHttpServletResponse();
		
		MockHttpSession session=new MockHttpSession();
		request.setSession(session);
		
		MemberService service=new MemberService();
		service.checkMemberEmail(request, response);
	
		System.out.println(request);
		System.out.println(response);
	}

}
