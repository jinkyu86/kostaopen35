package kr.or.kosta.betting.memberbetdata.test;

import java.util.ArrayList;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.memberbetdata.MemberBetData;
import kr.or.kosta.betting.memberbetdata.MemberBetDataDAO;

import org.junit.Test;

public class MemberBatDataDAOTest {

	@Test
	public void testInsultMemberBetData(){
		MemberBetData mbd = new MemberBetData();
		mbd.setBetMineral(100);
		
		Member member = new Member();
		member.setID("jun1");
		
		Betting betting = new Betting();
		betting.setNum("5");
		
		mbd.setBetting(betting);
		mbd.setMember(member);
		
		MemberBetDataDAO.insultMemberBetData(mbd);
	}
	@Test
	public void testSelectMemberBetDataList(){
		ArrayList<MemberBetData> page1List = 
				MemberBetDataDAO.selectMemberBetDataList(1, 5);
		System.out.println("page1List:" + page1List);
		ArrayList<MemberBetData> page2List = 
				MemberBetDataDAO.selectMemberBetDataList(2, 5);
		System.out.println("page2List:" + page2List);
	}
	@Test
	public void testSelectMemberBetDataListByID(){
		ArrayList<MemberBetData> page1List = 
				MemberBetDataDAO.selectMemberBetDataListByID(1,5,"jun1");
		System.out.println("page1List:" + page1List);
		ArrayList<MemberBetData> page2List = 
				MemberBetDataDAO.selectMemberBetDataListByID(2,5,"jun1");
		System.out.println("page2List:" + page2List);
	}
	@Test
	public void testDeleteMemberBetData(){
		MemberBetDataDAO.deleteMemberbetData("16");
		
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
}
