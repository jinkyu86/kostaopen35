package kr.or.kosta.member.test;

import static org.junit.Assert.*;
import kr.or.kosta.member.Member;
import kr.or.kosta.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest {

//	@Test
//	public void testInsertMember() {
//		Member member=new Member();
//		member.setAddress("서울시 도봉구 쌍문동");
//		member.setEmail("thkims76@naver.com");
//		member.setMemberid("thkims76");
//		member.setName("김태한");
//		member.setPassword("1234");
//		member.setPhoneNumber("010-000-0000");
//		member.setPwAnswer("1487");
//		member.setPwHint("비밀번호");
//		member.setRegiNumber("1111");
//		member.setStrAddress("406호");
//		member.setTelNumber("02-333-3333");
//		member.setZipcode("631-310");
//		MemberDAO.insertMember(member);
//		System.out.println("testInsertMember");
//	}
//
//	@Test
//	public void testSelectMemberByid() {
//		Member member=new Member();
//		member.setAddress("서울시 도봉구 쌍문동");
//		member.setEmail("thkims76@naver.com");
//		member.setMemberid("fhrtks");
//		member.setName("김태한");
//		member.setPassword("1234");
//		member.setPhoneNumber("010-000-0000");
//		member.setPwAnswer("1487");
//		member.setPwHint("비밀번호");
//		member.setRegiNumber("1111");
//		member.setStrAddress("406호");
//		member.setTelNumber("02-333-3333");
//		member.setZipcode("631-310");
//		MemberDAO.selectMemberByid(member.getName(),member.getRegiNumber());
//		System.out.println("testiSelectMemberByid");
//		
//	}
//
//	@Test
//	public void testSelectMemberBypw() {
//		Member member=new Member();
//		member.setAddress("서울시 도봉구 쌍문동");
//		member.setEmail("thkims76@naver.com");
//		member.setMemberid("thkims76");
//		member.setName("김태한");
//		member.setPassword("0000");
//		member.setPhoneNumber("010-000-0000");
//		member.setPwAnswer("1487");
//		member.setPwHint("비밀번호");
//		member.setRegiNumber("1111");
//		member.setStrAddress("406호");
//		member.setTelNumber("02-333-3333");
//		member.setZipcode("631-310");
//		MemberDAO.selectMemberBypw(member.getPwHint(), member.getPwAnswer());
//		System.out.println("testiSelectMemberByPw");
//	}
//
//	@Test
//	public void testDeleteMember() {
//		Member member=new Member();
//		member.setName("김태한");
//		member.setPassword("1111");
//		member.setRegiNumber("0000");
//		MemberDAO.deleteMember(member.getPassword(),member.getRegiNumber());
//		System.out.println("testiDeleteMember");
//	}
//
//	@Test
//	public void testUpdateMember() {
//		Member member=new Member();
//		member.setAddress("서울시 강북구");
//		member.setEmail("thkims76@naver.com");
//		member.setMemberid("thkims76");
//		member.setName("김태한");
//		member.setPassword("1234");
//		member.setPhoneNumber("010-000-0000");
//		member.setPwAnswer("1487");
//		member.setPwHint("비밀번호");
//		member.setRegiNumber("1111");
//		member.setStrAddress("406호");
//		member.setTelNumber("02-333-3333");
//		member.setZipcode("631-310");
//		MemberDAO.updateMember(member);
//		System.out.println("testUpdateMember");
//	}
//
//	@Test
//	public void testLogin() {
//		Member member=new Member();
//	}
	
	@Test
	public void testSelectMember(){
		Member member=new Member();
		member=MemberDAO.selsctMember("yubi");
		
		System.out.println(member);
	}

}
