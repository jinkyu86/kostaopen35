package kr.or.kosta.bookchange.member.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardService;
import kr.or.kosta.bookchange.member.Block;
import kr.or.kosta.bookchange.member.BlockCondition;
import kr.or.kosta.bookchange.member.BlockDAO;
import kr.or.kosta.bookchange.member.Member;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BlockDAOTest extends BlockDAO {

	@Test
	public void testUpdateBlock() {
		Block block=new Block();
		block.setBlockNo(1);
		BlockCondition con=new BlockCondition();
		con.setBlockConditionResult(2);
		block.setBlockCondition(con);
		
		BlockDAO dao=new BlockDAO();
		dao.updateBlock(block);		
	}
	
	@Test
	public void testDeleteBlock(){
		
		BlockDAO dao=new BlockDAO();
		dao.deleteBlock(142);
	}
	@Test
	public void testinsertBlock(){
		Block block=new Block();
	//	block.setBlockNo(3);
		block.setBlockContent("제발 신고해줘");
		Member member=new Member();
		member.setEmail("kiki@nate.com");
		Member member2=new Member();
		member2.setEmail("hoihoi@nate.com");
		block.setBlockmember(member);
		block.setMember(member2);
		BlockCondition blockCondition=new BlockCondition();
		blockCondition.setBlockConditionResult(0);
		block.setBlockCondition(blockCondition);
		BlockDAO dao=new BlockDAO();
		dao.insertBlock(block);
	}
	@Test
	public void testselectBlockList(){
		BlockDAO dao=new BlockDAO();
		List<Block> BlockList=dao.selectBlockList(1, 5);
		System.out.println(BlockList);
	}
	@Test
	public void testselectMyBlockList(){
		BlockDAO dao=new BlockDAO();
		List<Block> BlockList=dao.selectMyBlockList(6, 1, "gohome@naver.com");
		System.out.println(BlockList);
	
	}
	@Test
	public void testselectCountList(){
	    BlockDAO dao=new BlockDAO();
		int list=dao.selectBlockCount();
		System.out.println(list);
	}
	@Test
	public void testselectBlockByResult(){
		BlockDAO dao=new BlockDAO();
		List<Block> BlockList=dao.selectBlockbyResult(4, 1, "0");
		System.out.println(BlockList);
	
	}
	@Test
	public void testselectCountByResult(){
	    BlockDAO dao=new BlockDAO();
		int list=dao.selectBlockbyResultCount(0);
		System.out.println(list);
	}
	@Test
	public void testselectCountByResulting(){
	
	}
}
