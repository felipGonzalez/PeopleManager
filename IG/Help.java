package IG;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Constant.Constant;
import Properties.Lenguage;
import models.FileManager;
import models.OpenForm;
public class Help extends JDialog{

	private static final long serialVersionUID = -4087613790028224129L;

	private static final String PATH = "resource/AboutSpanish.txt";
	private static final String PATH_2 = "resource/AboutEnglish.txt";
	public static final String ABOUT = "Ayuda";
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton buttonExit;
	
	public Help(String lenguage) {
		this.setTitle(ABOUT);
		this.setSize(400, 600);
		this.setLayout(new BorderLayout());
		textArea = new JTextArea();
		textArea.append(selectLenguage(lenguage));
		textArea.setLineWrap(true);
		textArea.setAutoscrolls(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea);
		buttonExit = new JButton(new Lenguage(lenguage).getProperty(Constant.EXIT));
		this.add(scrollPane,BorderLayout.CENTER);
		init();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}	
	
	public String selectLenguage(String lenguage) {
		if(lenguage == Constant.SPANISH){
			return readAbout(PATH);
		}else {
			return readAbout(PATH_2);
		}
	}
	
	public String readAbout(String pahtLenguage) {
		FileManager fileManager = new FileManager(pahtLenguage, OpenForm.READ);
		fileManager.open();
		String line1 = fileManager.read();
		String line2 ="";
		line2 += line1+"\n";
		while (line1 != null) {
			line1 = fileManager.read();
			if (line1 != null) {
				line2 += line1+"\n";
			}
		}
		fileManager.close();
		return line2;
	}
	
	public void init(){ 
		this.add("South", buttonExit);
		buttonExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
	}
}
