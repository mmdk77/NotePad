package exam.project.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exam.project.dialog.LoginDialog;

public class MovieFrame extends JFrame{
	private JButton btn1,btn2,btn3,btn4,btn5;
	private JMenuBar menubar;
	private JMenu homeMenu;
	private JMenuItem login,exit;
	
	private SpinnerModel model;
	private JSpinner spinner;
	
	private Container con = getContentPane();
	
	public MovieFrame(){	//��ȭ����ȭ��
		
		super("��ȭ����"); 			//���α׷� Ÿ��Ʋ
		this.setSize(300,350);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		createMenuBar();
		movieInfo();
		movieSchedule();
		addEventListener();
		
	} //end of MoiveFrame
	
	private void createMenuBar(){					//Menu�����
		
		menubar = new JMenuBar();		//�޴��� ���� bar�� ��ü ����
		homeMenu = new JMenu("Ȩ");		//�޴� ��ü ����
		
		
		this.setJMenuBar(menubar);
		menubar.add(homeMenu);
		
		login = new JMenuItem("�α���");
		exit = new JMenuItem("����");
		
		homeMenu.add(login);	//Ȩ�޴��� "�α���" �߰�
		homeMenu.add(exit);		//Ȩ�޴��� "����" �߰�
		
	}//end of createMenuBar
	
	public void movieInfo(){
	
		btn1 = new JButton(new ImageIcon("123.jpg")); //��ȭ ������ ����
		btn2 = new JButton("��");					  //������ȭ
		btn3 = new JButton("��");					  //������ȭ
		btn4 = new JButton("����");					  //�����ϱ�
		btn5 = new JButton("���");					  //����ϱ�
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		this.setVisible(true);
	
	
	}//end of MoviInfo
	
	public void movieSchedule(){
		
		model = new SpinnerDateModel();
		spinner = new JSpinner(model);
	    
	    JLabel label = new JLabel(" ��¥/�ð� "); //��¥: ��/��/��
	    JPanel panel = new JPanel();
	    panel.add(label,BorderLayout.WEST);
	    panel.add(spinner,BorderLayout.EAST);
	    add(panel);

	    this.setVisible(true);
	   
	}//end of movieSchedule
	
	public void addEventListener(){
		login.addActionListener(new EventListener());
		
	}//end of addEventListener
	
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj == login){
				LoginDialog login = new LoginDialog(MovieFrame.this);
			}
			
		}
		
		
	}
	
}//end of class

