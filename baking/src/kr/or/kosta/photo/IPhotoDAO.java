package kr.or.kosta.photo;

import java.util.List;

public interface IPhotoDAO {

	void insertPhoto(Photo photo);
	
	List<Photo> selectGoodPhotoList(int goodNum);
	List<Photo> selectRecipePhotoList(int recipeNum);

	

}
