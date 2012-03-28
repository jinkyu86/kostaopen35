package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.BlockDAO;

import org.junit.Test;

public class BlockDAOTestResultCount {

	@Test
	public void test() {
		int blockResultCount=BlockDAO.selectBlockbyResultCount(0);
		System.out.println(blockResultCount);
	}

}
