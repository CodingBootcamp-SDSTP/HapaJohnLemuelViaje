import java.util.ArrayList;

public class BadgeCollection
{
	public static BadgeCollection _instance = null;

	public static BadgeCollection instance() {
		if(_instance == null) {
			_instance = new BadgeCollection();
		}
		return(_instance)
	}

	private ArrayList<Badges> badges;

	private BadgeCollection() {
		badges = new ArrayList<Badges>();
	}

	public void addBadge(Badges badge) {
		badges.add(badge);
	}

	public void removeBadge(Badges badge) {
		badges.remove(badge);
	}

	public Badges getBadgeByIndex(int n) {
		return(badges.get(n));
	}

	public int getBadgeCount() {
		return(badges.size());
	}

	public ArrayList<Badges> getAllBadges() {
		return(badges);
	}
}
