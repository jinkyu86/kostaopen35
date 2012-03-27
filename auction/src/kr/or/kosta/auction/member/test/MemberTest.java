package kr.or.kosta.auction.member.test;


import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.member.MemberDAO;


import org.junit.Test;

public class MemberTest {

	@Test
	public void testselectMember() {
		Member member = MemberDAO.selectMember("park");		
	    System.out.println(member);
	}

}
