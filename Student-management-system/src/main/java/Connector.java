import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connector {
 private String DbUrl = "jdbc:mysql://localhost:3306/userinfo";
 private String dbpassword = "";
 private String dbUsername = "root";
 private String driver = "com.mysql.cj.jdbc.Driver";
 public static final String INSERT_INTO_STUDENT = "INSERT INTO student (LastName, FirstName, Age, description, performance, Location) value (?,?,?,?,?,?);";
 public static final String SELECT_BY_ID = "select * from student where StudentId = ?;";
 public static final String SELECT_ALL_STUDENT = "select * from student;";
 public static final String DELECT_STUDENT = "delect from student where StudentId = ?;";
 public static final String UPDATE_STUDENT = "update student set LastName = ?, FirstName = ?, Age = ?, description = ?, performance = ?, Location where StudentId = ?";
 
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
 
 public void insertStudent(Student std) throws SQLException {
	 try(Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(INSERT_INTO_STUDENT)) {
		 pr.setString(1, std.getLastName());
		 pr.setString(2, std.getFirstName());
		 pr.setInt(1, std.getAge());
		 pr.setString(1, std.getDescription());
		 pr.setString(1, std.getPerformance());
		 pr.setString(1, std.getLocation());
		 pr.executeUpdate();
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
 }
 
 public void updateStudent(Student std) throws SQLException {
	 boolean rowsUpdated;
	 try(Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(UPDATE_STUDENT)) {
		 pr.setString(1, std.getLastName());
		 pr.setString(2, std.getFirstName());
		 pr.setInt(1, std.getAge());
		 pr.setString(1, std.getDescription());
		 pr.setString(1, std.getPerformance());
		 pr.setString(1, std.getLocation());
		 rowsUpdated = pr.executeUpdate() > 0;
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
 }
 
public Student selectStudentById(int id) throws SQLException {
	Student Std = null;
	try(Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(SELECT_BY_ID);) {
		pr.setInt(1, id);
		System.out.println(pr);
		ResultSet rs = pr.executeQuery();
		
		while(rs.next()) {
			String LastName, FirstName, description, performance, Location;
			int Age = 0;
			LastName = rs.getString("LastName");
			FirstName = rs.getString("FirstName");
			int age = rs.getInt(Age);
			description = rs.getString("description");
			performance = rs.getString("performance");
			Location = rs.getString("Location");
			
			Std = new Student(LastName, FirstName, Age, description, performance, Location);
			
			
		}
	} catch (Exception e) {
		 e.printStackTrace();
	 }
	return Std;
}

public List<Student> selectAllStudent() throws SQLException {
	List<Student> Std = new ArrayList<>();
	try(Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(SELECT_ALL_STUDENT);) {
		System.out.println(pr);
		ResultSet rs = pr.executeQuery();
		
		while(rs.next()) {
			String LastName, FirstName, description, performance, Location;
			int Age = 0;
			LastName = rs.getString("LastName");
			FirstName = rs.getString("FirstName");
			int age = rs.getInt(Age);
			description = rs.getString("description");
			performance = rs.getString("performance");
			Location = rs.getString("Location");
			
			Std.add(new Student(LastName, FirstName, Age, description, performance, Location));
			
			
		}
	} catch (Exception e) {
		 e.printStackTrace();
	 }
	return Std;
}
public boolean delectStudent(int id) throws SQLException {
	boolean rowDelected = false;
	try(Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(DELECT_STUDENT);) {
		pr.setInt(1, id);
		rowDelected = pr.executeUpdate() > 0;
	} catch (Exception e) {
		 e.printStackTrace();
	 }
	return rowDelected;
	
}




// public String Insert(Student std) {
//	 loadDriver(driver);
//	 Connection con = getConnection();
//	 String result = "data insertion successful";
//	 String sql = "insert into student( LastName, FirstName, Age, description, performance, Location) values(?,?,?,?,?,?)";
//	 
//	 
//	 try {
//		PreparedStatement pr = con.prepareStatement(sql);
//		pr.setString(1, std.getFirstName());
//		pr.setString(2, std.getLastName());
//		pr.setInt(3, std.getAge());
//		pr.setString(4, std.getDescription());
//		pr.setString(5, std.getPerformance());
//		pr.setString(2, std.getLocation());
//		pr.executeUpdate();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		result = "unsuccessfull";
//	}
//	 return result;
//	 
// }
// public String UpdateStudent(Student std) {
//	 loadDriver(driver);
//	 Connection con = getConnection();
//	 String result = "data updated successful";
//	 String sql = "insert into student( LastName, FirstName, Age, description, performance, Location) values(?,?,?,?,?,?)";
//	 
//	 
//	 try {
//		PreparedStatement pr = con.prepareStatement(sql);
//		pr.setString(1, std.getFirstName());
//		pr.setString(2, std.getLastName());
//		pr.setInt(3, std.getAge());
//		pr.setString(4, std.getDescription());
//		pr.setString(5, std.getPerformance());
//		pr.setString(2, std.getLocation());
//		pr.executeUpdate();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		result = "unsuccessfull";
//	}
//	 return result;
//	 
// }
// public String Find(Student std) {
//	 loadDriver(driver);
//	 Connection con = getConnection();
//	 String result = "successful";
//	 String sql = "Select LastName, FirstName, Age, description, performance, Location from student";
//	 
//	 
//	 try {
//		PreparedStatement pr = con.prepareStatement(sql);
//		pr.setString(1, std.getFirstName());
//		pr.setString(2, std.getLastName());
//		pr.setInt(3, std.getAge());
//		pr.setString(4, std.getDescription());
//		pr.setString(5, std.getPerformance());
//		pr.setString(2, std.getLocation());
//		pr.executeUpdate();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		result = "unsuccessfull";
//	}
//	 return result;
//	 
// }
//
}
