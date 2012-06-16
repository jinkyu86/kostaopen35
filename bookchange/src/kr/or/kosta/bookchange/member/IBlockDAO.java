package kr.or.kosta.bookchange.member;

import java.util.List;

public interface IBlockDAO {



	void insertBlock(Block block);

	Block viewBlock(String blockNo);

	List<Block> selectBlockbyResult(int length, int page, String resultNo);

	int selectBlockbyResultCount(String resultNo);
	
	int selectBlockbyResultCounting(String resultNo);
	


	int selectBlockCount();
	
	int selectBlockbyResultCount(int resultNo);

	List<Block> selectBlockbyResulting(int length, int page, String resulting);

	
	void updateBlock(Block block);

	List<Block> selectMyBlockList(int length, int page, String email);

	List<Block> selectBlockList(int page, int length);





}
