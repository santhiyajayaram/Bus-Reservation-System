import java.util.Date;
import java.sql.*;
public class Booking_info {
	public int getBookedCount(int busNo, Date date) throws SQLException{
		String query = "select count(passenger_name) from booking where bus_no = ? and tavel_date = ?";
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public void addBooking(Booking booking) throws SQLException{
		String query = "insert into booking values(?,?,?)";
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
		pst.setString(1,  booking.passengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqldate);
		
		pst.executeUpdate();
	}
}
