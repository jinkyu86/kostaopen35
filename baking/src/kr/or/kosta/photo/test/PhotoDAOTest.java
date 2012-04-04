package kr.or.kosta.photo.test;

import static org.junit.Assert.*;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;

import org.junit.Test;

public class PhotoDAOTest {

//	@Test
//	public void testSelectGoodPhotoList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectRecipePhotoList() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testInsertPhoto() {
		Photo photo=new Photo();
		photo.setP_num(1000);
		photo.setRecipe_num(30);
		photo.setImage("asd");
		photo.setDivision(3);
		PhotoDAO.insertPhoto(photo,30);
		System.out.println(photo);
	}

}
