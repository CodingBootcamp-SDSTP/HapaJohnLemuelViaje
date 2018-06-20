public class Following
{
	private final int ID;
	private int userId;
	private String date;
	private String time;
	private int status;
	private int followingId;

	public Following(int id, int uid, String d, String t, int sts, int f) {
		ID = id;
		userId = uid;
		date = d;
		time = t;
		status = sts;
		followingId = f;
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

	public void setFollowingId(int fid) {
		followingId = fid;
	}

	public int getFollowingId() {
		return(followingId);
	}
}
