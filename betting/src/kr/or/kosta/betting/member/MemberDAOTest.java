package kr.or.kosta.betting.member;

import java.util.ArrayList;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSelectMemberListIntInt() {
		ArrayList<Member>page1List=
				MemberDAO.selectMemberList(5, 1);
		System.out.println("page1List:"+page1List);
		ArrayList<Member>page2List=
				MemberDAO.selectMemberList(5, 2);
		System.out.println("page2List:"+page2List);
	}

	@Test
	public void testInsertMember() {
		
		Member member = new Member();
		member.setID("jun123");
		member.setName("¾ÆÀú¾¾");
		member.setPW("1234");
		member.setMineral(1000);
		member.setEmail("jun1");
		
		MemberDAO.insultMember(member);
		
	}
}
