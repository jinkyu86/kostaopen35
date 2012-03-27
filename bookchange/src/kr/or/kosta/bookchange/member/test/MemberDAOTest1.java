package kr.or.kosta.bookchange.member.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.MemberDAO;

import org.junit.Test;

public class MemberDAOTest1 extends MemberDAO {

	@Test
	public void test() {
		int a=MemberDAO.selectMemberCount();
		System.out.println(a);
	}

}
