package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest2 {

	@Test
	public void test() {
		Member member=MemberDAO.selectMember("homeless@nate.com");
		System.out.println(member);
	}

}
