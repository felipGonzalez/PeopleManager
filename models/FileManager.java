package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * abre un archivo ya sea para leer, editar, o escribir
 * @author Felipe Gonzaelz
 *
 */
public class FileManager {
	private File file;
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedWriter bufferedWriter = null;
	private BufferedReader bufferedReader = null;
	private OpenForm openForm;

	public FileManager(String nameFile, OpenForm openForm) {
		file = new File(nameFile);
		this.openForm = openForm;
	}
	/**
	 * Seleciona la forma de abrir
	 */
	public void open() {
		try {
			switch (this.openForm) {
			case WRITE:
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);
				break;
			case READ:
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				break;
			case APPEND:
				fileWriter = new FileWriter(file, true);
				bufferedWriter = new BufferedWriter(fileWriter);
				break;	
			default:
				break;
			}
		} catch (IOException e) {
			System.out.println("existe un error al abrir");
		}
	}
	// cierra el archivo
	public void close() {
		try {
			switch (this.openForm) {
			case WRITE:
			case APPEND:
				bufferedWriter.close();
				fileWriter.close();
				break;
			case READ:
				bufferedReader.close();
				fileReader.close();
				break;
			default:
				break;
			}
		} catch (IOException e) {
			System.out.println("existe un error al cerrar");
		}
	}

	// Almacena la cadena ingresada por parametro
	public void write(String cad) {
		if (this.openForm == OpenForm.WRITE || this.openForm == OpenForm.APPEND) {
			try {
				bufferedWriter.write(cad);
				bufferedWriter.newLine();
			} catch (IOException e) {
				System.out.println("Error al escribir");
			}
		}
	}

	// Lee una lnea del archivo
	public String read() {
		String cad = "";
		try {
			if(this.openForm == OpenForm.READ){
				cad = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error al leer");
		}
		return cad;
	}

	public File getFile(){
		return file;
	}
	
	public void createArray(){
		String line = ".";
		while (line != null) {
			line = read();
			System.out.println(line);	
		}
	}
}