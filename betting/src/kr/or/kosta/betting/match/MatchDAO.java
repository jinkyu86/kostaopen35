package kr.or.kosta.betting.match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.betting.util.ConnectionUtil;



public class MatchDAO {

	/**
	 * ��ġ�� ��� ������ ����Ʈ ��ȸ �޼���
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList<Match> selectMatchList(int page, int length) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		ArrayList<Match>studentList=new ArrayList<Match>();
				
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT match_num,match_time,match_result_score,home_team_num"+
				" FROM tb_student s,tb_department d"+
				" WHERE s.deptno=d.deptno";
			
		//rs.absolute()�� �����ϵ��� ����
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			//������ ���ڵ� ����
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String studno=rs.getString(1);
				String name = rs.getString(2);
				String userid = rs.getString(3);
				String pw = rs.getString(4);
				String deptno = rs.getString(5);
				String dname = rs.getString(6);
				String loc=rs.getString(7);
				
				Student student = new Student();
				student.setStudno(studno);
				student.setName(name);
				student.setUserid(userid);
				student.setPw(pw);
				
				Department department = new Department();
				department.setDeptno(deptno);
				department.setDname(dname);
				department.setLoc(loc);
				
				student.setDepartment(department);
				
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	/**
	 * ������ ��¥�� �ϴ� ��� ������ ��ȸ �޼���
	 * 
	 * @param Date
	 */
	public ArrayList selectMatchByDate(Date Date) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ������ ��ġ ��ȣ�� ������ ��ȸ �޼���
	 * 
	 * @param num
	 * @param score
	 * @param winNum
	 */
	public void updateMatch(String num, String score, String winNum) {
		/* default generated stub */;
		
	}

	/**
	 * ��ġ ���̼� ���� �޼���
	 * 
	 * @param match
	 */
	public void insertMatch(Match match) {
		/* default generated stub */;
	
	}

	/**
	 * ������ ������ ���� ī���� �޼���
	 */
	public int countMatch() {
		/* default generated stub */;
		return 0;
	}

	/**
	 * ���õ� ��¥�� ����� ����ŭ ī�����ϴ� �޼���
	 * 
	 * @param date
	 */
	public int countMatchByDate(Date date) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * ���õ� ����ȣ�� �̱��� ��ȣ�� ��ȸ�ϴ� �޼���
	 * 
	 * @param matchnum
	 */
	public String selectWinTeam(String matchnum) {
		/* default generated stub */;
		return null;
	}
}
