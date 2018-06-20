public class Comments
{
	private final int ID;
	private int postId;
	private int userId;
	private String comment;
	private String dateEntry;
	private String timeEntry;
	private String dateDeleted;
	private String timeDeleted;
	private int status;

	public Comments(int id, int pid, int uid, String cmnt, String de, String te, String dd, String td, int sts) {
		ID = id;
		postId = pid;
		userId = uid;
		comment = cmnt;
		dateEntry = de;
		timeEntry = te;
		dateDeleted = dd;
		timeDeleted = td;
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

	public void setComment(String cmnt) {
		comment = cmnt;
	}

	public String getComment() {
		return(comment);
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
