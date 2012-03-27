package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest4 {

	@Test
	public void test() {
		Member member=new Member();
		member.setEmail("homeless@nate.com");
		member.setAddress("경상도 울산시");
		member.setPw("2424");
		member.setTel("02-3636-3434");
		MemberDAO.updateMember(member);
	}

}
