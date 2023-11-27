package clubApplication;

public class Person {
	private String surName;
	private String firstName;
	private String secondName;
	
	public Person(String surName, String firstName, String secondName) {
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	public String getSurName() {
		return surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	
	@Override
	public String toString() {
		return surName+" "+firstName+" "+secondName;
	}
	public void show() {
		System.out.println(this);
	}
	
	
}
