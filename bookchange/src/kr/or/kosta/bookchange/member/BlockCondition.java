package kr.or.kosta.bookchange.member;

public class BlockCondition {

	/**
	 * �Ű���(0-�Ű�����, 1-�Ű����, 2-��ϿϷ�)
	 */
	private String blockConditionResult;

	/**
	 * �Ű�ó������(�Ű�����, �Ű����, ��ϿϷ�)
	 */
	private String blockConditionIng;

	public String getBlockConditionResult() {
		return blockConditionResult;
	}

	public String getBlockConditionIng() {
		return blockConditionIng;
	}

	public void setBlockConditionIng(String blockConditionIng) {
		this.blockConditionIng = blockConditionIng;
	}

	@Override
	public String toString() {
		return "BlockCondition [blockConditionResult=" + blockConditionResult
				+ ", blockConditionIng=" + blockConditionIng + "]";
	}


	

}
