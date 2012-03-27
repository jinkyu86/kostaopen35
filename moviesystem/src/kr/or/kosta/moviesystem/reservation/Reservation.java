package kr.or.kosta.moviesystem.reservation;

import java.util.Date;

import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.screentime.ScreenTime;

public class Reservation {
	private String resnum;//예약번호
	private Date resDate;//예약날짜
	private long resQty;//예매수량
	private long payState;//결제상태
	private long totalPrice;//전체가격
	public ScreenTime screenTime;
	public Movie movie;
	public Member member;
	
	public String getResnum() {
		return resnum;
	}
	public void setResnum(String resnum) {
		this.resnum = resnum;
	}
	public Date getResDate() {
		return resDate;
	}
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	public long getResQty() {
		return resQty;
	}
	public void setResQty(long resQty) {
		this.resQty = resQty;
	}
	public long getPayState() {
		return payState;
	}
	public void setPayState(long payState) {
		this.payState = payState;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ScreenTime getScreenTime() {
		return screenTime;
	}
	public void setScreenTime(ScreenTime screenTime) {
		this.screenTime = screenTime;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Reservation [resnum=" + resnum + ", resDate=" + resDate
				+ ", resQty=" + resQty + ", payState=" + payState
				+ ", totalPrice=" + totalPrice + ", screenTime=" + screenTime
				+ ", movie=" + movie + ", member=" + member + "]";
	}

	
}
