import java.util.ArrayList;

public class UpCollection
{
	public static UpCollection _instance = null;

	public static UpCollection instance() {
		if(_instance == null) {
			_instance = new UpCollection();
		}
		return(_instance);
	}

	private ArrayList<Up> ups;

	private UpCollection() {
		ups = new ArrayList<Up>();
	}

	public void addUp(Up up) {
		ups.add(up);
	}

	public void removeUp(Up up) {
		ups.remove(up);
	}

	public Up getUpByIndex(int n) {
		return(ups.get(n));
	}

	public int getUpCount() {
		return(ups.size());
	}

	public ArrayList<Up> getAllUps() {
		return(ups);
	}
}
