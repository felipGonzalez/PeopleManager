package percistence;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.*;

public class Save {
	
	
	private static final String DATOS = "datos";
	private static final String EXTENSION = ".tmp";
	private FilePeople fileNew;
	private String pathName;
	private JFileChooser jFileChooser;
	private String path;
	private FileNameExtensionFilter extensionFilter;
	
	public Save() {
		this.pathName = "";
		this.fileNew = null;
		extensionFilter = new FileNameExtensionFilter("Bin","bin");
	}
	
	public void saveNormal(String pathName, People [] people){
		DaoPeople[] daoPeople = createList(people);
		this.pathName = pathName;
		delete(pathName);
		this.fileNew = new FilePeople(pathName);
		fileNew.open(OpenForm.WRITE);
		savePeople(daoPeople);
		fileNew.close();
	}

	
	public void savePeople(DaoPeople [] daoPeople) {
	try {
			for (int i = 0; i < daoPeople.length; i++) {
				System.out.println(daoPeople[i].RECORD_SIZE);
				this.fileNew.getRandomAccessFile().seek(i * daoPeople[i].RECORD_SIZE);
				this.fileNew.getRandomAccessFile().writeInt(daoPeople[i].getId());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getFirstName());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getLastName());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getGender());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getBirthDate());
				this.fileNew.getRandomAccessFile().writeFloat(daoPeople[i].getValue());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getPhone());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getPhoto());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getCity());
				this.fileNew.getRandomAccessFile().write(daoPeople[i].getEmail());
				
			}
		} catch (IOException ex) {
		}
	}
	
	public void saveAs(People [] people){
		DaoPeople[] daoPeople = createList(people);
		jFileChooser = new JFileChooser();
		jFileChooser.setFileFilter(extensionFilter);
		jFileChooser.setApproveButtonText("Guardar");
		jFileChooser.showSaveDialog(null);
		this.pathName = (jFileChooser.getSelectedFile()+"");
		if(!this.pathName.equals("")){
			delete(pathName);
			this.fileNew = new FilePeople(pathName);
			fileNew.open(OpenForm.WRITE);
			savePeople(daoPeople);
			fileNew.close();
		}
		
	}
	
	public boolean isSave() {
		if(fileNew == null){
			return false;
		}
		return true;
	}
	
	public void delete(String pathName) {
		this.fileNew = new FilePeople(pathName);
		this.fileNew.open(OpenForm.WRITE);
		this.fileNew.getFile().delete();
		this.fileNew.close();
	}
	
	public DaoPeople [] createList( People [] people) {
		DaoPeople[] daoPeople = new DaoPeople[people.length];
		for (int i = 0; i < people.length; i++) {
			daoPeople[i] = new DaoPeople(people[i]);
				
		}
			return daoPeople;
	}
	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	
}

