package exam.project.dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import exam.project.server.ServerFrame;

public class CreatorInfoDialog extends JDialog{
	private ServerFrame sf;
	private JPanel panel_1,panel_2,panel_3;
	
	private JButton btnClose;
	private JTextField tf_1,tf_2,tf_3;
	private JTextArea ta;
	private JLabel pic,maker,explanation,title,period;
	

	public CreatorInfoDialog(ServerFrame sf){
		
		super(sf,"제작자 정보",false);
		this.sf = sf;
		this.setSize(400, 500);
		
		panel_1 = new JPanel(new GridLayout(0,1));
		panel_2 = new JPanel();
		panel_3 = new JPanel();
		

		
		pic = new JLabel(new ImageIcon("123.jpg"));
		
		panel_3.setLayout(null);
		
		maker = new JLabel("제작자 : ");
		tf_1 = new JTextField();
		maker.setBounds(56 ,10, 60, 60);
		tf_1.setBounds(120, 30, 150, 20);
		tf_1.setText("이선용  & 신봉규");
		panel_3.add(tf_1);
		panel_3.add(maker);
		
		title = new JLabel("프로젝트명 : ");
		tf_2 = new JTextField();
		title.setBounds(30,40,100,60);
		tf_2.setBounds(120, 60, 150, 20);
		tf_2.setText("영화예매 프로그램");
		panel_3.add(title);
		panel_3.add(tf_2);
		
		period = new JLabel("제작 기간 : ");
		tf_3 = new JTextField();
		period.setBounds(40,70,100,60);
		tf_3.setBounds(120, 90, 150, 20);
		tf_3.setText("2015.09.02 ~ 2015.12.01");
		panel_3.add(period);
		panel_3.add(tf_3);
		
		explanation = new JLabel("Q&A : ");
		ta = new JTextArea();
		explanation.setBounds(68,100,100,60);
		ta.setBounds(120, 120, 150, 40);
		ta.append("mmdk77@gmail.com\n");
		ta.append("bonggyu4359@daum.net");
		panel_3.add(explanation);
		panel_3.add(ta);
		
		
		panel_2.add(BorderLayout.CENTER,pic);
		panel_1.add(panel_2);
		panel_1.add(panel_3);
		add(panel_1);
		
		btnClose = new JButton("Close");
		add(BorderLayout.SOUTH,btnClose);
		
	
		addEventListener();
		
		this.setVisible(true);	


	}

	public void addEventListener(){	
		btnClose.addActionListener(new EventListener());

	}

	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj==btnClose){
				CreatorInfoDialog.this.dispose();
			}
		}
	}
}
