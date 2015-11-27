package exam.project.test;

import exam.project.DAO.UserDAO;
import exam.project.DTO.UserData;
import exam.project.frame.MovieFrame;
import exam.project.server.ConnectServer;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MovieFrame();
		
		UserData ud = new UserData();
		
		ConnectServer cs = new ConnectServer(7070);
		cs.waitForClient();
		cs.receive();
		cs.send(ud.getId(),ud.getPwd());
		cs.close();
	}

}
