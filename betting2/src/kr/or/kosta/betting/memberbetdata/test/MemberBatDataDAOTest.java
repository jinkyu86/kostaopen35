package kr.or.kosta.betting.memberbetdata.test;

import java.util.List;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.memberbetdata.MemberBetData;
import kr.or.kosta.betting.memberbetdata.MemberBetDataDAO;

import org.junit.Test;

public class MemberBatDataDAOTest {

	@Test
	public void testInsultMemberBetData(){
		MemberBetData mbd = new MemberBetData();
		mbd.setBetMineral(700);
		
		Member member = new Member();
		member.setId("jun1");
		
		Betting betting = new Betting();
		betting.setNum("5");
		
		mbd.setBetting(betting);
		mbd.setMember(member);
		
		MemberBetDataDAO.insultMemberBetData(mbd);
	}
//	@Test
//	public void testSelectMemberBetDataList(){
//		List<MemberBetData> page1List = 
//				MemberBetDataDAO.selectMemberBetDataList(1, 5);
//		System.out.println("page1List:" + page1List);
//		List<MemberBetData> page2List = 
//				MemberBetDataDAO.selectMemberBetDataList(2, 5);
//		System.out.println("page2List:" + page2List);
//	}
	@Test
	public void testSelectMemberBetDataListByID(){
		List<MemberBetData> page1List = 
				MemberBetDataDAO.selectMemberBetDataListByID(1,5,"jun1");
		System.out.println("page1List:" + page1List);
		List<MemberBetData> page2List = 
				MemberBetDataDAO.selectMemberBetDataListByID(2,5,"jun1");
		System.out.println("page2List:" + page2List);
	}
	@Test
	public void testDeleteMemberBetData(){
		MemberBetDataDAO.deleteMemberbetData("157");
		
	}
	@Test
	public void testSelectMemberBetDataByIDCount(){
		long idcount = MemberBetDataDAO
					.selectMemberBetDataByIDCount("jun1");
		System.out.println(idcount);
	}
	@Test
	public void testUpdateMemberBatData(){
		MemberBetDataDAO.updateMemberBetData("14");
	}
	
	@Test
	public void testSelectMatchNum(){
		String num = MemberBetDataDAO.selectMatchNum("14");
		System.out.println(num);
	}
	@Test
	public void testSelectMemberBetData(){
		MemberBetData mbd = 
				MemberBetDataDAO.selectMemberBetData("14");
		System.out.println(mbd);
	}
	
	@Test
	public void testSelectMineralConfirm(){
		int confirm = MemberBetDataDAO.selectMineralConfirm("2");
		System.out.println(confirm);
	}
}
