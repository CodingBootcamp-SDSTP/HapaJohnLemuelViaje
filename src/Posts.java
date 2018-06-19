public class Posts
{
	private final int ID;
	private int userId;
	private int locationId;
	private String address;
	private int badgeId;
	private String image;
	private String dateEntry;
	private String timeEntry;
	private String dateDeleted;
	private String timeDeleted;
	private String caption;
	private int status;
	private int up;

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return(ID);
	}

	public void setUserId(int ud) {
		userId = ud;
	}

	public int getUserId() {
		return(userId);
	}

	public void setLocationId(int ld) {
		locationId = ld;
	}

	public int getLocationId() {
		return(locationId);
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return(address);
	}

	public void setBadgeId(int bid) {
		badgeId = bid;
	}

	public int getBadgeId() {
		return(badgeId);
	}

	public void setImage(String img) {
		image = img;
	}

	public String getImage() {
		return(image);
	}

	public void setDateEntry(String de) {
		dateEntry = de;
	}

	public String getDateEntry() {
		return(dateEntry);
	}

	public void setTimeEntry(String te) {
		timeEntry = te;
	}

	public String getTimeEntry() {
		return(timeEntry);
	}

	public void setDateDeleted(String dd) {
		dateDeleted = dd;
	}

	public String getDateDeleted() {
		return(dateDeleted);
	}

	public void setTimeDeleted(String td) {
		timeDeleted = td;
	}

	public String getTimeDeleted() {
		return(timeDeleted);
	}

	public void setCaption(String cp) {
		caption = cp;
	}

	public String getCaption() {
		return(caption);
	}

	public void setStatus(int sts) {
		status = sts;
	}

	public int getStatus() {
		return(status);
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getUp() {
		return(up);
	}
}
