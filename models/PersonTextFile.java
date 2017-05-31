package models;

public class PersonTextFile extends People{

	public PersonTextFile() throws Exception {
		super();
	}
	
	public String toString(){
		String line =  (this.id + "," + this.firstName+ "," + this.lastName+ "," + this.gender+ "," + this.birthDate+ "," + this.phone + "," +this.value+ "," +
				this.photo);
		return line;
	}	
	
	public void toPerson( String line){
	}
}