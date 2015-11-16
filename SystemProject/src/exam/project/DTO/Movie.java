package exam.project.DTO;

public class Movie {
	
	private String director;
	private String genre;
	private String mtime;
	private String actor;
	private String reservation;
	private String banch;
	private String mdate;
	
	public Movie(String director, String genre, String mtime, String actor, String reservation,String banch,String mdate){
	
		this.director = director;
		this.genre = genre;
		this.mtime = mtime;
		this.actor = actor;
		this.reservation = reservation;
		this.banch = banch;
		this.mdate = mdate;
		
	}
	public Movie(){
		
	}
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
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public String getBanch() {
		return banch;
	}
	public void setBanch(String banch) {
		this.banch = banch;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
}
