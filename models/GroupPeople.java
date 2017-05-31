package models;

import java.time.LocalDate;

/**
 * @author Felipe Gonzales ,david guio, diego flechas
 *
 */

public class GroupPeople {

	private People [] peopleList;
	
	public GroupPeople(){
		this.peopleList = new People[0];
	}
	
	public GroupPeople( GroupPeople newPeopleList ){
		this.peopleList = newPeopleList.getPeopleList();
	}
	
	public  People [] getPeopleList() {
		return peopleList;
	}

	public void addPerson( People person){
		People[] auxListPerson = new People[this.peopleList.length + 1];
		for (int i = 0; i < peopleList.length; i++) {
			auxListPerson[i] = peopleList[i];
		}
		auxListPerson[auxListPerson.length -1] = person;
		System.out.println(auxListPerson[auxListPerson.length -1].toString());
		this.peopleList = auxListPerson;
	}
	
	public void modifyPerson(People person, int pos){
		peopleList[pos] = person;
	}
	
	
	public void setListPeople(People [] list){
		this.peopleList = list;
	}
	
	public People getPeople(int pos){
		return peopleList[pos];
	}
	
	public void deletePeople( int  id) {
		for (int i = 0; i < peopleList.length; i++) {
			if (peopleList[i] != null) {
				if(peopleList[i].getId() == id){
					peopleList[i] = null;
					break;
				}
			}
		}
		order();
	}
	
	
	public void deletePeoplePos( int  pos) {
		peopleList[pos] = null;
		order();
	}
	
	public void order(){
		People [] AuxListPeople = new People[this.peopleList.length - 1];
		int num = 0;
		for (int i = 0; i < peopleList.length; i++) {
			if( peopleList[i] != null){
				AuxListPeople[num] = peopleList[i];
				num++;
			}
		}
		this.peopleList = AuxListPeople;
	}
	
	public boolean searchPeople( String name) {
		for (int i = 0; i < peopleList.length; i++) {
			if (peopleList[i] != null) {
				if(peopleList[i].getFirsName().equals(name)){
					return true;
				}
			}
		}
		return false;
	}
	
	public People [] findTwo( byte first, byte last ) throws Exception{
		People [] AuxListPeople = new People[this.peopleList.length];
		byte numPeopleOutRange = 0;
		for (int i = 0; i < peopleList.length; i++) {
			if( peopleList[i].getAge() >= first && peopleList[i].getAge() <= last){
				AuxListPeople[i] = peopleList[i];
			}
			else{
				numPeopleOutRange++;
			}
		}
		
		if(numPeopleOutRange == peopleList.length){
			throw new Exception("No ha nadie en este rango");
		}
		return AuxListPeople;
	}
	
	public People []  fingGroupPeople( Gender gender) {
		People [] AuxListPeople = new People[orderListAux( gender)];
		System.out.println(AuxListPeople.length);
		int num = 0;
		for (int i = 0; i < peopleList.length; i++) {
			if(peopleList[i].getGender() == gender){
				AuxListPeople[num] = peopleList[i];
			}
		}
		return AuxListPeople; 
	}
	
	public int orderListAux(Gender gender){
		int sum = 0;
		for (int i = 0; i < peopleList.length; i++) {
			if(peopleList[i].getGender() == gender){
			sum++;
			}			
		}
		return sum;
	}

	public boolean confirText(String [] list) {
		int i = 0;
		boolean flag = true;
		while(i < list.length && flag){
			if(list[i] != null){
				if(list[i].equals("")){
					flag = false;
				}
			}
			i++;
		}
		return flag;
	}
	
	public boolean getValidationInt(String line) {
		boolean flag;
		int i = 0;
		flag = true;
		while (i < line.length() && flag) {
			if (line.charAt(i) < 48 || line.charAt(i) > 58) {
				if (line.charAt(i) != 46 && line.charAt(i) != 69) {
					flag = false;
				}
			}
			i++;
		}
		return flag;
	}
		
	public boolean getValidationId(int id){
		boolean flag = true;
		for (People people : peopleList) {
			if(people.getId() == id){
				flag = false;
			}
		}
		return flag;
	}
	
	public boolean getValidationDate(LocalDate date) {
		return (LocalDate.now().compareTo(date) < 0) ? false : true;
	}
}
