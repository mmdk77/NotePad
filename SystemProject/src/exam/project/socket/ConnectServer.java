package exam.project.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectServer{
	//TCP�ʵ�
	private ServerSocket server;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	int port = 7070;

	public ConnectServer(int port){

		this.port = port;
		System.out.println(">>������ �����մϴ�.");
			try {
				server = new ServerSocket(7070);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}//end of ConnectServer
	
	public void waitForClient(){
		System.out.println(">>Ŭ���̾�Ʈ�� �����ϱ� ��ٸ��� �ֽ��ϴ�,");
		try {
			socket = server.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of waitForClient
	
	public void receive(){
		try {
			System.out.println("[Ŭ���̾�Ʈ]"+in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of receive
	
	public void send(String id, String pwd){
		out.println(id);
		out.print(pwd);
		out.flush();
	}//end of send
	
	public void close(){
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of close
	
}

