package kr.or.kosta.member;

public class BlockDAO {

	/**
	 * @param length
	 * @param page
	 */
	public ArrayList selectBlockList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	public int selectBlockCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * 신고리스트에 추가(신고접수 클릭시)
	 * 
	 * @param block
	 */
	public void insertBlock(Block block) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 신고리스트 수정(신고결과 처리시 사용, 검토완료됐는지, 검토중인지 등)
	 * 
	 * @param blockNo
	 */
	public Block updateBlock(String blockNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 신고리스트에서 삭제
	 * 
	 * @param blockNo
	 */
	public void deleteBlock(String blockNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 신고결과(0,1,2)로 신고리스트 조회 - 신고검토완료된 글들만 블랙리스트(공지사항)에 띄워줄 때 사용
	 * 
	 * @param length
	 * @param page
	 * @param resultNo
	 */
	public ArrayList selectBlockbyResult(int length, int page, String resultNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 신고결과로 신고리스트 조회한 게시물 수 리턴
	 * 
	 * @param resultNo
	 */
	public int selectBlockbyResultCount(String resultNo) {
		/* default generated stub */;
		return null;
	}
}
