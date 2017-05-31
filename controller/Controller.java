package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import Constant.Constant;
import IG.Dialogo;
import IG.Help;
import IG.JFrameViewPeople;
import IG.ShowMessage;
import models.Gender;
import models.GroupPeople;
import models.People;
import percistence.Load;
import percistence.Save;

/**
 * Controla los eventos y las acciones del usuario
 * 
 * @author  Felipe Gonzalez 
 * 			Davic Guio
 * 			Diego Flechas
 *
 */
public class Controller implements ActionListener, ChangeListener {

	private JFrameViewPeople jFrameViewPeople;
	private GroupPeople groupPeople;
	private Load load1;
	private int count;
	private String pathActual;
	private File file;
	private ImageIcon icon;
	private Gender genderAux;
	private ShowMessage message;
	
	public Controller(JFrameViewPeople jFrameViewPeople) {
		this.jFrameViewPeople = jFrameViewPeople;
		load1 = new Load();
		this.groupPeople = new GroupPeople();
		message = new ShowMessage();
		count = 0;
		pathActual = "";
		file = null;
		icon = null;
		genderAux = null;
		init();
	}

	/**
	 * agrega los eventos a los botones
	 */
	public void init() {
		this.jFrameViewPeople.jPanelPeople.jRadioButtonFemale.addChangeListener(this);
		this.jFrameViewPeople.jPanelPeople.jRadioButtonMale.addChangeListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonAddPerson.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonDeletePerson.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonLoad.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonModifyPerson.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonNew.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonSave.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonSaveAs.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonExit.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jButtonAddPhoto.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jRadioButtonFemale.addActionListener(this);
		this.jFrameViewPeople.jPanelPeople.jRadioButtonMale.addActionListener(this);
		/**
		 * Cierra la aplicacion
		 */
		this.jFrameViewPeople.jMenuBarPeople.jItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jFrameViewPeople.dispose();
			}
		});
		/**
		 * traduce a español la aplicacion
		 */
		this.jFrameViewPeople.jMenuBarPeople.jItemSpanish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jFrameViewPeople.changeLenguage(Constant.SPANISH, pathActual);
				jFrameViewPeople.jPanelPeople.setLenguage(jFrameViewPeople.getLenguage());
				jFrameViewPeople.jMenuBarPeople.setLenguage(jFrameViewPeople.lenguage);
			}
		});
		/**
		 * traduce a ingles la aplicacion
		 */
		this.jFrameViewPeople.jMenuBarPeople.jItemEnglish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jFrameViewPeople.changeLenguage(Constant.ENGLISH, pathActual);
				jFrameViewPeople.jPanelPeople.setLenguage(jFrameViewPeople.getLenguage());
				jFrameViewPeople.jMenuBarPeople.setLenguage(jFrameViewPeople.lenguage);
			}
		});
		/**
		 * Carga los datos guardados del usuario
		 */
		this.jFrameViewPeople.jMenuBarPeople.jItemLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btloadDateActionPerformed();
			}
		});
		/**
		 * Guarda los datos
		 */
		this.jFrameViewPeople.jMenuBarPeople.jItemSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setModSave();

			}
		});
		/**
		 * guarda los datos como
		 */
		this.jFrameViewPeople.jMenuBarPeople.jItemSaveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btSaveAsActionPerformed();
			}
		});
		/**
		 * acerca de
		 */
		this.jFrameViewPeople.jMenuBarPeople.jItemAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Dialogo(jFrameViewPeople.getLenguage());
			}
		});
		/**
		 * About
		 */
		this.jFrameViewPeople.jMenuBarPeople.jMenuItemHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Help(jFrameViewPeople.languageActaul);
			}
		});
	}

	/**
	 * agrega una nueva persona al vector y la tabla
	 */
	public void btAddActionPerformed() {
		String[] data = new String[9];
		data[0] = this.jFrameViewPeople.jPanelPeople.jTextFieldId.getText();
		data[1] = this.jFrameViewPeople.jPanelPeople.jTextFieldFirstName.getText();
		data[2] = this.jFrameViewPeople.jPanelPeople.jTextFieldLastName.getText();
		data[3] = null;
		data[4] = getBirthDate().toString();
		data[5] = (String) this.jFrameViewPeople.jPanelPeople.comboBox.getSelectedItem();
		data[6] = this.jFrameViewPeople.jPanelPeople.jTextFieldEmail.getText();
		data[7] = this.jFrameViewPeople.jPanelPeople.jTextFieldPhone.getText();
		data[8] = this.jFrameViewPeople.jPanelPeople.jTextFieldValue.getText();

		if (groupPeople.confirText(data)) {
			if (groupPeople.getValidationInt(data[0])) {
				if (groupPeople.getValidationInt(data[7])) {
					if (groupPeople.getValidationInt(data[8])) {
						if (groupPeople.getValidationId((Integer.parseInt(data[0])))) {
							if (groupPeople.getValidationDate(getBirthDate())) {
								if (getGender() != null) {
									try {
										groupPeople.addPerson(new People((Integer.parseInt(data[0])), data[1], data[2],
												getGender(), getBirthDate(), data[7], (Float.parseFloat(data[8])),
												getImage(), data[5], data[6]));
										this.icon = null;
										data[3] = getGender().name();
										this.jFrameViewPeople.jPanelPeople.defaultTableModel.addRow(data);
									} catch (NumberFormatException e) {
										e.printStackTrace();
									} catch (Exception e) {
										e.printStackTrace();
									}
									
								} else {
									message.showMessage(jFrameViewPeople,jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_SELECT_GENDER));
								}

							} else {
								message.showMessage(jFrameViewPeople, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_CKECK_DATE));
							}

						}else {
							message.showMessage(jFrameViewPeople,jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_REGISTER_ID));
						}
					}else {
						message.showMessage(jFrameViewPeople, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_CHECK_INGRESS));
					}
				}else {
					message.showMessage(jFrameViewPeople,jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_CHECK_PHONE));
				}
			} else {
				message.showMessage(jFrameViewPeople, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_CKECK_ID));
			}
		} else {
			message.showMessage(jFrameViewPeople, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_CONFIRM_DATA));
		}

	}

	/**
	 * Retorna la fecha selecionada
	 * @return 
	 */
	public LocalDate getBirthDate() {

		return jFrameViewPeople.jPanelPeople.getDate();
	}

	/**
	 * 
	 * @return el genero seleccionado
	 */
	public Gender getGender() {
		return genderAux;
	}

	public void setGenderAux(Gender gender) {
		this.genderAux = gender;
	}

	/**
	 * borra los campos dej jText para gregar una nueva persona
	 */
	public void btNewActionPerformed() {
		this.jFrameViewPeople.jPanelPeople.jTextFieldId.setText("");
		this.jFrameViewPeople.jPanelPeople.jTextFieldFirstName.setText("");
		this.jFrameViewPeople.jPanelPeople.jTextFieldLastName.setText("");
		//this.jFrameViewPeople.jPanelPeople.jTextFieldCity.setText("");
		this.jFrameViewPeople.jPanelPeople.jTextFieldEmail.setText("");
		this.jFrameViewPeople.jPanelPeople.jTextFieldPhone.setText("");
		this.jFrameViewPeople.jPanelPeople.jTextFieldValue.setText("");
		this.jFrameViewPeople.jPanelPeople.jTextFieldFirstName.requestFocus();
	}

	/**
	 * modifica los datos de una persona
	 */
	public void btModifyActionPerformed(ActionEvent e) {
		int filaSelec = this.jFrameViewPeople.jPanelPeople.jTable.getSelectedRow();
		if (filaSelec >= 0) {
			this.icon = groupPeople.getPeople(filaSelec).getPhoto();
			groupPeople.deletePeoplePos(filaSelec);
			this.jFrameViewPeople.jPanelPeople.jTextFieldId
					.setText(this.jFrameViewPeople.jPanelPeople.jTable.getValueAt(filaSelec, 0).toString());
			this.jFrameViewPeople.jPanelPeople.jTextFieldFirstName
					.setText(this.jFrameViewPeople.jPanelPeople.jTable.getValueAt(filaSelec, 1).toString());
			this.jFrameViewPeople.jPanelPeople.jTextFieldLastName
					.setText(this.jFrameViewPeople.jPanelPeople.jTable.getValueAt(filaSelec, 2).toString());
			//this.jFrameViewPeople.jPanelPeople.jTextFieldCity
				//	.setText(this.jFrameViewPeople.jPanelPeople.jTable.getValueAt(filaSelec, 5).toString());
			this.jFrameViewPeople.jPanelPeople.jTextFieldEmail
					.setText(this.jFrameViewPeople.jPanelPeople.jTable.getValueAt(filaSelec, 6).toString());
			this.jFrameViewPeople.jPanelPeople.jTextFieldPhone
					.setText(this.jFrameViewPeople.jPanelPeople.jTable.getValueAt(filaSelec, 7).toString());
			this.jFrameViewPeople.jPanelPeople.jTextFieldValue
					.setText(this.jFrameViewPeople.jPanelPeople.jTable.getValueAt(filaSelec, 8).toString());
			this.jFrameViewPeople.jPanelPeople.jLabelPhoto.setIcon(new ImageIcon(
					icon.getImage().getScaledInstance(this.jFrameViewPeople.jPanelPeople.jLabelPhoto.getWidth(),
							this.jFrameViewPeople.jPanelPeople.jLabelPhoto.getWidth(), Image.SCALE_DEFAULT)));
			this.jFrameViewPeople.jPanelPeople.defaultTableModel.removeRow(filaSelec);
			
		} else {
			JOptionPane.showMessageDialog(this.jFrameViewPeople, "Fila no selecionada");
		}
	}

	// borra los datos de una persona
	public void btDeleteActionPerformed() {
		int filaSelec = this.jFrameViewPeople.jPanelPeople.jTable.getSelectedRow();
		if (filaSelec >= 0) {
			groupPeople.deletePeoplePos(filaSelec);
			int optionSelect = message.showOptionSelect(jFrameViewPeople, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_ARE_YOU_SURE));
			if (optionSelect == 0) {
				this.jFrameViewPeople.jPanelPeople.defaultTableModel.removeRow(filaSelec);
			}
		} else {
			message.showMessage(jFrameViewPeople, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_UNSIGNED_ROW));
			
		}
	}

	/*
	 * dialogo de confirmacion
	 */
	public void btExitActionPerformed() {
		int optionSelect = message.showOptionSelect(jFrameViewPeople,jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_ARE_YOU_SURE));
		if (optionSelect == 0) {
			jFrameViewPeople.dispose();
		}

	}

	

	/**
	 * agrega los datos cargados a la tabla
	 */
	public void addPersonTable() {
		String[] data = new String[9];
		for (int i = 0; i < groupPeople.getPeopleList().length; i++) {
			data[0] = String.valueOf(groupPeople.getPeopleList()[i].getId());
			data[1] = groupPeople.getPeopleList()[i].getFirsName();
			data[2] = groupPeople.getPeopleList()[i].getLastName();
			data[3] = groupPeople.getPeopleList()[i].getGender().getGender();
			data[4] = groupPeople.getPeopleList()[i].getBirthDate().toString();
			data[5] = groupPeople.getPeopleList()[i].getCity();
			data[6] = groupPeople.getPeopleList()[i].getEmail();
			data[7] = String.valueOf(groupPeople.getPeopleList()[i].getPhone());
			data[8] = String.valueOf(groupPeople.getPeopleList()[i].getValue());
			this.jFrameViewPeople.jPanelPeople.defaultTableModel.addRow(data);
		}
	}

	/**
	 * cargar datos
	 */

	public void btloadDateActionPerformed() {
		try {
			this.load1 = new Load();
			load1.openFile();
			if (load1.getListPeople() != null) {
				pathActual = load1.getPathArchivo();
				int number = jFrameViewPeople.jPanelPeople.defaultTableModel.getRowCount();
				if (number != 0) {
					for (int i = 0; i < number; i++) {
						this.jFrameViewPeople.jPanelPeople.defaultTableModel.removeRow(0);
					}
				}
				groupPeople.setListPeople(load1.getListPeople());
				addPersonTable();
				message.showMessage(null, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_CHARGE_COMPLETED));
				jFrameViewPeople.setTitlePaht(pathActual);
			}
		} catch (Exception e) {
			message.showMessage(null, "Error al cargar el archivo");
		}
		

	}
	
	/**
	 * modo de guardado
	 */
	public void setModSave() {
		Save save = new Save();
		save.setPathName(pathActual);
		if (save.getPathName().equals("")) {
			btSaveAsActionPerformed();

		} else {
			btSaveActionPerformed();

		}
	}

	/**
	 * guardado normal
	 */
	public void btSaveActionPerformed() {
		Save save = new Save();
		save.saveNormal(pathActual, groupPeople.getPeopleList());
		message.showMessage(null, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_SAVE_CORRECT));
		this.pathActual = save.getPathName();
		jFrameViewPeople.setTitlePaht(pathActual);

	}

	/**
	 * guardar como
	 */
	public void btSaveAsActionPerformed() {
		Save save = new Save();
		save.saveAs(groupPeople.getPeopleList());
		if (save.isSave()) {
			message.showMessage(null, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_SAVE_CORRECT));
			this.pathActual = save.getPathName();
			jFrameViewPeople.setTitlePaht(pathActual);
		}
	}
	/**
	 * carga una imgane de perfil
	 */
	public void btAddPhotoActionPerformed() {
		int result = 0;
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JGP y PNG", "jpg", "png");
		this.jFrameViewPeople.jFileChooser.setFileFilter(extensionFilter);
		result = this.jFrameViewPeople.jFileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			this.file = this.jFrameViewPeople.jFileChooser.getSelectedFile();
			try {
				this.icon = new ImageIcon(file.toString());
				this.jFrameViewPeople.jPanelPeople.jLabelPhoto.setText(null);

				Icon icon2 = new ImageIcon(
						icon.getImage().getScaledInstance(this.jFrameViewPeople.jPanelPeople.jLabelPhoto.getWidth(),
								this.jFrameViewPeople.jPanelPeople.jLabelPhoto.getWidth(), Image.SCALE_DEFAULT));

				this.jFrameViewPeople.jPanelPeople.jLabelPhoto.setIcon(icon2);

			} catch (Exception e) {
				message.showMessage(null, jFrameViewPeople.lenguage.getProperty(Constant.MESAGGE_ERROR_FILE + " " + e));
			}
		}

	}
	/**
	 * Verifica que haya una direccion de imagen
	 * @return
	 */
	public ImageIcon getImage() {
		if (icon != null) {
			return icon;

		} else {
			return new ImageIcon(" ");
		}
	}

	/**
	 * sobreecribe la acciones de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonAddPerson) {
			btAddActionPerformed();
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonNew) {
			btNewActionPerformed();
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonModifyPerson) {
			btModifyActionPerformed(e);
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonDeletePerson) {
			btDeleteActionPerformed();
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonExit) {
			btExitActionPerformed();
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonLoad) {
			btloadDateActionPerformed();
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonSave) {
			setModSave();
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonSaveAs) {
			btSaveAsActionPerformed();
		} else if (e.getSource() == this.jFrameViewPeople.jPanelPeople.jButtonAddPhoto) {
			btAddPhotoActionPerformed();
		} 
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (jFrameViewPeople.jPanelPeople.jRadioButtonFemale.isSelected()) {
			setGenderAux(Gender.FEMALE);
		} else if (jFrameViewPeople.jPanelPeople.jRadioButtonMale.isSelected()) {
			setGenderAux(Gender.MALE);
		}

	}

}
