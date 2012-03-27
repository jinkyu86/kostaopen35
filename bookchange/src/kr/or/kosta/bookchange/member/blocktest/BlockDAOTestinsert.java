package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.kosta.bookchange.member.Block;
import kr.or.kosta.bookchange.member.BlockDAO;
import kr.or.kosta.bookchange.member.Member;

public class BlockDAOTestinsert extends BlockDAO {

	@Test
	public void test() {
		
		Block block=new Block();
		block.setBlockContent("½Å°í");
		Member member=new Member();
		member.setEmail("homeless@nate.com");
		BlockDAO.insertBlock(block);
	}

}
