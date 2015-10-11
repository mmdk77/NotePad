package exam.project.dialog;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import exam.project.server.ServerFrame;

public class MovieInfoDialog extends JDialog {
	
	

	public MovieInfoDialog(ServerFrame sf){

		super(sf,"��ȭ����",false);
		this.setSize(350,400);
		
		movieInfoUi();
		this.setVisible(true);

			
	}

	public void movieInfoUi(){

		String list[] = {"�絵","���׶�","�ϻ�","Ž��","ġ�ܹ���"};
		JList<String> ls = new JList<String>(list);



		JPanel jp1 = new JPanel();
		jp1.add(ls,BorderLayout.WEST);


		JTextArea ta = new JTextArea(10,30);
		ta.setText("��ȭ���������Ѱ� \n �Է��ض�");
		JPanel jp2 = new JPanel();
		jp2.add(ta);

		JPanel p = new JPanel();
		p.add(jp1);
		p.add(jp2);
		add(p);

	}


}
