package kr.or.kosta.betting.member.test;

import java.util.List;

import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSelectMemberListIntInt() {
		List<Member>page1List=
				MemberDAO.selectMemberList(5, 1);
		System.out.println("page1List:"+page1List);
		List<Member>page2List=
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
	public void testSelectMemberByID(){
		Member member =MemberDAO.selectMemberByID("jun1");
		
		System.out.println(member);
		
		
	}
	@Test
	public void testSelectMemberRankingList(){
		
		List<Member>page1List=
				MemberDAO.selectMemberRankingList(5, 1);
		System.out.println("page1List:"+page1List);
		List<Member>page2List=
				MemberDAO.selectMemberRankingList(5, 2);
		System.out.println("page2List:"+page2List);
		
	}
	@Test
	public void testUpdateMember(){
		
		Member member = new Member();
		member.setId("jun123");
		member.setPw("1234");
		member.setMineral(1000);
		member.setEmail("jun21");
		
		MemberDAO.updateMember(member);
		
	}
	@Test
	public void testSelectMemberCount(){
		int memberCount=MemberDAO.selectMemberCount();
		System.out.println(memberCount);
		
	}
	@Test
	public void testSelectMemberRanking(){
		long rank=MemberDAO.selectMemberRanking("jun1");
		System.out.println(rank);
		
	}
	
	@Test
	public void testSelectMineralByID(){
		long mineral=MemberDAO.selectMineralByID("jun1");
		System.out.println(mineral);
	}
	
	@Test
	public void testUpdateMineralByID(){
		Member member = new Member();
		member.setId("jun123");
		member.setMineral(7000);
		MemberDAO.updateMineralByID(member);
	}
}
