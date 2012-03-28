package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.bookchange.member.Block;
import kr.or.kosta.bookchange.member.BlockDAO;

import org.junit.Test;

public class BlockDAOTestArraySelect {

	@Test
	public void test() {
	  ArrayList<Block> BlockList=BlockDAO.selectBlockList(2, 1);
	  System.out.println(BlockList);
	  ArrayList<Block> BlockList1=BlockDAO.selectBlockList(2, 2);
	  System.out.println(BlockList1);
	}

}
