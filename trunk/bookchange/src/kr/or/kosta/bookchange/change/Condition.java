package kr.or.kosta.bookchange.change;


public class Condition {

	/**교환결과(0-교환가능, 1-교환중, 2-교환완료)**/
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
