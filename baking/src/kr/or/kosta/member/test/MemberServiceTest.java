package kr.or.kosta.member.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.or.kosta.member.MemberService;


import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class MemberServiceTest {

	@Test
	public void testViewMember() throws ServletException, IOException {
		MemberService service=new MemberService();
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		request.addParameter("memberid", "jun123");
		request.addParameter("name", "전인하");
		request.addParameter("reginum", "70102-12345");
		service.viewMember(request, response);
	}

	@Test
	public void testEditMember() throws ServletException, IOException {
		MemberService service=new MemberService();
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		request.addParameter("memberid", "jun123");
		request.addParameter("name", "전인하");
		request.addParameter("regiNumer", "70102-12345");
		request.addParameter("password", "1111");
		request.addParameter("pwHint", "hint");
		request.addParameter("pwAnswer", "answer");
		request.addParameter("zipcode", "333-222");
		request.addParameter("address", "서울시 송파구");
		request.addParameter("strAddress", "52번지");
		request.addParameter("email", "jun123@naver.com");
		request.addParameter("phoneNumber", "010-33-2343");
		request.addParameter("telNumber", "02-343-3333");
		service.editMember(request, response);
	}

	@Test
	public void testEditMemberForm() throws ServletException, IOException {
		MemberService service=new MemberService();
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		request.addParameter("memberid", "thkims");
		request.addParameter("name", "홍길동");
		request.addParameter("reginum", "834243-423333");
		service.editMemberForm(request, response);
	}

	@Test
	public void testRemoveMember() throws ServletException, IOException {
		MemberService service=new MemberService();
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		request.addParameter("memberid", "jun123");
		request.addParameter("pw", "1100");
		request.addParameter("reginum", "70102-12345");
		service.removeMember(request, response);
	}

	@Test
	public void testAddMember() throws ServletException, IOException {
		MemberService service=new MemberService();
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		request.addParameter("memberid", "jun123");
		request.addParameter("name", "전인하");
		request.addParameter("regiNumer", "70102-12345");
		request.addParameter("password", "1111");
		request.addParameter("pwHint", "hint");
		request.addParameter("pwAnswer", "answer");
		request.addParameter("zipcode", "333-222");
		request.addParameter("address", "서울시 송파구");
		request.addParameter("strAddress", "52번지");
		request.addParameter("email", "jun123@naver.com");
		request.addParameter("phoneNumber", "010-33-2343");
		request.addParameter("telNumber", "02-343-3333");
		service.addMember(request, response);
	}
	
	@Test
	public void testAddMemberForm() {
		MemberService service=new MemberService();
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		
		
	}

	@Test
	public void testLogin() throws ServletException, IOException {
		MockHttpServletRequest request= new MockHttpServletRequest();
		request.addParameter("memberid", "jun123");
		request.addParameter("password", "1234");
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		MockHttpSession session = new MockHttpSession();
		
		request.setSession(session);
		
		MemberService service = new MemberService();
		service.login(request, response);
		
		System.out.println("testLogin:request :"+request);
		System.out.println("testLogin:session :"+session);
	}

	@Test
	public void testLoginForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogout() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckMemberID() throws ServletException, IOException {
		MemberService service=new MemberService();
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		request.addParameter("memberid", "kim123");
		request.addParameter("name", "김태한");
		request.addParameter("reginum", "80102-12345");
		service.checkMemberID(request, response);
	}

	@Test
	public void testSearchMemberID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchMemberIDForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchMemberPW() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchMemberPwForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeMemberPW() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeMemberPWForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testServiceServletRequestServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testHttpServlet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastModified() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoHead() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoPut() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoOptions() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoTrace() {
		fail("Not yet implemented");
	}

	@Test
	public void testServiceHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenericServlet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDestroy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInitParameter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInitParameterNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServletConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServletContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServletInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitServletConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testInit() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogString() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogStringThrowable() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServletName() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
