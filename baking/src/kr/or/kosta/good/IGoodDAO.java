package kr.or.kosta.good;

import java.util.List;

public interface IGoodDAO {

	void deleteGood(int goodnum);
	void updateGood(Good good);
	
	int insertGood(Good good);
	
	Good selectGood(int goodNum);

	List<Good> selectGoodList();
	List<Good> selectRecipeList(int recipeNum);
	List<Good> viewDivisionGoodList(int division);

}
