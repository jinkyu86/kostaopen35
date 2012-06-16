package kr.or.kosta.bookchange.member;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BlockDAO extends SqlSessionDaoSupport implements IBlockDAO {

	/**
	 * 내가 등록한 불량 회원 검색
	 * 
	 * 
	 * 
	 */
@Override
public List<Block> selectMyBlockList(int length,int page,String email){
	SqlSession session=getSqlSession();
	List<Block> BlockList;
	
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	BlockList=session.selectList("Block.selectMyBlockList",email,rowBounds);
	
	return BlockList;
}



	/** (관리자 모드) 불량회원 검색
	 * @param length
	 * @param page
	 */
@Override
public List <Block> selectBlockList(int page,int length){
	SqlSession session=getSqlSession();
	List<Block> BlockList;
		
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	BlockList=session.selectList("Block.selectBlockList",null,rowBounds);
			
	return BlockList;
}





	/**
	 * 신고리스트 수정(신고결과 처리시 사용, 검토완료됐는지, 검토중인지 등)
	 * 
	 * @param blockNo
	 */



	public void deleteBlock(String blockNo){
		SqlSession session=getSqlSession();
		session.delete("Block.deleteBlock",blockNo);
	}
	/**
	 * (관리자모드)신고상태변경
	 */
	@Override
	public Block viewBlock(String blockNo){
		SqlSession session=getSqlSession();
		Block block=session.selectOne("Block.selectBlockbyblockno",blockNo);
		return block;
	}


	/**
	 * 신고결과로 신고리스트 조회한 게시물 수 리턴
	 * 
	 * @param resultNo
	 */
@Override
    public int selectBlockbyResultCount(String resultNo){
    	SqlSession session=getSqlSession();
    		
		Integer count=null;
    	count=session.selectOne("Block.selectBlockbyResultCount",resultNo);
    	
    	return count;
    }

		@Override
		public List<Block> selectBlockbyResulting(int length, int page, String resulting){
			SqlSession session=getSqlSession();
			List<Block> BlockList;
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			BlockList=session.selectList("Block.selectBlockbyResulting", resulting, rowBounds);
			
			return BlockList;
			}
		@Override
		public int selectBlockbyResultCounting(String resultno){
			SqlSession session=getSqlSession();
				
			Integer count=null;
			count=session.selectOne("Block.selectBlockResultCounting",resultno);
			
			return count;
		}
		

public List<Block> myselectBlock(int page,int length,String email ){
	List<Block> BlockList;
	SqlSession session=getSqlSession();
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	BlockList=session.selectList("Block.myselectBlock",email,rowBounds);
	
	return BlockList;
}



/**
 * 불량 회원 인원수 
 */
@Override
public int selectBlockCount(){
	int Blockcount=0;
	SqlSession session=getSqlSession();
	
	Blockcount=session.selectOne("Block.selectBlockCount");
	return Blockcount;
}

	/**
	 * 신고리스트에 추가(신고접수 클릭시)
	 * 
	 * @param block
	 */
@Override
	public void insertBlock(Block block){
		SqlSession session=getSqlSession();
		session.insert("Block.insertBlock",block);
	}


	/**
	 * 신고리스트 수정(신고결과 처리시 사용, 검토완료됐는지, 검토중인지 등)
	 * 
	 * @param blockNo
	 */

	public void updateBlock(Block block){
		
		SqlSession session=getSqlSession();
		
		session.update("Block.updateBlock",block);
	}

	/**
	 * 신고리스트에서 삭제
	 * 
	 * @param blockNo
	 */

	public void deleteBlock(int blockNo){
		SqlSession session=getSqlSession();
		session.delete("Block.deleteBlock",blockNo);
	}


	/**
	 * 신고접수가 완료된 글들만 블랙리스트(공지사항)에 띄워줄 때 사용
	 * 
	 * @param length
	 * @param page
	 * @param resultNo
	 */
@Override
	public List<Block> selectBlockbyResult(int length, int page, String resultNo){
		SqlSession session=getSqlSession();
		List<Block> BlockList;
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		BlockList=session.selectList("Block.selectBlockbyResult", resultNo, rowBounds);
		
		return BlockList;
	}


	/**
	 * 신고결과로 신고리스트 조회한 게시물 수 리턴
	 * 
	 * @param resultNo
	 */
@Override
    public int selectBlockbyResultCount(int resultNo){
    	SqlSession session=getSqlSession();
    		
		Integer count=null;
    	count=session.selectOne("Block.selectBlockResultCount",resultNo);
    	
    	return count;
    }

}
