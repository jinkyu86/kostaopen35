package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;

public class MemberDAOTest3 extends MemberDAO {

	@Test
	public void test() {
		Member member =new Member();
		member.setEmail("mgmg@nate.com");
		member.setAddress("서울시 성북구");
		member.setPw("1234");
		member.setTel("010-9393-1234");
		MemberDAO.insertMember(member);
	}

}
