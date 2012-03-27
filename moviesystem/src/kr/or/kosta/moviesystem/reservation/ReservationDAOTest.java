package kr.or.kosta.moviesystem.reservation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.screentime.ScreenTime;

import org.junit.Test;

public class ReservationDAOTest {

	@Test
	public void testInsertReservation() {
		Reservation reservation = new Reservation();
		
		Movie movie =new Movie();
		movie.setMnum("1");
		reservation.setMovie(movie);
		
		Member member=new Member();
		member.setUserid("jun123");
		reservation.setMember(member);
		
		ScreenTime screenTime=new ScreenTime();
		screenTime.setScrnum("1");
		reservation.setScreenTime(screenTime);
		reservation.setResQty(1);
		reservation.setTotalPrice(8000);
		reservation.setPayState(1);
		reservation.setSeatnum(28);
		
		ReservationDAO.insertReservation(reservation);
	}
//	@Test
//	public void testUpdateStudent(){
//		Student student = new Student();
//		student.setStudno("40101");
//		student.setName("È«±æ¼ø");
//		student.setUserid("gilsun");
//		student.setPw("0070");
//		
//		Department department = new Department();
//		department.setDeptno("102");
//		
//		student.setDepartment(department);
//		
//		StudentDAO.updateStudent(student);
//		
//	}
//	@Test
//	public void testDeleteStudent(){
//		StudentDAO.deleteStudent("40101");
//		
//	}
//	@Test
//	public void testStudentList(){
//		ArrayList<Student>studentList = StudentDAO.selectStudentList();
//		for(int i =0;i<studentList.size();i++){
//			Student student = studentList.get(i);
//			System.out.println(student);
//		}//end for
//	}//end method
//	@Test
//	public void testSelectstudent(){
//		
//		Student student = StudentDAO.selectStudent("10201");
//		System.out.println(student);
//		
//	}
}//end class
