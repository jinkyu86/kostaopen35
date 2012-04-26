package kr.or.kosta.auction.bid;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.util.ConnectionUtil;

public class BidDAO extends SqlSessionDaoSupport implements IBidDAO {
	@Override
	public void insertBid(Bid bid) {
		SqlSession session = null;
		session = getSqlSession();

	}

	@Override
	public void updateBid(Bid bid) {
		SqlSession session = null;
		session = getSqlSession();
		session.update("Bid.updateBid", bid);
	}

	@Override
	public Bid selectBid(String bidNum) {
		SqlSession session = null;
		Bid bid = null;
		session = getSqlSession();
		bid = session.selectOne("Bid.selectBid", bidNum);

		return bid;
	}

	@Override
	public List<Bid> selectBidList() {
		SqlSession session = null;
		List<Bid> bidList = null;
		session = getSqlSession();
		bidList = session.selectList("Bid.selectBidList");

		return bidList;
	}

	@Override
	public List<Bid> selectBidList(int length, int page) {
		SqlSession session = null;
		List<Bid> bidList = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds((page - 1) * length, length);
		bidList = session.selectList("Bid.selectBidList", null, rowBounds);

		return bidList;
	}

	@Override
	public List<Bid> selectBidListByID(int length, int page, String userid) {
		SqlSession session = null;
		List<Bid> bidList = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds((page - 1) * length, length);
		bidList = session
				.selectList("Bid.selectBidListByID", userid, rowBounds);

		return bidList;
	}

	@Override
	public List<Bid> selectBidListByAuctionNum(String aNum, int size) {
		SqlSession session = null;
		List<Bid> bidList = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds(0, size);
		bidList = session.selectList("Bid.selectBidListByAuctionNum", aNum,
				rowBounds);

		return bidList;
	}

	@Override
	public void deleteBidById(String userid) {
		SqlSession session = null;
		session = getSqlSession();
		session.delete("Bid.deleteBidById", userid);

	}

	// ID별로 환불완료 표시
	@Override
	public void updateMoneybackById(String userid) {
		SqlSession session = null;
		session = getSqlSession();
		session.update("Bid.updateMoneybackById", userid);

	}

	// 해당경매의 ID별로 환불완료 표시
	@Override
	public void updateMoneybackByIdInAuction(String userid, String aNum) {
		SqlSession session = null;
		session = getSqlSession();
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("userid", userid);
		parameters.put("aNum", aNum);
		session.update("Bid.updateMoneybackById", parameters);

	}

	@Override
	public int selectMoneybackByIdCount(String userid) {
		SqlSession session = null;
		Integer count = null;
		session = getSqlSession();
		count = session.selectOne("Bid.selectMoneybackByIdCount", userid);

		return count;
	}

}
