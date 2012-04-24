package kr.or.kosta.betting.memberbetdata;

import java.util.List;

public interface IMemberBetData {

	List<MemberBetData> selectMemberBetDataListByID(int page, int length,
			String id);

	void insultMemberBetData(MemberBetData mbd);

	void deleteMemberbetData(String mbdNum);

	int selectMemberBetDataByIDCount(String id);

	void updateMemberBetData(String mbdNum);

	String selectMatchNum(String mbdNum);

	MemberBetData selectMemberBetData(String mbdNum);

	int selectMineralConfirm(String mbdNum);

}
