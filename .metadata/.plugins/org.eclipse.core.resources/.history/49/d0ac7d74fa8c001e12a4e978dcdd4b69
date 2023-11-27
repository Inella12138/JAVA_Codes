package clubApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Club {
	private int currentNumber;
	private List<Member> members;
	Map<String,Facility> n2f;
	
	public Club() {
		currentNumber = 0;
		members = new ArrayList<>();
		n2f = new HashMap<>();
	}
	
	public List<Member> getMember(){
		return members;
	}
	
	public Member addMember(Person p) {
		Member m = new Member(p.getSurName(),p.getFirstName(),p.getSecondName(), currentNumber);
		currentNumber++;
		members.add(m);
		return m;
	}
	public void showMember() {
		for(Member m:members) {
			m.show();
		}
	}
	public void removeMember(int num) {
		members.remove(num);
	}
	public Member findMember(int index) {
		return members.get(index);
	}
	
	public Facility getFacility(String name) {
		return n2f.get(name);
	}
	public Collection<Facility> getFacilities(){
		return n2f.values();
	}
	public void addFacility(Facility f) {
		n2f.put(f.getName(),f);
	}
	public void removeFacility(String name) {
		n2f.remove(name);
	}
	public void showFacilities() {
		for(Facility f : n2f.values()) {
			System.out.println(f);
		}
	}
}
