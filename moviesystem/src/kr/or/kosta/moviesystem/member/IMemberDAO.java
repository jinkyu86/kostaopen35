package kr.or.kosta.moviesystem.member;

import java.util.List;

public interface IMemberDAO {

	Member selectMemberById(String userid);

	Member selectMember(String userNum);

	String insertMember(Member member);

	void editMember(Member member);

	void dropMember(Member member);

	List<Member> selectMemberList(int length, int page);

	int selectMemberListCount();

	List<Member> searchMemberListByName(int length, int page, String name);

	int searchMemberListByNameCount(String name);

	List<Member> searchMemberListByPhone(int length, int page, String phone);

	int searchMemberListByPhoneCount(String phone);

	List<Member> searchMemberListByEmail(int length, int page, String email);

	int searchMemberListByEmailCount(String email);

	List<Member> searchMemberListByAddr(int length, int page, String addr);

	int searchMemberListByAddrCount(String addr);

	Member findMemberId(String email, String name);

	Member findMemberPw(String email, String name, String userid);

	List<Member> selectMemberList();

}
