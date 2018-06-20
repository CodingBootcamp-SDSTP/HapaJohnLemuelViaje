import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class NewsFeedServlet extends HttpServlet
{
	ViajeDatabase vdb;
	PostCollection pc;
	FollowingCollection fwc;
	LocationCollection lc;

	public void init() throws ServletException {
		vdb = ViajeDatabase.instance();
		pc = PostCollection.instance();
		fwc = FollowingCollection.instance();
		lc = LocationCollection.instance();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		ArrayList<Integer> users = new ArrayList<Integer>();
		String query = request.getQueryString();
		String[] userid = query.split("=");
		StringBuilder bf = new StringBuilder("");
		for(int i=0; i<fwc.getFollowingCount(); i++) {
			Following following = fwc.getFollowingByIndex(i);
			if(Integer.parseInt(userid[1]) == following.getUserId()) {
				users.add(following.getFollowingId());
			}
		}
		bf.append("[");
		for(int i=0; i<pc.getPostCount(); i++) {
			Posts post = pc.getPostByIndex(i);
			for(int j=0; j<users.size(); j++) {
				if(users.get(j) == post.getUserId()) {
					bf.append("{\"address\" : \"" + post.getAddress() + "\", \"location\" : \"" + lc.getLocationByID(post.getLocationId()) + "\", \"image\" : \"" + post.getImage() + "\", \"caption\" : \"" + post.getCaption() + "\"}");
				}
				if(i != pc.getPostCount()-1) {
					bf.append(",");
				}
			}
		}
		bf.append("]");
		out.write(bf.toString());
	}

	public void destroy() {
		vdb = null;
		pc = null;
		fwc = null;
		lc = null;
	}
}
