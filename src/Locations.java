public class Locations
{
	private final int ID;
	private String locationName;
	private String image;

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return(ID);
	}

	public void setLocationName(String ln) {
		locationName = ln;
	}

	publoc String getLocationName() {
		return(locationName);
	}

	public void setImage(String img) {
		image = img;
	}

	public String getImage() {
		return(image);
	}
}
