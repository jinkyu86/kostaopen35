package kr.or.kosta.moviesystem.reservation;

import java.util.ArrayList;
import java.util.List;


public interface IReservationDAO {

	void insertReservation(Reservation reservation);

	List<Reservation> selectReservationList(int length, int page,
			String memberid);

	List<Reservation> selectReservationTime(String userid, String mnum);

	ArrayList<Reservation> selectReservationList(String memberid);

	int selectReservationCount(String userid);

	long selectReservationSeatNum(long Res_num);

	long selectReservationQty(long res_num);

	String selectReservationResNum(String scr_num);

	Reservation selectReservation(String resnum);

	void removeReservation(String resnum);

	void updateReservation(Reservation reservation);

	void cancelReservation(String resnum);

	List<Reservation> selectSeatNumByScrnumAndUserid(String scrnum,
			String userid);

	List selectSeatNumByScrnum(String scrnum);

	List selectTotalList(String scrnum);
	
	int selectReservationSeatCount(String mnum, String scrnum);
}
