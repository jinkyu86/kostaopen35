package kr.or.kosta.betting.match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.betting.util.ConnectionUtil;



public class MatchDAO {

	/**
	 * 매치의 모든 데이터 리스트 조회 메서드
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
			
		//rs.absolute()가 가능하도록 설정
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			//가져온 레코드 개수
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
	 * 선택한 날짜에 하는 경기 데이터 조회 메서드
	 * 
	 * @param Date
	 */
	public ArrayList selectMatchByDate(Date Date) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 선택한 매치 번호의 데이터 조회 메서드
	 * 
	 * @param num
	 * @param score
	 * @param winNum
	 */
	public void updateMatch(String num, String score, String winNum) {
		/* default generated stub */;
		
	}

	/**
	 * 매치 데이서 삽입 메서드
	 * 
	 * @param match
	 */
	public void insertMatch(Match match) {
		/* default generated stub */;
	
	}

	/**
	 * 페이지 설정을 위한 카운터 메서드
	 */
	public int countMatch() {
		/* default generated stub */;
		return 0;
	}

	/**
	 * 선택된 날짜의 경기의 수만큼 카운터하는 메서드
	 * 
	 * @param date
	 */
	public int countMatchByDate(Date date) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * 선택된 팀번호의 이긴팀 번호를 조회하는 메서드
	 * 
	 * @param matchnum
	 */
	public String selectWinTeam(String matchnum) {
		/* default generated stub */;
		return null;
	}
}
