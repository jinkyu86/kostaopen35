package kr.or.kosta.bookchange.member;

public class BlockCondition {

	/**
	 * 신고결과(0-신고접수, 1-신고검토, 2-등록완료)
	 */
	private int blockConditionResult;

	/**
	 * 신고처리상태(신고접수, 신고검토, 등록완료)
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
