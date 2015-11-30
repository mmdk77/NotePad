package exam.project.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectClient {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public ConnectClient(String ip, int port){
		
		try {
			socket = new Socket(ip,port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.println(">>서버접속에 성공 했습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end ConnectClient
	
	public void receive(){
		
		try {
			System.out.println("[서버]"+in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of receive
	
	public void loginSend(String id, String pwd){
		
		out.println("ID:"+id+",PWD:"+pwd);
		out.flush();
	}//end of send
	
	public void addUserSend(String id, String pwd, String rePwd, String name,String sex){
		out.println("ID:"+id+",PWD:"+pwd+",REPWD:"+rePwd+",NAME:"+name+",SEX:"+sex);
		out.flush();
	}
	
	public void close(){
		try {
			System.out.println(">>접속을 종료합니다.");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
