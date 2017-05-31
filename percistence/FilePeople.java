package percistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import models.OpenForm;

public class FilePeople {

	private String filename;
	private File file;
	private RandomAccessFile randomAccessFile;

	public FilePeople(String filename) {
		this.file = new File(filename);
		
	}

	public void open(OpenForm openForm) {
		try {
			this.randomAccessFile = new RandomAccessFile(file,
					(openForm == OpenForm.READ) ? "r" : "rw");
		} catch (FileNotFoundException ex) {
		}
	}

	public RandomAccessFile getRandomAccessFile() {
		return randomAccessFile;
	}
	
	public void close() {
		try {
			randomAccessFile.close();
		} catch (IOException ex) {
		}
	}

	public File getFile() {
		return file;
	} 
	
}
