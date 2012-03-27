package kr.or.kosta.moviesystem.movie;



import java.sql.Date;

import kr.or.kosta.moviesystem.screentime.ScreenTime;

public class Movie {

	public ScreenTime screenTime;

	/**
	 * 영화번호
	 */
	private String mnum;

	/**
	 * 영화이름
	 */
	private String mname;

	/**
	 * 개봉일
	 */
	private String launchDate;

	/**
	 * 영화내용
	 */
	private String content;

	/**
	 * 영화장르
	 */
	private String genre;

	/**
	 * 영화 포스터
	 */
	private String poster;

	/**
	 * 영화 내리는 날짜
	 */
	private String endDate;

	/**
	 * 영화 가격
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

	public String getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(String launchDate) {
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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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
