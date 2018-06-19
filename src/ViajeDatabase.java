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
	private BadgeCollection bc;

	private ViajeDatabase() {
		uc = UserCollection.instance();
		lc = LocationCollection.instance();
		pc = PostCollection.instance();
		cc = CommentCollection.instance();
		upc = UpCollection.instance();
		frc = FollowerCollection.instance();
		fwc = FollowingCollection.instance();
		bc = BadgeCollection.instance();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ViajeDB?user=usernameviaje&" + "password=passwordviaje&serverTimezone=UTC&useSSL=false");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {};
		}
	}

	public boolean readFromSql() {
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, firstname, lastname, email, image, DATE_FORMAT(registered_date, '%M %d, %Y') as rdate, DATE_FORMAT(registered_date, '%h:%i %p') as rtime, followers, following, status, username, password, DATE_FORMAT(deleted_date, '%M %d, %Y') as ddate, DATE_FORMAT(deleted_date, '%h:%i %p') as dtime FROM users");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("email"),
					rs.getString("image"),
					rs.getString("rdate"),
					rs.getString("rtime"),
					rs.getInt("followers"),
					rs.getInt("following"),
					rs.getInt("status"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("ddate"),
					rs.getString("dtime"),
					"users"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT * FROM locations");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getString("location_name"),
					rs.getString("image"),
					"locations"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, user_id, location_id, DATE_FORMAT(date_entry, '%M %d, %Y') as dentry, DATE_FORMAT(date_entry, '%h:%i %p') as tentry, DATE_FORMAT(date_deleted, '%M %d, %Y') as ddeleted, DATE_FORMAT(date_deleted, '%h:%i %p') as tdeleted, status FROM badges");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getInt("location_id"),
					rs.getString("dentry"),
					rs.getString("tentry"),
					rs.getString("ddeleted"),
					rs.getString("tdeleted"),
					rs.getInt("status"),
					"badges"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, user_id, location_id, address, badge_id, image, DATE_FORMAT(date_entry, '%M %d, %Y') as dentry, DATE_FORMAT(date_entry, '%h:%i %p') as tentry, DATE_FORMAT(date_deleted, '%M %d, %Y') as ddeleted, DATE_FORMAT(date_deleted, '%h:%i %p') as tdeleted, caption, status, up FROM posts");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getInt("location_id"),
					rs.getString("address"),
					rs.getInt("badge_id"),
					rs.getString("image"),
					rs.getString("dentry"),
					rs.getString("tentry"),
					rs.getString("ddeleted"),
					rs.getString("tdeleted"),
					rs.getString("caption"),
					rs.getInt("status"),
					rs.getInt("up"),
					"posts"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, post_id, user_id, comment, DATE_FORMAT(date_entry, '%M %d, %Y') as dentry, DATE_FORMAT(date_entry, '%h:%i %p') as tentry, DATE_FORMAT(date_deleted, '%M %d, %Y') as ddeleted, DATE_FORMAT(date_deleted, '%h:%i %p') as tdeleted, status FROM comments");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("post_id"),
					rs.getInt("user_id"),
					rs.getString("comment"),
					rs.getString("dentry"),
					rs.getString("tentry"),
					rs.getString("ddeleted"),
					rs.getString("tdeleted"),
					rs.getInt("status"),
					"comments"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, post_id, user_id, DATE_FORMAT(up, '%M %d, %Y') as ddate, DATE_FORMAT(up, '%h:%i %p') as dtime, status FROM up");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("post_id"),
					rs.getInt("user_id"),
					rs.getString("ddate"),
					rs.getString("dtime"),
					rs.getInt("status"),
					"up"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, user_id, DATE_FORMAT(up, '%M %d, %Y') as ddate, DATE_FORMAT(up, '%h:%i %p') as dtime, status FROM followers");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getString("ddate"),
					rs.getString("dtime"),
					rs.getInt("status"),
					"followers"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT id, user_id, DATE_FORMAT(up, '%M %d, %Y') as ddate, DATE_FORMAT(up, '%h:%i %p') as dtime, status FROM following");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getString("ddate"),
					rs.getString("dtime"),
					rs.getInt("status"),
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
				Users user = new Users(Integer.parseInt(str[0]), str[1], str[2], str[3], str[4], str[5], str[6], Integer.parseInt(str[7]), Integer.parseInt(str[8]), Integer.parseInt(str[9]), str[10], str[11], str[12], str[13]);
				uc.addUser(user);
				break;
			case "locations":
				Locations location = new Locations(Integer.parseInt(str[0]), str[1], str[2]);
				lc.addLocation(location);
				break;
			case "badges":
				Badges badge = new Badges(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], str[5], str[6], Integer.parseInt(str[7]));
				bc.addBadge(badge);
				break;
			case "posts":
				Posts post = new Posts(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], Integer.parseInt(str[4]), str[5], str[6], str[7], str[8], str[9], str[10], Integer.parseInt(str[11]), Integer.parseInt(str[12]));
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
				Followers follower = new Followers(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], str[3], Integer.parseInt(str[4]));
				frc.addFollower(follower);
				break;
			case "following":
				Following following = new Following(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], str[3], Integer.parseInt(str[4]));
				fwc.addFollowing(following);
				break;
		}
	}

	public boolean registerAccount(String... d) {
		boolean result = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO users ( firstname, lastname, email, image, followers, following, status, username, password, deleted_date ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, d[0]);
			stmt.setString(2, d[1]);
			stmt.setString(3, d[2]);
			stmt.setString(4, d[3]);
			stmt.setInt(5, Integer.parseInt(d[4]));
			stmt.setInt(6, Integer.parseInt(d[5]));
			stmt.setInt(7, Integer.parseInt(d[6]));
			stmt.setString(8, d[7]);
			stmt.setString(9, d[8]);
			stmt.setString(10, d[9]);
			stmt.executeUpdate();
			result = true;
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
}
