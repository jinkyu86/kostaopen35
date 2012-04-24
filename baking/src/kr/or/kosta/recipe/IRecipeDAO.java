package kr.or.kosta.recipe;

import java.util.List;

public interface IRecipeDAO {

	void insertRecipe(Recipe recipe);
	void updateRecipe(Recipe recipe);
	void deleteRecipe(int recipenum);
	
	int maxRecipeNumber();

	Recipe selectRecipe(int recipe_num);
	
	List<Recipe> selectRecipeList();
	List<Recipe> selectDivisionRecipeList(int divisionNum);
	List<Recipe> selectGoodRelationRecipeList(int goodNum);

}
