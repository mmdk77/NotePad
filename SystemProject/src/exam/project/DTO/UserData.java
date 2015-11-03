package exam.project.DTO;

public class UserData {
	
	private String id;
	private String pwd;
	private String rePwd;
	private String name;
	private String sex;
	
	
	public UserData(String id,String pwd,String rePwd,String name,String sex){
		this.id = id;
		this.pwd = pwd;
		this.rePwd = rePwd;
		this.name = name;
	}
	
	public UserData(String id,String pwd){
		this.id = id;
		this.pwd = pwd;
	}
	
	public UserData(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRePwd() {
		return rePwd;
	}
	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}
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

	
	
	
}