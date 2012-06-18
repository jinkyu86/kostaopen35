package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.util.ConnectionUtil;

public class BlockDAO extends SqlSessionDaoSupport implements IBlockDAO {

	/*게시물을 테이블에 insert하고
	 * insert한 게시물 번호 리턴*/
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
	BlockList=session.selectList("Block.myselectBlock",email,rowBounds);
	
	return BlockList;
}
//public static ArrayList<Block> selectMyBlockList(int length, int page, String email) {
//		
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		ArrayList<Block> BlockList=new ArrayList<Block>();
//		
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select b.block_no,b.block_content,b.block_email, " +
//					"b.register_email,c.blockcondition_result,c.blockcondition_ing " +
//					"from tb_block b,tb_blockcondition c " +
//					"where b.register_email=? AND b.blockcondition_result=c.blockcondition_result ";
//			
//			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
//									ResultSet.CONCUR_READ_ONLY);
//			ps.setString(1, email);
//			rs=ps.executeQuery();
//			
//			if(page>1){rs.absolute((page-1)*length);}
//			int getRecord=0;
//			while (rs.next()&&getRecord<length) {
//				getRecord++;
//				int blockNo=rs.getInt(1);
//				String blockcontent=rs.getString(2);
//				String blockEmail=rs.getString(3);
//				String registerEmail=rs.getString(4);
//				String blockConditionResult=rs.getString(5);
//				String blockConditioning=rs.getString(6);
//				
//				Block block=new Block();
//				block.setBlockNo(blockNo);
//				block.setBlockContent(blockcontent);
//				
//				Member member=new Member();
//				member.setEmail(blockEmail);
//				block.setBlockmember(member);
//				
//				Member member2=new Member();
//				member2.setEmail(registerEmail);
//				block.setMember(member2);
//				
//				BlockCondition blockCondition=new BlockCondition();
//				blockCondition.setBlockConditionResult(Integer.parseInt(blockConditionResult));
//				blockCondition.setBlockConditionIng(blockConditioning);
//				block.setBlockCondition(blockCondition);				
//				
//				BlockList.add(block);
//				
//			}
//		
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return BlockList;
//	}




	/** (일반) 불량회원 검색
	 * @param length
	 * @param page
	 */
@Override
public List <Block> selectBlockList(int page,int length){
	SqlSession session=getSqlSession();
	List<Block> BlockList;
		
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	BlockList=session.selectList("selectBlock",null,rowBounds);
			
	return BlockList;
}

//	public static ArrayList<Block> selectBlockList(int length, int page) {
//		
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		ArrayList<Block> BlockList=new ArrayList<Block>();
//		
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select b.block_no,b.block_content,b.block_email, " +
//					"b.register_email,c.blockcondition_result,c.blockcondition_ing " +
//					"from tb_block b,tb_blockcondition c " +
//					"where b.blockcondition_result=c.blockcondition_result ";
//			
//			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
//									ResultSet.CONCUR_READ_ONLY);
//			rs=ps.executeQuery();
//			
//			if(page>1){rs.absolute((page-1)*length);}
//			int getRecord=0;
//			while (rs.next()&&getRecord<length) {
//				getRecord++;
//				int blockNo=rs.getInt(1);
//				String blockcontent=rs.getString(2);
//				String blockEmail=rs.getString(3);
//				String registerEmail=rs.getString(4);
//				String blockConditionResult=rs.getString(5);
//				String blockConditioning=rs.getString(6);
//				
//				Block block=new Block();
//				block.setBlockNo(blockNo);
//				block.setBlockContent(blockcontent);
//				
//				Member member=new Member();
//				member.setEmail(blockEmail);
//				block.setBlockmember(member);
//				
//				Member member2=new Member();
//				member2.setEmail(registerEmail);
//				block.setMember(member2);
//				
//				BlockCondition blockCondition=new BlockCondition();
//				blockCondition.setBlockConditionResult(Integer.parseInt(blockConditionResult));
//				blockCondition.setBlockConditionIng(blockConditioning);
//				block.setBlockCondition(blockCondition);				
//				
//				BlockList.add(block);
//				
//			}
//		
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return BlockList;
//	}
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
//	public static int selectBlockCount() {
//		/* default generated stub */;
//		Connection con=null;
//		ResultSet rs=null;
//		String sql=null;
//		PreparedStatement ps=null;
//		int BlockCount=0;
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select count(block_no) from tb_block ";
//			ps=con.prepareStatement(sql);
//			rs=ps.executeQuery();
//			if(rs.next()){
//				BlockCount=rs.getInt(1);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return BlockCount;
//	}
//
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
//	public static void insertBlock(Block block) {
//		/* default generated stub */;
//		Connection con =null;
//		PreparedStatement ps=null;
//		con=ConnectionUtil.getConnection();
//		
//		try {
//			ps=con.prepareStatement(
//					"insert into tb_block " +
//					"(block_no,block_email,register_email,block_content,blockcondition_result)" +
//					" values(block_seq.nextval,?,?,?,0)");
//			ps.setString(1, block.getBlockmember().getEmail());
//			ps.setString(2, block.getMember().getEmail());
//			ps.setString(3, block.getBlockContent());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	/**
	 * 신고리스트 수정(신고결과 처리시 사용, 검토완료됐는지, 검토중인지 등)
	 * 
	 * @param blockNo
	 */

	public void updateBlock(Block block){
		
		SqlSession session=getSqlSession();
		
		session.update("Block.updateBlock",block);
	}
//	public static void updateBlock(Block block) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement ps=null;
//		con=ConnectionUtil.getConnection();
//		
//		try {
//			ps=con.prepareStatement(
//					"update tb_block " +
//					"set blockCondition_result=? " +
//					"where block_no=?"
//					);
//			ps.setInt(1, block.getBlockCondition().getBlockConditionResult());
//			ps.setInt(2, block.getBlockNo());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}

	/**
	 * 신고리스트에서 삭제
	 * 
	 * @param blockNo
	 */

	public void deleteBlock(int blockNo){
		SqlSession session=getSqlSession();
		session.delete("Block.deleteBlock",blockNo);
	}
//	public static void deleteBlock(int blockNo) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement ps=null;
//		con=ConnectionUtil.getConnection();
//		try {
//			ps=con.prepareStatement(
//					"delete from tb_block " +
//					"where block_no=?"
//					);
//			ps.setInt(1, blockNo);
//			ps.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

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
//	public static ArrayList<Block> selectBlockbyResult(int length, int page, String resultNo) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		ArrayList<Block> BlockList=new ArrayList<Block>();
//		
//		try{
//			con=ConnectionUtil.getConnection();
//			
//			sql="select t.register_email, t.block_email, t.block_no, t.block_content, " +
//				"t.blockcondition_result " +
//				"from tb_block t, tb_blockcondition b " +
//				"where b.blockcondition_result=t.blockcondition_result " +
//				"and t.blockcondition_result=?";
//			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
//									ResultSet.CONCUR_READ_ONLY);
//			ps.setString(1,resultNo);
//			rs=ps.executeQuery();
//			
//			if(page>1){
//				rs.absolute((page-1)*length);
//			}
//			
//			int getresult=0;
//			System.out.println("왜안됨");
//			while(rs.next()&&getresult<length){
//				
//				getresult++;
//				String registeremail=rs.getString(1);
//				String blockemail=rs.getString(2);
//				int blockno=rs.getInt(3);
//				String blockcontent=rs.getString(4);
//				int blockConditionResult=rs.getInt(5);
//				//String blockConditionIng=rs.getString(6);
//				
//				Block block=new Block();
//				block.setBlockNo(blockno);
//				block.setBlockContent(blockcontent);
//				
//				BlockCondition blockcondition=new BlockCondition();
//				blockcondition.setBlockConditionResult(blockConditionResult);
//				//blockcondition.setBlockConditionIng(blockConditionIng);
//				block.setBlockCondition(blockcondition);
//				
//				Member member1=new Member();
//				member1.setEmail(blockemail);
//				block.setBlockmember(member1);
//				
//				Member member2=new Member();
//				member2.setEmail(registeremail);
//				block.setMember(member2);				
//				
//				BlockList.add(block);
//				
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return BlockList;
//	}

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
//	public static int selectBlockbyResultCount(String resultNo) {
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		int blockCount=0;
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select count(blockcondition_result) from tb_block" +
//				" where blockcondition_result=?";
//			ps=con.prepareStatement(sql);
//			ps.setString(1, resultNo);
//			rs=ps.executeQuery();
//			if(rs.next()){
//				blockCount=rs.getInt(1);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return blockCount;
//	}
//

}
