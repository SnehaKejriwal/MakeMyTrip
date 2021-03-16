package FinalProject.MakeMyTrip.pojo;

public class HotelBO {
	private String hotelName;
	private String roomType;

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Override
	public String toString() {
		return "HotelBO [hotelName=" + hotelName + ", roomType=" + roomType + "]";
	}

}
