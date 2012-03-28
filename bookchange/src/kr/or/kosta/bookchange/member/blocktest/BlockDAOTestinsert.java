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
		
		block.setBlockContent("신고합니다 ㅋ");
		
		Member member=new Member();
		member.setEmail("homeless@nate.com");		
		block.setMember(member);
		
		Member member2=new Member();
		member2.setEmail("hoihoi@nate.com");
		block.setBlockmember(member2);
		
		BlockDAO.insertBlock(block);
	}

}

