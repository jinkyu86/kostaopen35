package kr.or.kosta.bookchange.board;

public class Category {

	/**
	 * 카테고리번호
	 */
	private int categoryNo;

	/**
	 * 카테고리명
	 */
	private String categoryName;

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName="
				+ categoryName + "]";
	}

}
