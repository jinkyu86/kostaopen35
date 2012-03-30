package kr.or.kosta.photo;

public class Photo {
	private int p_num;
	private int good_num;
	private int recipe_num;
	private int board_num;
	private String image;
	
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getGood_num() {
		return good_num;
	}
	public void setGood_num(int good_num) {
		this.good_num = good_num;
	}
	public int getRecipe_num() {
		return recipe_num;
	}
	public void setRecipe_num(int recipe_num) {
		this.recipe_num = recipe_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Photo [p_num=" + p_num + ", good_num=" + good_num
				+ ", recipe_num=" + recipe_num + ", board_num=" + board_num
				+ ", image=" + image + "]";
	}
	
	
	
	
}