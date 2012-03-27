package kr.or.kosta.auction.member.test;

import static org.junit.Assert.*;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testInsertMember() {
		Member member = new Member();
		member.setUserid("zzang");
		member.setPw("1234");
		member.setEmail("JZZANG@naver.com");
		member.setName("¯��");
		member.setCoin("300");
		member.setEmoney("100");
				
		MemberDAO.insertMember(member);
		System.out.println("�Է��޾��.");
	}

	@Test
	public void testUpdateMember() {
		Member member = new Member();
		member.setUserid("jung");
		member.setPw("4321");
		member.setEmail("jungwon87@naver.com");
		member.setName("������");
		member.setCoin("300");
		member.setEmoney("300");
		
		MemberDAO.updateMember(member);
		System.out.println("�����޾��.");
	}

	@Test
	public void testDeleteMember() {
		MemberDAO.deleteMember("minsik");
		System.out.println("�������.");
	}

	@Test
	public void testselectMember() {
		Member member = MemberDAO.selectMember("jung");		
	    System.out.println(member);
	}

}
