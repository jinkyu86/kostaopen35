package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.BlockDAO;

import org.junit.Test;

public class BlockDAOTestdel {

	@Test
	public void test() {
		BlockDAO.deleteBlock(2);
	}

}
