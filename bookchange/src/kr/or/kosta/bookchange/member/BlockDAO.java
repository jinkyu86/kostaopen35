package kr.or.kosta.bookchange.member;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BlockDAO extends SqlSessionDaoSupport implements IBlockDAO {

	/**
	 * ���� ����� �ҷ� ȸ�� �˻�
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



	/** (������ ���) �ҷ�ȸ�� �˻�
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
	 * �Ű���Ʈ ����(�Ű��� ó���� ���, ����Ϸ�ƴ���, ���������� ��)
	 * 
	 * @param blockNo
	 */



	public void deleteBlock(String blockNo){
		SqlSession session=getSqlSession();
		session.delete("Block.deleteBlock",blockNo);
	}
	/**
	 * (�����ڸ��)�Ű���º���
	 */
	@Override
	public Block viewBlock(String blockNo){
		SqlSession session=getSqlSession();
		Block block=session.selectOne("Block.selectBlockbyblockno",blockNo);
		return block;
	}


	/**
	 * �Ű����� �Ű���Ʈ ��ȸ�� �Խù� �� ����
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
 * �ҷ� ȸ�� �ο��� 
 */
@Override
public int selectBlockCount(){
	int Blockcount=0;
	SqlSession session=getSqlSession();
	
	Blockcount=session.selectOne("Block.selectBlockCount");
	return Blockcount;
}

	/**
	 * �Ű���Ʈ�� �߰�(�Ű����� Ŭ����)
	 * 
	 * @param block
	 */
@Override
	public void insertBlock(Block block){
		SqlSession session=getSqlSession();
		session.insert("Block.insertBlock",block);
	}


	/**
	 * �Ű���Ʈ ����(�Ű��� ó���� ���, ����Ϸ�ƴ���, ���������� ��)
	 * 
	 * @param blockNo
	 */

	public void updateBlock(Block block){
		
		SqlSession session=getSqlSession();
		
		session.update("Block.updateBlock",block);
	}

	/**
	 * �Ű���Ʈ���� ����
	 * 
	 * @param blockNo
	 */

	public void deleteBlock(int blockNo){
		SqlSession session=getSqlSession();
		session.delete("Block.deleteBlock",blockNo);
	}


	/**
	 * �Ű������� �Ϸ�� �۵鸸 ������Ʈ(��������)�� ����� �� ���
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
	 * �Ű����� �Ű���Ʈ ��ȸ�� �Խù� �� ����
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
