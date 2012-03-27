package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTestdel {

	@Test
	public void test() {
		
		MemberDAO.deleteMember("mgmg@nate.com");
	}

}
