package percistence;

import java.time.LocalDate;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

import models.Gender;
import models.People;

public class DaoPeople {

	public static final int RECORD_SIZE = 85;
	public static final int NAME_LENGHT = 10;
	public static final int GENDER_LENGHT = 6;
	public static final int RECORD_NULL = -1;
	public static final int BIRTTHDATE_LENGHT = 10;
	public static final int PHONE_LENGHT = 10;
	public static final int EMAIL_LENGHT = 20;
	public static final int CITY_LENGHT = 10;

	private int id; // 4
	private byte[] firstName;// 10
	private byte[] lastName;// 10
	private byte[] gender;// 6
	private byte[] birthDate;//10
	private float value;// 4
	private byte[] phone;// 10
	private byte[] photo;// 1
	private byte[] email;// 20
	private byte[] city;// 10

	public DaoPeople() {

	}

	public DaoPeople(People people) {
		this.id = people.getId();
		this.firstName = stringToArray(people.getFirsName(), NAME_LENGHT);
		this.lastName = stringToArray(people.getLastName(), NAME_LENGHT);
		this.gender = stringToArray(String.valueOf(people.getGender()), GENDER_LENGHT);
		this.birthDate = stringToArray(people.getBirthDate().toString(), BIRTTHDATE_LENGHT);
		this.value = people.getValue();
		this.phone = stringToArray(people.getPhone(), PHONE_LENGHT);
		this.photo = stringToArray(people.getPhoto().toString(), 1);
		this.email = stringToArray(people.getEmail(), EMAIL_LENGHT);
		this.city = stringToArray(people.getCity(), CITY_LENGHT);
	}

	public DaoPeople(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, float value,
			String phone, ImageIcon photo, String email, String city) {
		this.id = id;
		this.firstName = stringToArray(firstName, NAME_LENGHT);
		this.lastName = stringToArray(lastName, NAME_LENGHT);
		this.gender = stringToArray(String.valueOf(gender), GENDER_LENGHT);
		this.birthDate = stringToArray(birthDate.toString(), BIRTTHDATE_LENGHT);
		this.value = value;
		this.phone = stringToArray(phone, PHONE_LENGHT);
		this.photo = stringToArray(photo.toString(), 1);
		this.email = stringToArray(email, EMAIL_LENGHT);
		this.city = stringToArray(city, CITY_LENGHT);
	}

	private byte[] stringToArray(String string, int size) {
		byte[] array = new byte[size];
		for (int i = 0; i < Math.min(string.length(), size); i++) {
			array[i] = (byte) string.charAt(i);
		}

		return array;
	}

	private String arrayToString(byte[] array, int size) {
		String string = "";
		for (int i = 0; i < size; i++) {
			string += (char) array[i];
		}
		return string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = stringToArray(firstName, NAME_LENGHT);
	}

	public byte[] getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = stringToArray(lastName, NAME_LENGHT);
	}

	public byte[] getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = stringToArray(String.valueOf(gender), GENDER_LENGHT);
	}

	public byte[] getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = stringToArray(String.valueOf(birthDate.toString()), BIRTTHDATE_LENGHT);
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public byte[] getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = stringToArray(phone, PHONE_LENGHT);
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(ImageIcon photo) {
		this.photo = stringToArray("", 1);
	}

	public byte[] getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = stringToArray(email, EMAIL_LENGHT);
	}

	public byte[] getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = stringToArray(city, CITY_LENGHT);
	}

	public People getPeople() {
		People people = null;
		try {
			people = new People(this.id, arrayToString(firstName, NAME_LENGHT), arrayToString(lastName, NAME_LENGHT),
					getGenderString(),dateFormat(arrayToString(birthDate, BIRTTHDATE_LENGHT)),
					arrayToString(phone, PHONE_LENGHT),	this.value, new ImageIcon(arrayToString(photo, 1)), 
					arrayToString(city, CITY_LENGHT),arrayToString(email, EMAIL_LENGHT));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	}

	public Gender getGenderString(){
		String stringGender = arrayToString(birthDate, BIRTTHDATE_LENGHT);
		if(stringGender.contains("MALE") ){
			return Gender.MALE;
		}else{
			return Gender.FEMALE;
		}
		
	}
	
	public LocalDate dateFormat(String date) {
		StringTokenizer token = new StringTokenizer(date, "-");
		int year = Integer.parseInt(token.nextToken());
		int month = Integer.parseInt(token.nextToken());
		int day = Integer.parseInt(token.nextToken());
		return LocalDate.of(year, month, day);
	}

	public void setFirstNameArrayToString(byte[] firstName) {
		this.firstName = firstName;
	}

	public void setLastNameArrayToString(byte[] lastName) {
		this.lastName = lastName;
	}

	public void setGenderArrayToString(byte[] gender) {
		this.gender = gender;
	}

	public void setBirthDateArrayToString(byte[] birthDate) {
		this.birthDate = birthDate;
	}

	public void setPhoneArrayToString(byte[] phone) {
		this.phone = phone;
	}

	public void setPhotoArrayToString(byte[] photo) {
		this.photo = photo;
	}

	public void setEmailArrayToString(byte[] email) {
		this.email = email;
	}

	public void setCityArrayToString(byte[] city) {
		this.city = city;
	}

	// public String getNameString() {
	// return arrayToString(this.name, NAME_LENGHT);
	// }
	//
	// public String getAbreviateString() {
	// return arrayToString(this.abreviate, ABREVIATE_LENGHT);
	// }
	//
	// public int getCode() {
	// return code;
	// }
	//
	// public void setCode(int code) {
	// this.code = code;
	// }
	//
	// public byte getLevel() {
	// return level;
	// }
	//
	// public void setLevel(byte level) {
	// this.level = level;
	// }
	//
	// public long getCodeParent() {
	// return codeParent;
	// }
	//
	// public void setCodeParent(long codeParent) {
	// this.codeParent = codeParent;
	// }
	//
	// public void setName1(byte[] name) {
	// this.name = name;
	// }
	//
	// public void setAbreviate1(byte[] abreviate) {
	// this.abreviate = abreviate;
	// }
	//
	// public byte[] getName() {
	// return name;
	// }
	//
	// public byte[] getAbreviate() {
	// return abreviate;
	// }
	//

}
