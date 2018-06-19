public class Followers
{
	private final int ID;
	private int userId;
	private String date;
	private String time;
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

	private void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return(date);
	}

	private void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return(time);
	}

	public void setStatus(int sts) {
		status = sts;
	}

	public int getStatus() {
		return(status);
	}
}
