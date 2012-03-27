package kr.or.kosta.bookchange.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		
		return null;
	}

	public int selectBlockCount() {
		/* default generated stub */;
		return 0;
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
					"(block_no,block_email,register_email,block_content)" +
					" values(nextval,?,?,?)");
			ps.setString(1, block.getMember().getEmail());
			ps.setString(2, block.getBlockContent());
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
	public static Block updateBlock(String blockNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �Ű���Ʈ���� ����
	 * 
	 * @param blockNo
	 */
	public static void deleteBlock(String blockNo) {
		/* default generated stub */;
		
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
		return null;
	}

	/**
	 * �Ű����� �Ű���Ʈ ��ȸ�� �Խù� �� ����
	 * 
	 * @param resultNo
	 */
	public static int selectBlockbyResultCount(String resultNo) {
		/* default generated stub */;
		return 0;
	}
}
