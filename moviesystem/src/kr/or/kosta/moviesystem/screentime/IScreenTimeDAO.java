package kr.or.kosta.moviesystem.screentime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IScreenTimeDAO {

	void insertScreenTime(Date time);

	ScreenTime selectScreenTimeScrNum(String time);

	ScreenTime selectScreenTimeBySrcNum(String scrnum);

	List<ScreenTime> selectScreen(String mnum);
}
