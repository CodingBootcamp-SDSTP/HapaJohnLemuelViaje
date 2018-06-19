public class Users
{
	private final int ID;
	private String firstname;
	private String lastname;
	private String email;
	private String image;
	private String registeredDate;
	private String registeredTime;
	private int followers;
	private int following;
	private int status;
	private String username;
	private String password;
	private String deletedDate;
	private String deletedTime;

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return(ID);
	}

	public void setFirstname(String fname) {
		firstname = fname;
	}

	public String getFirstname() {
		return(firstname);
	}

	public void setLastname(String lname) {
		lastname = lname;
	}

	public String getLastname() {
		return(lastname);
	}

	public void setEmail(String email) {
		this.email = email;
	} 

	public String getEmail() {
		return(email);
	}

	public void setImage(String img) {
		image = img;
	}

	public String setImage() {
		return(image);
	}

	public void setRegisteredDate(String rdate) {
		registeredDate = rdate;
	}

	public String getRegisteredDate() {
		return(registeredDate);
	}

	public void setRegisteredTime(String rtime) {
		registeredTime = rtime;
	}

	public String getRegisteredTime() {
		return(registeredTime);
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowers() {
		return(followers);
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getFollowing() {
		return(following);
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return(status);
	}

	public void setUsername(String uname) {
		username = uname;
	}

	public String getUsername() {
		return(username);
	}

	public void setPassword(String pass) {
		password = pass;
	}

	public String getPassword() {
		return(password);
	}

	public void setDeletedDate(String ddate) {
		deletedDate = ddate;
	}

	public String getDeletedDate() {
		return(deletedDate);
	}

	public void setDeletedTime(String dtime) {
		deletedTime = dtime;
	}

	public String getDeletedTime() {
		return(deletedTime);
	}
}
