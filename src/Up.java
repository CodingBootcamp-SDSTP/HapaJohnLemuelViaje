public class Up
{
	private final int ID;
	private int postId;
	private int userId;
	private String date;
	private String time;
	private int status;

	public Up(int id, int pid, int uid, String d, String t, int sts) {
		ID = id;
		postId = pid;
		userId = uid;
		date = d;
		time = t;
		status = sts;
	}

	public int getID() {
		return(ID);
	}

	public void setPostId(int pid) {
		postId = pid;
	}

	public int getPostId() {
		return(postId);
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
