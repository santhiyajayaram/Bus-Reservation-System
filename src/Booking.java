import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of the passenger: ");
		passengerName = scanner.next();
		System.out.println("Enter bus no: ");
		busNo = scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy: ");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
	
	public boolean isAvailable() throws SQLException{
		
		Bus_info bus_info = new Bus_info();
		Booking_info  booking_info = new Booking_info();
		int capacity = bus_info.getCapacity(busNo);
		int booked = booking_info.getBookedCount(busNo, date);
	
		return booked < capacity;
	}
}
