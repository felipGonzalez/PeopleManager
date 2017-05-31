package test;

import java.sql.Date;
import java.time.LocalDate;

public class TestToolKit {
	
	public static void main(String[] args) {
		System.out.println(""+LocalDate.now().getDayOfYear());
		LocalDate date = LocalDate.of(2017, 4, 21); 
		System.out.println(""+LocalDate.now().compareTo(date));
		System.out.println(new Date(System.currentTimeMillis()));
	}
	
}
