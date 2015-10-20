package exam.project.dialog;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JList;
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

		String [] moiveName = {"�絵","���׶�","�������","Ž��","�ϻ�"};
		movieList = new JList<String>(moiveName);
		sp = new JScrollPane(movieList);
		ta = new JTextArea(10,30);
		ta.setText("�����ϼ�");
		add(ta,BorderLayout.CENTER);
		add(sp,BorderLayout.WEST);
	}
	
	public void addEventListener(){
		movieList.addListSelectionListener(new EventListener());
	}

	class EventListener implements ListSelectionListener,ActionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if(movieList.getSelectedValue() == "�絵"){
				ta.setText("�絵 ��ȭ����");
			}else if(movieList.getSelectedValue() == "���׶�"){
				ta.setText("���׶� ��ȭ����");
			}else if(movieList.getSelectedValue() == "�������"){
				ta.setText("������ ��ȭ����");
			}else if(movieList.getSelectedValue() == "Ž��"){
				ta.setText("Ž�� ��ȭ����");
			}else if(movieList.getSelectedValue() == "�ϻ�"){
				ta.setText("�ϻ� ��ȭ����");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}


}
