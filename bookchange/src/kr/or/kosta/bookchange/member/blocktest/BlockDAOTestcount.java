package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.Block;
import kr.or.kosta.bookchange.member.BlockDAO;

import org.junit.Test;

public class BlockDAOTestcount {

	@Test
	public void test() {
		int block=BlockDAO.selectBlockCount();
		System.out.println(block);
				
	}

}
