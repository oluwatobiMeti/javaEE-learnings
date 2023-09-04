
public class dataBase {
  
private String firstName;
  private String LastName;
  
  
  public dataBase() {
	super();
}
public dataBase(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.LastName = lastName;
}
public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
  
  
}
