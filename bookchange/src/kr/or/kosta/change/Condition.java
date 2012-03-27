package kr.or.kosta.change;

import kr.or.kosta.bookchange.board.Board;

public class Condition {

	/**교환결과(0-교환가능, 1-교환중, 2-교환완료)**/
	private int conditionResult;

	/**교환처리상태(교환가능,교환중,교환완료)**/
	private String conditionIng;

	private Change changeCondition;//교환상태

	private Board boardCondition;//현재교환상태
}
