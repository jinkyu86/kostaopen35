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

//	@Test
//	public void testViewMember() throws ServletException, IOException {
//		MemberService service=new MemberService();
//		MockHttpServletRequest request=new MockHttpServletRequest();
//		MockHttpServletResponse response=new MockHttpServletResponse();
//		request.addParameter("memberid", "jun123");
//		request.addParameter("name", "전인하");
//		request.addParameter("reginum", "70102-12345");
//		service.viewMember(request, response);
//	}
//
//	@Test
//	public void testEditMember() throws ServletException, IOException {
//		MemberService service=new MemberService();
//		MockHttpServletRequest request=new MockHttpServletRequest();
//		MockHttpServletResponse response=new MockHttpServletResponse();
//		request.addParameter("memberid", "jun123");
//		request.addParameter("name", "전인하");
//		request.addParameter("regiNumer", "70102-12345");
//		request.addParameter("password", "1111");
//		request.addParameter("pwHint", "hint");
//		request.addParameter("pwAnswer", "answer");
//		request.addParameter("zipcode", "333-222");
//		request.addParameter("address", "서울시 송파구");
//		request.addParameter("strAddress", "52번지");
//		request.addParameter("email", "jun123@naver.com");
//		request.addParameter("phoneNumber", "010-33-2343");
//		request.addParameter("telNumber", "02-343-3333");
//		service.editMember(request, response);
//	}
//
//	@Test
//	public void testEditMemberForm() throws ServletException, IOException {
//		MemberService service=new MemberService();
//		MockHttpServletRequest request=new MockHttpServletRequest();
//		MockHttpServletResponse response=new MockHttpServletResponse();
//		request.addParameter("memberid", "thkims");
//		request.addParameter("name", "홍길동");
//		request.addParameter("reginum", "834243-423333");
//		service.editMemberForm(request, response);
//	}
//
//	@Test
//	public void testRemoveMember() throws ServletException, IOException {
//		MemberService service=new MemberService();
//		MockHttpServletRequest request=new MockHttpServletRequest();
//		MockHttpServletResponse response=new MockHttpServletResponse();
//		request.addParameter("memberid", "jun123");
//		request.addParameter("pw", "1100");
//		request.addParameter("reginum", "70102-12345");
//		service.removeMember(request, response);
//	}
//
//	@Test
//	public void testAddMember() throws ServletException, IOException {
//		MemberService service=new MemberService();
//		MockHttpServletRequest request=new MockHttpServletRequest();
//		MockHttpServletResponse response=new MockHttpServletResponse();
//		request.addParameter("memberid", "jun123");
//		request.addParameter("name", "전인하");
//		request.addParameter("regiNumer", "70102-12345");
//		request.addParameter("password", "1111");
//		request.addParameter("pwHint", "hint");
//		request.addParameter("pwAnswer", "answer");
//		request.addParameter("zipcode", "333-222");
//		request.addParameter("address", "서울시 송파구");
//		request.addParameter("strAddress", "52번지");
//		request.addParameter("email", "jun123@naver.com");
//		request.addParameter("phoneNumber", "010-33-2343");
//		request.addParameter("telNumber", "02-343-3333");
//		service.addMember(request, response);
//	}
//	
//	@Test
//	public void testAddMemberForm() {
//		MemberService service=new MemberService();
//		MockHttpServletRequest request=new MockHttpServletRequest();
//		MockHttpServletResponse response=new MockHttpServletResponse();
//		
//		
//	}
//
//
////	@Test
////	public void testLogin() {
////		MockHttpServletRequest request= new MockHttpServletRequest();
////		request.addParameter("memberid", "jun123");
////		request.addParameter("password", "1234");
////		
////		MockHttpServletResponse response = new MockHttpServletResponse();
////		MockHttpSession session = new MockHttpSession();
////		
////		request.setSession(session);
////		
////		MemberService service = new MemberService();
////		service.login(request, response);
////		
////		System.out.println("testLogin:request :"+request);
////		System.out.println("testLogin:session :"+session);
////	}
//
//	@Test
//	public void testLogin() throws ServletException, IOException {
//		MockHttpServletRequest request= new MockHttpServletRequest();
//		request.addParameter("memberid", "jun123");
//		request.addParameter("password", "1234");
//		
//		MockHttpServletResponse response = new MockHttpServletResponse();
//		MockHttpSession session = new MockHttpSession();
//		
//		request.setSession(session);
//		
//		MemberService service = new MemberService();
//		service.login(request, response);
//		
//		System.out.println("testLogin:request :"+request);
//		System.out.println("testLogin:session :"+session);
//	}
//
//
//	@Test
//	public void testLoginForm() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLogout() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testCheckMemberID() throws ServletException, IOException {
//		MemberService service=new MemberService();
//		MockHttpServletRequest request=new MockHttpServletRequest();
//		MockHttpServletResponse response=new MockHttpServletResponse();
//		request.addParameter("memberid", "kim123");
//		request.addParameter("name", "김태한");
//		request.addParameter("reginum", "80102-12345");
//		service.checkMemberID(request, response);
//	}



}
