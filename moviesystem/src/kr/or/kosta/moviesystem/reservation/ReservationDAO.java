package kr.or.kosta.moviesystem.reservation;

public class ReservationDAO {

	/**
	 * ��ȭ�� ������ �����Ͽ� ����ϴ� ���
	 * 
	 * @param reservation
	 */
	public void insertReservation(Reservation reservation) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ�����̵�� ���ų����� ã�� �� �ִ� �޼���
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
	 * ȸ�����̵�� ã�� ���Ÿ���� ���� ã�� �� �ִ� ���
	 * 
	 * @param userid
	 */
	public int selectReservationCount(String userid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ��ȣ�� �󿵽ð����� ������ ���� Ȯ���� �� �ִ� ���
	 * 
	 * @param scrnum
	 * @param mnum
	 */
	public int selectReservationSeatCount(Number scrnum, Number mnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �����ȣ�� ȸ����ȣ�� ����� ������ ã�� �� �ִ� ���
	 * 
	 * @param userid
	 * @param resnum
	 */
	public Reservation selectReservation(String userid, int resnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ��� ���� ���
	 * 
	 * @param userid
	 * @param resnum
	 */
	public void removeReservation(String userid, int resnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ��� ������Ʈ(����) ���
	 * 
	 * @param reservation
	 */
	public void updateReservation(Reservation reservation) {
		/* default generated stub */;
		return null;
	}
}
