package kr.or.kosta.bookchange.member;

import java.util.ArrayList;

public class BlockDAO {

	/**
	 * @param length
	 * @param page
	 */
	public ArrayList<Block> selectBlockList(int length, int page) {
		/* default generated stub */;
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
	public void insertBlock(Block block) {
		/* default generated stub */;
		
	}

	/**
	 * �Ű���Ʈ ����(�Ű��� ó���� ���, ����Ϸ�ƴ���, ���������� ��)
	 * 
	 * @param blockNo
	 */
	public Block updateBlock(String blockNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �Ű���Ʈ���� ����
	 * 
	 * @param blockNo
	 */
	public void deleteBlock(String blockNo) {
		/* default generated stub */;
		
	}

	/**
	 * �Ű���(0,1,2)�� �Ű���Ʈ ��ȸ - �Ű����Ϸ�� �۵鸸 ������Ʈ(��������)�� ����� �� ���
	 * 
	 * @param length
	 * @param page
	 * @param resultNo
	 */
	public ArrayList<Block> selectBlockbyResult(int length, int page, String resultNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �Ű����� �Ű���Ʈ ��ȸ�� �Խù� �� ����
	 * 
	 * @param resultNo
	 */
	public int selectBlockbyResultCount(String resultNo) {
		/* default generated stub */;
		return 0;
	}
}
