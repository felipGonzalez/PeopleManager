package IG;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.freixas.jcalendar.JCalendarCombo;

import Constant.Constant;
import Properties.Lenguage;

public class JPanelPeople extends JPanel{
	
	/**
	 * Crea el panel contenedor
	 * @author 
	 *
	 */	
	private static final long serialVersionUID = 4006524958198495494L;
	public JTextArea jTextArea;
	public JButton jButtonAddPerson;
	public JButton jButtonAddPhoto;
	public JButton jButtonSaveAs;
	public JButton jButtonDeletePerson;
	public JButton jButtonModifyPerson;
	public JButton jButtonSave;
	public JButton jButtonLoad;
	public JButton jButtonNew;
	public JButton jButtonExit;

	public JLabel jLabelId;
	public JLabel jLabelFirtsName;
	public JLabel jLabelLastName;
	public JLabel jLabelGender;
	public JLabel jLabelBirhDate;
	public JLabel jLabelPhone;
	public JLabel jLabelValue;
	public JLabel jLabelcity;
	public JLabel jLabelEmail;
	public JLabel jLabelPhoto;
	public String[] data;
	public String[] list;
	public JTextField jTextFieldId;
	public JTextField jTextFieldFirstName;
	public JTextField jTextFieldLastName;
	public JTextField jTextFieldPhone;
	public JTextField jTextFieldValue;
	//public JTextField jTextFieldCity;
	public JTextField jTextFieldEmail;
	public DefaultTableModel defaultTableModel;
	public JTable jTable;
	public JScrollPane jScrollPane;
	public JPanel[] jPanel;
	public Lenguage lenguage;

	public ButtonGroup buttonGroup;
	public JCalendarCombo calendarCombo;
	public JRadioButton jRadioButtonMale;
	public JRadioButton jRadioButtonFemale;
	public JComboBox<String> comboBox;
	/**
	 * inicializa los parametros
	 * @param lenguage
	 */
	public JPanelPeople(Lenguage lenguage,String [] listCity){
		this.lenguage = lenguage;
		data = new String[9];
		list = new String[0];
		this.jPanel = new JPanel[3];
		this.defaultTableModel = new DefaultTableModel();
		this.jTable = new JTable();
		this.setLayout(new GridLayout(2, 1));
		comboBox = new JComboBox<>(listCity);
		init();
		initPanelOne();
		initPanelTwo();
	}
	/**
	 * inicializa los botones y los items
	 */
	public void init(){
		this.jButtonAddPerson = new JButton(lenguage.getProperty(Constant.ADD));
		this.jButtonAddPhoto = new JButton(lenguage.getProperty(Constant.ADD_PHOTO));
		this.jButtonDeletePerson = new JButton(lenguage.getProperty(Constant.DELETE));
		this.jButtonModifyPerson = new JButton(lenguage.getProperty(Constant.MODIFY));
		this.jButtonLoad = new JButton(lenguage.getProperty(Constant.LOAD));
		this.jButtonSave = new JButton(lenguage.getProperty(Constant.SAVE));
		this.jButtonSaveAs = new JButton(lenguage.getProperty(Constant.SAVE_AS));
		this.jButtonNew = new JButton(lenguage.getProperty(Constant.NEW)); 
		this.jButtonExit = new JButton(lenguage.getProperty(Constant.EXIT));
		this.jLabelFirtsName = new JLabel(lenguage.getProperty(Constant.FIRST_NAME));
		this.jLabelLastName = new JLabel(lenguage.getProperty(Constant.LAST_NAME));
		this.jLabelId = new JLabel(lenguage.getProperty(Constant.ID));
		this.jLabelBirhDate = new JLabel(lenguage.getProperty(Constant.BIRTH_DATE));
		this.jLabelcity = new JLabel(lenguage.getProperty(Constant.CITY));
		this.jLabelEmail = new JLabel(lenguage.getProperty(Constant.EMAIL));
		this.jLabelGender = new JLabel(lenguage.getProperty(Constant.GENDER));
		this.jLabelPhone = new JLabel(lenguage.getProperty(Constant.PHONE));
		this.jLabelPhoto = new JLabel(lenguage.getProperty(Constant.PHOTO), 2);
		this.jLabelValue = new JLabel(lenguage.getProperty(Constant.INGRESS));
		this.jRadioButtonFemale = new JRadioButton(lenguage.getProperty(Constant.FEMALE)); 
		this.jRadioButtonMale = new JRadioButton(lenguage.getProperty(Constant.MALE)); 
		//this.jTextFieldCity = new JTextField();
		this.jTextFieldEmail = new JTextField();
		this.jTextFieldFirstName = new JTextField();
		this.jTextFieldId = new JTextField();
		this.jTextFieldLastName = new JTextField();
		this.jTextFieldPhone = new JTextField();
		this.jTextFieldValue = new JTextField();
		this.calendarCombo = new JCalendarCombo();
		this.buttonGroup = new ButtonGroup();
		for (int i = 0; i < jPanel.length; i++) {
			jPanel[i] = new JPanel();
		}
		
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.ID));
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.FIRST_NAME));
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.LAST_NAME));
		this.defaultTableModel.addColumn("Genero");
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.BIRTH_DATE));
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.CITY));
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.EMAIL));
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.PHONE));
		this.defaultTableModel.addColumn(lenguage.getProperty(Constant.INGRESS));
		
		jTable.setModel(defaultTableModel);
		jScrollPane =new JScrollPane(jTable);
		this.jTable.setBackground(Color.YELLOW);
		jScrollPane.setBackground(Color.YELLOW);
	}
	/**
	 * cambia los idiomas del lenguaje
	 * @param lenguage2
	 */
	public void setLenguage(Lenguage lenguage2) {
		this.lenguage = lenguage2;
			this.jButtonAddPerson.setText(lenguage.getProperty(Constant.ADD));
			this.jButtonAddPhoto.setText(lenguage.getProperty(Constant.ADD_PHOTO));
			this.jButtonDeletePerson.setText(lenguage.getProperty(Constant.DELETE));
			this.jButtonModifyPerson.setText(lenguage.getProperty(Constant.MODIFY));
			this.jButtonLoad.setText(lenguage.getProperty(Constant.LOAD));
			this.jButtonSave.setText(lenguage.getProperty(Constant.SAVE));
			this.jButtonSaveAs.setText(lenguage.getProperty(Constant.SAVE_AS));
			this.jButtonNew.setText(lenguage.getProperty(Constant.NEW));				
			this.jButtonExit.setText(lenguage.getProperty(Constant.EXIT));
			this.jLabelFirtsName.setText(lenguage.getProperty(Constant.FIRST_NAME));
			this.jLabelLastName.setText(lenguage.getProperty(Constant.LAST_NAME));
			this.jLabelId.setText(lenguage.getProperty(Constant.ID));
			this.jLabelBirhDate.setText(lenguage.getProperty(Constant.BIRTH_DATE));
			this.jLabelcity.setText(lenguage.getProperty(Constant.CITY));
			this.jLabelEmail.setText(lenguage.getProperty(Constant.EMAIL));
			this.jLabelGender.setText(lenguage.getProperty(Constant.GENDER));
			this.jLabelPhone.setText(lenguage.getProperty(Constant.PHONE));
			this.jLabelPhoto.setText(lenguage.getProperty(Constant.PHOTO));
			this.jLabelValue.setText(lenguage.getProperty(Constant.INGRESS));
			this.jRadioButtonFemale.setText(lenguage.getProperty(Constant.FEMALE)); 
			this.jRadioButtonMale.setText(lenguage.getProperty(Constant.MALE)); 
	}
	/**
	 * inicializa el panel principal y le agrega los items y botones
	 */
	private void initPanelOne(){
		this.jPanel[1].setBackground(Color.YELLOW);
		this.jPanel[1].setLayout(null);
		this.jButtonAddPerson.setBounds(10, 290, 100, 30);
		this.jButtonNew.setBounds(120, 290, 100, 30);
		this.jButtonDeletePerson.setBounds(230, 290, 100, 30);
		this.jButtonModifyPerson.setBounds(340, 290, 100, 30);
		this.jButtonLoad.setBounds(450, 290, 100, 30);
		this.jButtonSave.setBounds(560, 290, 100, 30);
		this.jButtonSaveAs.setBounds(670, 290, 200, 30);
		this.jButtonExit.setBounds(880, 290, 100, 30);
		this.jButtonAddPhoto.setBounds(750, 230, 200, 30);
		
		this.jLabelFirtsName.setBounds(40, 30, 100, 30);
		this.jLabelLastName.setBounds(40, 70, 100, 30);
		this.jLabelId.setBounds(40, 110, 100, 30);
		this.jLabelcity.setBounds(40, 150, 100, 30);
		this.jLabelEmail.setBounds(40, 190, 100, 30);
		this.jLabelValue.setBounds(40, 230, 100, 30);
		this.jLabelPhone.setBounds(370, 30, 100, 30);
		
		this.jLabelPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.jLabelPhoto.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.jLabelPhoto.setBounds(750, 30, 200, 200);		
		ImageIcon imagen = new ImageIcon("resource/img/add-photo.jpg");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(jLabelPhoto.getWidth(), jLabelPhoto.getHeight(), Image.SCALE_DEFAULT));
		jLabelPhoto.setIcon(icono);
		
	
		this.jLabelBirhDate.setBounds(370, 70, 120, 30);
		this.jLabelGender.setBounds(370, 150, 100, 30);
		this.calendarCombo.setBounds(450, 100, 250, 30);
		this.buttonGroup.add(jRadioButtonFemale);
		this.buttonGroup.add(jRadioButtonMale);
		jRadioButtonFemale.setBackground(Color.PINK);
		this.jRadioButtonFemale.setBounds(450, 170, 100, 30);
		jRadioButtonMale.setBackground(Color.decode("#429AE3"));
		this.jRadioButtonMale.setBounds(450, 210, 100, 30);
		this.jTextFieldFirstName.setBounds(110, 30, 250, 30);
		this.jTextFieldLastName.setBounds(110, 70, 250, 30);
		this.jTextFieldId.setBounds(110, 110, 250, 30);
		
		//this.jTextFieldCity.setBounds(110, 150, 250, 30);
		this.comboBox.setBounds(110, 150, 250, 30);
		this.jTextFieldEmail.setBounds(110, 190, 250, 30);
		this.jTextFieldValue.setBounds(110, 230, 250, 30);
		this.jTextFieldPhone.setBounds(450, 30, 250, 30);
		
		this.jPanel[1].add(jButtonAddPerson);
		this.jPanel[1].add(jButtonAddPhoto);
		this.jPanel[1].add(jButtonDeletePerson);
		this.jPanel[1].add(jButtonModifyPerson);
		this.jPanel[1].add(jButtonLoad);
		this.jPanel[1].add(jButtonSave);
		this.jPanel[1].add(jButtonSaveAs);
		this.jPanel[1].add(jButtonNew);
		this.jPanel[1].add(jButtonExit);
		this.jPanel[1].add(jLabelFirtsName);
		this.jPanel[1].add(jLabelLastName);
		this.jPanel[1].add(jLabelId);
		this.jPanel[1].add(jLabelcity);
		this.jPanel[1].add(jLabelEmail);
		this.jPanel[1].add(jLabelGender);
		this.jPanel[1].add(jLabelPhone);
		this.jPanel[1].add(jLabelPhoto);
		this.jPanel[1].add(jLabelBirhDate);
		this.jPanel[1].add(jLabelValue);
		this.jPanel[1].add(calendarCombo);
		this.jPanel[1].add(jTextFieldFirstName);
		this.jPanel[1].add(jTextFieldLastName);
		this.jPanel[1].add(jTextFieldId);
		this.jPanel[1].add(comboBox);
		this.jPanel[1].add(jTextFieldEmail);
		this.jPanel[1].add(jTextFieldValue);
		this.jPanel[1].add(jTextFieldPhone);
		this.jPanel[1].add(jRadioButtonFemale);
		this.jPanel[1].add(jRadioButtonMale);
		this.add(jPanel[1]);
	}
	/**
	 * inicializa el panel secunadrio donde se ubica la tabla
	 */
	public  void initPanelTwo(){
		this.jPanel[2].setBackground(Color.YELLOW);
		this.jPanel[2].setLayout(new BorderLayout());
		this.jPanel[2].add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel[2]);
	}

	public LocalDate getDate() {
		return this.calendarCombo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}	
}
