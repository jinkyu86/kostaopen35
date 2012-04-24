package kr.or.kosta.betting.loc.test;

import java.util.List;

import kr.or.kosta.betting.loc.ILoc;
import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.loc.LocDAO;

import org.junit.Test;

public class LocDAOTest {
	
	private ILoc locDAO;
	

	public LocDAOTest(ILoc locDAO) {
		super();
		this.locDAO = locDAO;
	}

	@Test
	public void testSelectLocList() {
		List<Loc> locList = locDAO.selectLocList();
		for(int i=0;i<locList.size();i++){
			Loc loc =locList.get(i);
			System.out.println(loc);
		}
	}
	
	@Test
	public void testSelectLoc(){
		Loc loc = locDAO.selectLoc("15");
		System.out.println(loc);
	}

}
