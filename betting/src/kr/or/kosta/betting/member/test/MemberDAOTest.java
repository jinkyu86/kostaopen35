package kr.or.kosta.betting.member.test;

import java.util.ArrayList;

import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.member.MemberDAO;

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
		member.setId("jun123");
		member.setName("¾ÆÀú¾¾");
		member.setPw("1234");
		member.setMineral(1000);
		member.setEmail("jun1");
		
		MemberDAO.insultMember(member);
		
	}
	@Test
	public void testDeleteMember(){
		
		MemberDAO.deleteMember("jun123");
		
		
	}
	@Test
	public void selectMemberByID(){
		Member member =MemberDAO.selectMemberByID("jun1");
		
		System.out.println(member);
		
		
	}
	@Test
	public void selectMemberRankingList(){
		
		ArrayList<Member>page1List=
				MemberDAO.selectMemberRankingList(5, 1);
		System.out.println("page1List:"+page1List);
		ArrayList<Member>page2List=
				MemberDAO.selectMemberRankingList(5, 2);
		System.out.println("page2List:"+page2List);
		
	}
	@Test
	public void updateMember(){
		
		Member member = new Member();
		member.setId("jun123");
		member.setPw("1234");
		member.setMineral(1000);
		member.setEmail("jun21");
		
		MemberDAO.updateMember(member);
		
	}
	@Test
	public void selectMemberCount(){
		int memberCount=MemberDAO.selectMemberCount();
		System.out.println(memberCount);
		
	}
}
