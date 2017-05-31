package IG;

import javax.swing.JOptionPane;

public class ShowMessage {

	public void showMessage(JFrameViewPeople jFrameViewPeople ,String message) {
		JOptionPane.showMessageDialog(jFrameViewPeople, message);
	}

	public int showOptionSelect(JFrameViewPeople jFrameViewPeople ,String message) {
		return JOptionPane.showConfirmDialog(jFrameViewPeople, message);
	}
	
}
