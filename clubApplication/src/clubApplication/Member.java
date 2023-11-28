package clubApplication;

public class Member extends Person implements Comparable<Member>{
	private int memberNumber;

	public Member(String surName, String firstName, String secondName, int memberNumber) {
		super(surName, firstName, secondName);
		this.memberNumber = memberNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+memberNumber;
	}
	@Override
	public int compareTo(Member another) {
		if(this.getSurName().compareTo(another.getSurName())!=0) {
			return this.getSurName().compareTo(another.getSurName());
		}
		else if(this.getFirstName().compareTo(another.getFirstName())!=0) {
			return this.getFirstName().compareTo(another.getFirstName());
		}
		else if(this.getSecondName().compareTo(another.getSecondName())!=0){
			return this.getSecondName().compareTo(another.getSecondName());
		}
		else{
			return 0;
		}
	}
}
