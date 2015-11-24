package exam.project.DTO;

public class Movie {
	
	private String director;
	private String genre;
	private String mtime;
	private String actor;
	private String movieName;
	private String banch;
	private String mdate;
	
	public Movie(String director,String actor, String genre, String mtime, String mdate){
	
		this.director = director;
		this.actor = actor;
		this.genre = genre;
		this.mtime = mtime;
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
	public void setMovieName(String sMovieName) {
		// TODO Auto-generated method stub
		this.movieName = sMovieName;
	}
	public String getMovieName(){
		return movieName;
		
	}
	
}