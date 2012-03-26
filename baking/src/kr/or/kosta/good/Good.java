package kr.or.kosta.good;


import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.recipe.Recipe;

public class Good {

	private Good_division good_division;
	private Recipe recipe;
	/**
	 * 상품번호
	 */
	private int goodNum;

	/**
	 * 상품번호
	 */
	private int division;

	/**
	 * 상품가격
	 */
	private int goodPrice;

	/**
	 * 상품수량
	 */
	private int qty;

	/**
	 * 상품이름
	 */
	private String name;

	/**
	 * 상품구분
	 */
	private String explantion;

	/**
	 * 이미지
	 */
	private String img;

	/**
	 * 상품옵션
	 */
	private String option;

}
