package kr.or.kosta.bookchange.member;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class BlockServiceTestsaerch {

	
		@Test
		public void test() throws ServletException,IOException {
			MockHttpServletRequest request=new MockHttpServletRequest();
			request.addParameter("keyword", "1");			
			
			MockHttpServletResponse response=new MockHttpServletResponse();
			
			MockHttpSession session=new MockHttpSession();
			request.setSession(session);
			
			BlockService service=new BlockService();
			service.searchBlockList(request, response);
		
			ArrayList<Block> memberList=(ArrayList<Block>) request.getAttribute("BLOCK_LIST");
			for(int i=0;i<memberList.size();i++){
				Block member=memberList.get(i);
				System.out.println(member);
			}
			//System.out.println(request);
			//System.out.println(response);
		}
	}


