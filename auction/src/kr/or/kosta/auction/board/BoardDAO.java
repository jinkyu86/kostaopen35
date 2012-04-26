package kr.or.kosta.auction.board;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

//import kr.or.kosta.util.ConnectionUtil;

public class BoardDAO extends SqlSessionDaoSupport implements IBoardDAO {
	@Override
	public String insertBoard(Board board) {
		SqlSession session = null;
		session = getSqlSession();
		session.insert("Board.insertBoard", board);
		return board.getbNum();
	}

	@Override
	public void updateBoard(Board board) {
		SqlSession session = null;
		session = getSqlSession();
		session.insert("Board.updateBoard", board);

	}

	@Override
	public void deleteBoard(String boardno) {
		SqlSession session = null;
		session = getSqlSession();
		session.delete("Board.deleteBoard", boardno);
	}

	@Override
	public Board selectBoard(String boardno) {
		SqlSession session = null;
		Board board = null;
		session = getSqlSession();
		board = session.selectOne("selectBoard", boardno);

		return board;
	}

	@Override
	public List<Board> selectBoardList() {
		SqlSession session = null;
		List<Board> boardList = null;
		session = getSqlSession();
		boardList = session.selectList("selectBoardList");

		return boardList;
	}

	@Override
	public List<Board> selectBoardList(int page, int length) {
		SqlSession session = null;
		List<Board> boardList = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds((page - 1) * length, length);
		boardList = session.selectList("selectBoardList", null, rowBounds);

		return boardList;
	}

	@Override
	public int selectBoardCount() {
		SqlSession session = null;
		int count = 0;
		session = getSqlSession();
		count = session.selectOne("selectBoardCount");

		return count;
	}

	@Override
	public int selectBoardListByTitleCount(String title) {
		SqlSession session = null;
		int count = 0;
		session = getSqlSession();
		count = session.selectOne("selectBoardListByTitleCount", "%" + title
				+ "%");

		return count;
	}

	@Override
	public int selectBoardListByUseridCount(String userid) {
		SqlSession session = null;
		int count = 0;
		session = getSqlSession();
		count = session.selectOne("selectBoardListByUseridCount", "%" + userid
				+ "%");

		return count;
	}

	@Override
	public List<Board> selectBoardListByTitle(int page, int length, String title) {
		SqlSession session = null;
		List<Board> boardList = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds((page - 1) * length, length);
		boardList = session.selectList("selectBoardListByTitle", "%" + title
				+ "%", rowBounds);

		return boardList;
	}

	@Override
	public List<Board> selectBoardListByUserid(int page, int length,
			String userid) {
		SqlSession session = null;
		List<Board> boardList = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds((page - 1) * length, length);
		boardList = session.selectList("selectBoardListByUserid", "%" + userid
				+ "%", rowBounds);

		return boardList;
	}
}
