package kr.or.kosta.bookchange.member;

import java.util.List;

public interface IMemberDAO {

	void insertMember(Member member);

	void updateMember(Member member);

	void deleteMember(String email);

	int selectMemberCount();
	
	int selectMemberCountEmail(String email);

	Member selectMemberEmail(String email);

	Member selectMemberListByPw(String email, String tel);
	
	Member selectMemberEmailTel(String tel);
	
	List<Member> selectMemberList(int page, int length);

	List<Member> selectMemberListByEmail(int page, int length, String email);

	List<Member> selectMemberListByTel(int page, int length, String tel);

	
}
