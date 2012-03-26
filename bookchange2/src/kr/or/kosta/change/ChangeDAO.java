package kr.or.kosta.change;

public class ChangeDAO {

	/**
	 * 교환리스트 보기
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList selectChangeList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전체 교환 수 리턴
	 */
	public int selectChangeCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * 내 게시물번호로 교환리스트 검색(나에게 교환을 요청한 사람들 검색)
	 * 
	 * @param length
	 * @param page
	 * @param boardNo
	 */
	public ArrayList selectChangeMyboardList(int length, int page,
			String boardNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 내 게시물 번호로 검색한 게시물 수 리턴
	 * 
	 * @param boardNo
	 */
	public int selectChangeMyboardCount(String boardNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 내가 교환을 신청한 사람 검색(상대방 email로 조회)
	 * 
	 * @param length
	 * @param page
	 * @param email
	 */
	public ArrayList selectChangeRequestList(int length, int page, String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 내가 교환을 신청한 사람의 수 리턴
	 * 
	 * @param email
	 */
	public int selectChangeRequestCount(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 교환상태 보기
	 * 
	 * @param changeNo
	 */
	public Change selectChange(String changeNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 교환 리스트에 추가(교환신청 클릭시)
	 * 
	 * @param change
	 */
	public void insertChange(Change change) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 교환리스트 수정(교환결과를 수정할때 사용,교환중인지,완료됐는지등등)
	 * 
	 * @param changeNo
	 */
	public Change updateChange(String changeNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 교환리스트에서 삭제
	 * 
	 * @param changeNo
	 */
	public void deleteChange(String changeNo) {
		/* default generated stub */;
		return null;
	}
}
