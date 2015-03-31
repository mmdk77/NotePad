package exam.notepad.frames;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

import exam.notepad.dialogs.*;



public class NotePadFrame extends JFrame {
	private JMenuBar menubar;
	private JMenu fileMenu, editMenu, viewMenu, helpMenu;
	private JMenuItem mNew, mOpen, mSave, mSaveAs, mPage, mPrint, mExit;
	private JMenuItem mUndo, mCut, mCopy, mPaste, mFind, mSelectAll;
	private JCheckBoxMenuItem mLine, mStatus, mFont;
	private JMenuItem mHelper, mAbout;
	
	//툴바
	private JToolBar toolbar;
	private JButton tNew, tOpen, tSave, tExit;
	private JButton tCut, tCopy ,tPaste;
	
	//test 공간
	private JTextArea textArea;
	private JScrollPane jsp;
	//상태창?
	private JLabel status;
	private File curFile;
	
	private boolean isEdit = false;
	
	public NotePadFrame(){
		super("My NotePad");
		
		createMenuBar(); // 생성자 호출
		createToolBar();
		addEventListener();
		
		textArea = new JTextArea();
		jsp = new JScrollPane(textArea);
		
		this.add(BorderLayout.CENTER,jsp);
		
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void createMenuBar(){ //생성자 메뉴바 설정.
		//메뉴 바
		menubar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		viewMenu = new JMenu("View");
		helpMenu = new JMenu("Help");
		
		this.setJMenuBar(menubar);
		menubar.add(fileMenu);
		menubar.add(editMenu);
		menubar.add(viewMenu);
		menubar.add(helpMenu);
		
		fileMenu.setMnemonic('F');  // 단축키 alt + O (니모니킥)
		editMenu.setMnemonic('E');
		viewMenu.setMnemonic('V');
		helpMenu.setMnemonic('H');
		
		//File 메뉴 아이템
		mNew = new JMenuItem("New");
		mOpen = new JMenuItem("Open");
		mSave = new JMenuItem("Save");
		mSaveAs = new JMenuItem("Save as");
		mPage = new JMenuItem("Page");
		mPrint = new JMenuItem("Print");
		mExit = new JMenuItem("Exit");
		//Edit 메뉴 아이템
		mUndo = new JMenuItem("Undo");
		mCut = new JMenuItem("Cut");
		mCopy = new JMenuItem("Copy");
		mPaste = new JMenuItem("Paste");
		mFind = new JMenuItem("Find");
		mSelectAll = new JMenuItem("Select All");
		//View 메뉴 아이템
		mLine = new JCheckBoxMenuItem("Line");
		mStatus = new JCheckBoxMenuItem("Status");
		mFont = new JCheckBoxMenuItem("Font");
		//help 메뉴 아이템
		mHelper = new JMenuItem("Help");
		mAbout = new JMenuItem("About");
		
		
		
		//File 메뉴
		fileMenu.add(mNew);
		fileMenu.add(mOpen);
		fileMenu.addSeparator();  // 구분선.
		fileMenu.add(mSave);
		fileMenu.add(mSaveAs);
		fileMenu.addSeparator();
		fileMenu.add(mPage);
		fileMenu.add(mPrint);
		fileMenu.addSeparator();
		fileMenu.add(mExit);
		//Edit 메뉴
		editMenu.add(mUndo);
		editMenu.add(mCut);
		editMenu.addSeparator();
		editMenu.add(mCopy);
		editMenu.add(mPaste);
		editMenu.addSeparator();
		editMenu.add(mFind);
		editMenu.add(mSelectAll);
		//View 메뉴
		viewMenu.add(mLine);
		viewMenu.add(mStatus);
		viewMenu.add(mFont);
		//Helper 메뉴
		helpMenu.add(mHelper);
		helpMenu.add(mAbout);
		
		
		
		//File 메뉴 단축키
		mNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		mOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		mSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		mPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
		
		//Edit 메뉴 단축키
		mUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
		mCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		mCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		mPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		mFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		mSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		
	}
	
	public void createToolBar(){ //Toolbar 생성자.
		
		toolbar = new JToolBar();
		
		tNew = new JButton(new ImageIcon("new.gif"));
		tOpen = new JButton(new ImageIcon("open.gif"));
		tSave = new JButton(new ImageIcon("Save.gif"));
		tExit = new JButton(new ImageIcon("Exit.gif"));	
		tCut = new JButton(new ImageIcon("cut.gif"));
		tCopy = new JButton(new ImageIcon("copy.gif"));
		tPaste = new JButton(new ImageIcon("paste.gif"));
		
		
		
		toolbar.add(tNew);
		toolbar.add(tOpen);
		toolbar.add(tSave);
		toolbar.addSeparator();
		toolbar.add(tExit);
		toolbar.addSeparator();
		toolbar.add(tCut);
		toolbar.add(tCopy);
		toolbar.add(tPaste);
		
		
		toolbar.setFloatable(false); //붕붕 뜨게 할것인지 말것인지.
		
		tNew.setToolTipText("New");   //tool tip.
		tOpen.setToolTipText("Open");
		tSave.setToolTipText("Save");
		tExit.setToolTipText("Exit");
		tCut.setToolTipText("Cut");
		tCopy.setToolTipText("Copy");
		tPaste.setToolTipText("Paste");

		
		this.add(BorderLayout.NORTH,toolbar);
	
	}
	
	public void addEventListener(){
		mNew.addActionListener(new EventListener());
		mSave.addActionListener(new EventListener());
		mSaveAs.addActionListener(new EventListener());
		mOpen.addActionListener(new EventListener());
		
		tNew.addActionListener(new EventListener());
		tSave.addActionListener(new EventListener());
		tOpen.addActionListener(new EventListener());
		
		mAbout.addActionListener(new EventListener());
		mFind.addActionListener(new EventListener());
	
		
	}
	
	class EventListener implements ActionListener{
		
		public void newDocument(){
			if(!textArea.getText().isEmpty()){
				int result =JOptionPane.showConfirmDialog(NotePadFrame.this,"저장하시곘습니까?","저장?",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				//textArea.setText("");
				
				// 예
				if(result == JOptionPane.YES_OPTION){
					JFileChooser chooser = new JFileChooser();
				    chooser.showSaveDialog(NotePadFrame.this);
				}
				// 아니오
				else if(result == JOptionPane.NO_OPTION){
					textArea.setText("");
				}
				
				// 취소
				else{
					return;
				}			
			}
		}
		
		public void saveDocument(Boolean isVisibleSaveDialog){
			if(isVisibleSaveDialog){
				JFileChooser chooser = new JFileChooser();
				int r =	chooser.showSaveDialog(NotePadFrame.this);
				
				//저장
				if(r==JFileChooser.APPROVE_OPTION){
					File saveFile = chooser.getSelectedFile();
					/*System.out.println(saveFile.getName());*/
					
					saveFile(saveFile);
				}
				
				//취소
				else{
					return;
				}		
			}
			else{
				return;
			}
		}
		
		//저장파일
		public void saveFile(File saveFile){
			try {
				PrintWriter pw = new PrintWriter(saveFile);
				pw.write(textArea.getText());
				pw.flush();
				
				curFile = saveFile;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void openDocument(Boolean isVisibleOpenDialog){
			if(isVisibleOpenDialog){
				JFileChooser chooser = new JFileChooser();
				int r =	chooser.showOpenDialog(NotePadFrame.this);
				
				//열기
				if(r==JFileChooser.APPROVE_OPTION){
					File openFile = chooser.getSelectedFile();
					/*System.out.println(openFile.getName());*/
					
					openFile(openFile);
				}
				
				//취소
				else{
					return;
				}		
			}
			else{
				return;
			}
			
		}
		
		//열기파일
		public void openFile(File openFile){
			try {                                         //try,catch
				Scanner sc = new Scanner(openFile);
				textArea.setText(sc.nextLine());
				while(sc.hasNext()){
					textArea.append(sc.nextLine()+"\n");
				}
		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(NotePadFrame.this, "파일을 찾을 수 없습니다.");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj == mNew || obj == tNew){ 
				newDocument();
			}
			
			//save
			else if(obj == mSave || obj == tSave){ 
				if(curFile == null)     //저장된적이 없으면
					saveDocument(true);
				else                    //저장된적이 있으면
					saveDocument(false);
			}
			
			//save as
			else if(obj == mSaveAs){ 
				saveDocument(true);
			}
			
			//Open
			else if(obj == mOpen || obj == tOpen){
				openDocument(true);
			}
			
			// 프레임 위나 또다른 다이어그램에서만  다이어그램을 선언 가능
			else if(obj == mAbout){
				/*//JOptionPane.showMessageDialog(NotePadFrame.this, "신기한 자바자바", "Information", JOptionPane.INFORMATION_MESSAGE);
				JDialog about = new JDialog(NotePadFrame.this, "INFO",false);
				
				about.setSize(200, 300);
				about.setVisible(true);*/
				AboutDialog about = new AboutDialog(NotePadFrame.this);	
			}
			else if(obj == mFind){
				FindDialog find = new FindDialog(NotePadFrame.this);
			}
		}
		
	}
}
