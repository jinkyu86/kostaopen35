package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.member.Block;
import kr.or.kosta.bookchange.member.BlockDAO;
import kr.or.kosta.bookchange.member.BlockService;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberService;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class BlockServiceTestaddblock {

	@Test
	public void test() throws IOException, ServletException {
		MockHttpServletRequest request=new MockHttpServletRequest();
	
		request.addParameter("blockno", "21");
		request.addParameter("blockemail", "gohome@naver.com");
		request.addParameter("registeremail", "minwoo@naver.com");
		
		MockHttpServletResponse response=new MockHttpServletResponse();
		
		MockHttpSession session=new MockHttpSession();
		request.setSession(session);
		
		BlockService service=new BlockService();
		service.addBlock(request, response);
		System.out.println(service);
	
		
	}

}
