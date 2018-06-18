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
			rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id");
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("email"),
					rs.getString("image"),
					rs.getString("registered_date"),
					rs.getInt("followers"),
					rs.getInt("following"),
					rs.getInt("status"),
					rs.getString("username"),
					rs.getString("password"),
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
			rs = stmt.executeQuery("SELECT * FROM posts");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getInt("location_id"),
					rs.getString("address"),
					rs.getInt("badge_id"),
					rs.getString("image"),
					rs.getString("date_entry"),
					rs.getString("date_deleted"),
					rs.getString("caption"),
					rs.getInt("status"),
					rs.getInt("up"),
					"posts"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT * FROM comments");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("post_id"),
					rs.getInt("user_id"),
					rs.getString("comment"),
					rs.getString("date_entry"),
					rs.getString("date_deleted"),
					rs.getInt("status"),
					"comments"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT * FROM up");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("post_id"),
					rs.getInt("user_id"),
					rs.getString("date"),
					rs.getInt("status"),
					"up"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT * FROM followers");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getString("date"),
					rs.getInt("status"),
					"followers"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT * FROM following");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getString("date"),
					rs.getInt("status"),
					"following"
				};
				createObjectFromSql(d);
			}
			rs = stmt.executeQuery("SELECT * FROM badges");
			while(rs.next()) {
				String[] d = {
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getInt("location_id"),
					rs.getString("date_entry"),
					rs.getString("date_deleted"),
					rs.getInt("status"),
					"badges"
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
				Users user = new Users(Integer.parseInt(str[0]), str[1], str[2], str[3], str[4], str[5], Integer.parseInt(str[6]), Integer.parseInt(str[7]), Integer.parseInt(str[8]), str[9], str[10]);
				uc.addUser(user);
				break;
			case "locations":
				Locations location = new Locations(Integer.parseInt(str[0]), str[1], str[2]);
				lc.addLocation(location);
				break;
			case "posts":
				Posts post = new Posts(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], Integer.parseInt(str[4]), str[5], str[6], str[7], str[8], Integer.parseInt(str[9]), Integer.parseInt(str[10]));
				pc.addPost(post);
				break;
			case "comments":
				Comments comment = new Comments(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], str[5], Integer.parseInt(str[6]));
				cc.addComment(comment);
				break;
			case "up":
				Up up = new Up(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4]);
				upc.addUp(up);
				break;
			case "followers":
				Followers follower = new Followers(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]));
				frc.addFollower(follower);
				break;
			case "following":
				Following following = new Following(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]));
				fwc.addFollowing(following);
				break;
			case "badges":
				Badges badge = new Badges(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], Integer.parseInt(str[5]));
				bc.addBadge(badge);
				break;
		}
	}
}
