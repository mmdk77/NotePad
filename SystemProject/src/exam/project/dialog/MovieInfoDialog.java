package exam.project.dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exam.project.frame.MovieFrame;
import exam.project.server.ServerFrame;

public class MovieInfoDialog extends JDialog {

	private JList<String> movieList;
	private JTextArea ta;
	private JScrollPane sp;
	private JPanel panel_1,panel_2,panel_3,panel_4;
	private JButton img_1;

	public MovieInfoDialog(ServerFrame sf){

		super(sf,"��ȭ����",false);
		this.setSize(500,500);

		movieInfoUi();
		addEventListener();
		this.setVisible(true);

	}

	public MovieInfoDialog(MovieFrame mf){

		super(mf,"��ȭ����",false);
		this.setSize(500,500);

		movieInfoUi();
		addEventListener();
		this.setVisible(true);
	}

	public void movieInfoUi(){

		String [] movieName = {"�絵","���׶�","�������","Ž��","�ϻ�"};
		movieList = new JList<String>(movieName);
		sp = new JScrollPane(movieList);
		
		panel_1 = new JPanel();
		panel_1.add(sp);
		
		panel_2 = new JPanel();
		img_1 = new JButton(new ImageIcon("123.jpg"));
		panel_2.add(img_1);
		
		panel_3 = new JPanel();
		ta = new JTextArea(10,30);
		ta.setText("�����ϼ�");
		panel_3.add(ta);
		
		panel_4 = new JPanel(new GridLayout(2, 0));
		panel_4.add(panel_2);
		panel_4.add(panel_3);

		add(panel_1,BorderLayout.WEST);
		add(panel_4);
		
	}
	
	public void addEventListener(){
		movieList.addListSelectionListener(new EventListener());
	}

	class EventListener implements ListSelectionListener,ActionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if(movieList.getSelectedValue() == "�絵"){
				img_1.setText("");
				ta.setText("��ȭ����1");
			}else if(movieList.getSelectedValue() == "���׶�"){
				img_1.setText("icon");
				ta.setText("��ȭ����2");
			}else if(movieList.getSelectedValue() == "�������"){
				img_1.setText("icon");
				ta.setText("��ȭ����3");
			}else if(movieList.getSelectedValue() == "Ž��"){
				img_1.setText("icon");
				ta.setText("��ȭ����4");
			}else if(movieList.getSelectedValue() == "�ϻ�"){
				img_1.setText("icon");
				ta.setText("��ȭ����5");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}


}
