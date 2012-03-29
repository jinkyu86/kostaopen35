package kr.or.kosta.good;


import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.recipe.Recipe;

public class Good {

	private Good_division good_division; //�����: has a
	private Recipe recipe; //������ : �ٴ�� ����
	private int goodNum; //��ǰ��ȣ
	private int goodPrice; //��ǰ����
	private int qty; //��ǰ����
	private String name; //��ǰ�̸�
	private String explantion; //��ǰ����
	private String img;//�̹���
	private String option;//��ǰ�ɼ�

	public Good_division getGood_division() {
		return good_division;
	}

	public void setGood_division(Good_division good_division) {
		this.good_division = good_division;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public int getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	public int getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(int goodPrice) {
		this.goodPrice = goodPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplantion() {
		return explantion;
	}

	public void setExplantion(String explantion) {
		this.explantion = explantion;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Good [good_division=" + good_division + ", recipe=" + recipe
				+ ", goodNum=" + goodNum + ", goodPrice=" + goodPrice
				+ ", qty=" + qty + ", name=" + name + ", explantion="
				+ explantion + ", img=" + img + ", option=" + option + "]";
	}
	
}
