package IG;

import javax.swing.*;

import java.awt.*;
/**
 * crea el splash del programa
 * @author 
 *
 */
public class Splash extends JWindow{

	private static final long serialVersionUID = -6976615184201431932L;

	public static final int DURATION = 600;
	
	JPanel panel;
	
	public Splash(){
		panel = (JPanel) getContentPane();
		ImageIcon img = new ImageIcon("resource/img/Splash.jpg");
		panel.add(new JLabel (img), BorderLayout.CENTER);
		setSize(img.getIconWidth(), img.getIconHeight());
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			Thread.sleep(DURATION);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(false);
	}
	
}
