package kr.or.kosta.member;

public interface IMemberDAO {

	void insertMember(Member member);
	void updateMember(Member member);
	void deleteMember(String memberId);

	Member selectMemberByid(Member member);
	Member selectMemberBypw(Member member);
	Member login(Member member);
	Member selsctMember(String memberid);

}
