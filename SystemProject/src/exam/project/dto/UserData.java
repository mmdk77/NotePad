package exam.project.dto;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UserData {
	
	private String id;
	private int pwd;
	private int rePwd;
	private String name;
	private boolean sex;
	
	public String getId() {
		return id;
	}
	public void setId(String id2) {
		this.id = id2;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public int getRePwd() {
		return rePwd;
	}
	public void setRePwd(int rePwd) {
		this.rePwd = rePwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	
	
}
