package models;
/**
 * Crea los generos de las pesonas
 * @author Felipe Gonzalez
 *
 */
public enum Gender {
	
	MALE("Masculino"), FEMALE("Femenino");
	
	private String gender;
	
	private Gender (String gender) {
		this.gender = gender;
	}
	
	public String getGender(){
		return gender;
		
	}
	
	public void setGender( String gender) {
		this.gender = gender;
	}
	/**
	 * retorna un vector con los nombres de los usuarios 
	 * @return
	 */
	public  static String [] getGenderString() {
		String [] option = new String[ Gender.values().length];
		int i = 0;
		for (Gender gender : Gender.values()) {
			option[i + 1] = gender.name();
		}
		return option;
	}
	
}
