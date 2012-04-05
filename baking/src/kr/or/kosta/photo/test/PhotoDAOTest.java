package kr.or.kosta.photo.test;

import static org.junit.Assert.*;
import kr.or.kosta.gooddivision.Good_division;
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
		
		photo.setImage("test.jpg");
		Good_division good_division =new Good_division();
		good_division.setDivision(1);
		photo.setGood_division(good_division);
		PhotoDAO.insertPhoto(photo,30);
		
	}

}
