package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.bookchange.member.Block;
import kr.or.kosta.bookchange.member.BlockDAO;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.bookchange.member.MemberDAO;

import org.junit.Test;

public class BlockDAOTestArrayresult {

	@Test
	public void test() {
		ArrayList<Block> member=BlockDAO.selectBlockbyResult(2, 1, "2");
		System.out.println(member);
		ArrayList<Block> member1= BlockDAO.selectBlockbyResult(2, 2, "2");
		System.out.println(member1);

	}

}
