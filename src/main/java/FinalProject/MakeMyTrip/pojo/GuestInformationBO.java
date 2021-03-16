package FinalProject.MakeMyTrip.pojo;

public class GuestInformationBO {
	private String firstName;
	private String lastName;
	private String email;
	private String MobileNumber;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "GuestInformationBO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", MobileNumber=" + MobileNumber + "]";
	}
	

}
