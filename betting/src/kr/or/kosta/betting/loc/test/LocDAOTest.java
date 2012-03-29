package kr.or.kosta.betting.loc.test;

import java.util.ArrayList;

import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.loc.LocDAO;

import org.junit.Test;

public class LocDAOTest {

	@Test
	public void testSelectLocList() {
		ArrayList<Loc> locList = LocDAO.selectLocList();
		for(int i=0;i<locList.size();i++){
			Loc loc =locList.get(i);
			System.out.println(loc);
		}
	}
	
	@Test
	public void testSelectLoc(){
		Loc loc = LocDAO.selectLoc("15");
		System.out.println(loc);
	}

}
