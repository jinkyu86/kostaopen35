package kr.or.kosta.bookchange.change;


public class Condition {

	/**��ȯ���(0-��ȯ����, 1-��ȯ��, 2-��ȯ�Ϸ�)**/
	private int conditionResult;
	private String conditionIng;
	
	public int getConditionResult() {
		return conditionResult;
	}
	public void setConditionResult(int conditionResult) {
		this.conditionResult = conditionResult;
	}
	public String getConditionIng() {
		return conditionIng;
	}
	public void setConditionIng(String conditionIng) {
		this.conditionIng = conditionIng;
	}
	@Override
	public String toString() {
		return "Condition [conditionResult=" + conditionResult
				+ ", conditionIng=" + conditionIng + "]";
	}
	
	
}
