
public class Student {
	 private int StudentId;
	 private String LastName;
	 private String FirstName;
	 private int Age;
	 private String description;
	 private String performance;
	 private String Location;
	 
	public Student(int studentId, String lastName, String firstName, int age, String description, String performance,
			String location) {
		super();
		StudentId = studentId ;
		LastName = lastName;
		FirstName = firstName;
		Age = age;
		this.description = description;
		this.performance = performance;
		Location = location;
	}
	public Student(String lastName, String firstName, int age, String description, String performance,
			String location) {
		super();
		LastName = lastName;
		FirstName = firstName;
		Age = age;
		this.description = description;
		this.performance = performance;
		Location = location;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	 
}
