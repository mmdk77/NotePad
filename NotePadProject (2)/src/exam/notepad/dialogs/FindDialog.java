package exam.notepad.dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import exam.notepad.frames.NotePadFrame;

public class FindDialog extends JDialog{
	private JLabel lFind, lReplace;
	private JTextField txtFind, txtReplace;
	private JButton btnFind, btnReplace, btnClose;
	private	JRadioButton rbForward, rbBackward;
	private	ButtonGroup buttonGroup;
	private NotePadFrame frame;

	public FindDialog(NotePadFrame frame){
		
		super(frame,"Find/Replace",false);
		this.frame = frame;
		this.setSize(400, 300);
		this.setVisible(true);	
			
	}
	public void findOperation(){
		

	}
	
	public void replaceOperation(){
		
	}
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

