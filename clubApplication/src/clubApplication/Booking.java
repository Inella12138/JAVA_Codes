package clubApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Booking {
	private Member member;
	private Facility facility;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy HH:mm", Locale.ENGLISH);

	public Booking(Member member, Facility facility, LocalDateTime startTime, LocalDateTime endTime)
			throws BadBookingException {
		if (member == null || facility == null || startTime.isAfter(endTime)) {
			throw new BadBookingException("Error!");
		}
		this.member = member;
		this.facility = facility;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Member getMember() {
		return member;
	}

	public Facility getFacility() {
		return facility;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public boolean overlaps(Booking booking) {
		if (booking.facility.equals(this.facility)) {
			if ((booking.startTime.isAfter(this.startTime) && booking.startTime.isBefore(this.endTime))
					|| (this.startTime.isAfter(booking.startTime) && this.startTime.isBefore(booking.endTime))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return member.toString() + " booked " + facility.toString() + " from " + startTime.format(df) + " to " + endTime.format(df);
	}
}
