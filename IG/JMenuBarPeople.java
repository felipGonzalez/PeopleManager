package IG;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Constant.Constant;
import Properties.Lenguage;
/**
 * crea el menu de opciones con sus items
 * @author Felipe Gonzalez
 *
 */
public class JMenuBarPeople extends JMenuBar{

	private static final long serialVersionUID = 2615971885304632276L;
	public JMenu jMenuArchive;
	public JMenu jMenuHelp;
	public JMenu jMenuSee;
	public JMenu jMenuEdition;
	public JMenu jMenuTool;
	public JMenu jMenuChangeLanguage;
	
	public JMenuItem jItemExit;
	public JMenuItem jItemAdd;
	public JMenuItem jItemSave;
	public JMenuItem jItemLoad;
	public JMenuItem jItemSaveAs;
	public JMenuItem jItemDelete;
	public JMenuItem jItemModify;
	public JMenuItem jItemSearch;
	public JMenuItem jItemAbout;
	public JMenuItem jItemSpanish;
	public JMenuItem jItemEnglish;
	public JMenuItem jMenuItemHelp;
	
	public JMenuBarPeople() {
		init();
		setShortcut();
	}
	
	public void setLenguage(Lenguage lenguage) {
		this.jMenuArchive.setText(lenguage.getProperty(Constant.ARCHIVE));  
		this.jMenuEdition.setText(lenguage.getProperty(Constant.EDITION));
		this.jMenuTool.setText(lenguage.getProperty(Constant.TOOLS));
		this.jMenuSee.setText(lenguage.getProperty(Constant.SEE));
		this.jMenuHelp.setText(lenguage.getProperty(Constant.HELP));
		this.jMenuChangeLanguage.setText(lenguage.getProperty(Constant.CHANGE_LANGUAGE));
		this.jItemExit.setText(lenguage.getProperty(Constant.EXIT));
		this.jItemAdd.setText(lenguage.getProperty(Constant.ADD));
		this.jItemSave.setText(lenguage.getProperty(Constant.SAVE));
		this.jItemSaveAs.setText(lenguage.getProperty(Constant.SAVE_AS));
		this.jItemLoad.setText(lenguage.getProperty(Constant.LOAD));
		this.jItemDelete.setText(lenguage.getProperty(Constant.DELETE));
		this.jItemModify.setText(lenguage.getProperty(Constant.MODIFY));
		this.jItemSearch.setText(lenguage.getProperty(Constant.SEARCH));
		this.jItemAbout.setText(lenguage.getProperty(Constant.ABOUT));
		this.jItemSpanish.setText(lenguage.getProperty(Constant.SPANISH));
		this.jItemEnglish.setText(lenguage.getProperty(Constant.ENGLISH));
		this.jMenuItemHelp.setText(lenguage.getProperty(Constant.HELP));
	}
	
	public void init(){
		this.jMenuArchive = new JMenu();
		this.jMenuEdition = new JMenu();
		this.jMenuTool = new JMenu();
		this.jMenuSee = new JMenu();
		this.jMenuHelp = new JMenu();
		this.jMenuChangeLanguage = new JMenu();
		this.jItemExit = new JMenuItem();
		this.jItemAdd = new JMenuItem();
		this.jItemSave = new JMenuItem();
		this.jItemSaveAs = new JMenuItem();
		this.jItemLoad = new JMenuItem();
		this.jItemDelete = new JMenuItem();
		this.jItemModify = new JMenuItem();
		this.jItemSearch = new JMenuItem();
		this.jItemAbout = new JMenuItem();
		this.jItemSpanish = new JMenuItem();
		this.jItemEnglish = new JMenuItem();
		this.jMenuItemHelp = new JMenuItem();
		
		this.add(jMenuArchive);
		this.add(jMenuEdition);
		this.add(jMenuTool);
		this.add(jMenuSee);
		this.add(jMenuHelp);
		
		this.jMenuArchive.add(jItemSearch);
		this.jMenuArchive.add(jItemSave);
		this.jMenuArchive.add(jItemSaveAs);
		this.jMenuArchive.add(jItemLoad);
		this.jMenuArchive.addSeparator();
		this.jMenuArchive.add(jItemExit);
		
		this.jMenuEdition.add(jItemAdd);
		this.jMenuEdition.add(jItemModify);
		this.jMenuEdition.add(jItemDelete);
		
		this.jMenuChangeLanguage.add(jItemSpanish);
		this.jMenuChangeLanguage.add(jItemEnglish);
		this.jMenuSee.add(jItemAbout);
		this.jMenuTool.add(jMenuChangeLanguage);
		this.jMenuHelp.add(jMenuItemHelp);
		}
	/**
	 * agrega los atajos
	 */
	public void setShortcut(){
		this.jItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		this.jItemAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		this.jItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		this.jItemLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		this.jItemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		this.jItemModify.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		this.jItemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		this.jItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, InputEvent.ALT_DOWN_MASK));
		this.jItemSpanish.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		this.jItemEnglish.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK));
		this.jMenuItemHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
	}
	
}
