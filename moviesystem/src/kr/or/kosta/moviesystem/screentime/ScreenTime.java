package kr.or.kosta.moviesystem.screentime;

import java.util.Date;

public class ScreenTime {

	private Number scrnum;//��ȭ�ð���ȣ
	private Date time;//��ȭ�����ð�
	public Number getScrnum() {
		return scrnum;
	}
	public void setScrnum(Number scrnum) {
		this.scrnum = scrnum;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ScreenTime [scrnum=" + scrnum + ", time=" + time + "]";
	}

}
