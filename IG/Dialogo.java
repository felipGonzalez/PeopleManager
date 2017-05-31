package IG;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constant.Constant;
import Properties.Lenguage;

public class Dialogo extends JDialog{

	private static final String PATH_IMAGEN_PERSONA = "resource/img/persona.png";
	private static final long serialVersionUID = 310713849800155380L;
	private static final String PATH_LANGUAGE = "resource/AboutSpanish.txt";
	private JLabel labelPrograma;
	private JLabel labelText;
	private JLabel labelText2;
	private JLabel labelVersion;
	private JLabel labelAutor;
	private JLabel labelAutor2;
	private JLabel labelAutor3;
	private JLabel labelDerechos;
	private JLabel labelImagen;
	
	private JButton buttonAceptar;
	
	private JPanel panelPrincipal;
	private JPanel panelInfo;
	private JPanel panelBoton;
	
		public Dialogo(Lenguage lenguage){
			super(new Frame(), lenguage.getProperty(Constant.ABOUT), true);
			labelPrograma = new JLabel(lenguage.getProperty(Constant.ABOUT_TITLE), JLabel.CENTER);
			labelText = new JLabel(lenguage.getProperty(Constant.DESCRIPTION_ONE), JLabel.CENTER);
			labelText2 = new JLabel(lenguage.getProperty(Constant.DESCRIPTION_TWO), JLabel.CENTER);
			labelVersion = new JLabel(lenguage.getProperty(Constant.VERSION), JLabel.CENTER);
			labelAutor = new JLabel(lenguage.getProperty(Constant.AUTHOR_NAME_ONE), JLabel.CENTER);
			labelAutor2 = new JLabel(lenguage.getProperty(Constant.AUTHOR_NAME_TWO),JLabel.CENTER);
			labelAutor3 = new JLabel(lenguage.getProperty(Constant.AUTHOR_NAME_THREE),JLabel.CENTER);
			labelDerechos = new JLabel(lenguage.getProperty(Constant.YEAR_RIGHT), JLabel.CENTER);
			
			buttonAceptar = new JButton("Aceptar");
			
			panelPrincipal = new JPanel(new BorderLayout());
			panelInfo = new JPanel(new GridLayout(8, 1));
			panelBoton = new JPanel(new FlowLayout());
			init();
			this.setResizable(false);

			labelImagen = new JLabel(" ");
			ImageIcon imagen = new ImageIcon(PATH_LANGUAGE);
			labelImagen.setBounds(120, 20, 160, 170);
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_DEFAULT));
			labelImagen.setIcon(icono);
			this.add(labelImagen,BorderLayout.WEST);
		
			ImageIcon imagen2 = new ImageIcon(PATH_IMAGEN_PERSONA);
			Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_DEFAULT));
			labelImagen.setIcon(icono2);
			this.add(labelImagen,BorderLayout.WEST);
			
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
	 
		
		public void init(){
			panelInfo.add(labelPrograma);
			panelInfo.add(labelText);
			panelInfo.add(labelText2);
			panelInfo.add(labelVersion);
			panelInfo.add(labelAutor);
			panelInfo.add(labelAutor2);
			panelInfo.add(labelAutor3);
			panelInfo.add(labelDerechos);
	 
			panelBoton.add(buttonAceptar);
	 
			panelPrincipal.add("Center", panelInfo);
			panelPrincipal.add("South", panelBoton);
	 
			this.getContentPane().add(panelPrincipal);
			this.setSize(500, 200);
			buttonAceptar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					dispose();
				}
			});
		}		
}
