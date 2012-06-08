package kr.or.kosta.bookchange.member;

import java.util.List;

public interface IMemberDAO {

	void insertMember(Member member);

	void updateMember(Member member);

	void deleteMember(String email);

	int selectMemberCount();

	List<Member> selectMemberList(int page, int length);

	int selectMemberCountemail(String email);

	Member selectMemberemail(String email);

	List<Member> selectMemberListByEmail(int page, int length, String email);

	Member selectMemberListByPw(String email, String tel);

	Member selectMemberemailTel(String tel);

}
