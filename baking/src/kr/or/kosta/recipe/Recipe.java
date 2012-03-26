package kr.or.kosta.recipe;

import kr.or.kosta.good.Good;

public class Recipe {

	/**
	 * 레시피번호
	 */
	private int recipeNum;

	/**
	 * 레시피이름
	 */
	private String title;

	/**
	 * 레시피설명
	 */
	private String content;

	/**
	 * 이미지
	 */
	private String img;

	private Good good;

	public int getRecipeNum() {
		return recipeNum;
	}

	public void setRecipeNum(int recipeNum) {
		this.recipeNum = recipeNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "Recipe [recipeNum=" + recipeNum + ", title=" + title
				+ ", content=" + content + ", img=" + img + ", good=" + good
				+ "]";
	}

}
