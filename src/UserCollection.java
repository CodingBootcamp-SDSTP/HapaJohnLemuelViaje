import java.util.ArrayList;

public class UserCollection
{
	public static UserCollection _instance = null;

	public static UserCollection instance() {
		if(_instance == null) {
			_instance = new UserCollection();
		}
		return(_instance);
	}

	private ArrayList<Users> users;

	private UserCollection() {
		users = new ArrayList<Users>();
	}

	public void addUser(Users user) {
		users.add(user);
	}

	public void removeUser(Users user) {
		users.remove(user);
	}

	public Users getUserByIndex(int n) {
		return(users.get(n));
	}

	public int getUserCount() {
		return(users.size());
	}

	public ArrayList<Users> getAllUsers() {
		return(users);
	}
}
