package kr.or.kosta.bookchange.member;

import java.util.List;

import kr.or.kosta.bookchange.change.Change;

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

	List<Member> searchMemberList(int page, int length, String email, String tel);



	List<Member> searchMemberListEmail(int page, int length, String email);

	List<Member> searchMemberListTel(int page, int length, String tel);

	List<Member> searchMemberListPw(int page, int length, String pw);
	
	int searchMemberCountTel(String tel);	
	
	int searchMemberCountEmail(String email);
	
	int searchMemberCountPw(String pw);

	List<Change> searchMemberListCondition(int page, int length);

	List<Change> searchMemberListCondition(int page, int length,String condition);

	int searchMemberListConditioncount(int page, int length);

}
