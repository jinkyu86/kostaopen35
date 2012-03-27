package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSelectMemberList() {
		ArrayList<Member> member=MemberDAO.selectMemberList(5, 1);
		System.out.println(member);
		ArrayList<Member> member1=MemberDAO.selectMemberList(5, 2);
		System.out.println(member1);
				
	}

}
