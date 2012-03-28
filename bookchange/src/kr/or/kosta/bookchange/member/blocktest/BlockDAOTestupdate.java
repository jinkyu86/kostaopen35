package kr.or.kosta.bookchange.member.blocktest;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.member.Block;
import kr.or.kosta.bookchange.member.BlockCondition;
import kr.or.kosta.bookchange.member.BlockDAO;

import org.apache.tomcat.util.digester.SetRootRule;
import org.junit.Test;

public class BlockDAOTestupdate {

	@Test
	public void test() {
		Block block=new Block();
		block.setBlockNo(1);
		
		BlockCondition blockCondition=new BlockCondition();
		blockCondition.setBlockConditionResult(2);
		block.setBlockCondition(blockCondition);
		
		
		BlockDAO.updateBlock(block);
		System.out.println(block);
		
	}

}
