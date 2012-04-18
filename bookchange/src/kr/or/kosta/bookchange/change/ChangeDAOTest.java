package kr.or.kosta.bookchange.change;

import java.util.List;

import kr.or.kosta.bookchange.board.Board;

import org.junit.Test;

public class ChangeDAOTest {

	@Test
	public void testInsertChange() {
		Board agreeBoard=new Board();
		Board demandBoard=new Board();
		agreeBoard.setBoardNo(11);
		demandBoard.setBoardNo(13);
		
		Change change=new Change();
		change.setAgreeBoard(agreeBoard);
		change.setDemandBoard(demandBoard);
		
		ChangeDAO.insertChange(change);
	}

	@Test
	public void testMatchChange() {
		Board agreeBoard=new Board();
		Board demandBoard=new Board();
		agreeBoard.setBoardNo(11);
		demandBoard.setBoardNo(13);
		
		Change change=new Change();
		change.setAgreeBoard(agreeBoard);
		change.setDemandBoard(demandBoard);
		
		ChangeDAO.matchChange(change);
	}

	@Test
	public void testCancelChange() {
		int boardNo=13;
		ChangeDAO.cancelChange(boardNo);
	}

	@Test
	public void testCompleteChange() {
		int ChangeNo=13;
		int BoardNo=11;
		ChangeDAO.completeChange(ChangeNo, BoardNo);
	}

	@Test
	public void testselectChangeRequestListIntIntString() {
		int page=1;
		int length=5;
		String email="shego@naver.com";
		List<Change> changeList=ChangeDAO.selectChangeRequestList(length, page, email);
		for(int i=0; i<changeList.size(); i++){
			Change change=changeList.get(i);
			System.out.println(change);
		}
	}

	@Test
	public void testselectChangeRequestListCountString() {
		String email="shego@naver.com";
		int count=ChangeDAO.selectChangeRequestCount(email);
		System.out.println(count);
	}

	@Test
	public void testselectChangeMyboardListIntIntString() {
		int page=1;
		int length=5;
		String email="gohome@naver.com";
		List<Change> changeList=ChangeDAO.selectChangeMyboardList(length, page, email);
		for(int i=0; i<changeList.size(); i++){
			Change change=changeList.get(i);
			System.out.println(change);
		}
	}

	@Test
	public void testselectChangeMyboardListCountString() {
		String email="gohome@naver.com";
		int count=ChangeDAO.selectChangeMyboardCount(email);
		System.out.println(count);
	}

	@Test
	public void testselectMatchListIntIntString() {
		int page=1;
		int length=5;
		String email="gohome@naver.com";
		List<Change> changeList=ChangeDAO.selectMatchList(length, page, email);
		for(int i=0; i<changeList.size(); i++){
			Change change=changeList.get(i);
			System.out.println(change);
		}
	}

	@Test
	public void testselectMatchListCountString() {
		String email="gohome@naver.com";
		int count=ChangeDAO.selectMatchListCount(email);
		System.out.println(count);
	}

	@Test
	public void testDeleteChangeInt() {
		int boardNo=11;
		ChangeDAO.deleteChange(boardNo);
	}

	@Test
	public void testselectMatchResultListIntIntString() {
		int page=1;
		int length=5;
		String email="gohome@naver.com";
		List<Change> changeList=ChangeDAO.selectMatchResultList(length, page, email);
		for(int i=0; i<changeList.size(); i++){
			Change change=changeList.get(i);
			System.out.println(change);
		}
	}

	@Test
	public void testselectMatchResultListCountString() {
		String email="gohome@naver.com";
		int count=ChangeDAO.selectMatchResultListCount(email);
		System.out.println(count);
	}

}
