package $301_도메인.$301_AN00_분석.AN30_요구사항정의.AN33_클래스모델개발.$35조_중고도서물물교환시스템_클래스모델개발;

public class Condition {

	/**
	 * 교환결과(0-교환가능, 1-교환중, 2-교환완료)
	 */
	private int conditionResult;

	/**
	 * 교환처리상태(교환가능,교환중,교환완료)
	 */
	private String conditionIng;

	private Change condition;

	private Board condition;
}
