package kr.or.kosta.recipe;

import kr.or.kosta.good.Good;
import kr.or.kosta.gooddivision.Good_division;

public class Recipe {

	private int recipeNum;			 	//레시피번호
	private String title;				//레시피이름
	private String content; 			//레시피설명
	private String img;					//이미지
	private String material;			//준비재료
	private Good good;					//관련상품
	private Good_division good_division;//레시피구분
	
	
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Good_division getGood_division() {
		return good_division;
	}

	public void setGood_division(Good_division good_division) {
		this.good_division = good_division;
	}

	@Override
	public String toString() {
		return "Recipe [recipeNum=" + recipeNum + ", title=" + title
				+ ", content=" + content + ", img=" + img + ", material="
				+ material + ", good=" + good + ", good_division="
				+ good_division + "]";
	}

	

	

}
