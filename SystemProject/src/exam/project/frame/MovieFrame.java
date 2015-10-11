package exam.project.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exam.project.dialog.AccountBankDialog;
import exam.project.dialog.LoginDialog;
import exam.project.dialog.MovieInfoDialog;

public class MovieFrame extends JFrame{
	
	private JPanel panel;
	private JButton movie,ago,next,reservetion,cancel;
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

		movie = new JButton(new ImageIcon("123.jpg")); //��ȭ ������ ����
		ago = new JButton("��");					  //������ȭ
		next = new JButton("��");					  //������ȭ
		reservetion = new JButton("����");					  //�����ϱ�
		cancel = new JButton("���");					  //����ϱ�

		setLayout(new FlowLayout(FlowLayout.CENTER));

		add(movie);
		add(ago);
		add(next);
		add(reservetion);
		add(cancel);

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
		reservetion.addActionListener(new EventListener());
		movie.addActionListener(new EventListener());
		
		//����
		cancel.addActionListener(new EventListener());
		exit.addActionListener(new EventListener());
		
	}//end of addEventListener

	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();

			if(obj == login){
				LoginDialog login = new LoginDialog(MovieFrame.this);
			}
			else if(obj == reservetion){
				AccountBankDialog bank = new AccountBankDialog(MovieFrame.this);
			}
			else if(obj == movie){
				MovieInfoDialog mid = new MovieInfoDialog(MovieFrame.this);
			}
			else if(obj == cancel){
				System.exit(0);
			}
			else if(obj == exit){
				System.exit(0);
			}


		}


	}

}//end of class

