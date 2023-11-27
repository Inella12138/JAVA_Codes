package clubApplication;

import java.time.LocalDateTime;

public class Booking {
	private Member m;
	private Facility f;
	private LocalDateTime start;
	private LocalDateTime end;

	public Booking(Member m, Facility f, LocalDateTime start, LocalDateTime end) {
		this.m = m;
		this.f = f;
		this.start = start;
		this.end = end;
	}

	public Member getM() {
		return m;
	}

	public Facility getF() {
		return f;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getEnd() {
		return end;
	}
	
	public boolean overlaps(Booking b) {
		if(b.f.equals(this.f)) {
			if((b.start.isAfter(this.start)&&b.start.isBefore(this.end))||(this.start.isAfter(b.start)&&this.start.isBefore(b.end))) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return m.toString()+" booked "+f.toString()+" from "+start.toString()+" to "+end.toString();
	}
}
