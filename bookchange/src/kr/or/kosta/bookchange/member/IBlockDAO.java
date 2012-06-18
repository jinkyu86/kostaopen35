package kr.or.kosta.bookchange.member;

import java.util.List;

public interface IBlockDAO {

	List<Block> selectMyBlockList(int length, int page, String email);

	List<Block> selectBlockList(int page, int length);

	int selectBlockCount();

	void insertBlock(Block block);

	void updateBlock(Block block);

	void deleteBlock(int blockNo);


	int selectBlockbyResultCount(int resultNo);

	List<Block> selectBlockbyResult(int length, int page, String resultNo);


	
}
