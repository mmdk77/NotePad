package exam.project.dialog;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exam.project.frame.MovieFrame;

public class AccountBankDialog extends JDialog{

	private MovieFrame MF;
	private JPanel p,p1,p2;
	private JLabel jl,jl1;
	private JTextField tf; 
	private JPasswordField tf1; 
	private JButton b1,b2; 
	private Container con = getContentPane();

	public AccountBankDialog(MovieFrame MF){

		this.setTitle("����");
		this.setSize(400, 300); 
		this.setVisible(true); 

		accountUi();
	}
	
	public void accountUi(){
		
		jl = new JLabel("����"); 
		tf = new JTextField(10);

		jl1 = new JLabel("���º�й�ȣ");
		tf1 = new JPasswordField(10);

		b1 = new JButton("�����ϱ�");
		b2 = new JButton("���");

		p.add(jl); 
		p.add(tf);

		p1.add(jl1);
		p1.add(tf1); 

		p2.add(b1); 
		p2.add(b2); 
		
		con.add(p,"West");
		con.add(p1,"South");
		con.add(p2,"Center");
		
		this.setVisible(true);
		
		
	}

}


