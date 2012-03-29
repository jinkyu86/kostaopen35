package kr.or.kosta.moviesystem.reservation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.screentime.ScreenTime;

import org.junit.Test;

public class ReservationDAOTest {

//	@Test
//	public void testInsertReservation() {
//		Reservation reservation = new Reservation();
//		
//		Movie movie =new Movie();
//		movie.setMnum("1");
//		reservation.setMovie(movie);
//		
//		Member member=new Member();
//		member.setUserid("jun123");
//		reservation.setMember(member);
//		
//		ScreenTime screenTime=new ScreenTime();
//		screenTime.setScrnum("1");
//		reservation.setScreenTime(screenTime);
//		reservation.setResQty(1);
//		reservation.setTotalPrice(8000);
//		reservation.setPayState(1);
//		reservation.setSeatnum(28);
//		
//		ReservationDAO.insertReservation(reservation);
//	}
//	@Test
//	public void testUpdateReservation(){
//		Reservation reservation = new Reservation();
//		
//		Movie movie =new Movie();
//		movie.setMnum("2");
//		reservation.setMovie(movie);
//		
//		ScreenTime screenTime=new ScreenTime();
//		screenTime.setScrnum("2");
//		reservation.setScreenTime(screenTime);
//		
//		reservation.setResnum("1");
//		
//		ReservationDAO.updateReservation(reservation);
//		
//	}
//	@Test
//	public void testRemoveReservation(){
//		Reservation reservation = new Reservation();
//		
//		reservation.setPayState(0);
//		reservation.setResnum("2");
//		
//		ReservationDAO.removeReservation(reservation);
//		
//	}
////	@Test
////	public void testDeleteStudent(){
////		StudentDAO.deleteStudent("40101");
////		
////	}
//	@Test
//	public void testReservationList(){
//		ArrayList<Reservation>reservationList = ReservationDAO.selectReservationList("jun123");
//		for(int i =0;i<reservationList.size();i++){
//			Reservation reservation = reservationList.get(i);
//			System.out.println(reservation);
//		}//end for
//	}//end method
////	@Test
////	public void testSelectstudent(){
////		
////		Student student = StudentDAO.selectStudent("10201");
////		System.out.println(student);
////		
////	}
}//end class
