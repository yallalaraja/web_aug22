package web.vo;

public class Student {
	private int stuId;
	private String firstName;
	private String lastName;
	
	public Student(int stuId, String firstName, String lastName) {
		super();
		this.stuId = stuId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Student() {
		super();
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
