package kr.or.kosta.auction.member.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;
import kr.or.kosta.auction.member.IMemberDAO;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest {
	private IMemberDAO memberDAO;
	
	public MemberDAOTest(IMemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}

	@Test
	public void testInsertMember() {
		Member member=new Member();
		member.setUserid("joo6");
		member.setPw("1234");
		member.setEmail("jojo@naver.com");
		member.setName("����");
		memberDAO.insertMember(member);
	}

	@Test
	public void testUpdateGood() {
		Member member=new Member();		
		member.setPw("2222");
		member.setEmail("jjo@naver.com");
		member.setName("��");
		member.setCoin("300");
		member.setEmoney("2000");
		member.setUserid("jojo1");
		memberDAO.updateMember(member);
		
	}

	@Test
	public void testDeleteMember() {
		memberDAO.deleteMember("jojo1");
	}

	@Test
	public void testSelectMember() {
		Member member=memberDAO.selectMember("apple");
		System.out.println(member.toString());
	}

	@Test
	public void testSelectMemberList() {
		List<Member> memberList=memberDAO.selectMemberList();
		System.out.println("MemberDAO:selectMember:member"+memberList);
	}

	@Test
	public void testSelectMemberListIntInt() {
		List<Member> memberList=memberDAO.selectMemberList(1, 2);
		System.out.println("memberList:"+memberList);
	}

}
