import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connnect {
 private String DbUrl = "jdbc:mysql://localhost:3306/userinfo";
 private String dbpassword = "";
 private String dbUsername = "root";
 private String driver = "com.mysql.cj.jdbc.Driver";
 
 public void loadDriver(String Driver) {
	 try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 public Connection getConnection() {
	 Connection con = null;
	 try {
		con = DriverManager.getConnection(DbUrl, dbUsername, dbpassword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return con;
 }
 
 public String Insert(dataBase dt) {
	 loadDriver(driver);
	 Connection con = getConnection();
	 String result = "data insertion successful";
	 String sql = "insert into users(fname,lname) values(?,?)";
	 
	 
	 try {
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setString(1, dt.getFirstName());
		pr.setString(2, dt.getLastName());
		pr.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result = "unsuccessfull";
	}
	 return result;
	 
 }
//
}
