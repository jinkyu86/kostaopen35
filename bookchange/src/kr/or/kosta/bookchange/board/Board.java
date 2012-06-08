package kr.or.kosta.bookchange.board;

import kr.or.kosta.bookchange.change.Condition;
import kr.or.kosta.bookchange.member.Member;

public class Board {

	private Deal deal;
	private Category category;
    private Member member;
	private Condition condition;

	/**
	 * 게시물번호
	 */
	private int boardNo;

	/**
	 * 게시물제목
	 */
	private String boardTitle;

	/**
	 * 자신이원하는물건
	 */
	private String boardWant;

	/**
	 * 물품사진
	 */
	private String boardPhoto;

	/**
	 * 물건에 대한 상세 내용
	 */
	private String boardContent;

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWant() {
		return boardWant;
	}

	public void setBoardWant(String boardWant) {
		this.boardWant = boardWant;
	}

	public String getBoardPhoto() {
		return boardPhoto;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "Board [deal=" + deal + ", category=" + category + ", member="
				+ member + ", condition=" + condition + ", boardNo=" + boardNo
				+ ", boardTitle=" + boardTitle + ", boardWant=" + boardWant
				+ ", boardPhoto=" + boardPhoto + ", boardContent="
				+ boardContent + "]";
	}


}
