package clubApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingRegister {
	private HashMap<Facility, ArrayList<Booking>> f2b;

	public BookingRegister() {
		f2b = new HashMap<>();
	}

	public void addBooking(Member member, Facility facility, LocalDateTime startTime, LocalDateTime endTime) throws BadBookingException {
		Booking currentBooking = new Booking(member, facility, startTime, endTime);
		if (!f2b.containsKey(currentBooking)) {
			ArrayList<Booking> bookingList = new ArrayList<Booking>();
			bookingList.add(currentBooking);
			f2b.put(facility, bookingList);
		} else {
			ArrayList<Booking> bookingList = f2b.get(currentBooking.getFacility());
			for (Booking b : bookingList) {
				if (b.overlaps(currentBooking)) {
					throw new BadBookingException("Error!");
				}
			}
			bookingList.add(currentBooking);
			f2b.replace(facility, bookingList);
		}
	}

	public ArrayList<Booking> getBookings(Facility facility, LocalDateTime searchStart, LocalDateTime searchEnd) {
		ArrayList<Booking> result = f2b.get(facility);
		for (Booking b : result) {
			if (!((b.getStartTime().isAfter(searchStart) || b.getStartTime().isBefore(searchEnd))
					|| (b.getEndTime().isAfter(searchStart) || b.getEndTime().isBefore(searchEnd)))) {
				result.remove(b);
			}
		}
		return result;
	}

	public void removeBooking(Booking booking) {
		ArrayList<Booking> bookingList = f2b.get(booking.getFacility());
		bookingList.remove(booking);
		f2b.replace(booking.getFacility(), bookingList);
	}
}
