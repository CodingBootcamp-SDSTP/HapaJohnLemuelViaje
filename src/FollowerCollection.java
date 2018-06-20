import java.util.ArrayList;

public class FollowerCollection
{
	public static FollowerCollection _instance = null;

	public static FollowerCollection instance() {
		if(_instance == null) {
			_instance = new FollowerCollection();
		}
		return(_instance);
	}

	private ArrayList<Followers> followers;

	private FollowerCollection() {
		followers = new ArrayList<Followers>();
	}

	public void addFollower(Followers follower) {
		followers.add(follower);
	}

	public void removeFollower(Followers follower) {
		followers.remove(follower);
	}

	public Followers getFollowerByIndex(int n) {
		return(followers.get(n));
	}

	public int getFollowerCount() {
		return(followers.size());
	}

	public ArrayList<Followers> getAllFollowers() {
		return(followers);
	}
}
