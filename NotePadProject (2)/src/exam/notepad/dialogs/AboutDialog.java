package exam.notepad.dialogs;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;


import exam.notepad.frames.*;



public class AboutDialog extends JDialog {
	public static final String CloseAction = null;
	private NotePadFrame frame;
	private JButton btnClose;

	
	public AboutDialog(NotePadFrame frame){
		
		super(frame,"Info",false);
		this.frame = frame;
		this.setSize(200, 300);
		this.setVisible(true);	
		btnClose = new JButton("Close");
		this.add(BorderLayout.SOUTH,btnClose);
		
	
	}
	
	public void EventListener(){	
		btnClose.addActionListener(new EventListener());
			
	}
	
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj==btnClose){
		
			}
			
	
		}

			
	}
		
			
}
		
		


