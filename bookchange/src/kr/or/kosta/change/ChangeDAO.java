package kr.or.kosta.change;

import java.util.ArrayList;

public class ChangeDAO {

	/**��ȯ����Ʈ ����**/
	public ArrayList selectChangeList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**��� �� ��ȯ �� ����**/
	public int selectChangeCount() {
		int changeCount=0;
		/* default generated stub */;
		return changeCount;
	}

	/**�� �Խù���ȣ�� ��ȯ����Ʈ �˻�(������ ��ȯ�� ��û�� ����� �˻�)**/
	public ArrayList selectChangeMyboardList(int length, int page,
			String boardNo) {
		return null;
	}

	/**�� �Խù� ��ȣ�� �˻��� �Խù� �� ����**/
	public int selectChangeMyboardCount(String boardNo) {
		return 0;
	}

	/**���� ��ȯ�� ��û�� ��� �˻�(���� email�� ��ȸ)**/
	public ArrayList selectChangeRequestList(int length, int page, String email) {
		return null;
	}

	/**���� ��ȯ�� ��û�� ����� �� ����**/
	public int selectChangeRequestCount(String email) {
		return 0;
	}

	/**��ȯ���� ����**/
	public Change selectChange(String changeNo) {
		return null;
	}

	/**��ȯ ����Ʈ�� �߰�(��ȯ��û Ŭ����)**/
	public void insertChange(Change change) {
	}

	/**��ȯ����Ʈ ����(��ȯ����� �����Ҷ� ���,��ȯ������,�Ϸ�ƴ������)**/
	public Change updateChange(String changeNo) {
		return null;
	}

	/**��ȯ����Ʈ���� ����**/
	public void deleteChange(String changeNo) {
		
	}
}
