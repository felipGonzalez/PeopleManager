package models;

import java.time.LocalDate;

import javax.swing.ImageIcon;

public class People {

	protected int id;
	protected   String firstName;
	protected  String lastName;
	protected  Gender gender;
	protected LocalDate birthDate;
	protected float value;
	protected String phone;
	protected ImageIcon photo;
	protected String  email;
	protected String city;
	
	public People(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, String phone ,float  value,
			ImageIcon photo, String city, String email) throws Exception {
		super();
		setId(id);
		setFirstName( firstName );
		setLastName( lastName );
		setGender(gender);
		setBirthDate(birthDate);
		setValue(value);
		setPhone(phone);
		setPhoto(photo);
		setCity(city);
		setEmail(email);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public People() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * calcula la edad de la persona en base de la fecha de nacimiento
	 * @return
	 * @throws Exception
	 */
	public int getAge() throws Exception {
		int age = 0;
		if (birthDate.getYear() > LocalDate.now().getYear()) {
			throw new Exception("Error fecha fuera de rango");
		}
		age = (LocalDate.now().getYear() - birthDate.getYear());
		if (LocalDate.now().getMonthValue() < birthDate.getMonthValue()) {
			age--;
		} else if (LocalDate.now().getMonthValue() == birthDate.getMonthValue()) {
			if (LocalDate.now().getDayOfMonth() < birthDate.getDayOfMonth()) {
				age--;
			}
		}
		return age;
	}
	/**
	 * @param phone2
	 */
	public void setPhone(String phone2) {
		this.phone =phone2;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhoto(ImageIcon photo2) {
		this.photo = photo2;
	}
	
	public ImageIcon getPhoto(){
		return photo;
	}
	
	public void setValue(float value2) {
		this.value = value2;
	}
	
	public float getValue(){
		return value;
	}
	
	public void setBirthDate(LocalDate birthDate2) {
		this.birthDate = birthDate2;
	}
	
	public LocalDate getBirthDate(){
		return birthDate;
	}
	
	public void setLastName(String lastName2) {
		this.lastName = lastName2;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setGender(Gender gender2) {
		this.gender = gender2;
	}
	
	public Gender getGender(){
		return gender;
	}
	
	public void setId(int id2) {
		this.id = id2;
	}
	
	public int getId(){
		return id;
	}
	
	public void setFirstName(String firstName2) {
		this.firstName = firstName2;
	}
	
	public String getFirsName(){
		return firstName;
	}
	
	public void calculateAge(){
		LocalDate date = LocalDate.now();
	}
	
	public boolean chekName( String name ){
		return (name == firstName) ? true: false;
	}
	
	public String toStringFormat(){
		String line =  (this.id + "," + this.firstName+ "," + this.lastName+ "," + this.gender+ "," + this.birthDate+ "," + this.phone + "," 
	+this.value+ "," +	this.photo.toString() +"," +this.city+","+ this.email);
		return line;
	}	
	
	@Override
	public String toString() {
		String formatLine = "%1$-10s %2$-20s %3$-20s %4$-10s %5$-15s %6$-15s %7$-15s %8$-15s %9$-15s %10$-15s";
		String userLine = String.format(formatLine, this.id, this.firstName, this.lastName, this.gender, this.birthDate,
				this.phone, this.value, this.photo.toString(), this.city, this.email);
		return userLine;
	}
}
