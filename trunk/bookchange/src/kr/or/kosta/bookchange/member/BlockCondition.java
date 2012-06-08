package kr.or.kosta.bookchange.member;

public class BlockCondition {

	/**
	 * �Ű���(0-�Ű�����, 1-�Ű����, 2-��ϿϷ�)
	 */
	private int blockConditionResult;

	/**
	 * �Ű�ó������(�Ű�����, �Ű����, ��ϿϷ�)
	 */
	private String blockConditionIng;

	public int getBlockConditionResult() {
		return blockConditionResult;
	}

	public void setBlockConditionResult(int blockConditionResult) {
		this.blockConditionResult = blockConditionResult;
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
