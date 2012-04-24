package kr.or.kosta.betting.member;

import java.util.List;

public interface IMember {

	List<Member> selectMemberList(int length, int page);

	void insultMember(Member member);

	Member selectMemberByID(String id);

	void deleteMember(String id);

	List<Member> selectMemberRankingList(int length, int page);

	void updateMember(Member member);

	int selectMemberCount();

	long selectMineralByID(String id);

	void updateMineralByID(Member member);

	long selectMemberRanking(String id);

}
