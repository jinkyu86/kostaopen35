package kr.or.kosta.change;

import java.util.ArrayList;

public class ChangeDAO {

	/**교환리스트 보기**/
	public ArrayList selectChangeList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**등록 된 교환 수 리턴**/
	public int selectChangeCount() {
		int changeCount=0;
		/* default generated stub */;
		return changeCount;
	}

	/**내 게시물번호로 교환리스트 검색(나에게 교환을 요청한 사람들 검색)**/
	public ArrayList selectChangeMyboardList(int length, int page,
			String boardNo) {
		return null;
	}

	/**내 게시물 번호로 검색한 게시물 수 리턴**/
	public int selectChangeMyboardCount(String boardNo) {
		return 0;
	}

	/**내가 교환을 신청한 사람 검색(상대방 email로 조회)**/
	public ArrayList selectChangeRequestList(int length, int page, String email) {
		return null;
	}

	/**내가 교환을 신청한 사람의 수 리턴**/
	public int selectChangeRequestCount(String email) {
		return 0;
	}

	/**교환상태 보기**/
	public Change selectChange(String changeNo) {
		return null;
	}

	/**교환 리스트에 추가(교환신청 클릭시)**/
	public void insertChange(Change change) {
	}

	/**교환리스트 수정(교환결과를 수정할때 사용,교환중인지,완료됐는지등등)**/
	public Change updateChange(String changeNo) {
		return null;
	}

	/**교환리스트에서 삭제**/
	public void deleteChange(String changeNo) {
		
	}
}
