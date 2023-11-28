package clubApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ClubApplication {
	public static void main(String[] args) throws BadBookingException {
		Person p1 = new Person("Inella","von","Einzbern");
		p1.show();
		Facility f1 = new Facility("n1","d1");
		Facility f2 = new Facility("n2","d2");
		f1.show();
		f2.show();
		Member m1 = new Member("Inella","von","Einzbern",666);
		m1.show();
		Club c = new Club();
		Member m2 = c.addMember(p1);
		m2.show();
		c.addMember(p1);
		c.showMember();
		c.removeMember(0);
		c.showMember();
		c.getMember();
		System.out.println(c.findMember(0));
		c.addFacility(f1);
		c.addFacility(f2);
		c.getFacility("n1");
		c.showFacilities();
		c.removeFacility("n1");
		c.showFacilities();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm", Locale.ENGLISH);
		DateTimeFormatter df1=DateTimeFormatter.ofPattern("d-MM-yyyy H:mm");
		LocalDateTime t1 = LocalDateTime.parse("01-Nov-2023 15:00",df);
		LocalDateTime t2 = LocalDateTime.parse("04-Nov-2023 15:00",df);
		LocalDateTime t3 = LocalDateTime.parse("07-Nov-2023 15:00",df);
		LocalDateTime t4 = LocalDateTime.parse("10-Nov-2023 15:00",df);
		LocalDateTime t5 = LocalDateTime.parse("10-11-2023 15:00",df1);
		try {
			Booking b1 = new Booking(m1,f1,t1,t5);
			Booking b2 = new Booking(m2,f1,t2,t5);
			//Booking b2 = new Booking(m1,f1,t2,t1);
			System.out.println(b1);
			System.out.println(b1.overlaps(b2));
		}
		catch(BadBookingException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
