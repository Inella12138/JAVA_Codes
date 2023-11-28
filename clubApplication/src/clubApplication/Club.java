package clubApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Club {
	private int currentNumber;
	private List<Member> members;
	private Map<String,Facility> n2f;
	private BookingRegister register;
	
	public Club() {
		currentNumber = 0;
		members = new ArrayList<>();
		n2f = new HashMap<>();
		register = new BookingRegister();
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
	public Member findMember(int memberNumber) {
		return members.get(Integer.valueOf(memberNumber));
	}
	
	public Facility getFacility(String name) {
		if(n2f.containsKey(name)) {
			return n2f.get(name);
		}
		else return null;
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
	public void addBooking(int memberNumber, String facilityName, LocalDateTime start, LocalDateTime end) throws BadBookingException {
		Member m = this.findMember(memberNumber);
		Facility f = this.getFacility(facilityName);
		register.addBooking(m,f,start,end);
	}
	public ArrayList<Booking> getBookings(String facilityName ,LocalDateTime start, LocalDateTime end){
		Facility f = this.getFacility(facilityName);
		return register.getBookings(f, start, end);
	}
	public void showBookings(String facilityName ,LocalDateTime start, LocalDateTime end) {
		for(Booking b:this.getBookings(facilityName, start, end)) {
			System.out.println(b);
		}
	}
	public void showFacilitiesSortedByName() {
		List<Facility> c = (List<Facility>)this.getFacilities();
		Collections.sort(c);
		for(Facility f:c) {
			System.out.println(f);
		}
	}
	public void showFacilitiesSortedByDescription() {
		List<Facility> c = (List<Facility>)this.getFacilities();
		Collections.sort(c, new DescriptionComparator());
		for(Facility f:c) {
			System.out.println(f);
		}
	}
	public void showMembersSorted() {
		Collections.sort(members);
		for(Member m:members) {
			System.out.println(m);
		}
	}
}
class DescriptionComparator implements Comparator<Facility>{
	@Override
	public int compare(Facility f1,Facility f2) {
		return f1.getDescription().compareTo(f2.getDescription());
	}
}