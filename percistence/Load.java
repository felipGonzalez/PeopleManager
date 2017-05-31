package percistence;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.*;

public class Load {

	private FilePeople fileSource;
	private String pathName;
	private People[] people;
	private DaoPeople [] daoPeople;
	private JFileChooser jFileChooser;
	private FileNameExtensionFilter extensionFilter;
	private static final String PATH = "resource/city.txt";
	private String [] listCity;
	
	public Load() {
		
	}
	
	public void openFile() {
		jFileChooser = new JFileChooser();
		extensionFilter = new FileNameExtensionFilter("BIN","bin");
		jFileChooser.setApproveButtonText("Cargar");
		jFileChooser.setFileFilter(extensionFilter);
		if (jFileChooser.showOpenDialog(null) == 0) {
			this.fileSource = new FilePeople(jFileChooser.getSelectedFile() + "");
			this.people = new People[(int) (fileSource.getFile().length()/DaoPeople.RECORD_SIZE)];
			this.daoPeople = new DaoPeople[(int) (fileSource.getFile().length()/DaoPeople.RECORD_SIZE)];
			fileSource.open(OpenForm.READ);
			loadPerson();
			fileSource.close();
		}

	}

	public void loadPerson() {
		try{
		for (int i = 0; i < daoPeople.length; i++) {
			daoPeople[i] = new DaoPeople();
			fileSource.getRandomAccessFile().seek(i*DaoPeople.RECORD_SIZE);
			byte[] data = new byte[DaoPeople.NAME_LENGHT];
			daoPeople[i].setId(fileSource.getRandomAccessFile().readInt());
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setFirstNameArrayToString(data);
			data = new byte[DaoPeople.NAME_LENGHT];
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setLastNameArrayToString(data);
			data = new byte[DaoPeople.GENDER_LENGHT];
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setGenderArrayToString(data);
			data = new byte[DaoPeople.BIRTTHDATE_LENGHT];
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setBirthDateArrayToString(data);
			daoPeople[i].setValue(fileSource.getRandomAccessFile().readFloat());
			data = new byte[DaoPeople.PHONE_LENGHT];
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setPhoneArrayToString(data);
			data = new byte[1];
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setPhotoArrayToString(data);
			data = new byte[DaoPeople.CITY_LENGHT];
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setCityArrayToString(data);
			data = new byte[DaoPeople.EMAIL_LENGHT];
			fileSource.getRandomAccessFile().read(data);
			daoPeople[i].setEmailArrayToString(data);
		}
		}catch(IOException ex) {
			
		}
		
		
	}
	
	public People[] getListPeople() {
		for (int i = 0; i < daoPeople.length; i++) {
			people[i] = daoPeople[i].getPeople();
		}
		return people;
	}

	public String getPathArchivo() {
		return fileSource.getFile().getPath();
	}

	public String [] loadCity(){
		FileManager fileManager =new FileManager(PATH, OpenForm.READ);
		this.listCity = new String [0];
		fileManager.open();
		String line = ".";
		while (line != null) {
			line = fileManager.read();
			if(line != null){
				
				add(line);
				
			}
		}
		return listCity;
	}

	public void add( String file){
		String[] auxListFile = new String[this.listCity.length + 1];
		for (int i = 0; i < listCity.length; i++) {
			auxListFile[i] = listCity[i];
		}
		auxListFile[auxListFile.length -1] = file;
		this.listCity = auxListFile;
	}
	
}
