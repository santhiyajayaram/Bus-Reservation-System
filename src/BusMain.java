import java.sql.SQLException;
import java.util.Scanner;
public class BusMain {

	public static void main(String[] args) throws SQLException {
		
		Bus_info bus_info = new Bus_info();
		bus_info.displayBusInfo();
		
		int user_option = 1;
		Scanner scanner = new Scanner(System.in);
		
		while(user_option == 1) {
			System.out.println("Enter 1 to Book and 2 to exit");
			if(user_option == 1) {
				Booking booking = new Booking();
				if(booking.isAvailable()) {
					Booking_info booking_info = new Booking_info();
					booking_info.addBooking(booking);
					System.out.println("Your booking is confirmed");
				} else {
					System.out.println("Sorry, Bus is full. Try another bus");
				}
			}
		}
		scanner.close();
	} 
}

	