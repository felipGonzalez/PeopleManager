package IG;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import Properties.Lenguage;

public class JFrameViewPeople extends JFrame{

	/**
	 * Crea el frame y y se hace visible para el usuario
	 * @author 
	 *
	 */
	
	private static final long serialVersionUID = -5561273221216246922L;
	private static final String TITLE2 = "title";
	public static final int WIDTH_APP = 1000;
	public static final int HEIGHT_APP = 700;
	public static final String LENGUAGE_DEFAULT = "spanish";
	public String languageActaul;
	public Lenguage lenguage;
	public JMenuBarPeople jMenuBarPeople;
	
	public JFileChooser jFileChooser;
	
	public JPanelPeople jPanelPeople;
	
	public	JFrameViewPeople(String [] listCity) {
		super();
		new Splash();
		changeLenguage(LENGUAGE_DEFAULT, "");
		this.jMenuBarPeople = new JMenuBarPeople();
		this.jMenuBarPeople.setLenguage(lenguage);
		this.jFileChooser = new JFileChooser();
		this.jPanelPeople = new JPanelPeople(lenguage, listCity);
		languageActaul = LENGUAGE_DEFAULT;
		setIconImage(new ImageIcon("resource/img/title.gif").getImage());
		init();
	}
	
	
	/**
	 * 
	 */
	public void init(){
		this.setSize(WIDTH_APP, HEIGHT_APP);
		this.setJMenuBar(jMenuBarPeople);
		this.add(jMenuBarPeople);
		this.add(jPanelPeople);
		this.setLocationRelativeTo(null);
		this.setResizable(false); 
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}

	public void changeLenguage(String nameLenguage , String path){
		this.lenguage = new Lenguage(nameLenguage);
		this.languageActaul = nameLenguage;
		this.setTitle(lenguage.getProperty(TITLE2) + " [ " + path +" ]");
		}
	
	public void setTitlePaht(String path){
		this.setTitle(lenguage.getProperty(TITLE2) + " [ " + path +" ]");
	}
	
	public Lenguage getLenguage(){
		return lenguage;
	}
	
	}
