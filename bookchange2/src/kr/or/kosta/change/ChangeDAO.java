package kr.or.kosta.change;

public class ChangeDAO {

	/**
	 * ��ȯ����Ʈ ����
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList selectChangeList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ü ��ȯ �� ����
	 */
	public int selectChangeCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * �� �Խù���ȣ�� ��ȯ����Ʈ �˻�(������ ��ȯ�� ��û�� ����� �˻�)
	 * 
	 * @param length
	 * @param page
	 * @param boardNo
	 */
	public ArrayList selectChangeMyboardList(int length, int page,
			String boardNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �� �Խù� ��ȣ�� �˻��� �Խù� �� ����
	 * 
	 * @param boardNo
	 */
	public int selectChangeMyboardCount(String boardNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���� ��ȯ�� ��û�� ��� �˻�(���� email�� ��ȸ)
	 * 
	 * @param length
	 * @param page
	 * @param email
	 */
	public ArrayList selectChangeRequestList(int length, int page, String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���� ��ȯ�� ��û�� ����� �� ����
	 * 
	 * @param email
	 */
	public int selectChangeRequestCount(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȯ���� ����
	 * 
	 * @param changeNo
	 */
	public Change selectChange(String changeNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȯ ����Ʈ�� �߰�(��ȯ��û Ŭ����)
	 * 
	 * @param change
	 */
	public void insertChange(Change change) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȯ����Ʈ ����(��ȯ����� �����Ҷ� ���,��ȯ������,�Ϸ�ƴ������)
	 * 
	 * @param changeNo
	 */
	public Change updateChange(String changeNo) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȯ����Ʈ���� ����
	 * 
	 * @param changeNo
	 */
	public void deleteChange(String changeNo) {
		/* default generated stub */;
		return null;
	}
}
