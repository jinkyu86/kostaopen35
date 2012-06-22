package kr.or.kosta.moviesystem.movie;



import java.io.Serializable;
import java.util.Date;

import kr.or.kosta.moviesystem.screentime.ScreenTime;

public class Movie implements Serializable{

	public ScreenTime screenTime;

	/**
	 * ��ȭ��ȣ
	 */
	private String mnum;

	/**
	 * ��ȭ�̸�
	 */
	private String mname;

	/**
	 * ������
	 */
	private Date launchDate;

	/**
	 * ��ȭ����
	 */
	private String content;

	/**
	 * ��ȭ�帣
	 */
	private String genre;

	/**
	 * ��ȭ ������
	 */
	private String poster;

	/**
	 * ��ȭ ������ ��¥
	 */
	private Date endDate;

	/**
	 * ��ȭ ����
	 */
	private long mprice;
	
	private long mResCount;

	public ScreenTime getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(ScreenTime screenTime) {
		this.screenTime = screenTime;
	}

	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getMprice() {
		return mprice;
	}

	public void setMprice(long mprice) {
		this.mprice = mprice;
	}

	public long getMResCount(){
		return mResCount;
	}
	
	public void setMResCount(long mResCount){
		this.mResCount=mResCount;
	}
	@Override
	public String toString() {
		return "Movie [screenTime=" + screenTime + ", mnum=" + mnum
				+ ", mname=" + mname + ", launchDate=" + launchDate
				+ ", content=" + content + ", genre=" + genre + ", poster="
				+ poster + ", endDate=" + endDate + ", mprice=" + mprice + ", mResCount=" + mResCount + "]";
	}
	
	
}