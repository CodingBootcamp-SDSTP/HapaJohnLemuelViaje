public class Locations
{
	private final int ID;
	private String locationName;
	private String image;

	public Locations(int id, String ln, String img) {
		ID = id;
		locationName = ln;
		image = img;
	}

	public int getID() {
		return(ID);
	}

	public void setLocationName(String ln) {
		locationName = ln;
	}

	public String getLocationName() {
		return(locationName);
	}

	public void setImage(String img) {
		image = img;
	}

	public String getImage() {
		return(image);
	}
}
