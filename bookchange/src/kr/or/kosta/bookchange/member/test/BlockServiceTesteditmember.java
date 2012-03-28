package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.member.MemberService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class BlockServiceTesteditmember {

	@Test
	public void test() throws ServletException,IOException {
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addParameter("email", "hogo@nate.com");
		request.addParameter("tel", "02-123-4444");
		request.addParameter("address", "충청도 청원");
		request.addParameter("pw", "1234");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		
		MockHttpSession session=new MockHttpSession();
		request.setSession(session);
		
		MemberService service=new MemberService();
		service.editMember(request, response);
	
		System.out.println(request);
		System.out.println(response);
	}

}
