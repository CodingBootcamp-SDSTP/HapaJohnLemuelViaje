import java.util.ArrayList;

public class LocationCollection
{
	public static LocationCollection _instance = null;

	public static LocationCollection instance() {
		if(_instance == null) {
			_instance = new LocationCollection();
		}
		return(_instance);
	}

	private ArrayList<Locations> locations;

	private LocationCollection() {
		locations = new ArrayList<Locations>();
	}

	public void addLocation(Locations location) {
		locations.add(location);
	}

	public void removeLocation(Locations location) {
		locations.remove(location);
	}

	public Locations getLocationByIndex(int n) {
		return(locations.get(n));
	}

	public int getLocationCount() {
		return(locations.size());
	}

	public ArrayList<Locations> getAllLocations() {
		return(locations);
	}

	public String getLocationByID(int id) {
		String lname = "";
		for(int i=0; i<getLocationCount(); i++) {
			Locations l = getLocationByIndex(i);
			if(id == l.getID()) {
				lname = l.getLocationName();
			}
		}
		return(lname);
	}
}
