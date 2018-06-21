import java.sql.*;

public class ViajeDatabase
{
	private static ViajeDatabase _instance = null;

	public static ViajeDatabase instance() {
		if(_instance == null) {
			_instance = new ViajeDatabase();
		}
		return(_instance);
	}

	private Connection conn;
	private UserCollection uc;
	private LocationCollection lc;
	private PostCollection pc;
	private CommentCollection cc;
	private UpCollection upc;
	private FollowerCollection frc;
	private FollowingCollection fwc;

	private ViajeDatabase() {
		uc = UserCollection.instance();
		lc = LocationCollection.instance();
		pc = PostCollection.instance();
		cc = CommentCollection.instance();
		upc = UpCollection.instance();
		frc = FollowerCollection.instance();
		fwc = FollowingCollection.instance();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ViajeDB?user=usernameviaje&" + "password=passwordviaje&serverTimezone=UTC&useSSL=false");
			if(readFromSql()) {
				System.out.println("reading from server ....");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean readFromSql() {
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, firstname, lastname, email, image, DATE_FORMAT(registered_date, '%M %d, %Y') as rdate, DATE_FORMAT(registered_date, '%h:%i %p') as rtime, followers, following, status, username, password, DATE_FORMAT(deleted_date, '%M %d, %Y') as ddate, DATE_FORMAT(deleted_date, '%h:%i %p') as dtime, posts FROM users;");
			while(rs.next()) {
				String ddate = rs.getString("ddate");
				String dtime = rs.getString("dtime");
				if(ddate == null && dtime == null) {
					ddate = "0000-00-00";
					dtime = "00:00:00";
				}
				String[] d = {
					String.valueOf(rs.getInt("id")),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("email"),
					rs.getString("image"),
					rs.getString("rdate"),
					rs.getString("rtime"),
					String.valueOf(rs.getInt("followers")),
					String.valueOf(rs.getInt("following")),
					String.valueOf(rs.getInt("status")),
					rs.getString("username"),
					rs.getString("password"),
					ddate,
					dtime,
					String.valueOf(rs.getInt("posts")),
					"users"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT * FROM locations;");
			while(rs.next()) {
				String[] d = {
					String.valueOf(rs.getInt("id")),
					rs.getString("location_name"),
					rs.getString("image"),
					"locations"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, user_id, location_id, address, image, DATE_FORMAT(date_entry, '%M %d, %Y') as dentry, DATE_FORMAT(date_entry, '%h:%i %p') as tentry, DATE_FORMAT(date_deleted, '%M %d, %Y') as ddeleted, DATE_FORMAT(date_deleted, '%h:%i %p') as tdeleted, caption, status, up, comments FROM posts;");
			while(rs.next()) {
				String ddate = rs.getString("ddeleted");
				String dtime = rs.getString("tdeleted");
				if(ddate == null && dtime == null) {
					ddate = "0000-00-00";
					dtime = "00:00:00";
				}
				String[] d = {
					String.valueOf(rs.getInt("id")),
					String.valueOf(rs.getInt("user_id")),
					String.valueOf(rs.getInt("location_id")),
					rs.getString("address"),
					rs.getString("image"),
					rs.getString("dentry"),
					rs.getString("tentry"),
					ddate,
					dtime,
					rs.getString("caption"),
					String.valueOf(rs.getInt("status")),
					String.valueOf(rs.getInt("up")),
					String.valueOf(rs.getInt("comments")),
					"posts"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, post_id, user_id, comment, DATE_FORMAT(date_entry, '%M %d, %Y') as dentry, DATE_FORMAT(date_entry, '%h:%i %p') as tentry, DATE_FORMAT(date_deleted, '%M %d, %Y') as ddeleted, DATE_FORMAT(date_deleted, '%h:%i %p') as tdeleted, status FROM comments;");
			while(rs.next()) {
				String ddate = rs.getString("ddeleted");
				String dtime = rs.getString("tdeleted");
				if(ddate == null && dtime == null) {
					ddate = "0000-00-00";
					dtime = "00:00:00";
				}
				String[] d = {
					String.valueOf(rs.getInt("id")),
					String.valueOf(rs.getInt("post_id")),
					String.valueOf(rs.getInt("user_id")),
					rs.getString("comment"),
					rs.getString("dentry"),
					rs.getString("tentry"),
					ddate,
					dtime,
					String.valueOf(rs.getInt("status")),
					"comments"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, post_id, user_id, DATE_FORMAT(date, '%M %d, %Y') as ddate, DATE_FORMAT(date, '%h:%i %p') as dtime, status FROM up;");
			while(rs.next()) {
				String[] d = {
					String.valueOf(rs.getInt("id")),
					String.valueOf(rs.getInt("post_id")),
					String.valueOf(rs.getInt("user_id")),
					rs.getString("ddate"),
					rs.getString("dtime"),
					String.valueOf(rs.getInt("status")),
					"up"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, user_id, DATE_FORMAT(date, '%M %d, %Y') as ddate, DATE_FORMAT(date, '%h:%i %p') as dtime, status, whoFollow_id FROM followers;");
			while(rs.next()) {
				String[] d = {
					String.valueOf(rs.getInt("id")),
					String.valueOf(rs.getInt("user_id")),
					rs.getString("ddate"),
					rs.getString("dtime"),
					String.valueOf(rs.getInt("status")),
					String.valueOf(rs.getInt("whoFollow_id")),
					"followers"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, user_id, DATE_FORMAT(date, '%M %d, %Y') as ddate, DATE_FORMAT(date, '%h:%i %p') as dtime, status, youFollow_id FROM following;");
			while(rs.next()) {
				String[] d = {
					String.valueOf(rs.getInt("id")),
					String.valueOf(rs.getInt("user_id")),
					rs.getString("ddate"),
					rs.getString("dtime"),
					String.valueOf(rs.getInt("status")),
					String.valueOf(rs.getInt("youFollow_id")),
					"following"
				};
				createObjectFromSql(d);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
			try { if(rs != null) rs.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public void createObjectFromSql(String... str) {
		int len = str.length-1;
		String d = str[len];
		switch(d) {
			case "users":
				Users user = new Users(Integer.parseInt(str[0]), str[1], str[2], str[3], str[4], str[5], str[6], Integer.parseInt(str[7]), Integer.parseInt(str[8]), Integer.parseInt(str[9]), str[10], str[11], str[12], str[13], Integer.parseInt(str[14]));
				uc.addUser(user);
				break;
			case "locations":
				Locations location = new Locations(Integer.parseInt(str[0]), str[1], str[2]);
				lc.addLocation(location);
				break;
			case "posts":
				Posts post = new Posts(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], str[5], str[6], str[7], str[8], str[9], Integer.parseInt(str[10]), Integer.parseInt(str[11]), Integer.parseInt(str[12]));
				pc.addPost(post);
				break;
			case "comments":
				Comments comment = new Comments(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], str[5], str[6], str[7], Integer.parseInt(str[8]));
				cc.addComment(comment);
				break;
			case "up":
				Up up = new Up(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], Integer.parseInt(str[5]));
				upc.addUp(up);
				break;
			case "followers":
				Followers follower = new Followers(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]));
				frc.addFollower(follower);
				break;
			case "following":
				Following following = new Following(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]));
				fwc.addFollowing(following);
				break;
		}
	}

	public boolean login(String uname, String upass) {
		boolean result = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT COUNT(*) as count FROM users WHERE username = ? AND password = ?;");
			stmt.setString(1, uname);
			stmt.setString(2, upass);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("count") > 0) {
				result = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
			try { if(rs != null) rs.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean checkAccount(String uname) {
		boolean result = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT COUNT(username) as count FROM users WHERE username = ?;");
			stmt.setString(1, uname);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("count") > 0) {
				result = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
			try { if(rs != null) rs.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean registerAccount(String... d) {
		boolean result = false;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO users ( firstname, lastname, email, image, followers, following, status, username, password, posts ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );");
			stmt.setString(1, d[0]);
			stmt.setString(2, d[1]);
			stmt.setString(3, d[2]);
			stmt.setString(4, d[3]);
			stmt.setInt(5, Integer.parseInt(d[4]));
			stmt.setInt(6, Integer.parseInt(d[5]));
			stmt.setInt(7, Integer.parseInt(d[6]));
			stmt.setString(8, d[7]);
			stmt.setString(9, d[8]);
			stmt.setInt(10, Integer.parseInt(d[9]));
			stmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean addPost(String... d) {
		boolean result = false;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO posts ( user_id, location_id, address, image, caption, status, up, comments ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? );");
			stmt.setInt(1, Integer.parseInt(d[0]));
			stmt.setInt(2, Integer.parseInt(d[1]));
			stmt.setString(3, d[2]);
			stmt.setString(4, d[3]);
			stmt.setString(5, d[4]);
			stmt.setInt(6, Integer.parseInt(d[5]));
			stmt.setInt(7, Integer.parseInt(d[6]));
			stmt.setInt(8, Integer.parseInt(d[7]));
			stmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean addComment(String... d) {
		boolean result = false;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO comments ( post_id, user_id, comment, status ) VALUES ( ?, ?, ?, ?, ? );");
			stmt.setInt(1, Integer.parseInt(d[0]));
			stmt.setInt(2, Integer.parseInt(d[1]));
			stmt.setString(3, d[2]);
			stmt.setInt(4, Integer.parseInt(d[3]));
			stmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean addUp(String... d) {
		boolean result = false;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO up ( post_id, user_id, date, status ) VALUES ( ?, ?, ?, ? );");
			stmt.setInt(1, Integer.parseInt(d[0]));
			stmt.setInt(2, Integer.parseInt(d[1]));
			stmt.setString(3, d[2]);
			stmt.setInt(4, Integer.parseInt(d[3]));
			stmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean addFollowingAndFollowers(String type, String... d) {
		boolean result = false;
		PreparedStatement stmt = null;
		try {
			if("follower".equals(type)) {
				stmt = conn.prepareStatement("INSERT INTO followers ( user_id, date, status, whoFollow_id ) VALUES ( ?, ?, ?, ? );");
			}
			else if("following".equals(type)) {
				stmt = conn.prepareStatement("INSERT INTO following ( user_id, date, status, youFollow_id ) VALUES ( ?, ?, ?, ? );");
			}
			stmt.setInt(1, Integer.parseInt(d[0]));
			stmt.setString(2, d[1]);
			stmt.setInt(3, Integer.parseInt(d[2]));
			stmt.setInt(4, Integer.parseInt(d[3]));
			stmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean addFollowingAndFollowerCount(String type, int uid) {
		boolean result = false;
		PreparedStatement stmt = null;
		try {
			if("following".equals(type)) {
				stmt = conn.prepareStatement("UPDATE users SET following = following + 1 WHERE id = ?;");
			}
			else if("follower".equals(type)) {
				stmt = conn.prepareStatement("UPDATE users SET followers = followers + 1 WHERE id = ?;");
			}
			stmt.setInt(1, uid);
			stmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public boolean getUserByUsernameFromSql(String uname) {
		boolean result = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT id, firstname, lastname, email, image, DATE_FORMAT(registered_date, '%M %d, %Y') as rdate, DATE_FORMAT(registered_date, '%h:%i %p') as rtime, followers, following, status, username, password, DATE_FORMAT(deleted_date, '%M %d, %Y') as ddate, DATE_FORMAT(deleted_date, '%h:%i %p') as dtime, posts FROM users WHERE username = ?;");
			stmt.setString(1, uname);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String ddate = rs.getString("ddate");
				String dtime = rs.getString("dtime");
				if(ddate == null && dtime == null) {
					ddate = "0000-00-00";
					dtime = "00:00:00";
				}
				Users user = new Users(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("image"), rs.getString("rdate"), rs.getString("rtime"), rs.getInt("followers"), rs.getInt("following"), rs.getInt("status"), rs.getString("username"), rs.getString("password"), ddate, dtime, rs.getInt("posts"));
				addUser(user);
			}
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(result);
	}

	public void addUser(Users user) {
		uc.addUser(user);
	}
}
