package exam.project.frame;

import java.awt.*;

import javax.swing.*;

public class MovieFrame extends JFrame{
	private JButton btn1,btn2,btn3,btn4,btn5;
	private JMenuBar menubar;
	private JMenu homeMenu;
	private JMenuItem login,exit;
	
	public MovieFrame(){	//��ȭ����ȭ��
		
		super("��ȭ����"); 			//���α׷� Ÿ��Ʋ
		this.setSize(300,350);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		createMenuBar();
		movieInfo();
		movieSchedule();
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
		
		SpinnerModel model = new SpinnerDateModel();
	    JSpinner spinner = new JSpinner(model);
	    
	    JLabel label = new JLabel(" ��¥/�ð� "); //��¥: ��/��/��
	    JPanel panel = new JPanel();
	    panel.add(label,BorderLayout.WEST);
	    panel.add(spinner,BorderLayout.EAST);
	    add(panel);

	    this.setVisible(true);
	   
	}//end of movieSchedule
	
}//end of class

