package kr.or.kosta.auction.member;

import java.util.List;

public interface IMemberDAO {

	String insertMember(Member member);

	void updateMember(Member member);

	void deleteMember(String userid);

	Member selectMember(String userid);

	List<Member> selectMemberList();

	List<Member> selectMemberList(int page, int length);
  
}
