public class Badges
{
	private final int ID;
	private int userId;
	private int locationId;
	private String dateEntry;
	private String timeEntry;
	private String dateDeleted;
	private String timeDeleted;
	private int status;

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return(ID);
	}

	public void setUserId(int uid) {
		userId = uid;
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

	public void setStatus(int sts) {
		status = sts;
	}

	public int getStatus() {
		return(status);
	}
}
