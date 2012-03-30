package kr.or.kosta.bookchange.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

import oracle.net.aso.b;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.util.ConnectionUtil;

public class BlockDAO {

	/**
	 * @param length
	 * @param page
	 */
	public static ArrayList<Block> selectBlockList(int length, int page) {
		
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Block> BlockList=new ArrayList<Block>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql="select block_no,block_content,block_email," +
					"register_email,blockcondition_result " +
					"from tb_block";
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecord=0;
			while (rs.next()&&getRecord<length) {
				getRecord++;
				int blockNo=rs.getInt(1);
				String blockcontent=rs.getString(2);
				String blockEmail=rs.getString(3);
				String registerEmail=rs.getString(4);
				String blockConditionResult=rs.getString(5);
				
				
				Block block=new Block();
				block.setBlockNo(blockNo);
				block.setBlockContent(blockcontent);
				
				Member member=new Member();
				member.setEmail(blockEmail);
				block.setBlockmember(member);
				
				Member member2=new Member();
				member2.setEmail(registerEmail);
				block.setMember(member2);
				
				BlockCondition blockCondition=new BlockCondition();
				blockCondition.setBlockConditionResult(Integer.parseInt(blockConditionResult));
				block.setBlockCondition(blockCondition);				
				
				BlockList.add(block);
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return BlockList;
	}

	public static int selectBlockCount() {
		/* default generated stub */;
		Connection con=null;
		ResultSet rs=null;
		String sql=null;
		PreparedStatement ps=null;
		int BlockCount=0;
		try {
			con=ConnectionUtil.getConnection();
			sql="select count(block_no) from tb_block ";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				BlockCount=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return BlockCount;
	}

	/**
	 * �Ű���Ʈ�� �߰�(�Ű����� Ŭ����)
	 * 
	 * @param block
	 */
	public static void insertBlock(Block block) {
		/* default generated stub */;
		Connection con =null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		
		try {
			ps=con.prepareStatement(
					"insert into tb_block " +
					"(block_no,block_email,register_email,block_content,blockcondition_result)" +
					" values(block_seq.nextval,?,?,?,0)");
			ps.setString(1, block.getBlockmember().getEmail());
			ps.setString(2, block.getMember().getEmail());
			ps.setString(3, block.getBlockContent());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * �Ű���Ʈ ����(�Ű��� ó���� ���, ����Ϸ�ƴ���, ���������� ��)
	 * 
	 * @param blockNo
	 */
	public static void updateBlock(Block block) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		
		try {
			ps=con.prepareStatement(
					"update tb_block " +
					"set blockCondition_result=? " +
					"where block_no=?"
					);
			ps.setInt(1, block.getBlockCondition().getBlockConditionResult());
			ps.setInt(2, block.getBlockNo());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * �Ű���Ʈ���� ����
	 * 
	 * @param blockNo
	 */
	public static void deleteBlock(int blockNo) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement(
					"delete from tb_block " +
					"where block_no=?"
					);
			ps.setInt(1, blockNo);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * �Ű���(0,1,2)�� �Ű���Ʈ ��ȸ - �Ű����Ϸ�� �۵鸸 ������Ʈ(��������)�� ����� �� ���
	 * 
	 * @param length
	 * @param page
	 * @param resultNo
	 */
	public static ArrayList<Block> selectBlockbyResult(int length, int page, String resultNo) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Block> BlockList=new ArrayList<Block>();
		
		try{
			con=ConnectionUtil.getConnection();
			
			sql="select t.register_email, t.block_email, t.block_no, t.block_content, " +
				"t.blockcondition_result " +
				"from tb_block t, tb_blockcondition b " +
				"where b.blockcondition_result=t.blockcondition_result " +
				"and t.blockcondition_result=?";
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,resultNo);
			rs=ps.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			int getresult=0;
			System.out.println("�־ȵ�");
			while(rs.next()&&getresult<length){
				
				getresult++;
				String registeremail=rs.getString(1);
				String blockemail=rs.getString(2);
				int blockno=rs.getInt(3);
				String blockcontent=rs.getString(4);
				int blockConditionResult=rs.getInt(5);
				//String blockConditionIng=rs.getString(6);
				
				Block block=new Block();
				block.setBlockNo(blockno);
				block.setBlockContent(blockcontent);
				
				BlockCondition blockcondition=new BlockCondition();
				blockcondition.setBlockConditionResult(blockConditionResult);
				//blockcondition.setBlockConditionIng(blockConditionIng);
				block.setBlockCondition(blockcondition);
				
				Member member1=new Member();
				member1.setEmail(blockemail);
				block.setBlockmember(member1);
				
				Member member2=new Member();
				member2.setEmail(registeremail);
				block.setMember(member2);				
				
				BlockList.add(block);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return BlockList;
	}

	/**
	 * �Ű����� �Ű���Ʈ ��ȸ�� �Խù� �� ����
	 * 
	 * @param resultNo
	 */
	public static int selectBlockbyResultCount(String resultNo) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int blockCount=0;
		try {
			con=ConnectionUtil.getConnection();
			sql="select count(blockcondition_result) from tb_block" +
				" where blockcondition_result=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, resultNo);
			rs=ps.executeQuery();
			if(rs.next()){
				blockCount=rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return blockCount;
	}
	
}
