package FinalProject.MakeMyTrip.pojo;

import java.util.List;
// to store Search Criteria
public class SearchBO {

	private String city;
	private String checkinDate;
	private String checkoutDate;

	private String roomCount;
	private String adultCount;
	private String childrenCount;

	private String children1Age;
	private String children2Age;
	private String children3Age;

	private List<String> childrenAge;

	private String travellingReason;

	private String pricePerNight;

	private String userRating;

	private String room_GuestDetails;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getRoom_GuestDetails() {
		return room_GuestDetails;
	}

	public void setRoom_GuestDetails(String room_GuestDetails) {
		this.room_GuestDetails = room_GuestDetails;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public List<String> getChildrenAge() {
		return childrenAge;
	}

	public void setChildrenAge(List<String> childrenAge) {
		this.childrenAge = childrenAge;
	}

	public String getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}

	public String getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(String adultCount) {
		this.adultCount = adultCount;
	}

	public String getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(String childrenCount) {
		this.childrenCount = childrenCount;
	}

	public String getChildren1Age() {
		return children1Age;
	}

	public void setChildren1Age(String children1Age) {
		this.children1Age = children1Age;
	}

	public String getChildren2Age() {
		return children2Age;
	}

	public void setChildren2Age(String children2Age) {
		this.children2Age = children2Age;
	}

	public String getChildren3Age() {
		return children3Age;
	}

	public void setChildren3Age(String children3Age) {
		this.children3Age = children3Age;
	}

	public String getTravellingReason() {
		return travellingReason;
	}

	public void setTravellingReason(String travellingReason) {
		this.travellingReason = travellingReason;
	}

	public String getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(String pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

	@Override
	public String toString() {
		return "SearchBO [city=" + city + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate
				+ ", roomCount=" + roomCount + ", adultCount=" + adultCount + ", childrenCount=" + childrenCount
				+ ", children1Age=" + children1Age + ", children2Age=" + children2Age + ", children3Age=" + children3Age
				+ ", childrenAge=" + childrenAge + ", travellingReason=" + travellingReason + ", pricePerNight="
				+ pricePerNight + ", userRating=" + userRating + ", room_GuestDetails=" + room_GuestDetails + "]";
	}

}