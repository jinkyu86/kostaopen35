package kr.or.kosta.moviesystem.reservation;

public class ReservationDAO {

	/**
	 * 영화를 선택해 예약목록에 등록하는 기능
	 * 
	 * @param reservation
	 */
	public void insertReservation(Reservation reservation) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원아이디로 예매내역을 찾을 수 있는 메서드
	 * 
	 * @param length
	 * @param page
	 * @param memberid
	 */
	public ArrayList selectReservationList(int length, int page, String memberid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원아이디로 찾은 예매목록의 수를 찾을 수 있는 기능
	 * 
	 * @param userid
	 */
	public int selectReservationCount(String userid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화번호와 상영시간으로 예약한 수를 확인할 수 있는 기능
	 * 
	 * @param scrnum
	 * @param mnum
	 */
	public int selectReservationSeatCount(Number scrnum, Number mnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 예약번호와 회원번호로 예약된 정보를 찾을 수 있는 기능
	 * 
	 * @param userid
	 * @param resnum
	 */
	public Reservation selectReservation(String userid, int resnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화목록 삭제 기능
	 * 
	 * @param userid
	 * @param resnum
	 */
	public void removeReservation(String userid, int resnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화목록 업데이트(수정) 기능
	 * 
	 * @param reservation
	 */
	public void updateReservation(Reservation reservation) {
		/* default generated stub */;
		return null;
	}
}
