package kr.or.kosta.betting.team;

public class Team {

	/**
	 * �� ��ȣ
	 */
	private String num;

	/**
	 * �� �̸�
	 */
	private String name;

	/**
	 * �� ����
	 */
	private String photo;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Team [num=" + num + ", name=" + name + ", photo=" + photo + "]";
	}


}
