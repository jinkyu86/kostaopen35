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

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.util.ConnectionUtil;

public class BidDAO implements IBidDAO {
	private static String resource = "sqlmap-config.xml";
	private static Reader sqlReader;
	static {
		try {
			sqlReader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
			.build(sqlReader);
	@Override
	public void insertBid(Bid bid) {
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			session.insert("Bid.insertBid", bid);
		} finally {
			session.close();
		}
	}
	@Override
	public void updateBid(Bid bid) {
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			session.update("Bid.updateBid", bid);
		} finally {
			session.close();
		}
	}
	@Override
	public Bid selectBid(String bidNum) {
		SqlSession session = null;
		Bid bid = null;
		try {
			session = sqlMapper.openSession(true);
			bid = session.selectOne("Bid.selectBid", bidNum);
		} finally {
			session.close();
		}
		return bid;
	}
	@Override
	public List<Bid> selectBidList() {
		SqlSession session = null;
		List<Bid> bidList = null;
		try {
			session = sqlMapper.openSession(true);
			bidList = session.selectList("Bid.selectBidList");
		} finally {
			session.close();
		}
		return bidList;
	}
	@Override
	public List<Bid> selectBidList(int length, int page) {
		SqlSession session = null;
		List<Bid> bidList = null;
		try {
			session = sqlMapper.openSession(true);
			RowBounds rowBounds = new RowBounds((page - 1) * length, length);
			bidList = session.selectList("Bid.selectBidList", null, rowBounds);
		} finally {
			session.close();
		}
		return bidList;
	}
	@Override
	public List<Bid> selectBidListByID(int length, int page, String userid) {
		SqlSession session = null;
		List<Bid> bidList = null;
		try {
			session = sqlMapper.openSession(true);
			RowBounds rowBounds = new RowBounds((page - 1) * length, length);
			bidList = session.selectList("Bid.selectBidListByID", userid,
					rowBounds);
		} finally {
			session.close();
		}
		return bidList;
	}
	@Override
	public List<Bid> selectBidListByAuctionNum(String aNum, int size) {
		SqlSession session = null;
		List<Bid> bidList = null;
		try {
			session = sqlMapper.openSession(true);
			RowBounds rowBounds = new RowBounds(0, size);
			bidList = session.selectList("Bid.selectBidListByAuctionNum", aNum,
					rowBounds);
		} finally {
			session.close();
		}
		return bidList;
	}
	@Override
	public void deleteBidById(String userid) {
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			session.delete("Bid.deleteBidById", userid);
		} finally {
			session.close();
		}
	}

	// ID���� ȯ�ҿϷ� ǥ��
	@Override
	public void updateMoneybackById(String userid) {
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			session.update("Bid.updateMoneybackById", userid);
		} finally {
			session.close();
		}
	}

	// �ش����� ID���� ȯ�ҿϷ� ǥ��
	@Override
	public void updateMoneybackByIdInAuction(String userid, String aNum) {
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			HashMap<String, String> parameters = new HashMap<String, String>();
			parameters.put("userid", userid);
			parameters.put("aNum", aNum);
			session.update("Bid.updateMoneybackById", parameters);
		} finally {
			session.close();
		}
	}
	@Override
	public int selectMoneybackByIdCount(String userid) {
		SqlSession session = null;
		Integer count = null;
		try {
			session = sqlMapper.openSession(true);
			count = session.selectOne("Bid.selectMoneybackByIdCount", userid);

		} finally {
			// Connection�� ConnectionPool�� �ݳ�
			session.close();
		}
		return count;
	}

}
