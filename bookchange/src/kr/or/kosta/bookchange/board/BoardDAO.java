package $301_도메인.$301_AN00_분석.AN30_요구사항정의.AN33_클래스모델개발.$35조_중고도서물물교환시스템_클래스모델개발;

public class BoardDAO {

	/**
	 * 게시물리스트 조회
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList selectBoardList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전체게시물 수 리턴
	 */
	public int selectBoardCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * 카테고리별 게시물 조회
	 * 
	 * @param length
	 * @param page
	 * @param category
	 */
	public ArrayList selectBoardListbyCategory(int length, int page,
			String category) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 카테고리별 게시물 수 리턴
	 * 
	 * @param category
	 */
	public int selectBoardCategoryCount(String category) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 제목으로 검색한 게시물 조회
	 * 
	 * @param length
	 * @param page
	 * @param title
	 */
	public ArrayList selectBoardListbyTitle(int length, int page, String title) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 제목으로 검색한  게시물 수 리턴
	 * 
	 * @param title
	 */
	public int selectBoardTitleCount(String title) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 게시물 보기
	 * 
	 * @param boardNo
	 */
	public Board selectBoard(String boardNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 게시물 추가(물품 등록)
	 * 
	 * @param board
	 */
	public void insertBoard(Board board) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 게시물 수정
	 * 
	 * @param board
	 */
	public Board updateBoard(Board board) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 게시물 삭제
	 * 
	 * @param boardNo
	 */
	public void deleteBoard(String boardNo) {
		/* default generated stub */;
		return null;
	}
}
