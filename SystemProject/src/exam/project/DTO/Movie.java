package exam.project.DTO;

import java.sql.Date;
import java.sql.Time;

public class Movie {
	
	private String director;
	private String genre;
	private Time mtime;
	private String actor;
	private int reservation;
	private int banch;
	private Date mdate;
	
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Time getMtime() {
		return mtime;
	}
	public void setMtime(Time mtime) {
		this.mtime = mtime;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getReservation() {
		return reservation;
	}
	public void setReservation(int reservation) {
		this.reservation = reservation;
	}
	public int getBanch() {
		return banch;
	}
	public void setBanch(int banch) {
		this.banch = banch;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	
}
