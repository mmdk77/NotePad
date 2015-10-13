package exam.project.database;

public class UserData {			//회원가입하면 들어갈 DB?
	private String name;
	private String sex;
	private String id;
	private int password;
	private int rePassword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getRePassword() {
		return rePassword;
	}
	public void setRePassword(int rePassword) {
		this.rePassword = rePassword;
	}
	
}
