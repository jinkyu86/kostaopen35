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
	 * 신고리스트에 추가(신고접수 클릭시)
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
	 * 신고리스트 수정(신고결과 처리시 사용, 검토완료됐는지, 검토중인지 등)
	 * 
	 * @param blockNo
	 */
	public static Block updateBlock(String blockNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 신고리스트에서 삭제
	 * 
	 * @param blockNo
	 */
	public static void deleteBlock(String blockNo) {
		/* default generated stub */;
		
	}

	/**
	 * 신고결과(0,1,2)로 신고리스트 조회 - 신고검토완료된 글들만 블랙리스트(공지사항)에 띄워줄 때 사용
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
	 * 신고결과로 신고리스트 조회한 게시물 수 리턴
	 * 
	 * @param resultNo
	 */
	public static int selectBlockbyResultCount(String resultNo) {
		/* default generated stub */;
		return 0;
	}
}
