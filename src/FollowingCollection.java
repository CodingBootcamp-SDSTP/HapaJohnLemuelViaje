import java.util.ArrayList;

public class FollowingCollection
{
	public static FollowingCollection _instance = null;

	public static FollowingCollection instance() {
		if(_instance == null) {
			_instance = new FollowingCollection();
		}
		return(_instance)
	}

	private ArrayList<Following> followings;

	private FollowingCollection() {
		followings = new ArrayList<Following>();
	}

	public void addFollowing(Following following) {
		followings.add(following);
	}

	public void removeFollowing(Following following) {
		followings.remove(following);
	}

	public Following getFollowingByIndex(int n) {
		return(followings.get(n));
	}

	public int getFollowingCount() {
		return(followings.size());
	}

	public ArrayList<Following> getAllFollowings() {
		return(followings);
	}
}
